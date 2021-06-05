package com.cdfi.group.service;

import com.cdfi.group.filter.JWTTokenNeeded;
import com.cdfi.group.model.UsersMaster;
import com.cdfi.group.util.KeyGenerator;
import com.cdfi.group.util.LoggerProducer;
import com.cdfi.group.util.PasswordUtils;
import com.cdfi.group.util.SimpleKeyGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Provider;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class UserEndpoint {


// ======================================
    // =          Injection Points          =
    // ======================================

    @Context
    private UriInfo uriInfo;

    @Inject
    KeyGenerator keyGenerator;


    @PersistenceContext
    private EntityManager em;

    // ======================================
    // =          Business methods          =
    // ======================================

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    public Response authenticateUser(@FormParam("login") String login,
                                     @FormParam("password") String password) {

        try {

            System.out.println("#### login/password : " + login + "/" + password);

            // Authenticate the user using the credentials provided
            authenticate(login, password);

            // Issue a token for the user
            String token = issueToken(login);

            // Return the token on the response
            return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void authenticate(String login, String password) throws Exception {
        TypedQuery<UsersMaster> query = em.createNamedQuery(UsersMaster.FIND_BY_LOGIN_PASSWORD, UsersMaster.class);
        query.setParameter("login", login);
        //query.setParameter("password", password.getBytes(StandardCharsets.UTF_8)/*PasswordUtils.encodeBase64(password)*/);
        query.setParameter("password", PasswordUtils.digestPassword(password).getBytes(StandardCharsets.UTF_8));
        UsersMaster user = query.getSingleResult();

        if (user == null)
            throw new SecurityException("Invalid user/password");
    }

    private String issueToken(String login) {
            Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        System.out.println("#### generating token for a key : " + jwtToken + " - " + key);
        return jwtToken;

    }

    @POST
    @Consumes("application/json")
    public Response create(UsersMaster user) {

        user.setPassword(PasswordUtils.digestPassword(new String(user.getPassword())));
        em.persist(user);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(user.getId().toString()).build()).build();
    }

    @GET
    @Path("/{id}")
    @JWTTokenNeeded
    public Response findById(@PathParam("id") BigInteger id) {
        UsersMaster user = em.find(UsersMaster.class, id);

        if (user == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(user).build();
    }

    @GET
    public Response findAllUsers() {
        TypedQuery<UsersMaster> query = em.createNamedQuery(UsersMaster.FIND_ALL, UsersMaster.class);
        List<UsersMaster> allUsers = query.getResultList();

        if (allUsers == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(allUsers).build();
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") String id) {
        em.remove(em.getReference(UsersMaster.class, id));
        return Response.noContent().build();
    }

    // ======================================
    // =          Private methods           =
    // ======================================

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}

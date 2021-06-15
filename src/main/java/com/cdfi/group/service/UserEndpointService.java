package com.cdfi.group.service;

import com.cdfi.group.filter.JWTTokenNeeded;
import com.cdfi.group.model.UsersMasterEntity;
import com.cdfi.group.util.KeyGenerator;
import com.cdfi.group.util.PasswordUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class UserEndpointService {


// ======================================
    // =          Injection Points          =
    // ======================================

    @Context
    private UriInfo uriInfo;

    @Inject
    KeyGenerator keyGenerator;

    private static final Logger logger = Logger.getLogger(UserEndpointService.class.getName());

    @PersistenceContext
    private EntityManager em;

    // ======================================
    // =          Business methods          =
    // ======================================

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    public Response authenticateUser(@NotNull @FormParam("login") String login,
                                     @NotNull @FormParam("password") String password) {

        try {

            logger.info("#### login/password : " + login + "/" + password);

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

    private void authenticate(String login, String password) {
        TypedQuery<UsersMasterEntity> query = em.createNamedQuery(UsersMasterEntity.FIND_BY_LOGIN_PASSWORD, UsersMasterEntity.class);
        query.setParameter("login", login);
        //query.setParameter("password", password.getBytes(StandardCharsets.UTF_8)/*PasswordUtils.encodeBase64(password)*/);
        query.setParameter("password", PasswordUtils.digestPassword(password).getBytes(StandardCharsets.UTF_8));
        UsersMasterEntity user = query.getSingleResult();

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
        logger.info("#### generating token for a key : " + jwtToken + " - " + key);
        return jwtToken;

    }

    @POST
    @Consumes("application/json")
    public Response create(UsersMasterEntity user) {
        user.setPassword(PasswordUtils.digestPassword(new String(user.getPassword())));
        em.persist(user);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(user.getId().toString()).build()).build();
    }

    @GET
    @Path("/{id}")
    @JWTTokenNeeded
    public Response findById(@PathParam("id") BigInteger id) {
        UsersMasterEntity user = em.find(UsersMasterEntity.class, id);

        if (user == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(user).build();
    }

    @GET
    public Response findAllUsers() {
        TypedQuery<UsersMasterEntity> query = em.createNamedQuery(UsersMasterEntity.FIND_ALL, UsersMasterEntity.class);
        List<UsersMasterEntity> allUsers = query.getResultList();

        if (allUsers == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(allUsers).build();
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") String id) {
        em.remove(em.getReference(UsersMasterEntity.class, id));
        return Response.noContent().build();
    }

    // ======================================
    // =          Private methods           =
    // ======================================

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}

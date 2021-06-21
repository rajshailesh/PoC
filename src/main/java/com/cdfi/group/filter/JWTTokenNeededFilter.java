package com.cdfi.group.filter;

import com.cdfi.group.service.UserEndpointService;
import com.cdfi.group.util.KeyGenerator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import javax.annotation.Priority;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.lang.reflect.Method;
import java.security.Key;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


@Service
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private KeyGenerator keyGenerator;

    @Context
    private ResourceInfo resourceInfo;

    @PersistenceContext
    private EntityManager em;

    // ======================================
    // =          Member Variables          =
    // ======================================



    public static final String USER = "User";
    public static final String TENANT = "X-Tenant-Identifier";

    private static final Logger logger = Logger.getLogger(UserEndpointService.class.getName());

    public JWTTokenNeededFilter() {
    }

    // ======================================
    // =          Business methods          =
    // ======================================

    @Override
    public void filter(ContainerRequestContext requestContext) {

        // Get the HTTP Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        String user = requestContext.getHeaderString(USER);
        String tenant = requestContext.getHeaderString(TENANT);
        logger.info("#### authorizationHeader : " + authorizationHeader);

        // Check if the HTTP Authorization header is present and formatted correctly
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            logger.info("#### invalid authorizationHeader : " + authorizationHeader);
            throw new NotAuthorizedException("Authorization header must be provided");
        } else if (user == null ){
            logger.info(String.format("%s header is missing ", USER));
            throw new NotAuthorizedException(String.format("%s header must be provided ", USER));
        }  else if (tenant == null ) {
            logger.info(String.format("%s header is missing ", TENANT));
            throw new NotAuthorizedException(String.format("%s header must be provided ", TENANT));
        }

        Method method = resourceInfo.getResourceMethod();
        if (!method.isAnnotationPresent(PermitAll.class)) {
            //Access denied for all
            if (method.isAnnotationPresent(DenyAll.class)) {
                requestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
                        .entity("Access blocked for all users !!").build());
                return;
            }

            // Extract the token from the HTTP Authorization header
            String token = authorizationHeader.substring("Bearer".length()).trim();

            try {

                // Validate the token
                Key key = keyGenerator.generateKey();
                Jws<Claims> jwt = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
                if(!user.equals(jwt.getBody().getSubject())){
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Passed token belongs to other user").build());
                }
                logger.info("#### valid token : " + token);

            } catch (Exception e) {
                logger.info("#### invalid token : " + token);
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
            //Verify user access
            if (method.isAnnotationPresent(RolesAllowed.class)) {
                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<>(Arrays.asList(rolesAnnotation.value()));
                if (!isUserAllowed(user, rolesSet)) {
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                            .entity("You cannot access this resource").build());
                }
            }
        }
    }

    private boolean isUserAllowed(final String user, final Set<String> rolesSet) {
        TypedQuery<String> query
                = em.createQuery(
                "SELECT rm.roleName FROM RoleMasterEntity rm join UsersRoleRightsMapEntity urm on rm.roleId = urm.roleId and urm.userId = :user_id", String.class);
        query.setParameter("user_id", user);
        List<String> resultList = query.getResultList();
        logger.info("roles" + resultList);

        boolean isAllowed = false;

        for (String rm: resultList
             ) {
            if (rolesSet.contains(rm)) {
                isAllowed = true;
                break;
            }
        }
        return isAllowed;
    }

}

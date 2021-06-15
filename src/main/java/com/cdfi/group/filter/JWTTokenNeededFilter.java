package com.cdfi.group.filter;

import com.cdfi.group.model.RoleMasterEntity;
import com.cdfi.group.service.UserEndpointService;
import com.cdfi.group.util.KeyGenerator;
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
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.Key;
import java.util.*;
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
    private static final Logger logger = Logger.getLogger(UserEndpointService.class.getName());

    // ======================================
    // =          Business methods          =
    // ======================================

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        Method method = resourceInfo.getResourceMethod();
        if (!method.isAnnotationPresent(PermitAll.class)) {
            //Access denied for all
            if (method.isAnnotationPresent(DenyAll.class)) {
                requestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
                        .entity("Access blocked for all users !!").build());
                return;
            }
            // Get the HTTP Authorization header from the request
            String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
            logger.info("#### authorizationHeader : " + authorizationHeader);

            // Check if the HTTP Authorization header is present and formatted correctly
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                logger.info("#### invalid authorizationHeader : " + authorizationHeader);
                throw new NotAuthorizedException("Authorization header must be provided");
            }

            // Extract the token from the HTTP Authorization header
            String token = authorizationHeader.substring("Bearer".length()).trim();

            try {

                // Validate the token
                Key key = keyGenerator.generateKey();
                Jwts.parser().setSigningKey(key).parseClaimsJws(token);
                logger.info("#### valid token : " + token);

            } catch (Exception e) {
                logger.info("#### invalid token : " + token);
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
            //Verify user access
            if (method.isAnnotationPresent(RolesAllowed.class)) {
                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
                String user = requestContext.getHeaderString(USER);
                if (!isUserAllowed(token, user, rolesSet)) {
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                            .entity("You cannot access this resource").build());
                    return;
                }
            }
        }
    }

    private boolean isUserAllowed(final String token, final String user, final Set<String> rolesSet) {
        TypedQuery<RoleMasterEntity> query
                = em.createQuery(
                "SELECT urm.roleMasterEntity FROM UsersRoleRightsMapEntity urm WHERE urm.userId = :user_id", RoleMasterEntity.class);
        query.setParameter("user_id", user);
        List<RoleMasterEntity> resultList = query.getResultList();
        logger.info("roles" + resultList);

        boolean isAllowed = false;

        for (RoleMasterEntity rm: resultList
             ) {
            if (rolesSet.contains(rm.getRoleName())) {
                isAllowed = true;
            }
        }

        return isAllowed;
    }

}
package com.dedalus.resources;

import com.dedalus.model.UserEntity;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.dedalus.model.UserEntity.*;

@Path("user")
@RequestScoped
public class UserResource {
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity findUserById(@NotNull @PathParam("id") Long id) {
        return findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserEntity> all() {
        return listAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public UserEntity save(UserEntity entity) {
         entity.persist();
         return entity;
    }
}

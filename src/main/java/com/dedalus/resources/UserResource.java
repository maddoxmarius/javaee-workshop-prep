package com.dedalus.resources;

import com.dedalus.model.UserEntity;
import com.dedalus.persistence.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("user")
@RequestScoped
public class UserResource {
    @Inject
    UserRepository repository;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity findById(@NotNull @PathParam("id") Long id) {
        return repository.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserEntity> all() {
        return repository.list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public UserEntity save(UserEntity entity) {
        return repository.save(entity);
    }
}

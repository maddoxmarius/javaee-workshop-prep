package com.dedalus.resources;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dedalus.model.AnimalEntity;
import com.dedalus.persistence.AnimalRepository;

@Path("animal")
public class AnimalResource {
    @Inject
    AnimalRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalEntity> list() {
        return repository.list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalEntity save(AnimalEntity entity) {
        return repository.save(entity);
    }
}
package com.dedalus.resources;

import com.dedalus.model.AnimalEntity;
import com.dedalus.persistence.GreetingRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("animal")
public class AnimalResource {
    @Inject
    GreetingRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalEntity list() {
        return null;
    }
}
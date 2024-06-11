package com.dedalus.resources;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dedalus.model.AnimalEntity;
import com.dedalus.model.dto.AnimalDto;
import com.dedalus.persistence.AnimalRepository;

@Path("animal")
@RequestScoped
public class AnimalResource {
    @Inject
    AnimalRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalDto> list() {
        return repository.list().stream().map(a -> new AnimalDto(a.getName(), a.getType()))
                .collect(Collectors.toList());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalEntity save(AnimalEntity entity) {
        return repository.save(entity);
    }
}
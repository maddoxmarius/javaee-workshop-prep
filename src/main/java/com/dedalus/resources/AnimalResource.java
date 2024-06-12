package com.dedalus.resources;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;
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
import com.dedalus.security.Roles;
import com.dedalus.service.AnimalService;

@Path("animal")
@RequestScoped
public class AnimalResource {

     @Inject
    AnimalService animalService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalDto> list() {
        return animalService.list().stream().map(a -> new AnimalDto(a.getName(), a.getType()))
                .collect(Collectors.toList());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @RolesAllowed({ Roles.INTERESTED_USER })
    @Path("/details")
    public List<AnimalDto> detailedList() {
        return animalService.list().stream().map(a -> new AnimalDto(a.getName(), a.getType(), a.getComment(), a.getIsAvailable()))
                .collect(Collectors.toList());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalEntity save(AnimalEntity entity) {
        return animalService.save(entity);
    }
}
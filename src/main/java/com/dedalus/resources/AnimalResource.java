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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mapstruct.factory.Mappers;
import com.dedalus.model.AnimalEntity;
import com.dedalus.model.dto.AnimalDto;
import com.dedalus.model.dto.AnimalMapper;
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
        AnimalMapper mapper = Mappers.getMapper(AnimalMapper.class);
        return animalService.list().stream().map(a -> mapper.toSummary(a))
                .collect(Collectors.toList());
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @GET
    public AnimalDto listAnimalDetails(@PathParam("id") Long id) {
        AnimalMapper mapper = Mappers.getMapper(AnimalMapper.class);
        return mapper.toDetails(animalService.findById(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalEntity save(AnimalEntity entity) {
        return animalService.save(entity);
    }
}
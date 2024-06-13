package com.dedalus.resources;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.mapstruct.factory.Mappers;
import com.dedalus.model.AnimalEntity;
import com.dedalus.model.UserEntity;
import com.dedalus.model.dto.AdoptAnimalDto;
import com.dedalus.model.dto.AnimalDto;
import com.dedalus.model.dto.AnimalMapper;
import com.dedalus.service.AnimalService;
import com.dedalus.service.UserService;

@Path("animal")
@RequestScoped
public class AnimalResource {

    @Inject
    AnimalService animalService;

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalDto> list() {
        AnimalMapper mapper = Mappers.getMapper(AnimalMapper.class);
        return animalService.list().stream().map(a -> mapper.toSummary(a))
                .collect(Collectors.toList());
    }

    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void adoptAnimals(@PathParam("id") Long animalId, AdoptAnimalDto dto) {
        if (dto == null || dto.getAdoptedBy() == null) {
            return; //nothing to do
        }

        AnimalEntity animal = animalService.findById(animalId);
        if (animal == null) {
            throw new NotFoundException("animal with id " + animalId + " not found");
        }
        UserEntity user = userService.findById(dto.getAdoptedBy());
        if(user == null) {
            throw new NotFoundException("user with id " + dto.getAdoptedBy() + " not found");
        }
        animal.setAdoptedBy(user);
        animalService.save(animal);
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

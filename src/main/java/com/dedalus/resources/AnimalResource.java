package com.dedalus.resources;

import com.dedalus.exception.AnimalNotAvailableException;
import com.dedalus.model.AnimalEntity;
import com.dedalus.model.UserEntity;
import com.dedalus.model.dto.AdoptAnimalDto;
import com.dedalus.model.dto.AnimalDto;
import com.dedalus.model.dto.AnimalMapper;
import com.dedalus.service.AnimalApiNinjaService;
import com.dedalus.service.AnimalService;
import com.dedalus.service.UserService;
import org.apache.http.client.utils.URIBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.mapstruct.factory.Mappers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("animal")
@RequestScoped
public class AnimalResource {

    @Inject
    AnimalService animalService;

    @Inject
    UserService userService;

    @Inject
    @RestClient
    AnimalApiNinjaService animalApiNinjaService;

    @ConfigProperty(name = "api.key")
    String apiKey;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalDto> list() {
        AnimalMapper mapper = Mappers.getMapper(AnimalMapper.class);
        return animalService.list().stream().map(mapper::toSummary).collect(Collectors.toList());
    }

    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @Transactional
    public void adoptAnimals(@PathParam("id") Long animalId, AdoptAnimalDto dto) throws AnimalNotAvailableException {
        //TODO how to go from adopted to not being adopted?
        if (Objects.isNull(dto) || Objects.isNull(dto.getAdoptedBy())) {
            return; //nothing to do
        }

        // TODO add to a custom Validation bean
        AnimalEntity animal = animalService.findById(animalId);
        if (Objects.isNull(animal)) {
            throw new NotFoundException("animal with id " + animalId + " not found");
        }
        if (!animal.isAvailable()) {
            throw new AnimalNotAvailableException(animal);
        }

        UserEntity user = userService.findUserById(dto.getAdoptedBy());
        if (user == null) {
            throw new NotFoundException("user with id " + dto.getAdoptedBy() + " not found");
        }
        animal.setAdoptedBy(user);
        animalService.save(animal);
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @GET
    public AnimalEntity listAnimalDetails(@PathParam("id") Long id) {
        final AnimalEntity animal = animalService.findById(id);
        if (Objects.isNull(animal)) {
            throw new NotFoundException("animal with id " + id + " not found");
        }
        ArrayList<HashMap> details = animalApiNinjaService.getByName(animal.getType().name(), apiKey);
        Optional.ofNullable(details).ifPresent(d -> {
            if (!d.isEmpty()) {
                animal.setTypeDetails(details.get(0).get("characteristics"));
            }
        });
        return animal;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/info")
    @GET
    public Response info(@PathParam("id") Long id) throws URISyntaxException {
        final AnimalEntity animal = animalService.findById(id);
        if (animal == null) {
            throw new NotFoundException("animal with id " + id + " not found");
        }
        URI uri = new URIBuilder("https://en.wikipedia.org/w/index.php")
                .setParameter("search", animal.getType().name())
                .build();
        return Response.seeOther(uri).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalEntity save(@Valid AnimalEntity entity) {
        return animalService.save(entity);
    }

}

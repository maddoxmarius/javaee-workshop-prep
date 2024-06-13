package com.dedalus.exception;

import com.dedalus.model.AnimalEntity;

import javax.json.Json;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AnimalNotAvailableExceptionMapper implements ExceptionMapper<AnimalNotAvailableException> {
    @Override
    public Response toResponse(AnimalNotAvailableException e) {
        AnimalEntity animal = e.getAnimal();
        String errorMessage = new StringBuilder().append(animal.getName() + " is not available").toString();
        final Response response = Response.status(Response.Status.CONFLICT)
                .entity(Json.createObjectBuilder()
                        .add("errorMessage", errorMessage).toString()
                ).build();
        return response;
    }
}

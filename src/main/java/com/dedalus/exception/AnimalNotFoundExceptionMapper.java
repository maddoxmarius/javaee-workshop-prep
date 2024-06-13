package com.dedalus.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AnimalNotFoundExceptionMapper implements ExceptionMapper<NotFoundException>  {
    @Override
    public Response toResponse(NotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity("The animal or user could not be found.")
                .build();
    }
}

package com.dedalus.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.HashMap;

@RegisterRestClient(baseUri = "https://api.api-ninjas.com/v1/animals")
@ApplicationScoped
public interface AnimalApiNinjaService {

    @GET
    ArrayList<HashMap> getByName(@QueryParam("name") String name, @HeaderParam("X-Api-Key") String apiKey);

}

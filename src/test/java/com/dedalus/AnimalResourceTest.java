package com.dedalus;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static io.restassured.RestAssured.given;

import java.util.List;

import com.dedalus.model.AnimalEntity;
import com.dedalus.model.AnimalType;
import com.dedalus.service.AnimalService;

public class AnimalResourceTest {

    public void testHelloEndpoint() {

        AnimalService animalServiceMock = mock(AnimalService.class);
        AnimalEntity animal = new AnimalEntity();
        animal.setId(1L);
        animal.setName("Lion");
        animal.setType(AnimalType.CAT);
        animal.setComment("King of the Jungle");
        animal.setIsAvailable(true);
        when(animalServiceMock.list()).thenReturn(List.of(animal));
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

}
package com.dedalus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import com.dedalus.model.AnimalEntity;
import com.dedalus.model.AnimalType;
import com.dedalus.service.AnimalService;

@QuarkusTest
public class AnimalResourceTest {

    @Test
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
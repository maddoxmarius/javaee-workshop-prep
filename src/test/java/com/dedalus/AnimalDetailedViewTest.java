package com.dedalus;

import static io.restassured.RestAssured.given;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import com.dedalus.security.Roles;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

@QuarkusTest
public class AnimalDetailedViewTest {

    @Test
    @Transactional
    @TestSecurity(user = "INTERESTED_USER", roles = { Roles.INTERESTED_USER })
    public void testAnimalDetailedView() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/animal/details")
                .then()
                .statusCode(200);
    }

    //    @Test
    //    @TestSecurity(user = "username", roles = {"BIG_WORDS"})
    //    public void testGetPremiumWords() {
    //        WordService premiumWordServiceMock = mock(WordService.class);
    //        PanacheQuery<WordEntity> mockQuery = mock(PanacheQuery.class);
    //        when(premiumWordServiceMock.getPremiumWords()).thenReturn(mockQuery);
    //        given()
    //                .get("/words/premium")
    //                .then()
    //                .statusCode(200)
    //                .contentType(MediaType.APPLICATION_JSON)
    //                .body("$", hasSize(greaterThanOrEqualTo(0))); // Add assertions based on your expected response
    //    }
}

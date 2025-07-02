import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:4004";

    }

    // 1 - Arrange
    // 2 - Act
    // 3 - Assert
    // ***********************************


    @Test
    public void shouldReturnOKWithValidToken(){
        // Arrange
        String loginPayload = """
                
                {
                "email" : "testuser@test.com",
                "password" : "password123"
                }
                
                """;
        //  Act
    Response response = given()
            .contentType("application/json")
            .body(loginPayload)
            .when()
            .post("/auth/login")
            //Response
            .then()
            .statusCode(200)
            .body("token",notNullValue())
            .extract().response();


    }




}

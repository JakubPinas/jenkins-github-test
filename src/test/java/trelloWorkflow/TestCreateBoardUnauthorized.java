package trelloWorkflow;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TestCreateBoardUnauthorized extends BaseTest {

    @Test(enabled = true)
    public static void createBoardWrongKeyAndToken() {

        String wrongKey  = "8554a365f19064aa66123444bebcd230";
        String wrongToken = "ATTAadbfa99515b6a81298b0f8941133e095ff9d4f915525ed0872e1cb26bcd7fa29F0EBD016";
        String name            = "Kuba123";

        Response wrongAuth = given().
                spec(requestSpec).
                contentType("application/json").
                queryParam("name", name).
                queryParam("key",wrongKey).
                queryParam("token", wrongToken).
                when().
                post("/boards/"); //Send request
        wrongAuth.prettyPrint();

        Assertions.assertThat(wrongAuth.statusCode()).as("Should be  unauthorized  401").isEqualTo(401);
    }

    @Test(enabled = true)
    public static void createBoardWrongKey() {

        String wrongKey  = "8554a365f19064aa66123444bebcd230";
        String name            = "Kuba123";

        Response wrongAuth = given().
                spec(requestSpec).
                contentType("application/json").
                queryParam("name", name).
                queryParam("key",wrongKey).
                queryParam("token", Token).
                when().
                post("/boards/"); //Send request
        wrongAuth.prettyPrint();

        Assertions.assertThat(wrongAuth.statusCode()).as("Should be  unauthorized  401").isEqualTo(401);
    }

    @Test(enabled = true)
    public static void createBoardWrongToken() {

        String wrongToken = "ATTAadbfa99515b6a81298b0f8941133e095ff9d4f915525ed0872e1cb26bcd7fa29F0EBD016";
        String name = "Kuba123";

        Response wrongAuth = given().
                spec(requestSpec).
                contentType("application/json").
                queryParam("name", name).
                queryParam("key",Key).
                queryParam("token", wrongToken).
                when().
                post("/boards/");
        wrongAuth.prettyPrint();

        Assertions.assertThat(wrongAuth.statusCode()).as("Should be  unauthorized  401").isEqualTo(401);
    }
}

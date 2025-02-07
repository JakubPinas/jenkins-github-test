package trelloWorkflow;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TestUpdateBoardWrongRequest extends BaseTest{

    @Test
    public void updateBoardTestWrongUrl() {


        System.out.println(BOARD_ID);
        String endpoint = "/boards/" + BOARD_ID + "/lists";

        Response response = given().spec(requestSpec).contentType("application/json").
                queryParam("name", "123lesgo").
                queryParam("desc", "siabada").
                queryParam("prefs/permissionLevel", "public").
                queryParam("prefs/background", "pink").
                queryParam("labelNames/green", "spring").
                when().
                put(endpoint); //Send request
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),404);
        System.out.println("404 not found : Provided /{id}/lists instead of /lists/{id}  ");
    }

    @Test
    public void updateBoardTestWrongBoardId() {


        System.out.println(BOARD_ID);
        String endpoint = "/boards/" + BOARD_ID + "1";

        Response response = given().spec(requestSpec).contentType("application/json").
                queryParam("name", "123lesgo").
                queryParam("desc", "siabada").
                queryParam("prefs/permissionLevel", "public").
                queryParam("prefs/background", "pink").
                queryParam("labelNames/green", "spring").
                when().
                put(endpoint); //Send request
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),400);
        System.out.println("400 bad request : Provided wrong  board Id ");
    }
}

package trelloWorkflow.additionalTests;

import trelloWorkflow.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.BuildRequest;
import static io.restassured.RestAssured.given;

public class TestCreateLabels extends BaseTest {

    @Test(enabled = false)
    public  void addLabelsToBoard() {

        String endpoint = BOARD_ID + "/labels";
        System.out.println(BOARD_ID);

        Response response1 = given().
                spec(requestSpec).
                contentType("application/json").
                queryParam("key", Key).
                queryParam("token", Token).
                queryParam("color","orange").
                queryParam("name","orange").
                queryParam("id", BOARD_ID).
                when().
                post(endpoint); //Send request
        response1.then().spec(responseSpec);//validate response
        response1.prettyPrint();


        Response response2 = given().
                spec(requestSpec).
                contentType("application/json").
                queryParam("key", Key).
                queryParam("token", Token).
                queryParam("color","pink").
                queryParam("name","barbie").
                queryParam("id", BOARD_ID).
                when().
                post(endpoint); //Send request
        response2.then().spec(responseSpec);//validate response
        response2.prettyPrint();

        Response response3 = given().
                spec(requestSpec).
                contentType("application/json").
                queryParam("key", Key).
                queryParam("token", Token).
                queryParam("color","red").
                queryParam("name","bloody").
                queryParam("id", BOARD_ID).
                when().
                post(endpoint); //Send request
        response3.then().spec(responseSpec);//validate response
        response3.prettyPrint();

        Response response4 = new BuildRequest().requestSpecification
                .queryParam("color","yellow")
                .queryParam("name","river")
                .when().post(endpoint);
        response4.then().spec(responseSpec);//validate response
        response4.prettyPrint();
    }
}

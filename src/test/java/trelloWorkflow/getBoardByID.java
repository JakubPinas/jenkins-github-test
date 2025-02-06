package trelloWorkflow;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.BuildRequest;

import static io.restassured.RestAssured.given;

public class getBoardByID  extends BaseTest {


    @Test
    public void getLabels() {

        //createBoardUtil();
        //createLabelsUtil();
        System.out.println(BOARD_ID);
        String endpoint =  BOARD_ID;

        Response response = new BuildRequest().requestSpecification.
                when().
                get(endpoint); //Send request
        response.then().spec(responseSpec);//validate response
        response.prettyPrint();



    }





}

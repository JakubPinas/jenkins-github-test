package trelloWorkflow.additionalTests;

import trelloWorkflow.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.BuildRequest;

public class getLabels extends BaseTest {

    @Test
    public void getLabelsTest() {

//        createBoardUtil();
//        createLabelsUtil();
        System.out.println(BOARD_ID);
        String endpoint =  BOARD_ID + "/labels";

        Response response = new BuildRequest().requestSpecification.
                queryParam("fields", "color").
                queryParam("fields", "name").
                when().
                get(endpoint); //Send request
        response.then().spec(responseSpec);//validate response
        response.prettyPrint();

    }
}

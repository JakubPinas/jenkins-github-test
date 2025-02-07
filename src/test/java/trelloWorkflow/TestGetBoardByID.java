package trelloWorkflow;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.BuildRequest;

public class TestGetBoardByID extends BaseTest {

    @Test
    public void getLabels() {

        System.out.println(BOARD_ID);
        String endpoint =  BOARD_ID;

        Response response = new BuildRequest().requestSpecification.
                when().
                get(endpoint); //Send request
        response.then().spec(responseSpec);//validate response
        response.prettyPrint();
    }
}

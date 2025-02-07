package trelloWorkflow;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.BuildRequest;

public class TestDeleteBoard extends BaseTest {

    @Test
    void deleteBoard(){

        String endpoint = "/boards/" + BOARD_ID;
        Response response = new BuildRequest().requestSpecification.when().delete(endpoint);
        response.then()
                .assertThat().statusCode(200 );
    }
}

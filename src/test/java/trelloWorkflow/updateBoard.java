package trelloWorkflow;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import utility.BuildRequest;

public class updateBoard extends BaseTest {


    @Test
    public void updateBoardTest() {

        //createBoardUtil();
        createLabelsUtil();
        System.out.println(BOARD_ID);
        String endpoint =  BOARD_ID;



        Response response = new BuildRequest().requestSpecification.
                queryParam("name", "123lesgo").
                queryParam("desc", "siabada").
                queryParam("prefs/permissionLevel", "public").
                queryParam("prefs/background", "pink").
                queryParam("labelNames/green", "spring").
                when().
                put(endpoint); //Send request
        response.then().spec(responseSpec);//validate response
        response.prettyPrint();

        Assertions.assertThat(response.jsonPath().getString("name")).as("Names don't match").isEqualTo("123lesgo");
        Assertions.assertThat(response.jsonPath().getString("desc")).as("Description don't match").isEqualTo("siabada");
        Assertions.assertThat(response.jsonPath().getString("prefs.permissionLevel")).as("Names don't match").isEqualTo("public");
        Assertions.assertThat(response.jsonPath().getString("prefs.background")).as("Names don't match").isEqualTo("pink");
        Assertions.assertThat(response.jsonPath().getString("labelNames.green")).as("Names don't match").isEqualTo("spring");

    }


}

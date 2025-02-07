package trelloWorkflow;

import com.trello.PojoClasses.Response.BoardRootResponse;
import com.trello.PojoClasses.Response.Prefs;
import org.assertj.core.api.Assertions;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utility.*;


import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class CreateBoard extends BaseTest {

    @Test(enabled = true)
    public static void createBoardRawCode() {

        //make Strings to use same values to both POJO class and query parameters
        String name            = "Kuba123";
        String desc            = "Hope";
        String permissionLevel = "public";
        String voting          = "observers";
        String bgColor         = "red";

        //Make POJO instance, as expected response
        Prefs prefs = new Prefs();
        BoardRootResponse boardRootResponse = new BoardRootResponse();
        prefs.setPermissionLevel(permissionLevel);
        prefs.setVoting(voting);
        prefs.setBackground(bgColor);
        boardRootResponse.setName(name);
        boardRootResponse.setDesc(desc);
        boardRootResponse.setPrefs(prefs);

        //Specify request
        Response response = given().
                spec(requestSpec).
                contentType("application/json").
                queryParam("name", name).
                queryParam("desc", desc).
                queryParam("prefs_permissionLevel",permissionLevel).
                queryParam("prefs_voting", voting).
                queryParam("prefs_background", bgColor).
                queryParam("key",Key).
                queryParam("token", Token).

                when().
                post(); //Send request
        response.then().spec(responseSpec);//validate response
        response.prettyPrint();

        //Use soft testing as a way to check correct values of fields that are should change
        SoftAssert softAssert = new SoftAssert();

        //Actual values from response
        String actualName            = response.jsonPath().getString("name");
        String actualDesc            = response.jsonPath().getString("desc");
        String actualPermission      = response.jsonPath().getString("prefs.permissionLevel");
        String actualVoting          = response.jsonPath().getString("prefs.voting");
        String actualBackgroundColor = response.jsonPath().getString("prefs.background");

        //Expected value from POJO class
        String expectedName            = boardRootResponse.getName();
        String expectedDesc            = boardRootResponse.getDesc();
        String expectedPermission      = boardRootResponse.getPrefs().getPermissionLevel();
        String expectedVoting          = boardRootResponse.getPrefs().getVoting();
        String expectedBackgroundColor = boardRootResponse.getPrefs().getBackground();

        //compare  -----testNG-----
        softAssert.assertEquals(actualName,           expectedName, "Names don't match");
        softAssert.assertEquals(actualDesc,           expectedDesc,"Descriptions don't match");
        softAssert.assertEquals(actualPermission,     expectedPermission,"Permission levels don't match");
        softAssert.assertEquals(actualVoting,         expectedVoting,"Voting permissions don't match ");
        softAssert.assertEquals(actualBackgroundColor,expectedBackgroundColor,"Background colors don't match");
        softAssert.assertAll();

        //compare  -----assertJ-----
        Assertions.assertThat(actualName).as("Names don't match").isEqualTo(expectedName);
        Assertions.assertThat(actualDesc).as("Descriptions don't match").isEqualTo(expectedDesc);
        Assertions.assertThat(actualPermission).as("Permission levels don't match").isEqualTo(expectedPermission);
        Assertions.assertThat(actualVoting).as("Voting don't match").isEqualTo(expectedVoting);
        Assertions.assertThat(actualBackgroundColor).as("Backgrounds colors don't match").isEqualTo(expectedBackgroundColor);



        BOARD_ID = response.then().extract().path("id").toString();
    }

    @Test(enabled = false)
    public static void createBoardUtilClasses() {

        String name            = "Kuba123";
        String desc            = "Hope dies last";
        String permissionLevel = "public";
        String voting          = "observers";
        String bgColor         = "red";

        //Specify request
        BuildRequest request = new BuildRequest(name,desc,voting,permissionLevel,bgColor);

        //Send request
        Response response = SendRequest.sendPost(request.requestSpecification);

        //Validate response
        CheckResponseIsValid.validateResponse(response,200);

        //Actual values from response
        PrepareActualResponse actualResponsePOST = new PrepareActualResponse(response);

        //Expected value from POJO class
        PrepareExpectedResponse expectedResponsePOST = new PrepareExpectedResponse(request.expectedResponse);

        //Compare
        CheckActualVsExpectedResponses.checkActualVsExpectedResponses(actualResponsePOST,expectedResponsePOST);

        Assertions.assertThat(response.getStatusCode()).as("Checking answer status").isEqualTo(200);
        Assertions.assertThat(response.getContentType()).as("Checking Clntent-type").isEqualTo("application/json; charset=utf-8");
        Assertions.assertThat(response.getHeader("Connection")).as("Checking connection").isEqualTo("keep-alive");
        Assertions.assertThat(response.getBody()).asString().as("Checking if contains given text").doesNotContain("blue");

    }

    @Test(enabled = false)
    public static void testPOJOSerialization() throws IOException {

        String name = "Hello there";
        String desc = "SWSWSWSWSWWSWS";
        String permissionLevel = "private";
        String voting = "members";
        String bgColor = "lime";

        BuildRequest buildRequest = new BuildRequest(name, desc, voting, permissionLevel, bgColor);
        Response response = SendRequest.sendPost(buildRequest.requestSpecification);

        System.out.println(response.toString());

        //POJO serialization JSON -> Java
        ObjectMapper ob = new ObjectMapper();
        BoardRootResponse responseModelPOJO = ob.readValue(response.getBody().asString(), BoardRootResponse.class);
        System.out.println(responseModelPOJO);

        //Extract values to test from raw restAssured response
        PrepareActualResponse  actualResponse =new PrepareActualResponse(response);

        //Extract values from expected response - "clean" Strings written into POJO
        PrepareExpectedResponse expectedResponse = new PrepareExpectedResponse(buildRequest.expectedResponse);

        //extract coresponding values from response deserialized into Java object
        PrepareExpectedResponse responseAsPOJO = new PrepareExpectedResponse(responseModelPOJO);
        CheckActualVsExpectedResponses.checkActualVsExpectedResponses(actualResponse,expectedResponse);
        CheckActualVsExpectedResponses.checkActualVsExpectedResponses(actualResponse,responseAsPOJO);



    }
}

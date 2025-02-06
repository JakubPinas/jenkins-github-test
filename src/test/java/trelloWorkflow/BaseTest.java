package trelloWorkflow;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utility.BuildRequest;
import utility.SendRequest;

import utilityRetrofit.ConfigReader;

import java.util.Arrays;
import java.util.List;


public class BaseTest {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    protected static String Key = ConfigReader.readConfigurationFile("KEY");
    protected static String Token = ConfigReader.readConfigurationFile("TOKEN");
    protected static String Auth = String.format("?&key=%s&token=%s",Key,Token);
    protected static String BOARD_ID;


    protected static String URL_FOR_OKHTTP  = "https://api.trello.com/1/boards/";


    @BeforeSuite
    public void setBaseURI() {
       // requestSpec = new RequestSpecBuilder().setBaseUri("https://api.trello.com/1/boards").build();
        requestSpec = new RequestSpecBuilder().setBaseUri("https://api.trello.com/1/boards/").build();

    }

    @BeforeMethod
    public void beforeMethod() {
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
    }



    protected Response createBoardUtil() {


        String name = "( ͡° ͜ʖ ͡°)";
        String desc = "Base Description";
        String permissionLevel = "private";
        String voting = "members";
        String bgColor = "lime";

        BuildRequest buildRequest = new BuildRequest(name, desc, voting, permissionLevel, bgColor);
        Response response = SendRequest.sendPost(buildRequest.requestSpecification.queryParam("defaultLabels",true));
        BOARD_ID  = response.then().extract().path("id").toString();
        return response;
    }

    protected void createLabelsUtil() {


        String endpoint = BOARD_ID + "/labels";
        // Define test data
        List<CreateLabelsAutomated.TestData> testDataList = Arrays.asList(
                new CreateLabelsAutomated.TestData("orange", "orange"),
                new CreateLabelsAutomated.TestData("pink", "barbie"),
                new CreateLabelsAutomated.TestData("red", "bloody"),
                new CreateLabelsAutomated.TestData("blue", "ice")
        );

        for (CreateLabelsAutomated.TestData data : testDataList) {
            Response response = new BuildRequest().requestSpecification
                    .queryParam("color", data.color)
                    .queryParam("name", data.name)
                    .when()
                    .post(endpoint); // Send request
            response.then().spec(responseSpec); // Validate response
        }
    }


    protected void deleteBoardUtil(){

        String endpoint = BOARD_ID;
        Response response = new BuildRequest().requestSpecification.when().delete(endpoint);
        response.then().assertThat().statusCode(200 );
    }

}

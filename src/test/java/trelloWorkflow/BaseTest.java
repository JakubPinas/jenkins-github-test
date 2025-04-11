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


public class BaseTest {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    protected static String Key = ConfigReader.readConfigurationFile("KEY");
    protected static String Token = ConfigReader.readConfigurationFile("TOKEN");
    protected static String Auth = String.format("?&key=%s&token=%s",Key,Token);
    protected static String BOARD_ID;
    protected static String URL_FOR_OKHTTP  = "https://api.trello.com/1";

    @BeforeSuite
    public void setBaseURI() {
       // requestSpec = new RequestSpecBuilder().setBaseUri("https://api.trello.com/1/boards").build();
        requestSpec = new RequestSpecBuilder().setBaseUri("https://api.trello.com/1").build();

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

        String endpoint = "/boards/" + BOARD_ID + "/labels";

        String[] color = {"pink", "orange","blue", "red"};
        String[] name = {"barbie", "orange","ice", "bloody"};

        for (int i = 0; i < color.length; i++) {

            Response response = new BuildRequest().requestSpecification
                    .queryParam("color", color[i])
                    .queryParam("name", name[i])
                    .when()
                    .post(endpoint); // Send request
            response.then().spec(responseSpec);
        }
    }

    protected void deleteBoardUtil(){

        String endpoint = "/boards/" + BOARD_ID;
        Response response = new BuildRequest().requestSpecification.when().delete(endpoint);
        response.then().assertThat().statusCode(200 );
    }
}

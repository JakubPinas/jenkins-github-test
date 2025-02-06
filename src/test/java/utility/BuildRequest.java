package utility;

import trelloWorkflow.BaseTest;
import com.trello.PojoClasses.Response.BoardRootResponse;
import com.trello.PojoClasses.Response.Prefs;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;

//In this class I decided to do both RequestSpecification and POJO class including info about request
public class BuildRequest extends BaseTest {

    public RequestSpecification requestSpecification;
    public BoardRootResponse expectedResponse;



    public BuildRequest(String name, String desc, String voting, String permissionLevel, String bgColor) {
        this.requestSpecification = given().spec(requestSpec).contentType("application/json").
                queryParam("prefs_permissionLevel",permissionLevel).
                queryParam("prefs_voting", voting).
                queryParam("prefs_background", bgColor).
                queryParam("name",name).
                queryParam("desc",desc).
                queryParam("key",Key).
                queryParam("token", Token);

        BoardRootResponse boardRootResponse = new BoardRootResponse();
        boardRootResponse.setName(name);
        boardRootResponse.setDesc(desc);
        Prefs prefs = new Prefs();
        prefs.setVoting(voting);
        prefs.setPermissionLevel(permissionLevel);
        prefs.setBackground(bgColor);
        boardRootResponse.setPrefs(prefs);
        this.expectedResponse = boardRootResponse;
    }

    public BuildRequest()  {
        this.requestSpecification = given().spec(requestSpec).contentType("application/json").
                queryParam("key",Key).
                queryParam("token", Token);
    }

//    public static RequestSpecification createRequestPOSTBoard(String name, String desc, String voting, String permissionLevel, String bgColor) {
//        return given().spec(requestSpec).contentType("application/json").
//                queryParam("prefs_permissionLevel",permissionLevel).
//                queryParam("prefs_voting", voting).
//                queryParam("prefs_background", bgColor).
//                queryParam("name",name).
//                queryParam("desc",desc).
//                queryParam("key",Key).
//                queryParam("token", Token)
//                ;
//    }
}

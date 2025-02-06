package utility;
import io.restassured.response.Response;

public class PrepareActualResponse {

    public String actualName;
    public String actualDesc;
    public String actualPermission;
    public String actualVoting;
    public String actualBackgroundColor;

    public PrepareActualResponse(Response response) {
        this.actualName            = response.jsonPath().getString("name");
        this.actualDesc            = response.jsonPath().getString("desc");
        this.actualPermission      = response.jsonPath().getString("prefs.permissionLevel");
        this.actualVoting          = response.jsonPath().getString("prefs.voting");
        this.actualBackgroundColor = response.jsonPath().getString("prefs.background");

    }


}

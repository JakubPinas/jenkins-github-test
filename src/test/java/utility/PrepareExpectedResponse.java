package utility;
import com.trello.PojoClasses.Response.BoardRootResponse;

public class PrepareExpectedResponse {

    public String expectedName;
    public String expectedDesc;
    public String expectedPermission;
    public String expectedVoting;
    public String expectedBackgroundColor;

    public PrepareExpectedResponse(BoardRootResponse boardRootResponse) {
        this.expectedName = boardRootResponse.getName();
        this.expectedDesc = boardRootResponse.getDesc();
        this.expectedPermission = boardRootResponse.getPrefs().getPermissionLevel();
        this.expectedVoting = boardRootResponse.getPrefs().getVoting();
        this.expectedBackgroundColor = boardRootResponse.getPrefs().getBackground();
    }
}

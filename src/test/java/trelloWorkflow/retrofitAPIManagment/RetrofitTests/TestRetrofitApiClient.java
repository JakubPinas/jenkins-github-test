package trelloWorkflow.retrofitAPIManagment.RetrofitTests;

import trelloWorkflow.BaseTest;
import utilityRetrofit.CreateBoardClient;
import com.trello.PojoClasses.Request.BoardRootRequest;
import com.trello.PojoClasses.Response.BoardRootResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRetrofitApiClient extends BaseTest  {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Logger logger = Logger.getLogger(this.getClass().getName());
    CreateBoardClient createBoardClient = new CreateBoardClient();

    @Test
    public void validateBoardCreationTest() throws IOException {

        BoardRootRequest boardRootRequest = new BoardRootRequest();
        boardRootRequest.setName("RetrofitBoard");
        boardRootRequest.setDesc("dig dig dig");
        boardRootRequest.setDefaultLists(false);
        boardRootRequest.setDefaultLabels(false);
        boardRootRequest.setPrefs_background("pink");
        boardRootRequest.setPrefs_permissionLevel("public");

        Response<BoardRootResponse> response = createBoardClient.boardRootResponse(boardRootRequest);
        logger.log(Level.INFO, "Create Board Response: \n" + gson.toJson(response.body()));
        System.out.println(response.code());

        assert response.body() != null;
        BOARD_ID = response.body().getId();

        Assert.assertEquals(response.body().getName(),boardRootRequest.getName());
        Assert.assertEquals(response.body().getDesc(),boardRootRequest.getDesc());
        Assert.assertEquals(response.body().getPrefs().getPermissionLevel(),boardRootRequest.getPrefs_permissionLevel());
        Assert.assertEquals(response.body().getPrefs().getBackground(),boardRootRequest.getPrefs_background());

        deleteBoardUtil();
    }

}
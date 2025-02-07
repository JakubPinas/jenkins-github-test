package utilityRetrofit;
import com.trello.PojoClasses.Request.BoardRootRequest;
import com.trello.PojoClasses.Response.BoardRootResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;

public class CreateBoardClient  {

    Gson  gson = new GsonBuilder().setPrettyPrinting().create();
    String  baseUrl  = "https://api.trello.com/1/boards/";

    private final String apiKey = ConfigReader.readConfigurationFile("KEY");
    private final String apiToken = ConfigReader.readConfigurationFile("TOKEN");

    public CreateBoardService createBoardService(){
        Retrofit  retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return  retrofit.create(CreateBoardService.class);
    }

    public Response<BoardRootResponse>  boardRootResponse(BoardRootRequest boardRootRequest) throws IOException{
        Call<BoardRootResponse> call = createBoardService().createBoardRETROFIT(apiKey,apiToken,boardRootRequest);
        return call.execute();
    }

}

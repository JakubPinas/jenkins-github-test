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

    private final String apiKey = "85541f65f19064aa66861544bebcd890";
    private final String apiToken = "ATTAadbfd99515b6a81298b0f8942143e095dd9d4f915525ed0872e1cb26bcd7fa29F0EBD016";


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

package utilityRetrofit;

import com.trello.PojoClasses.Request.BoardRootRequest;
import com.trello.PojoClasses.Response.BoardRootResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CreateBoardService {
    @POST(".")
    Call<BoardRootResponse> createBoardRETROFIT(
            @Query("key") String key,
            @Query("token") String token,
            @Body BoardRootRequest createBoardRequest);
}

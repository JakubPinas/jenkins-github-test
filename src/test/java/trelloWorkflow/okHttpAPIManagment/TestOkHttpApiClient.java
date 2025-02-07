package trelloWorkflow.okHttpAPIManagment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.assertj.core.api.Assertions;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;
import trelloWorkflow.BaseTest;
import java.io.IOException;

public class TestOkHttpApiClient extends BaseTest {


    @Test
    public void postRequestCreateLists() throws IOException {

        createBoardUtil();

        RequestBody formBody = new FormBody.Builder()
                .add("id",BOARD_ID)
                .add("name","newList")
                .add("pos", "bottom")
                .build();

        Request request = new Request.Builder()
                .url(URL_FOR_OKHTTP + BOARD_ID + "/lists" + Auth)
                .post(formBody)
                .build();

        OkHttpClient client  =new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();

        Assertions.assertThat(response.isSuccessful()).as("Checking if sucessfull").isTrue();
        Assertions.assertThat(response.body().string()).as("Checking if not empty").isNotEmpty();

        deleteBoardUtil();
    }

    @Test
    public void customizeQueryGetLabels() throws IOException {

        createBoardUtil();
        createLabelsUtil();
        HttpUrl.Builder  urlBuilder = HttpUrl.parse(URL_FOR_OKHTTP + BOARD_ID + "/labels" ).newBuilder();

        urlBuilder
                .addQueryParameter("fields", "id")
                .addQueryParameter("fields","name")
                .addQueryParameter("fields","color")
                .addQueryParameter("key",Key)
                .addQueryParameter("token",Token);

        String url  = urlBuilder.build().toString();
        System.out.println(url);
        Request  request =new Request.Builder()
                .url(url)
                .build();

        OkHttpClient client  =new OkHttpClient();
        Call call = client.newCall(request);

        Response response = call.execute();
        Assertions.assertThat(response.isSuccessful()).as("Checking if sucessfull").isTrue();

        String responseBody = response.body().string();
        Assertions.assertThat(responseBody).as("Checking if not empty").isNotEmpty();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        Assertions.assertThat(jsonNode.isArray()).as("response should be JSON array").isTrue();

        for (JsonNode label : jsonNode) {

            System.out.println("Checking label: " + label.toPrettyString());
            //  Check mandatory fields exist and are not null
            Assertions.assertThat(label.has("id")).as("Each label must have an 'id'").isTrue();
            Assertions.assertThat(label.has("name")).as("Each label must have a 'name'").isTrue();
            Assertions.assertThat(label.has("color")).as("Each label must have a 'color'").isTrue();
        }
        //Assertions.assertThat(jsonNode.get("id").asText()).as("ID Board doesn't match").isEqualTo("67a3a21e4a5a477b6a9cc147");
        deleteBoardUtil();
    }

    @Test
    public void synchronousGETBoard() throws IOException {

        createBoardUtil();

        Request request = new Request.Builder()
                .url(URL_FOR_OKHTTP + BOARD_ID + Auth)
                .build();

        OkHttpClient client  =new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();

        Assertions.assertThat(response.isSuccessful()).as("Checking if sucessfull").isTrue();
        Assertions.assertThat(response.body().string()).as("Checking if not empty").isNotEmpty();

        deleteBoardUtil();
    }

    @Test
    public void  asynchrousGETBoard() throws IOException {


        createBoardUtil();

        Request request = new Request.Builder()
                .url(URL_FOR_OKHTTP + BOARD_ID + Auth)
                .build();
        OkHttpClient client =new OkHttpClient();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Assertions.assertThat(response.isSuccessful()).as("Checking if sucessfull").isTrue();
                Assertions.assertThat(response.body().string()).as("Checking if not empty").isNotEmpty();
            }
        });
        deleteBoardUtil();
    }

    @Test
    public void putRequestUpdateLists() throws IOException {
        //String boardID = "67a3a21e4a5a477b6a9cc147";
        createBoardUtil();

        RequestBody formBody = new FormBody.Builder()
                .add("id",BOARD_ID)
                .add("name","this shouldn't be lenny")
                .add("prefs/background", "sky")
                .build();

        Request request = new Request.Builder()
                .url(URL_FOR_OKHTTP + BOARD_ID + Auth)
                .put(formBody)
                .build();

        OkHttpClient client  =new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();

        Assertions.assertThat(response.isSuccessful()).as("Checking if sucessfull").isTrue();
        Assertions.assertThat(response.body().string()).as("Checking if not empty").isNotEmpty();

        deleteBoardUtil();
    }

    @Test
    public void deleteRequestDeleteBoard() throws IOException {
        //String boardID = "67a3a21e4a5a477b6a9cc147";
        createBoardUtil();

        Request request = new Request.Builder()
                .url(URL_FOR_OKHTTP + BOARD_ID + Auth)
                .delete()
                .build();

        OkHttpClient client  =new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();

        Assertions.assertThat(response.isSuccessful()).as("Checking if sucessfull").isTrue();
    }
}


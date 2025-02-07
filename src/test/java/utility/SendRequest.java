package utility;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SendRequest {

    public static Response sendGet(RequestSpecification requestSpecification ) {
        return requestSpecification.when().get();
    }

    public static Response sendPost(RequestSpecification requestSpecification) {
        return requestSpecification.when().post("/boards/");
    }

    public static Response sendPut(RequestSpecification requestSpecification) {
        return requestSpecification.when().put();
    }

    public static Response sendDelete(RequestSpecification requestSpecification) {
        return requestSpecification.when().delete();
    }
}

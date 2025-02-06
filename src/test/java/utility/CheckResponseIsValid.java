package utility;

import io.restassured.response.Response;
import org.testng.Assert;

public class CheckResponseIsValid {

    public static void validateResponse(Response response, int expectedStatus) {
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),expectedStatus);
        System.out.println("Expected status " + expectedStatus + " but got " + response.statusCode());
    }
}

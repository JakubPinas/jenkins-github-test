package trelloWorkflow;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import utility.BuildRequest;
import java.util.Arrays;
import java.util.List;

public class TestCreateLabelsAutomated extends BaseTest {

    static class TestData {
        String color;
        String name;

        TestData(String color, String name) {
            this.color = color;
            this.name = name;
        }
    }

    @Test
    public void createLabels() {


        String endpoint = BOARD_ID + "/labels";
        // Define test data
        List<TestData> testDataList = Arrays.asList(
                new TestData("orange", "orange"),
                new TestData("pink", "barbie"),
                new TestData("red", "bloody"),
                new TestData("blue", "ice")
        );

        for (TestData data : testDataList) {
            Response response = new BuildRequest().requestSpecification
                    .queryParam("color", data.color)
                    .queryParam("name", data.name)
                    .when()
                    .post(endpoint); // Send request
            response.then().spec(responseSpec); // Validate response

            Assertions.assertThat(response.jsonPath().getString("id"))
                    .as("Check ID")
                    .isNotNull()
                    .matches("^[a-f0-9]{24}$");

            Assertions.assertThat(response.jsonPath().getString("name"))
                    .as("Check name")
                    .isNotBlank()
                    .containsIgnoringCase(data.name);

            Assertions.assertThat(response.jsonPath().getString("color"))
                    .as("Check color")
                    .isEqualTo(data.color);

        }
    }
}


package trelloWorkflow;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.BuildRequest;

public class TestCreateLabelsAutomated extends BaseTest {

    @DataProvider(name = "data-provider")
    public Object[][] provideLabelData () {

        return new Object[][]  {
                {"orange", "orange"},
                {"pink", "barbie"},
                {"red", "bloody"},
                {"blue", "ice"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void createLabels(String color, String name) {

        String endpoint = "/boards/" + BOARD_ID + "/labels";

        Response response = new BuildRequest().requestSpecification
                .queryParam("color", color)
                .queryParam("name", name)
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
                .containsIgnoringCase(name);

        Assertions.assertThat(response.jsonPath().getString("color"))
                .as("Check color")
                .isEqualTo(color);
    }
}


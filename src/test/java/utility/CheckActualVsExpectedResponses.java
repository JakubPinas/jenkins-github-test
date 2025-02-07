package utility;

import org.testng.asserts.SoftAssert;
public class CheckActualVsExpectedResponses {

    public static void checkActualVsExpectedResponses(PrepareActualResponse actualResponse, PrepareExpectedResponse expectedResponse) {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResponse.actualName,           expectedResponse.expectedName, "Names don't match");
        softAssert.assertEquals(actualResponse.actualDesc,           expectedResponse.expectedDesc,"Descriptions don't match");
        softAssert.assertEquals(actualResponse.actualPermission,     expectedResponse.expectedPermission,"Permission levels don't match");
        softAssert.assertEquals(actualResponse.actualVoting,         expectedResponse.expectedVoting,"Voting permissions don't match ");
        softAssert.assertEquals(actualResponse.actualBackgroundColor,expectedResponse.expectedBackgroundColor,"Background colors don't match");
        softAssert.assertAll();

    }
}


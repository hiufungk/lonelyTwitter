package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    //will be run before test
    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity()); //(get connection to device, get activity)

    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testTweet(){
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class); //check if we are in LonelyTwitterActivity
        solo.enterText((EditText) solo.getView(R.id.body), "test tweet");

        solo.clickOnButton("Save"); //click whatever button on screen that says "Save"

        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("test tweet"));

        solo.clickOnButton("Clear");
        assertFalse(solo.searchText("test tweet"));
    }

    public void testClickTweetList(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();

        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "test tweet");
        solo.clickOnButton("Save");
        solo.waitForText("test tweet");

        final ListView oldTweetLst = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetLst.getItemAtPosition(0);
        assertEquals("test tweet", tweet.getMessage());

        solo.clickInList(0);
        solo.assertCurrentActivity("wrong activity", EditTweetActivity.class);
        assertTrue(solo.waitForText("test tweet"));

        solo.goBack(); //hit back button on device
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}
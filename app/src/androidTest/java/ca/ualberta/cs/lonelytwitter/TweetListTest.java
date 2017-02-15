package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by hiufungk on 2/14/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testStrings(){
        assertEquals("'test' should be 'test'", "test", "test");
        assertTrue("'test' should start eitj 't'", "test".startsWith("t"));
    }

    public void testAddTweetException(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");
        try {
            tweets.addTweet(tweet);
            tweets.addTweet(tweet);
            assertTrue(false);
        }catch (IllegalArgumentException e){
            assertTrue(true);
        }

    }

    public void testGetTweets() throws InterruptedException {
        TweetList tweets = new TweetList();

        Tweet tweet1 = new NormalTweet("test tweet1");
        TimeUnit.SECONDS.sleep(3);
        Tweet tweet2 = new NormalTweet("test tweet2");
        TimeUnit.SECONDS.sleep(3);
        Tweet tweet3 = new NormalTweet("test tweet3");
        TimeUnit.SECONDS.sleep(3);
        Tweet tweet4 = new NormalTweet("test tweet4");
        TimeUnit.SECONDS.sleep(3);
        tweets.add(tweet2);
        tweets.add(tweet1);
        tweets.add(tweet4);
        tweets.add(tweet3);



        ArrayList<Tweet> sortedTweetList = tweets.getTweets();
        int i;
        for (i = 1; i < sortedTweetList.size(); i++){
            assertTrue(sortedTweetList.get(i-1).getDate().before(sortedTweetList.get(i).getDate()));
        }

    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("test tweet1");
        Tweet tweet2 = new NormalTweet("test tweet2");
        Tweet tweet3 = new NormalTweet("test tweet3");


        tweets.add(tweet1);
        tweets.add(tweet2);


        assertTrue(tweets.hasTweet(tweet2));
        assertFalse(tweets.hasTweet(tweet3));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("test tweet1");
        Tweet tweet2 = new NormalTweet("test tweet2");
        Tweet tweet3 = new NormalTweet("test tweet3");

        assertEquals(tweets.getCount(), 0);
        tweets.add(tweet1);
        assertEquals(tweets.getCount(), 1);
        tweets.add(tweet2);
        assertEquals(tweets.getCount(), 2);
        tweets.add(tweet3);
        assertEquals(tweets.getCount(), 3);

        tweets.delete(tweet1);
        assertEquals(tweets.getCount(), 2);
        tweets.delete(tweet2);
        assertEquals(tweets.getCount(), 1);
        tweets.delete(tweet3);
        assertEquals(tweets.getCount(), 0);

    }
}

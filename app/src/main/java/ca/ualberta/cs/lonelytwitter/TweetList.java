package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by hiufungk on 2/14/17.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        tweets.add(tweet);
    }

    public void addTweet(Tweet tweet){
        if (tweets.contains(tweet) ){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public void delete (Tweet tweet){
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public int getCount(){
        return tweets.size();
    }

    class TweetDateComp implements Comparator<Tweet> {

        public int compare(Tweet t1, Tweet t2) {
            if(t1.getDate().before(t2.getDate())){
                return -1;
            } else {
                return 1;
            }
        }
    }

    public ArrayList<Tweet> getTweets(){
        Log.d("tweettag",tweets.toString());
        Collections.sort(tweets, new TweetDateComp());
        Log.d("tweettag",tweets.toString());
        return tweets;
    }
}

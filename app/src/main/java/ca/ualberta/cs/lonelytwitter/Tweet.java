package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hiufungk on 1/17/17.
 */

public abstract class Tweet implements Tweetable{ //Abstract classes cannot be instantiated
    private Date date;
    private String message;
    ArrayList<Mood> moodList = new ArrayList<Mood>();

    public Tweet(Date date, String message) throws TweetTooLongException {
        this.date = date;
        this.setMessage(message);
    }

    public Tweet(String message) throws TweetTooLongException {
        this.setMessage(message);
        this.date = new Date();
    }
    public abstract Boolean isImportant(); //all childclass must have this method that return a Boolean

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() >= 144){
            //todo throw error here
            throw new TweetTooLongException();
        }
        else{
            this.message = message;
        }

    }

    public void addMood(Mood mood){
        this.moodList.add(mood);
    }

    public ArrayList<Mood> getMood(){
        return this.moodList;
    }
}

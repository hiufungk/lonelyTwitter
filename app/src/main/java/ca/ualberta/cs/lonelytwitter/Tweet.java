package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hiufungk on 1/17/17.
 * <p>
 * Tweet class is a super class that implements tweets
 */
public abstract class Tweet implements Tweetable{ //Abstract classes cannot be instantiated
    private Date date;
    private String message;
    /**
     * The Mood list.
     */
    ArrayList<Mood> moodList = new ArrayList<Mood>();

    /**
     * Instantiates a new Tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public Tweet(Date date, String message) throws TweetTooLongException {
        this.date = date;
        this.setMessage(message);
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public Tweet(String message) throws TweetTooLongException {
        this.setMessage(message);
        this.date = new Date();
    }

    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant(); //all childclass must have this method that return a Boolean

    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception if length is bigger than 144 characters
     */
    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() >= 144){
            //todo throw error here
            throw new TweetTooLongException();
        }
        else{
            this.message = message;
        }

    }

    /**
     * Add mood.
     *
     * @param mood the mood
     */
    public void addMood(Mood mood){
        this.moodList.add(mood);
    }

    /**
     * Get mood array list.
     *
     * @return the array list
     */
    public ArrayList<Mood> getMood(){
        return this.moodList;
    }

    /*convert tweet to a string
    * format: date|message*/
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}

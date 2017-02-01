package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hiufungk on 1/17/17.
 */
public class ImportantTweet extends Tweet {
    /**
     * Instantiates a new Important tweet.
     *
     * @param date    the date of the tweet
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public ImportantTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public ImportantTweet(String message) throws TweetTooLongException {
        super(message);
    }

    /*show tweet important = true*/
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

    /**add "!!!!" to the end of the tweet*/
    @Override
    public String getMessage(){
        return super.getMessage() + " !!!!!";
    }
}

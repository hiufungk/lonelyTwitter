package ca.ualberta.cs.lonelytwitter;

/**
 * Created by hiufungk on 1/17/17.
 */
public class TweetTooLongException extends Exception {
    /**
     * Instantiates a new Tweet too long exception.
     */
    public TweetTooLongException() {
    }

    /**
     * Instantiates a new Tweet too long exception.
     *
     * @param detailMessage the detail message
     */
    public TweetTooLongException(String detailMessage) {
        super(detailMessage);
    }
}

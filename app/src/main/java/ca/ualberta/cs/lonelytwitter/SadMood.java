package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hiufungk on 1/17/17.
 */
public class SadMood extends Mood {

    /**
     * Instantiates a new Sad mood.
     *
     * @param date the date of the mood
     * @param mood the mood
     */
    public SadMood(Date date, String mood) {
        super(date, mood);
    }

    /**
     * Instantiates a new Sad mood.
     *
     * @param mood the mood
     */
    public SadMood(String mood) {
        super(mood);
    }

    /**
     * add a sad face to the mood
     * */
    public String printMood(){
        return this.mood + " :( ";
    }
}

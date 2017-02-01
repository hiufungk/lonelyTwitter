package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hiufungk on 1/17/17.
 */
public class HappyMood extends Mood {
    /**
     * Instantiates a new Happy mood.
     *
     * @param date the date of the mood
     * @param mood the mood
     */
    public HappyMood(Date date, String mood) {
        super(date, mood);
    }

    /**
     * Instantiates a new Happy mood.
     *
     * @param mood the mood
     */
    public HappyMood(String mood) {
        super(mood);
    }

    /**
    * add a smile face to the mood
     * */
    public String printMood(){
        return this.mood + " :) ";
    }
}

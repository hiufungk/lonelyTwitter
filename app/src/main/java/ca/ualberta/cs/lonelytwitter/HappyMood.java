package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hiufungk on 1/17/17.
 */

public class HappyMood extends Mood {
    public HappyMood(Date date, String mood) {
        super(date, mood);
    }

    public HappyMood(String mood) {
        super(mood);
    }

    public String printMood(){
        return this.mood + " :) ";
    }
}

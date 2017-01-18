package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hiufungk on 1/17/17.
 */

public class SadMood extends Mood {

    public SadMood(Date date, String mood) {
        super(date, mood);
    }

    public SadMood(String mood) {
        super(mood);
    }

    public String printMood(){
        return this.mood + " :( ";
    }
}

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hiufungk on 1/17/17.
 */
public abstract class Mood {
    private Date date;
    /**
     * The Mood.
     */
    protected String mood;

    /**
     * Instantiates a new Mood.
     *
     * @param date the date of the mood
     * @param mood the mood
     */
    public Mood(Date date, String mood) {
        this.date = date;
        this.mood = mood;
    }

    /**
     * Instantiates a new Mood.
     *
     * @param mood the mood
     */
    public Mood(String mood){
        this.date = new Date();
        this.mood = mood;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
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

    /**
     * Gets mood.
     *
     * @return the mood
     */
    public String getMood() {
        return mood;
    }

    /**
     * Sets mood.
     *
     * @param mood the mood
     */
    public void setMood(String mood) {
        this.mood = mood;
    }

    /**
     * Print mood string.
     *
     * @return the string
     */
    abstract public String printMood();
}

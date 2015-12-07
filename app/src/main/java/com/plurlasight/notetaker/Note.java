package com.plurlasight.notetaker;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Santosh Ganti on 12/4/2015.
 */
public class Note implements Serializable{
    private String title;
    private String note;
    private Date date;

    public Note(String title, String note, Date date) {
        super();
        this.title = title;
        this.date = date;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

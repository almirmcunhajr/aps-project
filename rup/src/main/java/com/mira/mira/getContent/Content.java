package com.mira.mira.getContent;

import java.util.ArrayList;

public class Content {
    public String title;
    public String overview;
    public String language;
    public String type;
    public ArrayList<String> genres;
    public int extId;

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getLanguage() {
        return language;
    }

    public String getType() {
        return this.type;
    }

    public ArrayList<String> getGenres() { return this.genres; }

    public int getExtId() {
        return this.extId;
    }
}

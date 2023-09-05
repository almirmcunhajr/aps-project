package com.mira.mira.getContent;

public class Content {
    public String title;
    public String overview;
    public String language;
    public String type;
    public String genre;
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

    public String getGenre() { return this.genre; }

    public int getExtId() {
        return this.extId;
    }
}

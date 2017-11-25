package com.yousef.mustafa.speakmylanguage.Model;

/**
 * Created by myousef on 24.11.17.
 * Project: speakmylanguage
 */

public class Language {

    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Language is " + language;
    }
}
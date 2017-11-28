package com.yousef.mustafa.speakmylanguage.Model;

/**
 * Created by myousef on 24.11.17.
 * Project: speakmylanguage
 */

public class Word {

    private String mDefaultTranslation;
    private String mForeignTranslation;
    private int mRecordedAudioResourceId;

    public Word(String defaultTranslation, String foreignTranslation, int recordedAudioResourceId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mForeignTranslation = foreignTranslation;
        this.mRecordedAudioResourceId = recordedAudioResourceId;
    }

    public Word(String foreignTranslation, String defaultTranslation) {
        this.mForeignTranslation = foreignTranslation;
        this.mDefaultTranslation = defaultTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getForeignTranslation() {
        return mForeignTranslation;
    }

    public void setDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }

    public void setForeignTranslation(String mForeignTranslation) {
        this.mForeignTranslation = mForeignTranslation;
    }

    public int getmRecordedAudioResourceId() {
        return mRecordedAudioResourceId;
    }
}
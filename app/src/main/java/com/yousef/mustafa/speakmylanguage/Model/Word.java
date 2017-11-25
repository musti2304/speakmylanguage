package com.yousef.mustafa.speakmylanguage.Model;

/**
 * Created by myousef on 24.11.17.
 * Project: speakmylanguage
 */

public class Word {

    private String mDefaultTranslation;
    private String mForeignTranslation;
    private int mRecordedAudioResourceId;

    public Word(String mDefaultTranslation, String mForeignTranslation, int mRecordedAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mForeignTranslation = mForeignTranslation;
        this.mRecordedAudioResourceId = mRecordedAudioResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmForeignTranslation() {
        return mForeignTranslation;
    }

    public int getmRecordedAudioResourceId() {
        return mRecordedAudioResourceId;
    }
}
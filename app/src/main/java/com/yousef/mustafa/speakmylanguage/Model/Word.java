package com.yousef.mustafa.speakmylanguage.Model;

import android.widget.ImageView;

/**
 * Created by myousef on 24.11.17.
 * Project: speakmylanguage
 */

public class Word {

    private String mDefaultTranslation;
    private String mForeignTranslation;
    private int recordIconImageResourceId;
    private int mRecordedAudioResourceId;

    public Word(String foreignTranslation, String defaultTranslation, int recordImageResourceId) {
        this.mForeignTranslation = foreignTranslation;
        this.mDefaultTranslation = defaultTranslation;
        this.recordIconImageResourceId = recordImageResourceId;
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

    public int getRecordIconImageResourceId() {
        return recordIconImageResourceId;
    }

    public int getmRecordedAudioResourceId() {
        return mRecordedAudioResourceId;
    }
}

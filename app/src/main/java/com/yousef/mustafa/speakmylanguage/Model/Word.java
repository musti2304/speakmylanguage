package com.yousef.mustafa.speakmylanguage.Model;

import android.media.MediaRecorder;
import android.widget.ImageView;

/**
 * Created by myousef on 24.11.17.
 * Project: speakmylanguage
 */

public class Word {

    private String mForeignTranslation;
    private String mDefaultTranslation;
    private ImageView mRecordIconImageResourceId;
    private MediaRecorder mMediaRecorder;

    public Word(String foreignTranslation, String defaultTranslation, ImageView recordIconImageResourceId, MediaRecorder mediaRecorder) {
        this.mForeignTranslation = foreignTranslation;
        this.mDefaultTranslation = defaultTranslation;
        this.mRecordIconImageResourceId = recordIconImageResourceId;
        this.mMediaRecorder = mediaRecorder;
    }

    public Word(String foreignTranslation, String defaultTranslation, ImageView recordIconImageResourceId) {
        this.mForeignTranslation = foreignTranslation;
        this.mDefaultTranslation = defaultTranslation;
        this.mRecordIconImageResourceId = recordIconImageResourceId;
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

    public ImageView getRecordIconImageResourceId() {
        return mRecordIconImageResourceId;
    }

    public MediaRecorder getMediaRecorder() {
        return mMediaRecorder;
    }

    public void setDefaultTranslation(String mDefaultTranslation) { this.mDefaultTranslation = mDefaultTranslation; }

    public void setForeignTranslation(String mForeignTranslation) { this.mForeignTranslation = mForeignTranslation; }

    public void setRecordIconImageResourceId(ImageView recordIconImageResourceId) { this.mRecordIconImageResourceId = recordIconImageResourceId; }

    public void setMediaRecorder(MediaRecorder mMediaRecorder) { this.mMediaRecorder = mMediaRecorder; }
}
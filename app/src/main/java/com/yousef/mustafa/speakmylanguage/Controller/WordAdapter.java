package com.yousef.mustafa.speakmylanguage.Controller;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yousef.mustafa.speakmylanguage.Model.Word;
import com.yousef.mustafa.speakmylanguage.R;
import com.yousef.mustafa.speakmylanguage.View.MyWordsActivity;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by myousef on 24.11.17.
 * Project: speakmylanguage
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private ArrayList<Word> wordsArrayList = new ArrayList<>();
    private MediaRecorder mediaRecorder = new MediaRecorder();



    public WordAdapter(@NonNull Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.my_word_list_items, parent, false);
        }

        Word currentWord = getItem(position);

        TextView foreignWord = listItemView.findViewById(R.id.myForeignWord);
        foreignWord.setText(currentWord.getForeignTranslation());

        TextView defaultWord = listItemView.findViewById(R.id.myDefaultWord);
        defaultWord.setText(currentWord.getDefaultTranslation());

        final ImageView recordIconImageView = listItemView.findViewById(R.id.recordIconImageView);
//        recordIconImageView = currentWord.getRecordIconImageResourceId();

        wordsArrayList = MyWordsActivity.getWordsArrayList();

        recordIconImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        recordIconImageView.setImageResource(R.drawable.mic_red);
                        startAudioRecording();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        recordIconImageView.setImageResource(R.drawable.mic_black);
                        stopAudioRecording();
                        break;
                    }
                }
                return true;
            }
        });

        return listItemView;
    }

//    private ArrayList<Word> getWordsArrayList() {
//        return wordsArrayList;
//    }

    private void startAudioRecording() {

        if (wordsArrayList != null) {
            Log.i("ArrayListe", wordsArrayList.toArray().toString());
            getMediaRecorderReady();

            try {
                mediaRecorder.prepare();
                mediaRecorder.start();
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(this.getContext(), "Recording started", Toast.LENGTH_SHORT).show();
        }
    }

    private void stopAudioRecording() {
        try {
            mediaRecorder.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this.getContext(), "Recording stopped", Toast.LENGTH_SHORT).show();
    }

    private void getMediaRecorderReady() {
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "speakmylanguage" + "/" + MyWordsActivity.getForeignWord() + ".3gp");
    }
}
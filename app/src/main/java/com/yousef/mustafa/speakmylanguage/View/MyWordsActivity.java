package com.yousef.mustafa.speakmylanguage.View;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yousef.mustafa.speakmylanguage.Controller.WordAdapter;
import com.yousef.mustafa.speakmylanguage.Model.Word;
import com.yousef.mustafa.speakmylanguage.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by myousef on 17.11.17.
 * Project: speakmylanguage
 */

public class MyWordsActivity extends AppCompatActivity {

    public static final int RequestPermissionCode = 1;
    String defaultWord, foreignWord;
    String audioSavePath;
    ArrayList<Word> wordsArrayList = new ArrayList<>();
    int position = 0;
    MediaRecorder mediaRecorder;

    // Views
    TextView hintTextView;
    ListView myWordsListView;
    FloatingActionButton floatingButtonAddNewWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_words);

        // MyWordsActivity views
        hintTextView = findViewById(R.id.hintTextView);
        myWordsListView = findViewById(R.id.myWordsList);
        floatingButtonAddNewWord = findViewById(R.id.fab);

        floatingButtonAddNewWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog addNewWordsDialog = new Dialog(MyWordsActivity.this);
                addNewWordsDialog.setContentView(R.layout.activity_add_new_words);
                final EditText addDefaultWordEditText = addNewWordsDialog.findViewById(R.id.addDefaultWordEditText);
                final EditText addForeignWordEditText = addNewWordsDialog.findViewById(R.id.addForeignWordEditText);
                final Button addWordButton = addNewWordsDialog.findViewById(R.id.addWordButton);
                final ImageView imageView = addNewWordsDialog.findViewById(R.id.recordImageView);

                addWordButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (!addDefaultWordEditText.getText().toString().equals("") && !addForeignWordEditText.getText().toString().equals("")) {
                            WordAdapter wordAdapter = new WordAdapter(MyWordsActivity.this, getWordsArrayList());
                            defaultWord = addDefaultWordEditText.getText().toString();
                            foreignWord = addForeignWordEditText.getText().toString();
                            wordsArrayList.add(new Word(foreignWord, defaultWord));
                            myWordsListView.setAdapter(wordAdapter);
                            hintTextView.setVisibility(View.GONE);
//                            addNewWordsDialog.dismiss();
                        } else {
                            Toast.makeText(MyWordsActivity.this, "Please enter two words", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN: {
                                imageView.setImageResource(R.drawable.mic_red);
                                startAudioRecording();
                                break;
                            }
                            case MotionEvent.ACTION_UP: {
                                imageView.setImageResource(R.drawable.mic_black);
                                stopAudioRecording();
                                addNewWordsDialog.dismiss();
                                break;
                            }
                        }
                        return true;
                    }
                });

                addNewWordsDialog.show();
            }
        });
    }

    public ArrayList<Word> getWordsArrayList() {
        return wordsArrayList;
    }


    private void startAudioRecording() {
        if (checkPermission()) {

            if (wordsArrayList != null) {
                audioSavePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + wordsArrayList.get(position).getForeignTranslation() + ".3gp";
                ++position;
                getMediaRecorderReady();
            }


            try {
                mediaRecorder.prepare();
                mediaRecorder.start();
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(MyWordsActivity.this, "Recording started", Toast.LENGTH_LONG).show();
        } else {
            requestPermission();
        }
    }

    private void stopAudioRecording() {
        mediaRecorder.stop();
        Toast.makeText(MyWordsActivity.this, "Recording stopped", Toast.LENGTH_LONG).show();
    }

    private void getMediaRecorderReady() {
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(audioSavePath);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(MyWordsActivity.this, new String[]{
                WRITE_EXTERNAL_STORAGE,
                RECORD_AUDIO}, RequestPermissionCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length > 0) {
                    boolean StoragePermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean RecordPermission = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;

                    if (StoragePermission && RecordPermission) {
                        Toast.makeText(MyWordsActivity.this, "Permission Granted",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MyWordsActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    private boolean checkPermission() {
        int resultWrite = ContextCompat.checkSelfPermission(getApplicationContext(),
                WRITE_EXTERNAL_STORAGE);
        int resultRecord = ContextCompat.checkSelfPermission(getApplicationContext(),
                RECORD_AUDIO);
        return resultWrite == PackageManager.PERMISSION_GRANTED &&
                resultRecord == PackageManager.PERMISSION_GRANTED;
    }
}
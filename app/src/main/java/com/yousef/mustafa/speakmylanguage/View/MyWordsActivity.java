package com.yousef.mustafa.speakmylanguage.View;

import android.app.Dialog;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yousef.mustafa.speakmylanguage.Controller.WordAdapter;
import com.yousef.mustafa.speakmylanguage.Model.Word;
import com.yousef.mustafa.speakmylanguage.R;

import java.util.ArrayList;

/**
 * Created by myousef on 17.11.17.
 * Project: speakmylanguage
 */

public class MyWordsActivity extends AppCompatActivity {

    private static String defaultWord, foreignWord;
    private static ArrayList<Word> wordsArrayList = new ArrayList<>();
    WordAdapter wordAdapter;

    // Main Activity Views
    TextView hintTextView;
    ListView myWordsListView;
    FloatingActionButton floatingButtonAddNewWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_words);

        // Init Main Activity Views
        hintTextView = findViewById(R.id.hintTextView);
        myWordsListView = findViewById(R.id.myWordsList);
        floatingButtonAddNewWord = findViewById(R.id.fabAddNewWord);

        floatingButtonAddNewWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog addNewWordsDialog = new Dialog(MyWordsActivity.this);
                addNewWordsDialog.setContentView(R.layout.activity_add_new_words);
                final EditText addForeignWordEditText = addNewWordsDialog.findViewById(R.id.addForeignWordEditText);
                final EditText addDefaultWordEditText = addNewWordsDialog.findViewById(R.id.addDefaultWordEditText);
                final Button addNewWordButton = addNewWordsDialog.findViewById(R.id.addNewWordButton);
                addNewWordsDialog.show();

                addNewWordButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!addDefaultWordEditText.getText().toString().equals("") && !addForeignWordEditText.getText().toString().equals("")) {
                            foreignWord = addForeignWordEditText.getText().toString();
                            defaultWord = addDefaultWordEditText.getText().toString();
                            wordsArrayList.add(new Word(foreignWord, defaultWord));
                            hintTextView.setVisibility(View.GONE);
                            addNewWordsDialog.dismiss();
                        } else {
                            Toast.makeText(MyWordsActivity.this, "Please enter two words", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                wordAdapter = new WordAdapter(MyWordsActivity.this, getWordsArrayList());
                myWordsListView.setAdapter(wordAdapter);
            }
        });
    }

    public static String getDefaultWord() {
        return defaultWord;
    }

    public static void setDefaultWord(String defaultWord) {
        MyWordsActivity.defaultWord = defaultWord;
    }

    public static String getForeignWord() {
        return foreignWord;
    }

    public static void setForeignWord(String foreignWord) {
        MyWordsActivity.foreignWord = foreignWord;
    }

    public static ArrayList<Word> getWordsArrayList() {
        return wordsArrayList;
    }

/*
    public void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{
                WRITE_EXTERNAL_STORAGE, RECORD_AUDIO, CAPTURE_AUDIO_OUTPUT, STORAGE}, REQUEST_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_CODE:
                if (grantResults.length > 0) {
                    boolean StoragePermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean RecordPermission = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;

                    if (StoragePermission && RecordPermission) {
                        Toast.makeText(this, "Permission Granted",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Permission Denied",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    public boolean checkPermission() {
        int resultWrite = ContextCompat.checkSelfPermission(this,
                WRITE_EXTERNAL_STORAGE);
        int resultRecord = ContextCompat.checkSelfPermission(this,
                RECORD_AUDIO);
        return resultWrite == PackageManager.PERMISSION_GRANTED &&
                resultRecord == PackageManager.PERMISSION_GRANTED;
    }
*/

}
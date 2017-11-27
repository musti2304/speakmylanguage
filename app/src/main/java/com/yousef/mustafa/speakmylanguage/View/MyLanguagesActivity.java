package com.yousef.mustafa.speakmylanguage.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yousef.mustafa.speakmylanguage.Model.Language;
import com.yousef.mustafa.speakmylanguage.R;

import java.util.ArrayList;

/**
 * Created by myousef on 17.11.17.
 * Project: speakmylanguage
 */

public class MyLanguagesActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> languageArrayList;


    /** Change of thinking, how about doing it in the activity
     *  Create a TextView with a hint
     *  When double tap convert the TextView to an EditText
     *  Then add another TextView below to repeat the same steps
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_languages);

        textView = findViewById(R.id.hintTextView);
        listView = findViewById(R.id.myLanguagesListView);

        languageArrayList = new ArrayList<>();
        languageArrayList.add("Language");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.my_languages_list_items, R.id.myLanguagesTextView, languageArrayList);
        listView.setAdapter(arrayAdapter);

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                return false;
            }
        });

    }
}
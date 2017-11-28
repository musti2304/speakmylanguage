package com.yousef.mustafa.speakmylanguage.View;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yousef.mustafa.speakmylanguage.R;

import java.util.ArrayList;

/**
 * Created by myousef on 17.11.17.
 * Project: speakmylanguage
 */

public class MyLanguagesActivity extends AppCompatActivity {

    // Views
    TextView hintTextView;
    ListView myLanguagesListView;
    FloatingActionButton floatingButtonAddNewLanguage;

    EditText addLanguageEditText;
    Button addButton;

    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> languageArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_languages);

        // MyLanguagesActivity views
        hintTextView = findViewById(R.id.hintTextView);
        myLanguagesListView = findViewById(R.id.myLanguagesListView);
        floatingButtonAddNewLanguage = findViewById(R.id.fab);

        // AltertDialog views
        addButton = new Button(MyLanguagesActivity.this);
        addLanguageEditText = new EditText(MyLanguagesActivity.this);


        floatingButtonAddNewLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MyLanguagesActivity.this);
                dialog.setContentView(R.layout.activity_add_new_language);
                final EditText editText = dialog.findViewById(R.id.addLanguageEditText);
                final Button button = dialog.findViewById(R.id.addLanguageButton);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!editText.getText().toString().equals("")) {
                            languageArrayList.add(editText.getText().toString());
                            arrayAdapter = new ArrayAdapter<>(MyLanguagesActivity.this, R.layout.my_languages_list, getLanguageArrayList());
                            myLanguagesListView.setAdapter(arrayAdapter);
                            hintTextView.setVisibility(View.GONE);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(MyLanguagesActivity.this, "Please enter language", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                dialog.show();
            }
        });
    }

    public ArrayList<String> getLanguageArrayList() {
        return languageArrayList;
    }
}
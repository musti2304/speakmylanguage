package com.yousef.mustafa.speakmylanguage.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.yousef.mustafa.speakmylanguage.Controller.LanguageAdapter;
import com.yousef.mustafa.speakmylanguage.Model.Language;
import com.yousef.mustafa.speakmylanguage.R;

/**
 * Created by myousef on 17.11.17.
 * Project: speakmylanguage
 */

public class AddNewLanguageActivity extends Activity {

    EditText addLanguageEditText;
    Button addLanguageButton;
    ListView myLanguagesListView;
    LanguageAdapter myLanguageAdapter;
    String enteredLanguage;
    Intent getLanguageIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_language);

        addLanguageEditText = findViewById(R.id.addLanguageEditText);
        addLanguageButton = findViewById(R.id.addLanguageButton);
        //myLanguagesListView = findViewById(R.id.myLanguagesList);

        enteredLanguage = addLanguageEditText.getText().toString();

        getLanguageIntent = new Intent();

        addLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLanguageIntent.putExtra("lang", enteredLanguage);
                setResult(RESULT_OK, getLanguageIntent);
                finish();
            }
        });
/*
        addLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<Language> languageArrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.activity_my_languages, R.id.myLanguagesTextView);
                myLanguagesListView.setAdapter(languageArrayAdapter);
            }
        });
*/

    }
}

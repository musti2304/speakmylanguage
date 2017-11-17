package com.yousef.mustafa.speakmylanguage;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

/**
 * Created by myousef on 17.11.17.
 */

public class AddNewLanguageActivity extends Activity {

    Button addNewLanguageButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_language);

        addNewLanguageButton = findViewById(R.id.button_add_language);

        addNewLanguageButton.setOnClickListener(new O);
    }
}

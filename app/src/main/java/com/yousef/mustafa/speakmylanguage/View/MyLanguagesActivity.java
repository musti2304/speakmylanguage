package com.yousef.mustafa.speakmylanguage.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yousef.mustafa.speakmylanguage.R;

/**
 * Created by myousef on 17.11.17.
 * Project: speakmylanguage
 */

public class MyLanguagesActivity extends AppCompatActivity {

    FloatingActionButton fab_addNewLanguage;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    TextView textView;
    String language;



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



        arrayAdapter = new ArrayAdapter<>(this, R.layout.my_languages_list, R.id.myLanguagesTextView);
        listView.setAdapter(arrayAdapter);
        textView.setVisibility(View.INVISIBLE);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
//        textView = findViewById(R.id.hintTextView);


        fab_addNewLanguage = findViewById(R.id.fab);
        fab_addNewLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyLanguagesActivity.this, AddNewLanguageActivity.class);
                startActivity(intent);

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_CODE) {
            if(resultCode == RESULT_OK) {
                String language = data.getStringExtra("lang");

                textView.setText(language);
                textView.setVisibility(View.VISIBLE);
            }
        }
    }
*/
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_languages, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}

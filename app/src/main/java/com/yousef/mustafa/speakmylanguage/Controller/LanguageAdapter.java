package com.yousef.mustafa.speakmylanguage.Controller;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.yousef.mustafa.speakmylanguage.Model.Language;
import com.yousef.mustafa.speakmylanguage.R;
import com.yousef.mustafa.speakmylanguage.View.AddNewLanguageActivity;

import java.util.ArrayList;

/**
 * Created by myousef on 24.11.17.
 * Project: speakmylanguage
 * © Copyright by myousef
 */

public class LanguageAdapter extends ArrayAdapter<Language> {


    public LanguageAdapter(Activity context, ArrayList<Language> languages) {
        super(context, 0, languages);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.my_languages_list, parent, false);
        }

        Language currentLanguage = getItem(position);

        TextView myLanguageTextView = listItemView.findViewById(R.id.myLanguagesTextView);
        myLanguageTextView.setText(currentLanguage.getLanguage());

        return listItemView;

    }
}
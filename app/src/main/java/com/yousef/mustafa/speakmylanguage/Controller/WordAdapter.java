package com.yousef.mustafa.speakmylanguage.Controller;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yousef.mustafa.speakmylanguage.Model.Word;
import com.yousef.mustafa.speakmylanguage.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by myousef on 24.11.17.
 * Project: speakmylanguage
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(@NonNull Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.my_word_list_items, parent, false);
        }

        Word currentWord = getItem(position);

        TextView defaultWord = listItemView.findViewById(R.id.myDefaultWord);
        defaultWord.setText(currentWord.getDefaultTranslation());

        TextView foreignWord = listItemView.findViewById(R.id.myForeignWord);
        foreignWord.setText(currentWord.getForeignTranslation());

        View textContainer = listItemView.findViewById(R.id.myWordsListItems);

        return listItemView;
    }
}
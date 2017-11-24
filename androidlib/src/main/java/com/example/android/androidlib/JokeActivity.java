package com.example.android.androidlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static String JOKE_INTENT_KEY = "joke_intent_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokes_activity);
        if (getIntent().hasExtra(JOKE_INTENT_KEY)) {
            String joke = getIntent().getStringExtra(JOKE_INTENT_KEY);
            TextView textView = (TextView) findViewById(R.id.joke_text);

            textView.setText(joke);
        }
    }
}

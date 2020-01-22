package com.illicitintelligence.storytime;

import android.content.Intent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.illicitintelligence.storytime.R;

public class DetailsActivity extends AppCompatActivity {
    TextView storyContent;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        storyContent = findViewById(R.id.contentOfStory);
        Intent i = getIntent();
        String title = i.getStringExtra("titleOfStory");
        String content = i.getStringExtra("contentOfStory");

        actionBar = getSupportActionBar();
        // set the appbar title as Story title
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.colorVelocity)));
            actionBar.setTitle(title);
        }

        // set content of the story to textview
        storyContent.setText(content);
        storyContent.setMovementMethod(new ScrollingMovementMethod());

        // enable back button to main activity or recyclerview
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

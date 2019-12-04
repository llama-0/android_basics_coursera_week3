package com.example.week3task;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static String TEXT_KEY = "TEXT_KEY";

    private TextView mTextView;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_second);

        mTextView = findViewById(R.id.tvText);
        mBtn = findViewById(R.id.btnSecond);

        Bundle bundle = getIntent().getExtras();
        mTextView.setText(bundle.getString(TEXT_KEY));

        mBtn.setOnClickListener(taskSecondOnClickListener);
    }

    private View.OnClickListener taskSecondOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent browserIntent = new Intent(Intent.ACTION_WEB_SEARCH);
            browserIntent.putExtra(SearchManager.QUERY, mTextView.getText().toString());
            startActivity(browserIntent);

        }
    };
}

package com.example.week3task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private EditText mText;
    private Button mBtnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        mText = findViewById(R.id.etText);
        mBtnClick = findViewById(R.id.btnClick);

        mBtnClick.setOnClickListener(taskOnClickListener);
    }

    private View.OnClickListener taskOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isInputEmpty()) {
                showMessage(mText.getText().toString());
                Intent startSecondIntent = new Intent(FirstActivity.this, SecondActivity.class);
                startSecondIntent.putExtra(SecondActivity.TEXT_KEY, mText.getText().toString());
                startActivity(startSecondIntent);
            }
        }
    };

    private boolean isInputEmpty() {
        return !TextUtils.isEmpty(mText.getText());
    }

    private void showMessage(String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }
}

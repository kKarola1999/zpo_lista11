package com.example.zpo_lista11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCalculateValueForX(View view) {
        final EditText editText = (EditText) findViewById(R.id.editMessage); //wpis
        String dane = editText.getText().toString();

        Intent intent = new Intent(this, CalculateForX.class);
        intent.putExtra(EXTRA_MESSAGE, dane);
        startActivity(intent);
    }

    public void onDerivativeClick(View view) {
        final EditText editText = (EditText) findViewById(R.id.editMessage); //wpis
        String dane = editText.getText().toString();

        Intent intent = new Intent(this, Derivative.class);
        intent.putExtra(EXTRA_MESSAGE, dane);
        startActivity(intent);
    }
}
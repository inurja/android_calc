package com.calculator.intz.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView textView;
    private static ArrayList<String> numberList = new ArrayList<String>();
    private static String numberString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.inputOutput);
    }

    public void onClick(View view) {
        Button btn = (Button) view;
        String idAsString = btn.getResources().getResourceName(btn.getId());
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Button pressed :" + idAsString);
        }
        if(btn.getText().equals("C")) {
            clearDisplay();
        } else {
            numberString = numberString + btn.getText();
            numberList.add(numberString);
            Log.d(TAG, "numberList array: " + numberList);
            displayNumbers();
        }
    }

    public void displayNumbers() {
        textView.setText(numberString);
    }

    public void clearDisplay() {
        numberString = "";
        displayNumbers();
    }
}

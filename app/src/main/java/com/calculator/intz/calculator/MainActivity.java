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
    public static String btnString = "";
    private Logic logic = new Logic();

    //private static final String STATE_NUMBERLIST = "numberList";
    //private static final String STATE_NUMBERSTRING = "numberString";
    //private static final String STATE_TEMPSTRING = "tempString";
    //private static final String STATE_VIEWSTRING = "viewString";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.inputOutput);

        if (savedInstanceState != null){
            if (BuildConfig.DEBUG) {
                Log.d(TAG, "Restoring state");
            }

            logic.setNumberList(savedInstanceState.getStringArrayList("STATE_NUMBERLIST"));
            displayNumbers();
        }
    }

    public void onClick(View view) {
        Button btn = (Button) view;
        String idAsString = btn.getResources().getResourceName(btn.getId());
        //Logic logic = new Logic();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Button pressed :" + idAsString);
        }

        btnString = btn.getText().toString();
        logic.tempString = btnString;
        logic.calculate();
        displayNumbers();
    }

    public void displayNumbers() {
        ArrayList arr = logic.getNumberList();
        String view = "";
        for (int i = 0; i < arr.size(); i++) {
            view = view + arr.get(i);
        }
        textView.setText(view);
        setTextSize();
    }

    public TextView getTextView() {
        //setTextView();
        return textView;
    }

    public void setTextView() {
        textView = (TextView) findViewById(R.id.inputOutput);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onSaveInstanceState called");
        }
        savedInstanceState.putStringArrayList("STATE_NUMBERLIST", logic.getNumberList());

        super.onSaveInstanceState(savedInstanceState);
    }

    public void setTextSize() {
        textView.setTextSize(40);
    }
}

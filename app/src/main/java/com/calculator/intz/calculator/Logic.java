package com.calculator.intz.calculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by intz on 9.03.16.
 */
public class Logic extends AppCompatActivity {

    public static ArrayList<String> numberList = new ArrayList<String>();
    public static String numberString = "";
    public static String viewString = "";
    public static String tempString = "";
    public static int answer = 0;

    public void calculate() {
        if(tempString.contains("C")) {
            clearDisplay();
            clearArrayMemeory();
        } else if(numberList.size() == 2 && lastIsOperator(numberList) && isOperator(tempString)) { //check so user cant input operators in a row
            numberList.remove(1);
            numberList.add(1, tempString);
            //main.displayNumbers();
        } else if(tempString.contains("=")) { //if equals is pressed, then calculate whats on the screen
            if(numberList.get(1).contains("+")) {
                answer = Integer.parseInt(numberList.get(0)) + Integer.parseInt(numberList.get(2));
            } else if(numberList.get(1).contains("-")) {
                answer = Integer.parseInt(numberList.get(0)) - Integer.parseInt(numberList.get(2));
            } else if(numberList.get(1).contains("*")) {
                answer = Integer.parseInt(numberList.get(0)) * Integer.parseInt(numberList.get(2));
            } else if(numberList.get(1).contains("/")) {
                answer = Integer.parseInt(numberList.get(0)) / Integer.parseInt(numberList.get(2));
            }

            numberList.clear();
            numberList.add(Integer.toString(answer));
            //main.displayNumbers();
        } else {
            if(isOperator(tempString)) {
                numberList.add(tempString);
                numberString = "";

                if(numberList.size() == 4) { //calculate first two numbers
                    int first = Integer.parseInt(numberList.get(0));
                    int second = Integer.parseInt(numberList.get(2));
                    String operator = numberList.get(1).toString();
                    String lastOperator = numberList.get(3).toString();

                    numberList.clear();
                    if(operator.contains("+")) {
                        answer = first + second;
                    } else if(operator.contains("-")) {
                        answer = first - second;
                    } else if(operator.contains("*")) {
                        answer = first * second;
                    } else if(operator.contains("/")) {
                        answer = first / second;
                    }
                    numberList.add(Integer.toString(answer));
                    numberList.add(lastOperator);


                }
            } else {
                numberString = numberString + tempString;

                if (numberList.size() > 0 && !lastIsOperator(numberList)) {
                    numberList.remove(numberList.size()-1);
                }
                numberList.add(numberString);

            }
            //main.displayNumbers();
        }
    }

    /*public void displayNumbers() {
        TextView tV = main.getTextView();
        viewString = "";
        for (int i = 0; i < numberList.size(); i++) {
            viewString = viewString + numberList.get(i);
        }
        tV.setText(viewString);
        //main.textView.setText(viewString);
    }*/

    public void clearDisplay() {
        clearStringMemory();
        clearArrayMemeory();
        //main.displayNumbers();
    }

    public void clearArrayMemeory() {
        numberList.clear();
    }

    public void clearStringMemory() {
        numberString = "";
    }

    public void saveToViewString() {
        viewString = viewString + numberString;
    }

    public boolean lastIsOperator(ArrayList<String> arr) {
        if(arr.get(arr.size()-1).contains("+") ||
                arr.get(arr.size()-1).contains("-") ||
                arr.get(arr.size()-1).contains("*") ||
                arr.get(arr.size()-1).contains("/")) {
            return true;
        } return false;
    }

    public boolean isOperator(String str) {
        if(str.contains("+") || str.contains("-") || str.contains("*") || str.contains("/")) {
            return true;
        } return false;
    }

    public String getViewString() {
        return viewString;
    }

    public ArrayList getNumberList() {
        return numberList;
    }

    public String getNumberString() {
        return numberString;
    }

    public String getTempString() {
        return tempString;
    }

    public int getAnswer() {
        return answer;
    }

    public void setViewString(String str) {
        viewString = str;
    }

    public void setNumberList(ArrayList<String> arr) {
        numberList = arr;
    }

    public void setNumberString(String str) {
        numberString = str;
    }

    public void setTempString(String str) {
        tempString = str;
    }

    public void setAnswer(int in) {
        answer = in;
    }
}

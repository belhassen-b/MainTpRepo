package com.example.tp_android;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CalcActivity extends AppCompatActivity {

    private TextView textViewResult;
    private TextView textViewOperation;

    String operation = "";

//    String result = "";

    double result = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        initializeViews();
    }

    private void initializeViews() {
        textViewResult = findViewById(R.id.textViewResult);
        textViewOperation = findViewById(R.id.textViewOperation);
    }

    public void clear(View view) {
        operation = "";
        result = 0.0;
        textViewOperation.setText(operation);
        textViewResult.setText(String.valueOf(result));
    }

    public void equal(View view) {
        if (operation.length() > 0) {
            operation = operation.replace("0-", "-");

            String[] numbers = operation.split("\\+|\\-|\\*|\\/");
            if (numbers.length == 2) {
                double number1 = Double.parseDouble(numbers[0]);
                double number2 = Double.parseDouble(numbers[1]);
                double result = 0;
                if (operation.contains("+")) {
                    result = number1 + number2;
                } else if (operation.contains("-")) {
                    result = number1 - number2;
                } else if (operation.contains("*")) {
                    result = number1 * number2;
                } else if (operation.contains("/")) {
                    result = number1 / number2;
                }
                operation = String.valueOf(result);

                textViewResult.setText(String.valueOf(result));
                textViewOperation.setText(operation);
            }
        }
    }

    public void add(View view) {
        if (operation.length() > 0) {
            char lastChar = operation.charAt(operation.length() - 1);
            if (lastChar != '+') {
                operation += "+";
                textViewOperation.setText(operation);
            }
        }
    }

    public void sub(View view) {
        if (operation.length() > 0) {
            char lastChar = operation.charAt(operation.length() - 1);
            if (lastChar != '-') {
                operation += "-";
                textViewOperation.setText(operation);
            }
        }
    }

    public void mul(View view) {
        if (operation.length() > 0) {
            char lastChar = operation.charAt(operation.length() - 1);

            if (lastChar != '*') {
                operation += "*";
                textViewOperation.setText(operation);
            }
        }
    }

    public void div(View view) {
        if (operation.length() > 0) {
            char lastChar = operation.charAt(operation.length() - 1);
            if (lastChar != '/') {
                operation += "/";
                textViewOperation.setText(operation);
            }
        }
    }

    public void one(View view) {
        operation += "1";
        textViewOperation.setText(operation);
    }

    public void two(View view) {
        operation += "2";
        textViewOperation.setText(operation);
    }

    public void three(View view) {
        operation += "3";
        textViewOperation.setText(operation);
    }

    public void four(View view) {
        operation += "4";
        textViewOperation.setText(operation);
    }


    public void five(View view) {
        operation += "5";
        textViewOperation.setText(operation);
    }

    public void six(View view) {
        operation += "6";
        textViewOperation.setText(operation);
    }

    public void seven(View view) {
        operation += "7";
        textViewOperation.setText(operation);
    }

    public void eight(View view) {
        operation += "8";
        textViewOperation.setText(operation);
    }

    public void nine(View view) {
        operation += "9";
        textViewOperation.setText(operation);
    }

    public void zero(View view) {
        operation += "0";
        textViewOperation.setText(operation);
    }

    public void dot(View view) {
        if (operation.length() > 0) {
            char lastChar = operation.charAt(operation.length() - 1);
            if (lastChar != '.') {
                operation += ".";
                textViewOperation.setText(operation);
            }
        }
    }


    public void plusMinus(View view) {
        if (operation.length() > 0) {
            char firstChar = operation.charAt(0);
            if (firstChar == '-') {
                operation = operation.substring(1, operation.length());
            } else {
                operation = "-" + operation;
            }
            textViewOperation.setText(operation);
        }
    }

    public void percent(View view) {
        if (operation.length() > 0) {
            char lastChar = operation.charAt(operation.length() - 1);
            if (lastChar != '%') {
                operation += "%";
                textViewOperation.setText(operation);
            }
        }
    }



}
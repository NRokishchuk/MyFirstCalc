package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    private static final String KEY_VALUE = "key_value";
    private static final String KEY_OPERATOR = "key_operator";
    private static final String KEY_RESULT = "key_result";


    private TextView txtResult;
    private double valueBuffer;
    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        operator = '1';
        valueBuffer = 0;
        txtResult = findViewById(R.id.outputTextView);



    }

    private void initButton() {
        Button btnNumberOne = findViewById(R.id.button1);
        btnNumberOne.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 1;
            txtResult.setText(value);
        });

        Button btnNumberTwo = findViewById(R.id.button2);
        btnNumberTwo.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 2;
            txtResult.setText(value);
        });

        Button btnNumberThree = findViewById(R.id.button3);
        btnNumberThree.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 3;
            txtResult.setText(value);
        });

        Button btnNumberFour = findViewById(R.id.button4);
        btnNumberFour.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 4;
            txtResult.setText(value);
        });

        Button btnNumberFive = findViewById(R.id.button5);
        btnNumberFive.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 5;
            txtResult.setText(value);
        });

        Button btnNumberSix = findViewById(R.id.button6);
        btnNumberSix.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 6;
            txtResult.setText(value);
        });

        Button btnNumberSeven = findViewById(R.id.button7);
        btnNumberSeven.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 7;
            txtResult.setText(value);
        });

        Button btnNumberEight = findViewById(R.id.button8);
        btnNumberEight.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 8;
            txtResult.setText(value);
        });

        Button btnNumberNine = findViewById(R.id.button9);
        btnNumberNine.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 9;
            txtResult.setText(value);
        });

        Button btnNumberDot = findViewById(R.id.buttonDot);
        btnNumberDot.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + ".";
            txtResult.setText(value);
        });

        Button btnNumberZero = findViewById(R.id.button0);
        btnNumberZero.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 0;
            txtResult.setText(value);

        });

        Button clearNum = findViewById(R.id.buttonClear);
        clearNum.setOnClickListener(view -> {
            valueBuffer = 0;
            txtResult.setText("");
        });

        Button ans = findViewById(R.id.buttonEqual);
        ans.setOnClickListener(view -> {
            switch (operator) {
                case '+':
                    valueBuffer += Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(String.valueOf(valueBuffer));
                    break;
                case '-':
                    valueBuffer -= Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(String.valueOf(valueBuffer));
                    break;
                case '/':
                    valueBuffer /= Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(String.valueOf(valueBuffer));
                    break;
                case '*':
                    valueBuffer *= Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(String.valueOf(valueBuffer));
                    break;
            }
            operator = 0;
        });

        Button btnMinus = findViewById(R.id.buttonMinus);
        btnMinus.setOnClickListener(v -> {
            valueBuffer = Double.parseDouble(txtResult.getText().toString());
            operator = btnMinus.getText().charAt(0);
            txtResult.setText("");
        });

        @SuppressLint("CutPasteId") Button btnPlus = findViewById(R.id.buttonAdd);
        btnPlus.setOnClickListener(v -> {
            valueBuffer = Double.parseDouble(txtResult.getText().toString());
            operator = btnPlus.getText().charAt(0);
            txtResult.setText("");
        });

        @SuppressLint("CutPasteId") Button btnDivide = findViewById(R.id.buttonDivide);
        btnDivide.setOnClickListener(v -> {
            valueBuffer = Double.parseDouble(txtResult.getText().toString());
            operator = btnDivide.getText().charAt(0);
            txtResult.setText("");
        });

        Button btnMultiply = findViewById(R.id.buttonMultiply);
        btnMultiply.setOnClickListener(v -> {
            valueBuffer = Double.parseDouble(txtResult.getText().toString());
            operator = btnMultiply.getText().charAt(0);
            txtResult.setText("");
        });


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putDouble(KEY_VALUE, valueBuffer);
        instanceState.putString(KEY_RESULT, txtResult.getText().toString());
        instanceState.putChar(KEY_OPERATOR, operator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        double value = instanceState.getDouble(KEY_VALUE);
        String result = instanceState.getString(KEY_RESULT);
        char operator = instanceState.getChar(KEY_OPERATOR);
        setConfig(value, result, operator);
    }

    private void setConfig(double value, String result, char operator) {
        valueBuffer = value;
        if (operator != 0) {
            this.operator = operator;
        }

        txtResult.setText(result);
    }
}
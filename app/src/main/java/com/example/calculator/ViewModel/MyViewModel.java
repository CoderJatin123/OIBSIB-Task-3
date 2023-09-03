package com.example.calculator.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.calculator.Calculator;

public class MyViewModel extends ViewModel {

    public MutableLiveData<String> expression,result;
    public Calculator calculator;

    public MyViewModel() {
        expression=new MutableLiveData<>("");
        result=new MutableLiveData<>("");
        calculator=new Calculator();
    }

    public LiveData<String> getExpression() {
        return expression;
    }

    public LiveData<String> getResult() {
        return result;
    }

    public void clear(){
        expression.setValue("");
        result.setValue("");
    }

    public void addExp(String x){


        expression.setValue(expression.getValue().concat(x));
        if(isLastCharacterDigit(expression.getValue()))
            result.setValue(String.valueOf( calculator.evaluateExpression(expression.getValue())));
    }

    public boolean isLastCharacterDigit(String input) {

        if (input != null && !input.isEmpty()) {
            char lastChar = input.charAt(input.length() - 1);
            if (Character.isDigit(lastChar) ) {
                return true;
            }
        }

        return false;
    }

    public boolean areNumbersValid(String expression) {
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");

        for (String token : tokens) {
            if (token.matches("[0-9]+(\\.[0-9]+)?")) {
                String[] parts = token.split("\\.");
                if (parts.length > 2) {
                    return false;
                }
            }
        }

        return true;
    }
}

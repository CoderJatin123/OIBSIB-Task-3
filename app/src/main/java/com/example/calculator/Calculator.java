package com.example.calculator;

public class Calculator {

    public double evaluateExpression(String expression) {
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");

        double currentNumber = 0;
        char currentOperator = '+';

        for (String token : tokens) {
            if (token.matches("[0-9]+(\\.[0-9]+)?")) {
                double number = Double.parseDouble(token);

                switch (currentOperator) {
                    case '+':
                        currentNumber += number;
                        break;
                    case '-':
                        currentNumber -= number;
                        break;
                    case '*':
                        currentNumber *= number;
                        break;
                    case '/':
                        if (number == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        currentNumber /= number;
                        break;
                }
            } else if (token.matches("[-+*/%]")) {
                currentOperator = token.charAt(0);
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        return currentNumber;
    }
}


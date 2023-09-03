package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.ViewModel.MyViewModel;

public class MainActivity extends AppCompatActivity {
    private Button btnDelete, btnPercentage;
    private Button btnSeven, btnEight, btnNine, btnMultiply;
    private Button btnFour, btnFive, btnSix, btnMinus;
    private Button btnOne, btnTwo, btnThree, btnPlus;
    private Button btnDot, btnZero, btnDivide;
    private MyViewModel viewModel;
    private TextView expression,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.clear();
                result.setText("00");
            }
        });


        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("%");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("9");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("*");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("6");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("-");            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("3");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("+");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp(".");
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("0");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addExp("/");
            }
        });

        viewModel.getResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(!s.equals(null))
                     result.setText(s);
            }
        });

        viewModel.getExpression().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(!s.equals(null))
                    expression.setText(s);
            }
        });

    }
    private void init(){
        viewModel=new MyViewModel();
        btnDelete = findViewById(R.id.btn_delete);
        btnPercentage = findViewById(R.id.btn_percentage);

        btnSeven = findViewById(R.id.btn_seven);
        btnEight = findViewById(R.id.btn_eight);
        btnNine = findViewById(R.id.btn_nine);
        btnMultiply = findViewById(R.id.btn_multiple);

        btnFour = findViewById(R.id.btn_four);
        btnFive = findViewById(R.id.btn_five);
        btnSix = findViewById(R.id.btn_six);
        btnMinus = findViewById(R.id.btn_minus);

        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnPlus = findViewById(R.id.btn_plus);

        btnDot = findViewById(R.id.btn_dot);
        btnZero = findViewById(R.id.btn_zero);
        btnDivide = findViewById(R.id.btn_divide);
        expression=findViewById(R.id.expression);
        result=findViewById(R.id.result);
    }

}
package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlus;
    Button btnMinus;
    Button btnDel;
    Button btnUmn;


    EditText etNumber1;
    EditText etNumber2;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find our buttons
        btnPlus = (Button) findViewById(R.id.button);
        btnMinus = (Button) findViewById(R.id.button2);
        btnDel = (Button) findViewById(R.id.button3);
        btnUmn = (Button) findViewById(R.id.button4);

        etNumber1 = (EditText) findViewById(R.id.editText);
        etNumber2 = (EditText) findViewById(R.id.editText2);

        tvResult  = (TextView) findViewById(R.id.textView);

        //make them active onClick
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnUmn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        //check for empty attributes
        if(TextUtils.isEmpty(etNumber1.getText().toString()) || TextUtils.isEmpty(etNumber2.getText().toString())){
            return;
        }

        //Give our editTexts 0
        num1 = Float.parseFloat(etNumber1.getText().toString());
        num2 = Float.parseFloat(etNumber2.getText().toString());


        //Chose button
        switch (v.getId()){
            case R.id.button:
                result = num1 + num2;
                break;
            case R.id.button2:
                result = num1 - num2;
                break;
            case R.id.button3:
                result = num1 / num2;
                //check for divide
                if(num2 == 0){
                    tvResult.setText("Don't divide by zero!");
                    return;
                }
                break;
            case R.id.button4:
                result = num1 * num2;
                break;
        }
        tvResult.setText("Answer is " + result);
    }
}

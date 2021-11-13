package com.medo.equationssolver.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.medo.equationssolver.R;
import com.medo.equationssolver.model.recyclerView.Operation;

public class four extends AppCompatActivity {
Button btn1,btn2;
EditText et;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        btn1 =findViewById(R.id.button5); //d to b
        btn2=findViewById(R.id.button6); // b to d
        et=findViewById(R.id.editTextNumber);
        tv=findViewById(R.id.textView3);
        //d to b
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et.getText().toString().isEmpty())
                    Toast.makeText(four.this, "please enter the values", Toast.LENGTH_SHORT).show();
                else {
                    tv.setText(decimalToBinary(Integer.parseInt(et.getText().toString())));
                    infoScreen.addToDataBase(
                            new Operation(et.getText().toString(),"ans: "+tv.getText().toString(),
                                    "decimal to binary"));
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et.getText().toString().isEmpty())
                    Toast.makeText(four.this, "please enter the values", Toast.LENGTH_SHORT).show();

               else {
                   if(isNotBinary(et.getText().toString()))
                       Toast.makeText(four.this, "please enter a binary number", Toast.LENGTH_SHORT).show();
                  else {
                       tv.setText(String.valueOf(binaryToDecimal(et.getText().toString())));
                       infoScreen.addToDataBase(
                               new Operation(et.getText().toString(),"ans: "+tv.getText().toString(),
                                       "binary to decimal"));
                   }
            }}
        });
    }

    private boolean isNotBinary(String toString) {
        for (int i = 0; i < toString.length(); i++) {
            int i1 = Integer.parseInt(String.valueOf(toString.charAt(i)));
            if(i1 !=1 && i1 !=0)
                return true;
        }
        return false;
    }

    private static String decimalToBinary(int d) {
        if(d==1) {
            return "1";
        }
        // true:false
        //  case case
        return decimalToBinary(d/2)+(d%2==1 ?"1":"0");
    }
    private static int binaryToDecimal(String b) {
        int d=0;
        double a=0.5;
        for (int i = b.length()-1; i >= 0; i--) {
            d+= Integer.parseInt(String.valueOf(b.charAt(i)))*2*a;
            a=a*2;
        }
        return d;
    }
}
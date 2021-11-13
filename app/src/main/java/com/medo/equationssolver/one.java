package com.medo.equationssolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class one extends AppCompatActivity {
EditText et[];
TextView tv;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        et=new EditText[3];
        et[0]=findViewById(R.id.editTextNumberDecimal);
        et[1]=findViewById(R.id.editTextNumberDecimal2);
        et[2]=findViewById(R.id.editTextNumberDecimal3);
        tv=findViewById(R.id.textView3);
        btn=findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et[0].getText().toString().isEmpty() || et[1].getText().toString().isEmpty() ||et[2].getText().toString().isEmpty())
                    Toast.makeText(one.this, "please enter the values", Toast.LENGTH_SHORT).show();
                else{
                double a,b,r;
                a=Double.parseDouble(et[0].getText().toString());
                b=Double.parseDouble(et[1].getText().toString());
                r=Double.parseDouble(et[2].getText().toString());
                if (r != 0)
                    b-=r;
                double sol1 = (-b) / a;
                tv.setText(String.valueOf(sol1));
            }
            }
        });
    }
}
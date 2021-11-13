package com.medo.equationssolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;

public class two extends AppCompatActivity {
    EditText et[];
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        et=new EditText[4];
        et[0]=findViewById(R.id.editTextNumberDecimal);
        et[1]=findViewById(R.id.editTextNumberDecimal2);
        et[2]=findViewById(R.id.editTextNumberDecimal3);
        et[3]=findViewById(R.id.editTextNumberDecimal4);
        tv=findViewById(R.id.textView3);
        btn=findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et[0].getText().toString().isEmpty()||et[1].getText().toString().isEmpty()||et[2].getText().toString().isEmpty()||et[3].getText().toString().isEmpty())
                    Toast.makeText(two.this, "please enter the values", Toast.LENGTH_SHORT).show();
                else{
                int a,b,c,r;
                a=Integer.parseInt(et[0].getText().toString());
                b=Integer.parseInt(et[1].getText().toString());
                c=Integer.parseInt(et[2].getText().toString());
                r=Integer.parseInt(et[3].getText().toString());

                if (r != 0)
                    b-=r;
                double sqrt = Math.sqrt(b * b - 4 * a * c);
                double sol1 = ((-b) + sqrt) / 2 * a;
                double sol2 = ((-b) - sqrt) / 2 * a;
                String sol="the result is : "+String.valueOf(sol1)+" or "+String.valueOf(sol2);
                tv.setText(sol);
            }
            }
        });
    }
}
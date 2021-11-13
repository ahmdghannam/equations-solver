package com.medo.equationssolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class three extends AppCompatActivity {
    EditText et[];
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        et=new EditText[6];
        et[0]=findViewById(R.id.editTextNumber);
        et[1]=findViewById(R.id.editTextNumberSigned2);
        et[2]=findViewById(R.id.editTextNumberSigned3);
        et[3]=findViewById(R.id.editTextNumberSigned4);
        et[4]=findViewById(R.id.editTextNumberSigned5);
        et[5]=findViewById(R.id.editTextNumberSigned6);
        tv=findViewById(R.id.textView3);
        btn=findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et[0].getText().toString().isEmpty()||et[1].getText().toString().isEmpty()||et[2].getText().toString().isEmpty()||et[3].getText().toString().isEmpty())
                    Toast.makeText(three.this, "please enter the values", Toast.LENGTH_SHORT).show();
                else{
                    int abc[][]=new int [3][3];
                    abc[0][0]=Integer.parseInt(et[0].getText().toString());
                    abc[0][1]=Integer.parseInt(et[1].getText().toString());
                    abc[0][2]=Integer.parseInt(et[2].getText().toString());

                    abc[1][0]=Integer.parseInt(et[3].getText().toString());
                    abc[1][1]=Integer.parseInt(et[4].getText().toString());
                    abc[1][2]=Integer.parseInt(et[5].getText().toString());


                    double X = ((abc[0][2] * abc[1][1]) - (abc[1][2] * abc[0][1])) / ((abc[0][0] * abc[1][1]) - (abc[0][1] * abc[1][0]));
                    double Y = ((abc[0][0] * abc[1][2]) - (abc[1][0] * abc[0][2])) / ((abc[0][0] * abc[1][1]) - (abc[0][1] * abc[1][0]));
                    String sol="the result is : X= "+String.valueOf(X)+" and Y= "+String.valueOf(Y);
                    tv.setText(sol);
                }
            }
        });
    }
}
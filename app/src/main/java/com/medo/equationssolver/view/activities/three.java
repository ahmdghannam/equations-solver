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
                double X;
                double Y;
                if(et[0].getText().toString().isEmpty()||et[1].getText().toString().isEmpty()||et[2].getText().toString().isEmpty()||et[3].getText().toString().isEmpty())
                    Toast.makeText(three.this, "please enter the values", Toast.LENGTH_SHORT).show();
                else{
                    double abc[][]=new double[3][3];
                    abc[0][0]=Double.parseDouble(et[0].getText().toString());
                    abc[0][1]=Double.parseDouble(et[1].getText().toString());
                    abc[0][2]=Double.parseDouble(et[2].getText().toString());

                    abc[1][0]=Double.parseDouble(et[3].getText().toString());
                    abc[1][1]=Double.parseDouble(et[4].getText().toString());
                    abc[1][2]=Double.parseDouble(et[5].getText().toString());

                    try {

                        X = ((abc[0][2] * abc[1][1]) - (abc[1][2] * abc[0][1])) / ((abc[0][0] * abc[1][1]) - (abc[0][1] * abc[1][0]));

                        Y = ((abc[0][0] * abc[1][2]) - (abc[1][0] * abc[0][2])) / ((abc[0][0] * abc[1][1]) - (abc[0][1] * abc[1][0]));
//                     if(String.valueOf(X).equalsIgnoreCase("nan") ||String.valueOf(Y).equalsIgnoreCase("nan"))
                        if(Double.isNaN(X) ||Double.isNaN(Y))
                        tv.setText(R.string.m_error);
                     else {
                         String sol = "the result is : X= " + String.valueOf(X) + " and Y= " + String.valueOf(Y);
                         tv.setText(sol);
                     }
                        infoScreen.addToDataBase(
                                new Operation(abc[0][0]+"X"+"+"+abc[0][1]+"Y"+"="+ abc[0][2]+"\n"+abc[1][0]+
                                        "X"+"+"+abc[1][1]+"Y"+"="+ abc[1][2]+"\n","ans: "+ String.valueOf(X) + " and Y= " + String.valueOf(Y),
                                        "two variables equations"));

                    }catch (Exception e){
                        tv.setText(R.string.m_error);
                        infoScreen.addToDataBase(
                                new Operation(abc[0][0]+"X"+"+"+abc[0][1]+"Y"+"="+ abc[0][2]+"\n"+abc[1][0]+
                                        "X"+"+"+abc[1][1]+"Y"+"="+ abc[1][2]+"\n","ans: "+ R.string.m_error,
                                        "two variables equations"));
                    }

                }
            }
        });
    }
}
package com.medo.equationssolver.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.medo.equationssolver.R;
import com.medo.equationssolver.databinding.RecyclerViewLayoutBinding;

public class navigationScreen extends AppCompatActivity {
 Button btn[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn=new Button[4];
        btn[0]=findViewById(R.id.button7);
        btn[1]=findViewById(R.id.button2);
        btn[2]=findViewById(R.id.button3);
        btn[3]=findViewById(R.id.button4);
        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigationScreen.this, one.class));
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigationScreen.this, two.class));
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigationScreen.this, three.class));
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigationScreen.this, four.class));
            }
        });
    }

//    if you want to make it java so it will be locally in this activity

//    public void openActivity3(View view) {
//        Intent intent = new Intent(this, one.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//    }

//    @Override
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
//    }

}
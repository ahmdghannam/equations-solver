package com.medo.equationssolver.view.activities.infoScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.medo.equationssolver.databinding.ActivityMainBinding;
import com.medo.equationssolver.model.database.DatabaseHandler;
import com.medo.equationssolver.view.activities.navigationScreen;

import java.util.ArrayList;
import java.util.List;

public class infoScreen extends AppCompatActivity {
    private ActivityMainBinding binding;
    private static DatabaseHandler databaseHandler;
    private List<Operation> operations;
    private RecuclerViewAdapter recuclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        //fixed size
       binding.recyclerView.setHasFixedSize(true);
       //layout manager
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //adapter
        operations = new ArrayList<>();
        // adding data to the operations list from the database
        databaseHandler=new DatabaseHandler(infoScreen.this);

        operations=databaseHandler.get();
        if(operations.isEmpty()) {
//            binding.recyclerView.setVisibility(View.GONE);
            binding.history.setVisibility(View.GONE);
             binding.greeting.setVisibility(View.VISIBLE);
        }else{
            binding.history.setVisibility(View.VISIBLE);
        }

        recuclerViewAdapter=new RecuclerViewAdapter(operations,getApplicationContext());
        binding.recyclerView.setAdapter(recuclerViewAdapter);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(infoScreen.this, navigationScreen.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        operations=databaseHandler.get();
        recuclerViewAdapter=new RecuclerViewAdapter(operations,getApplicationContext());
        binding.recyclerView.setAdapter(recuclerViewAdapter);
        if(!operations.isEmpty()) {
//            binding.recyclerView.setVisibility(View.GONE);
            binding.greeting.setVisibility(View.GONE );
        }
      recuclerViewAdapter.notifyDataSetChanged();
    }

    private List<Operation> addRubbeshData() {
        List<Operation>operations=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
           operations.add(new Operation("Input","result","activity name-"+i));
        }
        return operations;

    }

    public static void addToDataBase(Operation operation){
        databaseHandler.add(operation);
    }
}
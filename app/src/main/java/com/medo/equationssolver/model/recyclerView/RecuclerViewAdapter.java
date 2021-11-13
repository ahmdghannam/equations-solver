package com.medo.equationssolver.model.recyclerView;

import android.app.Dialog;
import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.medo.equationssolver.R;

import java.util.List;

/*** Created by medog on 23/09/2021 
 */
public class RecuclerViewAdapter extends RecyclerView.Adapter<RecuclerViewAdapter.ViewHolder> {
    //the attributes
    //context of the class that instantiated an object of this model
    private final Context context;

    // list of the model so we but but it sequentially in the recycler view
    private List<Operation> operationList;
    // layout inflater
//    LayoutInflater li ;

    public RecuclerViewAdapter(List<Operation> operationList, Context context) {
        this.operationList = operationList;
        this.context = context;

//        this.li=li;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder( LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_layout, parent, false));

    }

    @Override
    // to set the recycler view card elements text or stuff
    public void onBindViewHolder(ViewHolder holder, int position) {

      // we create an object of the same list type (the model) and specify it of the position provided in the arguments

        Operation item = operationList.get(position);
         holder.result.setText(item.getResult());
         holder.input.setText(item.getEquations());
         holder.activityName.setText(item.getActivityName());

    }

    @Override
    public int getItemCount() {
        if (operationList == null) {
            return 0;
        }
        return operationList.size();
    }
    // set on click listener of the recycler view card in the view holder class
    class ViewHolder extends RecyclerView.ViewHolder {
        Dialog dialog;
        TextView activityName, input,result;
        ViewHolder(View itemView) {
            super(itemView);
         input =itemView.findViewById(R.id.tvInput);
         result=itemView.findViewById(R.id.tvResult);
        activityName=itemView.findViewById(R.id.tvActivityName);

           itemView.setOnClickListener(v->{
             //              int SPLASH_TIME = 3000;

// Handling splash timer.
//               private void startSplashTimer() {
//                   new Handler().postDelayed(
//                           new Runnable() {
//                               @Override
//                               public void run() {
//
//                               }
//                           }, SPLASH_TIME);

//               dialog = new Dialog(context);
//               // when the LayoutInflater is not exist you need to define it like this
//
//               customDialogBinding = CustomDialogBinding.inflate(LayoutInflater.from(context));
//               dialog.setContentView(customDialogBinding.getRoot());
//                customDialogBinding.result.setText(result.getText().toString());
//               customDialogBinding.equations.setText(equations.getText().toString());
//                  dialog.dismiss();
//                  dialog.show();
              Toast.makeText(context.getApplicationContext(), "input:- "+ input.getText().toString()+"\n\nresult:- "+result.getText().toString(), Toast.LENGTH_SHORT).show();

           });
            }
        }

    }



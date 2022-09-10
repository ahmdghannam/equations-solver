package com.medo.equationssolver.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.medo.equationssolver.view.activities.infoScreen.Operation;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String ID = "id";
    private static final String TABLE_NAME = "slover_database";
    private static final String ACTIVITY_NAME = "operation_name";
    private static final String EQUATIONS = "equations";
    private static final String RESULT = "result";

    public DatabaseHandler(@Nullable Context context) {
        super(context, TABLE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE "+TABLE_NAME+
                " ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ACTIVITY_NAME +" TEXT,"+
                EQUATIONS+" TEXT,"+RESULT+" TEXT)";
           sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
               String query="DROP TABLE IF EXISTS "+TABLE_NAME;
               sqLiteDatabase.execSQL(query);
               onCreate(sqLiteDatabase);
    }

   public boolean add(Operation operation){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
       ContentValues contentValues=new ContentValues();
       contentValues.put(EQUATIONS,operation.getEquations());
       contentValues.put(RESULT,operation.getResult());
       contentValues.put(ACTIVITY_NAME,operation.getActivityName());
       long done= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
       sqLiteDatabase.close();
//       infoScreen.recuclerViewAdapter.notifyDataSetChanged();
        return done!=-1;
   }

   public List<Operation> get(){
        List<Operation> operations=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
       Cursor cursor=sqLiteDatabase.rawQuery(query,null);
       if (cursor.moveToFirst())
       {
           do {
               operations.add(new Operation
                             (cursor.getString(2)
                               ,cursor.getString(3),
                                 cursor.getString(1)));
           }while (cursor.moveToNext());
       }
       cursor.close();
       sqLiteDatabase.close();
        return operations;
   }


}

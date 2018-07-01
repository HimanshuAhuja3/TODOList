package com.example.himanshuahuja.todolist;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class todoOpenHepler extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "todo_db";
        public static final int VERSION = 1;



    private static todoOpenHepler instance;

        public static todoOpenHepler getInstance(Context context){
            if(instance == null){
                instance = new todoOpenHepler(context.getApplicationContext());
            }
            return instance;
        }


    private todoOpenHepler(Context context) {
            super(context, DATABASE_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String todosql ="CREATE TABLE " + Contract.Todo.TABLE_NAME + "("+
                    Contract.Todo.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    Contract.Todo.COLUMN_NAME  + " TEXT , " +
                    Contract.Todo.COLUMN_DAY + " TEXT )";



            sqLiteDatabase.execSQL(todosql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
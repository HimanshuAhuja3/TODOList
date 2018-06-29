package com.example.himanshuahuja.todolist;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    ArrayList<todo> todos = new ArrayList<>();
    // adapter;
    todoAdapter adapter;

    public static final int ADD_EXPENSE_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listview);
        adapter = new todoAdapter(this, todos);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                todo todo = todos.get(i);
                showInputBox(todo.getName(),todo.getDay(),i);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                todo todo = todos.get(i);


                final int position = i;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Confirm Delete");
                builder.setCancelable(false);
                builder.setMessage("Do you really want to delete " + todo.getName() + "?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //Toast.makeText(MainActivity.this,"Ok Presses",Toast.LENGTH_LONG).show();
                        todos.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //TODO
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

//

                //Toast.makeText(this,expense.getName() + " " + expense.getAmount(),Toast.LENGTH_LONG).show();


                return true;
            }
        });

        View view = new View(this);
    }
    public void showInputBox(String name,  String day, final int index){
        final int position=index;
        final Dialog dialog=new Dialog(MainActivity.this);
        dialog.setTitle("Input Box");
        dialog.setContentView(R.layout.input_box);
        TextView textView=(TextView)dialog.findViewById(R.id.txtmsz);
        textView.setText("Update Item");
        textView.setTextColor(Color.parseColor("#ff2222"));
        final EditText editText=dialog.findViewById(R.id.todoname);
        editText.setText(name);
        final  EditText editText1=dialog.findViewById(R.id.daytxt);
        editText1.setText(day);
        Button bt=dialog.findViewById(R.id.btnset);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todo todo = todos.get(index);
                todo.setName(editText.getText().toString());
                todo.setDay(position,editText1.getText().toString());
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.addtodo) {
            Bundle bundle = new Bundle();
            bundle.putString("title", "abc");
            bundle.putString("day", "monday");

            Intent intent = new Intent(this, AddTodoActivity.class);
            intent.putExtras(bundle);
            startActivityForResult(intent, ADD_EXPENSE_REQUEST_CODE);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("MainActivity", "Activity Result called");
        if (requestCode == ADD_EXPENSE_REQUEST_CODE) {
            if (resultCode == AddTodoActivity.ADD_RESULT_CODE) {
                String title = data.getStringExtra(AddTodoActivity.TITLE_KEY);
                String day = data.getStringExtra(AddTodoActivity.DAY_KEY);

                todo todo = new todo(title, day);
                todos.add(todo);
                adapter.notifyDataSetChanged();
            }
        }
    }





}
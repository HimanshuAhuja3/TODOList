package com.example.himanshuahuja.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTodoActivity extends AppCompatActivity {
    public static final String TITLE_KEY = "title";
    public static final String DAY_KEY = "amount";

    public static final int ADD_RESULT_CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bundle.getString("title");
    }

    public void save(View view){


        EditText titleEditText =findViewById(R.id.titletext);
        EditText dayEditText=findViewById(R.id.daytext);

        String title = titleEditText.getText().toString();
        String day = dayEditText.getText().toString();

        Intent data = new Intent();
        data.putExtra(TITLE_KEY,"Task:"+" "+title);
        data.putExtra(DAY_KEY,"Day:"+" "+day);

        setResult(ADD_RESULT_CODE,data);
        finish();



    }
}

package com.example.project3;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class FormActivity extends AppCompatActivity {
    private AppDB db;
    private PostDao postDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);



        this.db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "PostsDB")
                .allowMainThreadQueries()
                .build();

        this.postDao = this.db.postDao();

        Button btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(view -> {

        });
    }
}
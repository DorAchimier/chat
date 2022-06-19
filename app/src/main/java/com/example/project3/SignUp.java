package com.example.project3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class SignUp extends AppCompatActivity {
    private AppDB db;
    private PostDao postDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        this.db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "PostsDB")
                .allowMainThreadQueries()
                .build();

        this.postDao = this.db.postDao();

        Button btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(view -> {
            Intent i = new Intent(this, FormActivity.class);
            startActivity(i);

            EditText un = findViewById(R.id.editTextTextUsername);
            Post post = new Post(un.getText().toString());
            postDao.insert(post);
            finish();
        });
    }

    public void switchToSignIn(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
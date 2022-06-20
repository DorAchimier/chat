package com.example.project3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class SignUp extends AppCompatActivity {
    private AppDB db;
    private PostDao postDao;
    private String un;
    private String nick;
    private String pass;
    private String conf;
    private EditText usernameField;
    private EditText nicknameField;
    private EditText passwordField;
    private EditText confirmField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        this.db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "PostsDB")
                .allowMainThreadQueries()
                .build();

        this.postDao = this.db.postDao();


        usernameField = (EditText)findViewById(R.id.signUpUsername);
        nicknameField = (EditText)findViewById(R.id.signUpNickname);
        passwordField = (EditText)findViewById(R.id.signUpPassword);
        confirmField = (EditText)findViewById(R.id.signUpPasswordConfirmation);


        Button btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(view -> {

            un = this.usernameField.getText().toString();
            nick = this.nicknameField.getText().toString();
            pass = this.passwordField.getText().toString();
            conf = this.confirmField.getText().toString();

            boolean a = isUsernameValid();
            boolean b = isNicknameValid();
            boolean c = isPasswordValid();
            if(!a || !b || !c) {
                return;
            }
            Intent i = new Intent(this, FormActivity.class);
            startActivity(i);
            EditText un = this.usernameField;
            Post post = new Post(un.getText().toString());
            postDao.insert(post);
            finish();
        });
    }

    private boolean isPasswordValid() {
        boolean ans = true;
        boolean isEmpty = false;
        if(TextUtils.isEmpty(this.pass)) {
            this.passwordField.setError("Please enter a password!");
            ans = false;
            isEmpty = true;
        }
        if(TextUtils.isEmpty(this.conf)) {
            this.confirmField.setError("Please confirm your password!");
            ans = false;
        }
        if(!isEmpty && this.pass.length() < 4) {
            this.passwordField.setError("Password must be at least 4 characters long");
            ans = false;
        }
        if(ans && !this.pass.equals(this.conf)) {
            this.confirmField.setError("Confirmation is incorrect");
            ans = false;
        }
        return ans;
    }

    private boolean isUsernameValid() {
        if(this.un == null || TextUtils.isEmpty(this.un)) {
            this.usernameField.setError("Please enter a username!");
            return false;
        }
        if(this.un.length() < 4) {
            this.usernameField.setError("Username must be at least 4 characters long");
            return false;
        }
        if(this.un.equals("ADMIN")) {
            //add server confirmation later
            this.usernameField.setError("Username already taken, please pick another one");
            return false;
        }
        return true;
    }

    private boolean isNicknameValid() {
        if(this.nick == null || TextUtils.isEmpty(this.nick)) {
            this.nicknameField.setError("Please enter a nickname!");
            return false;
        }
        return true;
    }

    public void switchToSignIn(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
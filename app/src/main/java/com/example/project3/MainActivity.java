package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(view -> {
            Intent i = new Intent(this, ContactsScreen.class);
            startActivity(i);
        });
        Log.i("MainActivity","onCreate");
    }

    public void switchToSignUp(View view) {
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }

//    public void switchToChat(View view) {
//        Intent i = new Intent(this, ChatScreen.class);
//        startActivity(i);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("SignUp","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("SignUp","onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("SignUp","onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("SignUp","onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("SignUp","onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("SignUp","onRestart");

    }

}
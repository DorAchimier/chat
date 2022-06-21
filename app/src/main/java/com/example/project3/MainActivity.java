package com.example.project3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    private LinearLayout ll;
    private EditText usernameField;
    private EditText passwordField;
    private String pass;
    private String un;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = (EditText)findViewById(R.id.signInUsername);
        passwordField = (EditText)findViewById(R.id.signInPassword);


        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(view -> {
            un = this.usernameField.getText().toString();
            pass = this.passwordField.getText().toString();
            if(!validate()) {
                return;
            }
            Intent i = new Intent(this, ContactsScreen.class);
            startActivity(i);
        });
        Log.i("MainActivity","onCreate");

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(MainActivity.this, instanceIdResult -> {
            String newToken = instanceIdResult.getToken();
        });
    }

    @Override
    public void onBackPressed()
    {
        startActivity((new Intent(Intent.ACTION_MAIN)).addCategory(Intent.CATEGORY_HOME).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    private boolean validate() {
        int len = 4;
        boolean b1 = true, b2 = true;
        boolean n1 = !(this.pass == null);
        boolean n2 = !(this.un == null);
        if(n1 && TextUtils.isEmpty(this.pass)) {
            this.passwordField.setError("Please enter a password!");
            b1 = false;
        }
        if(n2 && TextUtils.isEmpty(this.un)) {
            this.usernameField.setError("Please enter a username!");
            b2 = false;
        }
        if(n1 && b1 && this.pass.length() < len) {
            this.passwordField.setError("Wrong password and/or username...");
            this.usernameField.setError("Wrong password and/or username...");
            b1 = false;
        }
        if(n2 && b2 && this.un.length() < len) {
            this.passwordField.setError("Wrong password and/or username...");
            this.usernameField.setError("Wrong password and/or username...");
            b2 = false;
        }
        return b1 && b2 && n1 && n2;
    }

    public void switchToSignUp(View view) {
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }

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
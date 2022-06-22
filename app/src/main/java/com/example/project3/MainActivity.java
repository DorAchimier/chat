package com.example.project3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.project3.Entity.Contact;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    private EditText usernameField;
    private EditText passwordField;
    private String pass;
    private String un;
    private ContactDao contactDao;
    private AppDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "ContactsDB")
                .allowMainThreadQueries()
                .build();

        this.contactDao = this.db.contactDao();

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
        boolean b1 = true;
        boolean n1 = !(this.pass == null);
        boolean n2 = !(this.un == null);
        if(n1 && TextUtils.isEmpty(this.pass)) {
            this.passwordField.setError("Please enter a password!");
            b1 = false;
        }
        boolean b2 = true;
        if(n2 && TextUtils.isEmpty(this.un)) {
            this.usernameField.setError("Please enter a username!");
            b2 = false;
        }
        if(!(b1 && b2)) {
            return false;
        }
        Contact c = this.contactDao.get(this.un);
        if(n1 && n2 && (c == null ||  !c.authenticate(this.pass))) {
            this.passwordField.setError("Wrong password and/or username...");
            this.usernameField.setError("Wrong password and/or username...");
            return false;
        }
        return n1 && n2;
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
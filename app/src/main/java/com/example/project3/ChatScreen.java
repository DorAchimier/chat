package com.example.project3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);


        TextView tv = findViewById(R.id.chatScreenNickname);
        tv.setText(this.getIntent().getExtras().toString());

        ImageButton btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(view -> {
            Intent i = new Intent(this, ContactsScreen.class);
            startActivity(i);
        });


    }
}
package com.example.project3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.project3.Entity.Contact;

public class ChatScreen extends AppCompatActivity {
    private AppDB db;
    private ContactDao contactDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        this.db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "ContactsDB")
                .allowMainThreadQueries()
                .build();

        this.contactDao = this.db.contactDao();
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("id");
        Contact c = this.contactDao.get(value);
        String n = c.getNickname();
        TextView name = findViewById(R.id.chatScreenNickname);
        name.setText(n);

        ImageButton btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(view -> {
            Intent i = new Intent(this, ContactsScreen.class);
            startActivity(i);
        });
    }
}
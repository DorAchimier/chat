package com.example.project3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project3.Entity.Contact;
import com.example.project3.adapters.ContactsListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ContactsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_screen);

        ImageButton btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(view -> {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        });

        RecyclerView listContacts = findViewById(R.id.listContacts);
        final ContactsListAdapter adapter = new ContactsListAdapter(this);
        listContacts.setAdapter(adapter);
        listContacts.setLayoutManager(new LinearLayoutManager(this));
        List<Contact> con = new ArrayList<>();
        con.add(new Contact("Haim1", "haim1"));
        con.add(new Contact("haim", "haim"));
        con.add(new Contact("haim2", "haim2"));
        con.add(new Contact("a", "a"));
        con.add(new Contact("v", "haim"));
        con.add(new Contact("him2", "haim2"));
        con.add(new Contact("Haim13", "haim1"));
        con.add(new Contact("haim333", "haim"));
        con.add(new Contact("haim233", "haim2"));
        con.add(new Contact("Haim11212", "haim1"));
        con.add(new Contact("haim11111", "haim"));
        con.add(new Contact("haim20", "haim2"));
        adapter.setContacts(con);
    }

    public void openChat(View view) {
        Intent i = new Intent(this, ChatScreen.class);
        startActivity(i);
    }
}
package com.example.project3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project3.adapters.ContactsListAdapter;
import com.example.project3.viewmodels.ContactsViewModel;

public class ContactsScreen extends AppCompatActivity {
    private ContactsViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_screen);

        viewModel = new ViewModelProvider(this).get(ContactsViewModel.class);


        ImageButton btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(view -> {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        });


        ImageButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {
            Intent i = new Intent(this, AddContact.class);
            startActivity(i);
        });




        RecyclerView listContacts = findViewById(R.id.listContacts);
        final ContactsListAdapter adapter = new ContactsListAdapter(this);
        listContacts.setAdapter(adapter);
        listContacts.setLayoutManager(new LinearLayoutManager(this));


        this.viewModel.get().observe(this, contacts -> {
            adapter.setContacts(contacts);
        });

    }

    @Override
    public void onBackPressed()
    {
        startActivity((new Intent(Intent.ACTION_MAIN)).addCategory(Intent.CATEGORY_HOME).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public void openChat(View view) {
        TextView tv = findViewById(R.id.tvContent);
        String str = tv.toString();
        Intent i = new Intent(this, ChatScreen.class);
        i.putExtra("NICKNAME", str);
        startActivity(i);
    }
}
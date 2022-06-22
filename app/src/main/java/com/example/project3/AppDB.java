package com.example.project3;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project3.Entity.Contact;

@Database(entities = {Contact.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract ContactDao contactDao();
}

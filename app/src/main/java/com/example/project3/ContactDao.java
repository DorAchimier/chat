package com.example.project3;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.project3.Entity.Contact;

@Dao
public interface ContactDao {
    //sign up
    @Insert
    void insert(Contact...contacts);

    @Query("SELECT * FROM contact WHERE username = :username")
    Contact get(String username);



}

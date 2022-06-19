package com.example.project3.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;

@Entity
public class Message {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String message;
    private String senderUn;
    private String receiverUn;
    private Time time;

}

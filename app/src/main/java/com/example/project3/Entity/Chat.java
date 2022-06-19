package com.example.project3.Entity;

import androidx.room.Entity;

import java.util.List;

@Entity
public class Chat {
    private String username1;
    private String username2;
    private List<Message> messages;
}

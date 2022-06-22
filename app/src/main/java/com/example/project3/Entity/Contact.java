package com.example.project3.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @PrimaryKey @NonNull
    private String username;
    private String nickname;
    private String password;
//    private Chat chat;

//    public Contact(String username, String nickname) {
////        this.chat = chat;
//        this.nickname = nickname;
//        this.username = username;

    public String getPassword() {
        return password;
    }
//    }

    public Contact(String username, String nickname, String password) {
//        this.chat = chat;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public static String getLastMsg() {
        return "temporary last messageeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
    }

    public static String getTime() {
        return "23:22 01/01/01";
    }

    public boolean authenticate(String pass) {
        return this.password.equals(pass);
    }

//    public Chat getChat() {
//        return chat;
//    }
//
//    public void setChat(Chat chat) {
//        this.chat = chat;
//    }
}

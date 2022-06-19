package com.example.project3;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Post {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    private String nickname;
//    private LinkedList<String> contacts;

    public int  getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String  getNickname() {
        return this.nickname;
    }

    public String  getUsername() {
        return this.username;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Post(int id, String nickname) {
        setId(id);
        setNickname(nickname);
    }

    public Post(String nickname) {
        setNickname(nickname);
    }

    public Post(){}
}

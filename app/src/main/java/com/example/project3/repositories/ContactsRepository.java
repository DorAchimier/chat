package com.example.project3.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.project3.Entity.Contact;
import com.example.project3.api.ContactAPI;

import java.util.LinkedList;
import java.util.List;

public class ContactsRepository {
    private ContactListData contactListData;
    private ContactAPI api;
//    private ContactDao dao;

    public ContactsRepository() {
//        LocalDatabase db = LocalDatabase.getInstance();
        contactListData = new ContactListData();
    }

    class ContactListData extends MutableLiveData<List<Contact>> {
        public ContactListData() {
            super();

            List<Contact> contacts = new LinkedList<>();
            contacts.add(new Contact("Haim1", "haim1jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", "11111"));
            contacts.add(new Contact("haim", "Haim", "11111"));
            contacts.add(new Contact("haim2", "haim2", "11111"));
            contacts.add(new Contact("a", "a", "11111"));
            contacts.add(new Contact("v", "haim", "11111"));
            contacts.add(new Contact("him2", "haim2", "11111"));


            setValue(contacts);


        }

        @Override
        protected void onActive() {
            super.onActive();
//            new Thread(() -> {
//                contactListData.postValue(dao.get());
//            }).start();

            ContactAPI contactAPI = new ContactAPI();
            contactAPI.get(this);
        }
    }
    public LiveData<List<Contact>> getAll() { return contactListData; }

    public void add(final Contact contact) {
        //api.add(contact);
    }
}

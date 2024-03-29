package com.example.project3.api;

import com.example.project3.Entity.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebServiceAPI {
    @GET("{id}/contacts")
    Call<List<Contact>> getContacts();

    @POST("contacts")
    Call<Void> createContact(@Body Contact contact);

    @DELETE("contacts/{id}")
    Call<Void> deleteContact(@Path("id") int id);
}

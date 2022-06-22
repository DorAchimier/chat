package com.example.project3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project3.Entity.Contact;
import com.example.project3.R;

import java.util.List;

public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ContactViewHolder> {
    class ContactViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvNickname;
        private final TextView tvLastMsg;
        private final TextView tvTime;
        private final TextView tvUserName;
        private ContactViewHolder(View itemView) {
            super(itemView);
            tvNickname = itemView.findViewById(R.id.tvContent);
            tvLastMsg = itemView.findViewById(R.id.tvLast);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvUserName=itemView.findViewById(R.id.usernameHolder);
        }
    }

    private final LayoutInflater mInflater;
    private List<Contact> contacts;


    public ContactsListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ContactsListAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.contact_layout, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsListAdapter.ContactViewHolder holder, int position) {
        if(contacts != null) {
            final Contact current = contacts.get(position);
            holder.tvNickname.setText(current.getNickname());
            holder.tvLastMsg.setText(current.getLastMsg());
            holder.tvTime.setText(current.getTime());
            holder.tvUserName.setText(current.getUsername());
        }
    }

    public void setContacts(List<Contact> s) {
        contacts = s;
        notifyDataSetChanged();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public int getItemCount() {
        if(contacts != null) {
            return contacts.size();
        }
        return 0;
    }
}

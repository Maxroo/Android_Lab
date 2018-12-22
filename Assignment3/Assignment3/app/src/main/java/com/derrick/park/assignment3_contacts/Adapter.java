package com.derrick.park.assignment3_contacts;


import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.util.SortedListAdapterCallback;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import com.derrick.park.assignment3_contacts.models.Contact;
import static com.derrick.park.assignment3_contacts.activities.MainActivity.TAG;

public class Adapter extends RecyclerView.Adapter<Adapter.ContactViewHolder> {
    private Context mContext;
    ArrayList<Contact> mContacta;
    private String phone;
    private String userFName;
    private String userLName;
    private String prevname;
    SortedList<Contact> mContactList;
    boolean add = false;
    private ContactViewHolder currentContactViewHolder;
    final private RecyclerView rv;
    boolean checkadded = false;
    Contact acontact = null;

    public Adapter(Context mContext, final ArrayList<Contact> mContactList, RecyclerView rv) {
        this.mContext = mContext;
        this.rv = rv;
        this.mContacta = mContactList;
        this.mContactList = new SortedList<>(Contact.class, new SortedListAdapterCallback<Contact>(this) {
            @Override
            public int compare(Contact contact, Contact t21) {
                return contact.getName().getFirst().substring(0, 1).compareToIgnoreCase(t21.getName().getFirst().substring(0, 1));
            }

            @Override
            public boolean areContentsTheSame(Contact contact, Contact t21) {
                return contact.getName() == t21.getName();
            }

            @Override
            public boolean areItemsTheSame(Contact contact, Contact t21) {
                return contact == t21;
            }

            @Override
            public void onInserted(int position, int count) {
                super.onInserted(position, count);
                if(count < 2)
                {
                    checktitle(position);
                }
            }

        });
        Log.d(TAG, "Adapter Constructor: ");
        this.mContactList.addAll(mContacta);
        initial();

    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_main, viewGroup, false);
        currentContactViewHolder = new ContactViewHolder(view, this);
        return currentContactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactViewHolder contactViewHolder, int i) {
        userFName = mContactList.get(i).getName().getFirst();
        userLName = mContactList.get(i).getName().getLast();
        phone = mContactList.get(i).getCell();
        contactViewHolder.name.setText(userFName + " " + userLName);
        contactViewHolder.phone.setText(phone);
        contactViewHolder.name_title.setText("  " + userFName.substring(0, 1).toUpperCase());
        if (mContactList.get(i).has_title == false)
        {
            contactViewHolder.name_title.setVisibility(View.GONE);
        }
        else {
            contactViewHolder.name_title.setVisibility(View.VISIBLE);
        }
    }



    public void additems(Contact contact) {
        Log.d(TAG, "additems: " + contact);
        this.mContactList.add(contact);
        acontact = contact;
    }

    public void checktitle(int i)
    {
        Contact currentitem = mContactList.get(i);
        String current_title = mContactList.get(i).getName().getFirst().substring(0,1);
        if (i - 1 >= 0)
        {
            int prev = i - 1;
            String prev_title = mContactList.get(prev).getName().getFirst().substring(0,1);
            if (current_title.equals(prev_title))
            {
                currentitem.has_title = false;
            }
        }else
        {
            currentitem.has_title = true;
        }
        if (i + 1 < mContactList.size())
    {
        int prev = i + 1;
        String prev_title = mContactList.get(prev).getName().getFirst().substring(0,1);
        if (current_title.equals(prev_title))
        {
            mContactList.get(prev).has_title = false;
        }
    }
        notifyDataSetChanged();

    }


    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    private void initial() {
        for (int i = 1; i < mContactList.size(); i++) {
            String current = mContactList.get(i).getName().getFirst().substring(0,1);
            String prev = mContactList.get(i - 1).getName().getFirst().substring(0,1);
            if (current.equals(prev)) {
                mContactList.get(i).has_title = false;
            } else {
                mContactList.get(i).has_title = true;
            }
        }
        mContactList.get(0).has_title = true;
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder{
        final Adapter mAdapter;
        private TextView phone;
        private TextView name;
        private TextView name_title;

//        private final TextView mNameTV, mTextTV;


        public ContactViewHolder(@NonNull View itemView, Adapter adpater) {
            super(itemView);
            this.phone = itemView.findViewById(R.id.phone);
            this.name = itemView.findViewById(R.id.name);
            this.name_title = itemView.findViewById(R.id.name_title);
            this.mAdapter = adpater;
        }
    }
}


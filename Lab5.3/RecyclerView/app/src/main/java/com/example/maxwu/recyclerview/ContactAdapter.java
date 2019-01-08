package com.example.maxwu.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    private Context mContext;
    private ArrayList<String> mNames;
    private ArrayList<String> mNumbers;


    public ContactAdapter(Context context)
    {
        mContext = context;

    }

    public ContactAdapter(Context mContext, ArrayList<String> mNames, ArrayList<String> mNumbers) {
        this.mContext = mContext;
        this.mNames = mNames;
        this.mNumbers = mNumbers;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.contact_row, viewGroup,false);
        return new ContactViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        contactViewHolder.mNameTV.setText(mNames.get(i));
        contactViewHolder.mNumberTV.setText(mNumbers.get(i));
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mNameTV, mNumberTV;
        final ContactAdapter mAdapter;

        public ContactViewHolder(View itemView, ContactAdapter adpater) {
            super(itemView);
            mNameTV = itemView.findViewById(R.id.name);
            mNumberTV = itemView.findViewById(R.id.phone);
            this.mAdapter = adpater;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getAdapterPosition();
            String element = mNumbers.get(mPosition);
            mNumbers.set (mPosition ,"Clicked! " + element);
            mAdapter.notifyDataSetChanged();
        }

    }
}

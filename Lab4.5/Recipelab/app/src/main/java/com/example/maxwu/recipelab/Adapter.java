package com.example.maxwu.recipelab;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.time.Instant;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ContactViewHolder> {
    private Context mContext;
    private MainActivity mmainActivity;
    private ArrayList<String> mfoodnames;
    private ArrayList<String> mfoodtexts;

    public Adapter(Context context, ArrayList<String> foodnames, ArrayList<String> foodtexts, MainActivity mainActivity) {
        this.mContext = context;
        this.mmainActivity = mainActivity;
        this.mfoodnames = foodnames;
        this.mfoodtexts = foodtexts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_main, viewGroup,false);
        return new ContactViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactViewHolder contactViewHolder, int i) {
        contactViewHolder.mTextTV.setText(mfoodtexts.get(i));
        contactViewHolder.mNameTV.setText(mfoodnames.get(i));
        contactViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,Main2Activity.class);
                intent.putExtra("FoodName",contactViewHolder.mNameTV.getText().toString());
                intent.putExtra("FoodText",contactViewHolder.mTextTV.getText().toString());
                mmainActivity.toRecipe(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mfoodnames.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final Adapter mAdapter;
        private final TextView mNameTV, mTextTV;
        private Button button;


        public ContactViewHolder(@NonNull View itemView, Adapter adpater) {
            super(itemView);
            this.mNameTV = itemView.findViewById(R.id.foodname);
            this.mTextTV = itemView.findViewById(R.id.foodtext);
            this.button = itemView.findViewById(R.id.recipebutton);
            this.mAdapter = adpater;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }


    }
}


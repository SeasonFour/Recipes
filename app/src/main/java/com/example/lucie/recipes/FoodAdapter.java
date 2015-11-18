package com.example.lucie.recipes;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lucie on 11/17/15.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder>{

    private String[] fDataset;           //our string  array of data from parse

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public static class FoodHolder extends RecyclerView.ViewHolder{
        // each data item is just a string in this case
        TextView tvname, tvingr,tvmethod;
        CardView foodView;
        public FoodHolder(View v) {
            super(v);
            tvname = (TextView) v.findViewById(R.id.name);
            tvingr = (TextView) v.findViewById(R.id.ingredients);
            tvmethod = (TextView) v.findViewById(R.id.method);
            foodView = (CardView) v.findViewById(R.id.people_card);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FoodAdapter(String[] myDataset) {
        fDataset = myDataset;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public FoodHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_card, parent, false);
        FoodHolder vh = new FoodHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager) ==data
    @Override
    public void onBindViewHolder(FoodHolder holder, int i) {
        holder.tvname.setText(fDataset[i]);
        holder.tvingr.setText(fDataset[i]);
        holder.tvmethod.setText(fDataset[i]);
    }

    @Override
    public int getItemCount() {
        return fDataset.length;
    }


}

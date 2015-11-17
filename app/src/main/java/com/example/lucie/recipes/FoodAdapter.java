package com.example.lucie.recipes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lucie on 11/17/15.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder>{


    @Override
    public FoodHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(FoodHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class FoodHolder extends RecyclerView.ViewHolder{
        TextView tvname, tvingr,tvmethod;
        public FoodHolder(View v) {
            super(v);
            tvname = (TextView) v.findViewById(R.id.name);
            tvingr = (TextView) v.findViewById(R.id.ingredients);
            tvmethod = (TextView) v.findViewById(R.id.method);

        }
    }
}

package com.example.thierrycouilleault.belotescore.Controller.Activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by thierrycouilleault on 22/01/2018.
 */

class PartieAdapter extends RecyclerView.Adapter<PartieAdapter.Viewholder> {
    @Override
    public PartieAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PartieAdapter.Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(View itemView) {
            super(itemView);
        }
    }
}

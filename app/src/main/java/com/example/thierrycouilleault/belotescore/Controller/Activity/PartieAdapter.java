package com.example.thierrycouilleault.belotescore.Controller.Activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thierrycouilleault.belotescore.Model.BDD.Donne;
import com.example.thierrycouilleault.belotescore.R;

import java.util.List;

/**
 * Created by thierrycouilleault on 22/01/2018.
 */

class PartieAdapter extends RecyclerView.Adapter<PartieAdapter.ViewHolder> {

    List<Donne> donnes;

    public PartieAdapter(List<Donne> donnes) {
        this.donnes = donnes;
    }

    @Override
    public PartieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donne_row, parent, false );

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PartieAdapter.ViewHolder holder, int position) {

        holder.tv_score1.setText(Integer.toString(donnes.get(position).getScore1()));
        holder.tv_score2.setText(Integer.toString(donnes.get(position).getScore2()));
        holder.tv_numdonne.setText(Integer.toString(donnes.get(position).getNumDonne()));
    }

    @Override
    public int getItemCount() {
        return donnes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_score1, tv_score2, tv_numdonne;


        public ViewHolder(View itemView) {
            super(itemView);

            tv_score1 = itemView.findViewById(R.id.tv_score1);
            tv_score2 = itemView.findViewById(R.id.tv_score2);
            tv_numdonne=itemView.findViewById(R.id.tv_numdonne);

        }
    }
}

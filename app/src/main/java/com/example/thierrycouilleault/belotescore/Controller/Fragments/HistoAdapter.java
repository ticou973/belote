package com.example.thierrycouilleault.belotescore.Controller.Fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thierrycouilleault.belotescore.Model.BDD.Partie;
import com.example.thierrycouilleault.belotescore.R;

import java.util.List;

/**
 * Created by thierrycouilleault on 27/01/2018.
 */

class HistoAdapter extends RecyclerView.Adapter<HistoAdapter.ViewHolder> {

    public List<Partie> parties;

    public HistoAdapter(List<Partie> parties) {
        this.parties = parties;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.partie_row, parent, false );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.annonces.setText(parties.get(position).getType().getTypeAnnonce());

        if (parties.get(position).isPartieterminee()){

            holder.etat.setText("Terminé");

        }else{

            holder.etat.setText("En cours");

        }

        holder.equipe1.setText(parties.get(position).getEquipes().getNomJoueur1()+ "- "+ parties.get(position).getEquipes().getNomJoueur2());
        holder.equipe2.setText(parties.get(position).getEquipes().getNomJoueur3()+ "- "+ parties.get(position).getEquipes().getNomJoueur4());

        holder.score1.setText(Integer.toString(parties.get(position).getScoreEquipeA()));
        holder.score2.setText(Integer.toString(parties.get(position).getScoreEquipeB()));
        holder.date.setText("date");


    }

    @Override
    public int getItemCount() {
        return parties.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView annonces, etat, date, equipe1, equipe2, score1, score2;

        public ViewHolder(View itemView) {
            super(itemView);

            annonces = itemView.findViewById(R.id.tv_annonce_partie);
            etat = itemView.findViewById(R.id.tv_etat_partie);
            date = itemView.findViewById(R.id.tv_date_partie);
            equipe1 = itemView.findViewById(R.id.tv_equipe1_partie);
            equipe2 = itemView.findViewById(R.id.tv_equipe2_partie);
            score1= itemView.findViewById(R.id.tv_score_equipe1_partie);
            score2=itemView.findViewById(R.id.tv_score_equipe2_partie);


        }
    }
}

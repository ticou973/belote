package com.example.thierrycouilleault.belotescore.Controller.Fragments;

import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.thierrycouilleault.belotescore.Model.BDD.AppDatabase;
import com.example.thierrycouilleault.belotescore.Model.BDD.Partie;
import com.example.thierrycouilleault.belotescore.R;

import java.util.List;

/**
 * Created by thierrycouilleault on 26/01/2018.
 */

public class GagnantDialogFragment extends DialogFragment {

    //Données graphiques

    public TextView tv_gagnant;
    public List<Partie> parties;
    public Partie partie;
    public String message1, message2;


    public GagnantDialogFragment() {
    }


    /* The activity that creates an instance of this dialog fragment must
                * implement this interface in order to receive event callbacks.
                * Each method passes the DialogFragment in case the host needs to query it. */
    public interface GagnantDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    GagnantDialogListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mListener = (GagnantDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " doit implémenter GagnantDialogListener");
        }
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.fragment_gagnants, null));




        //Gestion de la DB

        final AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        parties =db.partieDao().getAllParties();
        partie = db.partieDao().loadPartieById(parties.size());



        tv_gagnant=getActivity().findViewById(R.id.tv_equipe_gagnante);


        if (partie.getScoreEquipeA()>partie.getScoreEquipeB()){

            builder.setMessage("L'équipe 1 a gagné !");
        }else{

            builder.setMessage("L'équipe 2 a gagné !");
        }



        builder.setPositiveButton("Rejouer partie", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the positive button event back to the host activity
                        mListener.onDialogPositiveClick(GagnantDialogFragment.this);
                    }
                })
                .setNegativeButton("Rejoueur Autres Equipes/Stop", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the negative button event back to the host activity
                        mListener.onDialogNegativeClick(GagnantDialogFragment.this);
                    }
                });



        return builder.create();

    }

}

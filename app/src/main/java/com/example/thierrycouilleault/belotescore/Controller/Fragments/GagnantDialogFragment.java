package com.example.thierrycouilleault.belotescore.Controller.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.thierrycouilleault.belotescore.R;

/**
 * Created by thierrycouilleault on 26/01/2018.
 */

public class GagnantDialogFragment extends DialogFragment {

    //Données graphiques

    public TextView tv_gagnant;
    public String gagnant;


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

        tv_gagnant=getActivity().findViewById(R.id.tv_equipe_gagnante);


        builder.setMessage("coucou")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the positive button event back to the host activity
                        mListener.onDialogPositiveClick(GagnantDialogFragment.this);
                    }
                })
                .setNegativeButton("Autres Equipes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the negative button event back to the host activity
                        mListener.onDialogNegativeClick(GagnantDialogFragment.this);
                    }
                });



        return builder.create();

    }














}

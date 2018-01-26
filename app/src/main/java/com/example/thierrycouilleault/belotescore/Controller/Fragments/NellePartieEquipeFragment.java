package com.example.thierrycouilleault.belotescore.Controller.Fragments;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import com.example.thierrycouilleault.belotescore.Model.BDD.AppDatabase;
import com.example.thierrycouilleault.belotescore.Model.BDD.Equipe;
import com.example.thierrycouilleault.belotescore.Model.BDD.Equipes;
import com.example.thierrycouilleault.belotescore.Model.BDD.Partie;
import com.example.thierrycouilleault.belotescore.Model.BDD.TypeAnnonce;
import com.example.thierrycouilleault.belotescore.Model.BDD.TypeDePartie;
import com.example.thierrycouilleault.belotescore.Model.BDD.TypeJeu;
import com.example.thierrycouilleault.belotescore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NellePartieEquipeFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, View.OnFocusChangeListener {

    private EditText et_equipe1, et_equipe2, et_points2, et_donnes2;
    private Button bt_suivant_joueurs_type_partie2, bt_commencer_partie2;
    private LinearLayout ll_joueurs2, ll_annonces2;
    private ToggleButton tb_annonces2, tb_type_partie2;
    private CollapsingToolbarLayout ctl2;

    //Données


    private Equipe equipeA, equipeB;
    private int equipeIdA, equipeIdB;
    private Equipes equipes;
    private TypeDePartie type;
    private Partie partie;
    private TypeAnnonce typeAnnonce;
    private TypeJeu typeJeu;
    private String n = "Nous", e ="Eux";


    public NellePartieEquipeFragment() {
        // Required empty public constructor
    }

    public NellePartieFragment.OnNellePartieFragmentListener onNellePartieEquipeFragmentListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            onNellePartieEquipeFragmentListener = (NellePartieFragment.OnNellePartieFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " doit implémenter OnNellePartieEquipeFragmentListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Todo voir comment à ce niveau faire un seul fragment avec 2 xml différents.

        View view =inflater.inflate(R.layout.fragment_nelle_partie_equipe, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        et_equipe1 = getActivity().findViewById(R.id.et_equipe1);
        et_equipe2 = getActivity().findViewById(R.id.et_equipe2);
        et_points2 = getActivity().findViewById(R.id.et_points2);
        et_donnes2 = getActivity().findViewById(R.id.et_donnes2);

        bt_suivant_joueurs_type_partie2 = getActivity().findViewById(R.id.bt_suivant_joueurs_type_partie2);
        bt_commencer_partie2 = getActivity().findViewById(R.id.bt_commencer_partie2);

        tb_annonces2 = getActivity().findViewById(R.id.tb_annonces2);
        tb_type_partie2 = getActivity().findViewById(R.id.tb_type_partie2);

        ll_joueurs2 = getActivity().findViewById(R.id.ll_joueurs2);
        ll_annonces2 = getActivity().findViewById(R.id.ll_annonces2);

        ctl2 = getActivity().findViewById(R.id.ctl2);

        //listener d'événementd
        et_points2.setOnClickListener(this);
        et_donnes2.setOnClickListener(this);
        bt_commencer_partie2.setOnClickListener(this);
        bt_suivant_joueurs_type_partie2.setOnClickListener(this);

        tb_annonces2.setOnCheckedChangeListener(this);
        tb_type_partie2.setOnCheckedChangeListener(this);

        et_equipe1.setOnFocusChangeListener(this);
        et_equipe2.setOnFocusChangeListener(this);

        String nomEquipe1 = et_equipe1.getText().toString();
        String nomEquipe2 = et_equipe2.getText().toString();


        // Initialisation de l'écran
        ll_annonces2.setVisibility(View.INVISIBLE);
        et_equipe1.requestFocus();


        //TODO : mettre le focus sur le nombre de points et donnes

        //Actions

        verfieNomsDifferents(nomEquipe1, nomEquipe2);

        //Instanciation et Initialisation des valeurs
        typeAnnonce =TypeAnnonce.SANS_ANNONCE;
        typeJeu = TypeJeu.POINTS;
        type = new TypeDePartie(typeJeu.toString(), typeAnnonce.toString(), 1001, 1000);



    }






    //Méthode lorsque l'on clique sur les EditText ou boutons
    @Override
    public void onClick(View v) {
        if (v == bt_suivant_joueurs_type_partie2) {
            //mettre en alpha les layouts non utilisés
            ll_joueurs2.setAlpha(0.2f);
            ll_annonces2.setVisibility(View.VISIBLE);
            et_points2.requestFocus();

            //rendre inaccessible les champs des joueurs
            et_equipe1.setEnabled(false);
            et_equipe2.setEnabled(false);
            bt_suivant_joueurs_type_partie2.setEnabled(false);



            //TODO : faire un collapse de la fenêtre joueurs et typejeu
            //todo : faire le retour arrière dans les fenêtres


        }  else if (v == bt_commencer_partie2) {
            //Lancement d'une partie

            final AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "production")
                    .allowMainThreadQueries()
                    .build();


            //Création des équipes
            equipeA = new Equipe("EquipeA");
            equipeB = new Equipe("EquipeB");


            //todo gérer les doublons

            //Création des Equipes (paires d'équipes)
            equipes = new Equipes(equipeA.getNomEquipe(), equipeB.getNomEquipe());


            //lancement d'une partie avec points
            if (type.getTypeJeu() == TypeJeu.POINTS.toString()) {
                int nbPointsPartie = Integer.parseInt(et_points2.getText().toString());

                //Remplissage du type de jeu
                type.setNbPoints(nbPointsPartie);
                type.setNbDonnes(1000);


                //lancement d'une partie avec donnes
            } else {
                int nbDonnesPartie = Integer.parseInt(et_donnes2.getText().toString());

                //Remplissage du type de jeu
                type.setNbPoints(10000);
                type.setNbDonnes(nbDonnesPartie);

            }

            //Création d'une nouvelle partie
            partie = new Partie(type, equipes,0,0,true);

            // Insertion partie dans la DB
            db.partieDao().insertAll(partie);

            onNellePartieEquipeFragmentListener.commencerPartie();
        }
    }


    //Méthode pour vérifier que les champs de joueurs sont tous différents


    private void alphaDesactive(View v, boolean b){
        v.setEnabled(b);

        if (b) {
            v.setAlpha(1.0f);
        } else {v.setAlpha(0.2f);}
    }

    private void verfieNomsDifferents(String nomEquipe1, String nomEquipe2) {
        if (nomEquipe1 != nomEquipe2) {
            alphaDesactive(bt_suivant_joueurs_type_partie2, true);
        }else{
            alphaDesactive(bt_suivant_joueurs_type_partie2, false);
        }
    }



    //Méthode lancée lorsque les ToogleButton ou Checkbox sont utilisés
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked) {
            if (buttonView==tb_annonces2) {
                type.setTypeAnnonce(TypeAnnonce.SANS_ANNONCE.toString());

            } else if (buttonView==tb_type_partie2){
                type.setTypeJeu(TypeJeu.DONNES.toString());

                et_points2.setVisibility(View.INVISIBLE);
                et_donnes2.setVisibility(View.VISIBLE);
                et_donnes2.requestFocus();

            }

        } else {
            if (buttonView==tb_annonces2) {
                type.setTypeAnnonce(TypeAnnonce.AVEC_ANNONCES.toString());

            } else if(buttonView==tb_type_partie2){
                type.setTypeJeu(TypeJeu.POINTS.toString());

                et_points2.setVisibility(View.VISIBLE);
                et_donnes2.setVisibility(View.INVISIBLE);
                et_points2.requestFocus();


            }
        }
    }


    //Méthode pour remplir les champs des équipes et vérifier qu'ils sont différents
    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if (v == et_equipe1) {

            verfieNomsDifferents(et_equipe1.getText().toString(), et_equipe2.getText().toString());


        } else if (v == et_equipe2) {
            verfieNomsDifferents(et_equipe1.getText().toString(), et_equipe2.getText().toString());

        }
    }
}

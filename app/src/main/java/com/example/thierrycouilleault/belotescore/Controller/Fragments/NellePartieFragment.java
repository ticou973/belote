package com.example.thierrycouilleault.belotescore.Controller.Fragments;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import com.example.thierrycouilleault.belotescore.Model.BDD.AppDatabase;
import com.example.thierrycouilleault.belotescore.Model.BDD.Equipe;
import com.example.thierrycouilleault.belotescore.Model.BDD.Equipes;
import com.example.thierrycouilleault.belotescore.Model.BDD.Joueur;
import com.example.thierrycouilleault.belotescore.Model.BDD.Partie;
import com.example.thierrycouilleault.belotescore.Model.BDD.SensJeu;
import com.example.thierrycouilleault.belotescore.Model.BDD.TypeAnnonce;
import com.example.thierrycouilleault.belotescore.Model.BDD.TypeDePartie;
import com.example.thierrycouilleault.belotescore.Model.BDD.TypeJeu;
import com.example.thierrycouilleault.belotescore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NellePartieFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, View.OnFocusChangeListener, RadioGroup.OnCheckedChangeListener {


    private EditText et_joueur1, et_joueur2, et_joueur3, et_joueur4, et_points, et_donnes;
    private Button bt_suivant_joueurs_type_partie, bt_suivant_type_partie_distributeur, bt_commencer_partie;
    private LinearLayout ll_joueurs, ll_annonces, ll_distributeur;
    private ToggleButton tb_annonces, tb_type_partie;
    private RadioButton rb1, rb2, rb3, rb4;
    private CheckBox cb;
    private RadioGroup rgb;
    private CollapsingToolbarLayout ctl;

    //Données

    private Joueur joueur1, joueur2, joueur3, joueur4;
    private int nbPoints;
    private Equipe equipeA, equipeB;
    private Equipes equipes;
    private TypeDePartie type;
    private Partie partie;
    private Joueur premierDistributeur;
    private SensJeu sensJeu;
    private boolean sensJeuBoolean;
    private TypeAnnonce typeAnnonce;
    private TypeJeu typeJeu;
    private String v = "Vous", vp ="Votre partenaire", avg ="A votre gauche", avd ="A votre droite", nbPointsString;


    public NellePartieFragment() {
        // Required empty public constructor
    }

    public OnNellePartieFragmentListener onNellePartieFragmentListener;

    public interface OnNellePartieFragmentListener {
        public void commencerPartie();


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            onNellePartieFragmentListener = (OnNellePartieFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " doit implémenter OnNellePartieFragmentListener");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_nelle_partie, container, false);

        return view ;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());

        nbPointsString = sharedPref.getString("nb_donnes_gagner","");



        et_joueur1 = getActivity().findViewById(R.id.et_joueur1);
        et_joueur2 = getActivity().findViewById(R.id.et_joueur2);
        et_joueur3 = getActivity().findViewById(R.id.et_joueur3);
        et_joueur4 = getActivity().findViewById(R.id.et_joueur4);
        et_points = getActivity().findViewById(R.id.et_points);
        et_donnes = getActivity().findViewById(R.id.et_donnes);

        bt_suivant_joueurs_type_partie = getActivity().findViewById(R.id.bt_suivant_joueurs_type_partie);
        bt_suivant_type_partie_distributeur = getActivity().findViewById(R.id.bt_suivant_type_partie_distributeur);
        bt_commencer_partie = getActivity().findViewById(R.id.bt_commencer_partie);
        rb1 =getActivity().findViewById(R.id.rb1);
        rb2 =getActivity().findViewById(R.id.rb2);
        rb3 =getActivity().findViewById(R.id.rb3);
        rb4 =getActivity().findViewById(R.id.rb4);
        cb = getActivity().findViewById(R.id.cb);
        tb_annonces = getActivity().findViewById(R.id.tb_annonces);
        tb_type_partie = getActivity().findViewById(R.id.tb_type_partie);

        ll_joueurs = getActivity().findViewById(R.id.ll_joueurs);
        ll_annonces = getActivity().findViewById(R.id.ll_annonces);
        ll_distributeur = getActivity().findViewById(R.id.ll_distributeur);
        rgb = getActivity().findViewById(R.id.rgb);
        ctl = getActivity().findViewById(R.id.ctl);



        //listener d'événementd
        et_points.setOnClickListener(this);
        et_donnes.setOnClickListener(this);
        bt_commencer_partie.setOnClickListener(this);
        bt_suivant_joueurs_type_partie.setOnClickListener(this);
        bt_suivant_type_partie_distributeur.setOnClickListener(this);

        tb_annonces.setOnCheckedChangeListener(this);
        tb_type_partie.setOnCheckedChangeListener(this);
        cb.setOnCheckedChangeListener(this);

        et_joueur1.setOnFocusChangeListener(this);
        et_joueur2.setOnFocusChangeListener(this);
        et_joueur3.setOnFocusChangeListener(this);
        et_joueur4.setOnFocusChangeListener(this);

        rgb.setOnCheckedChangeListener(this);


        String nomJoueur1 = et_joueur1.getText().toString();
        String nomJoueur2 = et_joueur2.getText().toString();
        String nomJoueur3 = et_joueur3.getText().toString();
        String nomJoueur4 = et_joueur4.getText().toString();


        // Initialisation de l'écran
        ll_annonces.setVisibility(View.INVISIBLE);
        ll_distributeur.setVisibility(View.INVISIBLE);
        bt_suivant_joueurs_type_partie.setEnabled(false);
        bt_suivant_joueurs_type_partie.setAlpha(0.2f);
        et_joueur1.requestFocus();


        //et_points.setText(nbPointsString);





        //TODO : mettre le focus sur le nombre de points et donnes

        //Actions

        verfieNomsDifferents(nomJoueur1, nomJoueur2, nomJoueur3, nomJoueur4);


        //Instanciation et Initialisation des valeurs
        sensJeu = SensJeu.SENS_AIGUILLE;
        sensJeuBoolean = true;
        typeAnnonce =TypeAnnonce.SANS_ANNONCE;
        typeJeu = TypeJeu.POINTS;
        type = new TypeDePartie(typeJeu.toString(), typeAnnonce.toString(), 1001, 1000);
        premierDistributeur = new Joueur(rb1.getText().toString());


    }


    //Méthode lorsque l'on clique sur les EditText ou boutons
    @Override
    public void onClick(View v) {
        if (v == bt_suivant_joueurs_type_partie) {

            //mettre en alpha les layouts non utilisés
            ll_joueurs.setAlpha(0.2f);
            ll_annonces.setVisibility(View.VISIBLE);
            et_points.requestFocus();

            //rendre inaccessible les champs des joueurs
            et_joueur1.setEnabled(false);
            et_joueur2.setEnabled(false);
            et_joueur3.setEnabled(false);
            et_joueur4.setEnabled(false);
            bt_suivant_joueurs_type_partie.setEnabled(false);


            //Mettre les noms en face des joueurs pour le distributeur
            rb1.setText(et_joueur1.getText().toString());
            rb2.setText(et_joueur2.getText().toString());
            rb3.setText(et_joueur3.getText().toString());
            rb4.setText(et_joueur4.getText().toString());


            //TODO : faire un collapse de la fenêtre joueurs et typejeu
            //todo : faire le retour arrière dans les fenêtres


        } else if (v == bt_suivant_type_partie_distributeur) {


            ll_joueurs.setAlpha(0.2f);
            ll_annonces.setAlpha(0.2f);
            ll_distributeur.setVisibility(View.VISIBLE);
            bt_suivant_type_partie_distributeur.setEnabled(false);
            tb_annonces.setEnabled(false);
            tb_type_partie.setEnabled(false);
            et_donnes.setEnabled(false);
            et_points.setEnabled(false);



        } else if (v == bt_commencer_partie) {
            //Lancement d'une partie

            //construction de la DB

            final AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "production")
                    .allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build();


            //todo gestion des doublons

            //Création des joueurs et des équipes
            joueur1 = new Joueur(et_joueur1.getText().toString());
            joueur2 = new Joueur(et_joueur2.getText().toString());
            joueur3 = new Joueur(et_joueur3.getText().toString());
            joueur4 = new Joueur(et_joueur4.getText().toString());

            //Insertion des joueurs dans la BD
            db.joueurDao().insertAll(joueur1);
            db.joueurDao().insertAll(joueur2);
            db.joueurDao().insertAll(joueur3);
            db.joueurDao().insertAll(joueur4);

            //gestion des équipes

            equipeA = new Equipe("equipeA", joueur1.getNomJoueur(), joueur2.getNomJoueur());
            equipeB = new Equipe("equipeB", joueur3.getNomJoueur(), joueur4.getNomJoueur());

            //insertion des équipes
            db.EquipeDao().insertAll(equipeA);
            db.EquipeDao().insertAll(equipeB);

            equipes = new Equipes(equipeA.getNomEquipe(), joueur1.getNomJoueur(), joueur2.getNomJoueur(), equipeB.getNomEquipe(), joueur3.getNomJoueur(), joueur4.getNomJoueur());

            //todo gérer la DB pour la recherche Id des joueurs


            //lancement d'une partie avec points
            if (type.getTypeJeu() == TypeJeu.POINTS.toString()) {
                int nbPointsPartie = Integer.parseInt(et_points.getText().toString());

                //Remplissage du type de jeu
                type.setNbPoints(nbPointsPartie);
                type.setNbDonnes(1000);

                //lancement d'une partie avec donnes
            } else {
                int nbDonnesPartie = Integer.parseInt(et_donnes.getText().toString());

                //Remplissage du type de jeu
                type.setNbDonnes(nbDonnesPartie);
                type.setNbPoints(10000);

            }

            //Création d'une nouvelle partie
            partie = new Partie(type, equipes, premierDistributeur, sensJeuBoolean, 0, 0, false);

            // Insertion partie dans la DB
            db.partieDao().insertAll(partie);

            onNellePartieFragmentListener.commencerPartie();

        }

    }


        //Méthode pour vérifier que les champs de joueurs sont tous différents


    private void alphaDesactive(View v, boolean b){
            v.setEnabled(b);

            if (b) {
                v.setAlpha(1.0f);
            } else {v.setAlpha(0.2f);}

        }

    private void verfieNomsDifferents(String nomJoueur1, String nomJoueur2, String nomJoueur3, String nomJoueur4) {


            if(!v.equals(nomJoueur1)) {
                if(!vp.equals(nomJoueur2)) {
                    if(!avg.equals(nomJoueur3)){
                        if(!avd.equals(nomJoueur4)){
                            if (nomJoueur1 != nomJoueur2 && nomJoueur1 != nomJoueur3 && nomJoueur1 != nomJoueur4) {
                                if (nomJoueur2 != nomJoueur3 && nomJoueur2 != nomJoueur4) {
                                    if (nomJoueur3 != nomJoueur4) {
                                        alphaDesactive(bt_suivant_joueurs_type_partie, true);
                                    }else{
                                        alphaDesactive(bt_suivant_joueurs_type_partie, false);
                                    }
                                }
                            }

                        }
                    }
                }

            }else {alphaDesactive(bt_suivant_joueurs_type_partie, false);

            }

        }



    //Méthode lancée lorsque les ToogleButton ou Checkbox sont utilisés
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked) {
            if (buttonView==tb_annonces) {
                type.setTypeAnnonce(TypeAnnonce.SANS_ANNONCE.toString());

            } else if (buttonView==tb_type_partie){
                type.setTypeJeu(TypeJeu.DONNES.toString());

                et_points.setVisibility(View.INVISIBLE);
                et_donnes.setVisibility(View.VISIBLE);
                et_donnes.requestFocus();

            } else if (buttonView==cb) {
                sensJeu =SensJeu.SENS_AIGUILLE;
                sensJeuBoolean = true;
            }

        } else {
            if (buttonView==tb_annonces) {
                type.setTypeAnnonce(TypeAnnonce.AVEC_ANNONCES.toString());

            } else if(buttonView==tb_type_partie){
                type.setTypeJeu(TypeJeu.POINTS.toString());

                et_points.setVisibility(View.VISIBLE);
                et_donnes.setVisibility(View.INVISIBLE);
                et_points.requestFocus();


            } else if(buttonView==cb){
                sensJeu = SensJeu.SENS_INVERSE_AIGUILLE;
                sensJeuBoolean =false;
            }
        }
    }



    //Méthode lancée lorsque le RadioGroup Button est utilisée
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId==R.id.rb1) {

            premierDistributeur.setNomJoueur(rb1.getText().toString());

        }else if (checkedId==R.id.rb2) {
            premierDistributeur.setNomJoueur(rb2.getText().toString());

        }else if (checkedId==R.id.rb3) {
            premierDistributeur.setNomJoueur(rb3.getText().toString());

        }else if (checkedId==R.id.rb4) {
            premierDistributeur.setNomJoueur(rb4.getText().toString());

        }
    }



    //Méthode pour remplir les champs des joueurs et vérifier qu'ils sont différents
    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if (v == et_joueur1) {

            verfieNomsDifferents(et_joueur1.getText().toString(), et_joueur2.getText().toString(), et_joueur3.getText().toString(), et_joueur4.getText().toString());


        } else if (v == et_joueur2) {
            verfieNomsDifferents(et_joueur1.getText().toString(), et_joueur2.getText().toString(), et_joueur3.getText().toString(), et_joueur4.getText().toString());


        } else if (v == et_joueur3) {
            verfieNomsDifferents(et_joueur1.getText().toString(), et_joueur2.getText().toString(), et_joueur3.getText().toString(), et_joueur4.getText().toString());


        } else if (v == et_joueur4) {
            verfieNomsDifferents(et_joueur1.getText().toString(), et_joueur2.getText().toString(), et_joueur3.getText().toString(), et_joueur4.getText().toString());


        }
    }
}

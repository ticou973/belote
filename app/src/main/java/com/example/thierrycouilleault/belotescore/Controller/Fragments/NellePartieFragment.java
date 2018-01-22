package com.example.thierrycouilleault.belotescore.Controller.Fragments;


import android.content.Context;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.thierrycouilleault.belotescore.Model.BDD.Joueur;
import com.example.thierrycouilleault.belotescore.Model.BDD.Distributeur;
import com.example.thierrycouilleault.belotescore.Model.BDD.Equipe;
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
    private TextView tv_console;
    private ToggleButton tb_annonces, tb_type_partie;
    private RadioButton rb1, rb2, rb3, rb4;
    private CheckBox cb;
    private RadioGroup rgb;
    private CollapsingToolbarLayout ctl;

    //Données

    private Joueur joueur1, joueur2, joueur3, joueur4;
    private Equipe equipeA, equipeB;
    private TypeDePartie type;
    private Partie partie;
    private Distributeur premierDistributeur;
    private SensJeu sensJeu;
    private TypeAnnonce typeAnnonce;
    private TypeJeu typeJeu;
    private String v = "Vous", vp ="Votre partenaire", avg ="A votre gauche", avd ="A votre droite";


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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        tv_console = getActivity().findViewById(R.id.tv_console);

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


        tv_console.setVisibility(View.INVISIBLE);





        //TODO : mettre le focus sur le nombre de points et donnes

        //Actions

        verfieNomsDifferents(nomJoueur1, nomJoueur2, nomJoueur3, nomJoueur4);


        //Instanciation et Initialisation des valeurs
        type = new TypeDePartie();
        premierDistributeur = new Distributeur();
        sensJeu = SensJeu.SENS_AIGUILLE;
        premierDistributeur.setNomJoueur(rb1.getText().toString());



    }

    @Override
    public void onResume() {
        super.onResume();


    }


    @Override
    public void onStart() {
        super.onStart();

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


            //Création des joueurs et des équipes
            joueur1 = new Joueur(et_joueur1.getText().toString());
            joueur2 = new Joueur(et_joueur2.getText().toString());
            joueur3 = new Joueur(et_joueur3.getText().toString());
            joueur4 = new Joueur(et_joueur4.getText().toString());

            equipeA = new Equipe(joueur1, joueur2, "equipeA");
            equipeB = new Equipe(joueur3, joueur4, "equipeB");


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

            //lancement d'une partie avec points
            if (type.getTypeJeu() == TypeJeu.POINTS) {
                int nbPointsPartie = Integer.parseInt(et_points.getText().toString());
                partie = new Partie();
                onNellePartieFragmentListener.commencerPartie();



                //lancement d'une partie avec donnes
            } else {
                int nbDonnesPartie = Integer.parseInt(et_donnes.getText().toString());
                partie = new Partie();
                onNellePartieFragmentListener.commencerPartie();
            }

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
                type.setTypeAnnonce(TypeAnnonce.SANS_ANNONCE);

            } else if (buttonView==tb_type_partie){
                type.setTypeJeu(TypeJeu.DONNES);

                et_points.setVisibility(View.INVISIBLE);
                et_donnes.setVisibility(View.VISIBLE);
                et_donnes.requestFocus();

            } else if (buttonView==cb) {
                sensJeu =SensJeu.SENS_AIGUILLE;
            }

        } else {
            if (buttonView==tb_annonces) {
                type.setTypeAnnonce(TypeAnnonce.AVEC_ANNONCES);

            } else if(buttonView==tb_type_partie){
                type.setTypeJeu(TypeJeu.POINTS);

                et_points.setVisibility(View.VISIBLE);
                et_donnes.setVisibility(View.INVISIBLE);
                et_points.requestFocus();


            } else if(buttonView==cb){
                sensJeu = SensJeu.SENS_INVERSE_AIGUILLE;
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

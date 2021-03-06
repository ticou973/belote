package com.example.thierrycouilleault.belotescore.Controller.Activity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.thierrycouilleault.belotescore.Model.BDD.AppDatabase;
import com.example.thierrycouilleault.belotescore.Model.BDD.Couleur;
import com.example.thierrycouilleault.belotescore.Model.BDD.Donne;
import com.example.thierrycouilleault.belotescore.Model.BDD.Joueur;
import com.example.thierrycouilleault.belotescore.R;

import java.util.List;

public class TableScoreActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, TextWatcher, View.OnTouchListener {


   //Données graphiques
    public ImageView iv_supp_donne;
    public android.support.v7.widget.Toolbar toolbar3;
    public RadioGroup rg_preneur, rg_capot, rg_belote;
    public EditText et_score_equipe1, et_score_equipe2;
    public TextView tv_score_equipe1, tv_score_equipe2;
    public ActionBar actionBar3;
    public RadioButton rb2_joueur1, rb2_joueur2, rb2_joueur3, rb2_joueur4, rb_capot_equipe1, rb_capot_equipe2, rb_belote_equipe1, rb_belote_equipe2;
    public LinearLayout ll_score, ll_score_total;
    public Button bt_validation;


   //Données

    public Integer scoreTotalEquipe1 =new Integer(0);
    public Integer scoreTotalEquipe2 = new Integer(0);
    public int scoreDonneEquipe1, scoreDonneEquipe2, scoreExtraEquipe1, scoreExtraEquipe2;
    public List<Donne> donnes;
    public Donne donne;
    public Joueur joueur1, joueur2, joueur3, joueur4, preneur;
    public List<Joueur> joueurs;
    public boolean capot, belote;
    public Couleur couleur;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_score);

        //FindView

        iv_supp_donne = findViewById(R.id.iv_supp_donne);
        toolbar3 = findViewById(R.id.toolbar3);
        rg_preneur=findViewById(R.id.rg_preneur);
        rg_capot=findViewById(R.id.rg_capot);
        rg_belote=findViewById(R.id.rg_belote);
        et_score_equipe1=findViewById(R.id.et_score_equipe1);
        et_score_equipe2=findViewById(R.id.et_score_equipe2);
        tv_score_equipe1=findViewById(R.id.tv_score_equipe1);
        tv_score_equipe2=findViewById(R.id.tv_score_equipe2);
        rb2_joueur1=findViewById(R.id.rb2_joueur1);
        rb2_joueur2=findViewById(R.id.rb2_joueur2);
        rb2_joueur3=findViewById(R.id.rb2_joueur3);
        rb2_joueur4=findViewById(R.id.rb2_joueur4);
        rb_capot_equipe1=findViewById(R.id.rb2_equipe1);
        rb_capot_equipe2=findViewById(R.id.rb2_equipe2);
        rb_belote_equipe1=findViewById(R.id.rb2_equipe1_belote);
        rb_belote_equipe2=findViewById(R.id.rb2_equipe2_belote);
        ll_score=findViewById(R.id.ll_score);
        ll_score_total=findViewById(R.id.ll_score_total);
        bt_validation=findViewById(R.id.bt_validation);



        //Utilisation de la toolbar
        setSupportActionBar(toolbar3);
        actionBar3 = getSupportActionBar();
        actionBar3.setTitle("Ajouts");

        //TODO ajouter la couleur dans l'appBar
        //TODO ajouter le check dans l'appBar


        //Initialisation des données
        scoreDonneEquipe1 =0;
        scoreDonneEquipe2=0;


        //listeners et watchers

        rg_preneur.setOnCheckedChangeListener(this);
        rg_capot.setOnCheckedChangeListener(this);
        rg_belote.setOnCheckedChangeListener(this);


        et_score_equipe1.setOnTouchListener(this);
        et_score_equipe2.setOnTouchListener(this);


        iv_supp_donne.setOnClickListener(this);
        bt_validation.setOnClickListener(this);

        //Initialisation de l'écran
        ll_score.setVisibility(View.INVISIBLE);
        ll_score_total.setVisibility(View.INVISIBLE);
        rg_belote.setVisibility(View.INVISIBLE);
        rg_capot.setVisibility(View.INVISIBLE);
        tv_score_equipe1.setText("0");
        tv_score_equipe2.setText("0");

        et_score_equipe1.requestFocus();

        bt_validation.setVisibility(View.INVISIBLE);
        bt_validation.setEnabled(false);


        //Gestion de la DB

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        //Création donne courante

        donnes =db.donneDao().getAllDonnes();

        donne = db.donneDao().loadDonneById(donnes.size());

        joueur1 = new Joueur();
        joueur2 = new Joueur();
        joueur3 = new Joueur();
        joueur4 = new Joueur();

        joueurs = db.joueurDao().getAllJoueurs();

        joueur1 = db.joueurDao().loadJoueurById(joueurs.size()-3);
        joueur2 = db.joueurDao().loadJoueurById(joueurs.size()-2);
        joueur3 = db.joueurDao().loadJoueurById(joueurs.size()-1);
        joueur4 = db.joueurDao().loadJoueurById(joueurs.size());

        couleur = donne.getCouleur();

        //affichage des noms

       rb2_joueur1.setText(joueur1.getNomJoueur());
       rb2_joueur2.setText(joueur2.getNomJoueur());
       rb2_joueur3.setText(joueur3.getNomJoueur());
       rb2_joueur4.setText(joueur4.getNomJoueur());
       rb_belote_equipe1.setText(joueur1.getNomJoueur()+ " " + joueur2.getNomJoueur());
       rb_capot_equipe1.setText(joueur1.getNomJoueur()+ " " + joueur2.getNomJoueur());
       rb_belote_equipe2.setText(joueur3.getNomJoueur()+ " " + joueur4.getNomJoueur());
       rb_capot_equipe2.setText(joueur3.getNomJoueur()+ " " + joueur4.getNomJoueur());

       //Initialisation des données
        capot = false;
        belote = false;


    }

    //Méthode pour les Radio groups

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(group==rg_preneur) {
            ll_score.setVisibility(View.VISIBLE);
            ll_score_total.setVisibility(View.VISIBLE);
            rg_belote.setVisibility(View.VISIBLE);
            rg_capot.setVisibility(View.VISIBLE);

            if (checkedId==R.id.rb2_joueur1){
                preneur = joueur1;

            }else if (checkedId==R.id.rb2_joueur2){
                preneur = joueur2;

            }else if (checkedId==R.id.rb2_joueur3){
                preneur = joueur3;

            }else if (checkedId==R.id.rb2_joueur4){
                preneur = joueur4;

            }


        }else if(group==rg_capot){

            calculScoreDonne();
            tv_score_equipe1.setText(Integer.toString(scoreTotalEquipe1));
            tv_score_equipe2.setText(Integer.toString(scoreTotalEquipe2));
            bt_validation.setVisibility(View.VISIBLE);
            bt_validation.setEnabled(true);
            et_score_equipe1.setEnabled(false);
            et_score_equipe2.setEnabled(false);

            if (rb_capot_equipe1.isChecked()||rb_capot_equipe2.isChecked()){
                capot = true;
            }else{
                capot = false;
            }

            if (checkedId==R.id.rb2_equipe1){
                et_score_equipe1.setText("252");
                et_score_equipe2.setText("0");

            }else if(checkedId==R.id.rb2_equipe2){
                et_score_equipe2.setText("252");
                et_score_equipe1.setText("0");

            }

        }else if(group==rg_belote){
            calculScoreDonne();
            tv_score_equipe1.setText(Integer.toString(scoreTotalEquipe1));
            tv_score_equipe2.setText(Integer.toString(scoreTotalEquipe2));

            if (rb_belote_equipe1.isChecked()||rb_belote_equipe2.isChecked()){
                belote = true;
            }else{
                belote = false;
            }


        }

    }

    //Méthode pour gérer le bouton de suppression de la donne

    @Override
    public void onClick(View v) {
         if(v==iv_supp_donne) {

            Intent intent3 = new Intent(this, ScoreActivity.class);
            startActivity(intent3);
        }else if(v==bt_validation){

             //Gestion de la DB

             final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                     .allowMainThreadQueries()
                     .build();

             donne.setPreneur(preneur);
             donne.setBelote(belote);
             donne.setCapot(capot);
             donne.setScore1(scoreTotalEquipe1);
             donne.setScore2(scoreTotalEquipe2);

             db.donneDao().updateDonne(donne);


             Intent intent3 = new Intent(this, ScoreActivity.class);
             startActivity(intent3);

         }

    }


    public void calculScoreDonne(){
        scoreExtraEquipe1 = 0;
        scoreExtraEquipe2 = 0;

        //prise en charge de la belote

        if (rb_belote_equipe1.isChecked()){

            scoreExtraEquipe1 += 20;

        }else if (rb_belote_equipe2.isChecked()){

            scoreExtraEquipe2+=20;

        }


        //Prise en charge du capot

        if (rb_capot_equipe1.isChecked()){

            scoreExtraEquipe1 += 252;
            scoreTotalEquipe1=scoreExtraEquipe1;
            scoreTotalEquipe2=scoreExtraEquipe2;

            return;


        }else if (rb_capot_equipe2.isChecked()){

            scoreExtraEquipe2+=252;;
            scoreTotalEquipe1=scoreExtraEquipe1;
            scoreTotalEquipe2=scoreExtraEquipe2;

            return;

        }

        //cas hors capot

        scoreTotalEquipe1 =scoreExtraEquipe1+scoreDonneEquipe1;
        scoreTotalEquipe2 =scoreExtraEquipe2+scoreDonneEquipe2;


        if(scoreTotalEquipe1<scoreTotalEquipe2 && (rb2_joueur1.isChecked()||rb2_joueur2.isChecked())){

                scoreTotalEquipe1=scoreExtraEquipe1;
                scoreTotalEquipe2=162 + scoreExtraEquipe2;


        }else if (scoreTotalEquipe1>scoreTotalEquipe2&& (rb2_joueur3.isChecked()||rb2_joueur4.isChecked())){

                scoreTotalEquipe2=scoreExtraEquipe1;
                scoreTotalEquipe1=162 + scoreExtraEquipe2;

        }

    }



    //Méthode lorsque le texte change dans le score de la donne change.

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {



    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


              if (et_score_equipe1.isFocused()&&et_score_equipe1!=null&&et_score_equipe1.length()!=0){

                      String scoreString = et_score_equipe1.getText().toString();

                      scoreDonneEquipe1 = Integer.parseInt(scoreString);

                  bt_validation.setVisibility(View.VISIBLE);
                  bt_validation.setEnabled(true);

                      if(scoreDonneEquipe1<=162){
                          scoreDonneEquipe2 = 162 - scoreDonneEquipe1;

                          et_score_equipe2.setText(Integer.toString(scoreDonneEquipe2));
                          et_score_equipe2.setEnabled(false);

                          calculScoreDonne();
                          tv_score_equipe1.setText(Integer.toString(scoreTotalEquipe1));
                          tv_score_equipe2.setText(Integer.toString(scoreTotalEquipe2));

                      }



              }else if (et_score_equipe2.isFocused()&&et_score_equipe2!=null&&et_score_equipe2.length()!=0){

                  String scoreString1 = et_score_equipe2.getText().toString();

                  scoreDonneEquipe2 = Integer.parseInt(scoreString1);

                  bt_validation.setVisibility(View.VISIBLE);
                  bt_validation.setEnabled(true);

                  if(scoreDonneEquipe2<=162){
                      scoreDonneEquipe1 = 162 - scoreDonneEquipe2;

                      et_score_equipe1.setText(Integer.toString(scoreDonneEquipe1));
                      et_score_equipe1.setEnabled(false);

                      calculScoreDonne();
                      tv_score_equipe1.setText(Integer.toString(scoreTotalEquipe1));
                      tv_score_equipe2.setText(Integer.toString(scoreTotalEquipe2));

                  }

              }else if(et_score_equipe1.length()==0){

                  et_score_equipe2.setText(Integer.toString(162));
                  et_score_equipe2.setEnabled(false);

                  calculScoreDonne();
                  tv_score_equipe1.setText(Integer.toString(scoreTotalEquipe1));
                  tv_score_equipe2.setText(Integer.toString(scoreTotalEquipe2));

              }else if (et_score_equipe2.length()==0){
                  et_score_equipe1.setText(Integer.toString(162));
                  et_score_equipe1.setEnabled(false);

                  calculScoreDonne();
                  tv_score_equipe1.setText(Integer.toString(scoreTotalEquipe1));
                  tv_score_equipe2.setText(Integer.toString(scoreTotalEquipe2));


              }

              //Todo gérer l'arrêt d'affichage pour supérieur à 162. Voir avec le Keyboard ?

    }

    @Override
    public void afterTextChanged(Editable s) {


    }


    // Méthode pour activer le listener sur le texte qui change.
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v==et_score_equipe1){

            et_score_equipe1.addTextChangedListener(this);


        }else if (v==et_score_equipe2){

            et_score_equipe2.addTextChangedListener(this);


        }

        return false;
    }
}

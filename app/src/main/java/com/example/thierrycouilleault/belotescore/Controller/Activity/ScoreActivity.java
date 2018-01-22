package com.example.thierrycouilleault.belotescore.Controller.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.thierrycouilleault.belotescore.Model.BDD.Couleur;
import com.example.thierrycouilleault.belotescore.R;

public class ScoreActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    //Composants graphiques

    public FrameLayout fl2;
    public android.support.v7.widget.Toolbar toolbar2;
    public ActionBar actionBar2;
    public TextView tv_joueur1, tv_joueur2, tv_joueur3, tv_joueur4, tv_score_equipe1, tv_score_equipe2;
    public FloatingActionButton fab_ajout_donne;
    public RadioGroup rgb2;


    //Données

    public Couleur couleur;

    //instanciation des fragments


    public FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //gestion des fragments dynamiques

        fl2 = findViewById(R.id.fl2);

        toolbar2 = findViewById(R.id.toolbar2);

        //Utilisation de la toolbar
        setSupportActionBar(toolbar2);
        actionBar2 = getSupportActionBar();
        actionBar2.setTitle("Scores Belote");

        //Autres composants graphiques
        tv_joueur1=findViewById(R.id.tv_joueur1);
        tv_joueur2=findViewById(R.id.tv_joueur2);
        tv_joueur3=findViewById(R.id.tv_joueur3);
        tv_joueur4=findViewById(R.id.tv_joueur4);
        tv_score_equipe1 = findViewById(R.id.tv_score_equipe1);
        tv_score_equipe2 = findViewById(R.id.tv_score_equipe2);

        fab_ajout_donne=findViewById(R.id.fab_ajout_donne);
        fab_ajout_donne.setOnClickListener(this);

        rgb2 = findViewById(R.id.rgb2);
        rgb2.setOnCheckedChangeListener(this);

        //initialisation des composants graphiques
        tv_joueur1.setText("joueurs1");
        tv_joueur2.setText("joueurs2");
        tv_joueur3.setText("joueurs3");
        tv_joueur4.setText("joueurs4");
        tv_score_equipe1.setText("0");
        tv_score_equipe2.setText("0");



    }

    //Méthode qui inflate le menu d'option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.table_score_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.it_param:

                return true;
            case R.id.it_supp_partie:

                return true;

            case R.id.it_noter2:

                return true;

            case R.id.it_distributeur:

                return true;

            case R.id.it_stat:

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId==R.id.rb_trefle) {
            couleur=Couleur.TREFLE;

        }else if (checkedId==R.id.rb_carreau) {
            couleur=Couleur.CARREAU;

        }else if (checkedId==R.id.rb_coeur) {
            couleur=Couleur.COEUR;

        }else if (checkedId==R.id.rb_pique) {
            couleur=Couleur.PIQUE;

        }
    }

    @Override
    public void onClick(View v) {
        if (v==fab_ajout_donne){
            Intent intent2 = new Intent(this, TableScoreActivity.class);

            startActivity(intent2);



        }
    }
}

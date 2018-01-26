package com.example.thierrycouilleault.belotescore.Controller.Activity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.thierrycouilleault.belotescore.Model.BDD.AppDatabase;
import com.example.thierrycouilleault.belotescore.Model.BDD.Couleur;
import com.example.thierrycouilleault.belotescore.Model.BDD.Donne;
import com.example.thierrycouilleault.belotescore.Model.BDD.Equipe;
import com.example.thierrycouilleault.belotescore.Model.BDD.Equipes;
import com.example.thierrycouilleault.belotescore.Model.BDD.Joueur;
import com.example.thierrycouilleault.belotescore.Model.BDD.Partie;
import com.example.thierrycouilleault.belotescore.Model.BDD.TypeJeu;
import com.example.thierrycouilleault.belotescore.R;

import java.util.List;

public class ScoreActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    //Composants graphiques

    public android.support.v7.widget.Toolbar toolbar2;
    public ActionBar actionBar2;
    public TextView tv_joueur1, tv_joueur2, tv_joueur3, tv_joueur4, tv_score_equipe1, tv_score_equipe2;
    public FloatingActionButton fab_ajout_donne;
    public RadioGroup rgb2;
    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;


    //Données

    public Couleur couleur;
    public Partie partie;
    public Donne donne;
    public List<Donne> donnes;
    public Joueur joueur1, joueur2, joueur3, joueur4;
    public int equipesId, equipeIdA, equipeIdB, joueurId1, joueurId2, joueurId3, joueurId4;
    public Equipes equipes;
    public Equipe equipeA, equipeB;
    public List<Joueur> joueurs;
    public List<Partie> parties;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


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



        //Traitement du recycler view

        recyclerView = findViewById(R.id.recycler_view);


        //Gestion de la DB

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        //Création partie courante

        parties =db.partieDao().getAllParties();

        partie = db.partieDao().loadPartieById(parties.size());

        int pid = partie.getPartieId();

        joueur1 = new Joueur();
        joueur2 = new Joueur();
        joueur3 = new Joueur();
        joueur4 = new Joueur();

        joueurs = db.joueurDao().getAllJoueurs();

        joueur1 = db.joueurDao().loadJoueurById(joueurs.size()-3);
        joueur2 = db.joueurDao().loadJoueurById(joueurs.size()-2);
        joueur3 = db.joueurDao().loadJoueurById(joueurs.size()-1);
        joueur4 = db.joueurDao().loadJoueurById(joueurs.size());

        //calcul score



        tv_joueur1.setText(joueur1.getNomJoueur());
        tv_joueur2.setText(joueur2.getNomJoueur());
        tv_joueur3.setText(joueur3.getNomJoueur());
        tv_joueur4.setText(joueur4.getNomJoueur());
        tv_score_equipe1.setText(Integer.toString(partie.getScoreEquipeA()));
        tv_score_equipe2.setText(Integer.toString(partie.getScoreEquipeB()));



        //Affichage donnes ---> courante

        donnes = db.donneDao().getAllDonnesPartiesCourantes(parties.size());


        for (int i = 0; i <10 ; i++) {

            donne = new Donne();

            donne.setScore1(pid);
            donne.setScore2(162);
            donne.setNumDonne(i+1);

            donnes.add(donne);

        }



        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PartieAdapter(donnes);

        recyclerView.setAdapter(adapter);




        //gestion fin de partie

        if (partie.getType().getTypeJeu() == TypeJeu.POINTS.toString()){





        }else if (partie.getType().getTypeJeu() == TypeJeu.DONNES.toString()){



        }

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

        //todo bouger dans table score activity

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

            //Gestion de la DB

            final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                    .allowMainThreadQueries()
                    .build();

                donne = new Donne(partie.getPartieId(), donnes.size(), couleur);

                db.donneDao().insertAll(donne);

            Intent intent2 = new Intent(this, TableScoreActivity.class);

            startActivity(intent2);

        }
    }
}

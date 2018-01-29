package com.example.thierrycouilleault.belotescore.Controller.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.thierrycouilleault.belotescore.Controller.Fragments.HistoFragment;
import com.example.thierrycouilleault.belotescore.Controller.Fragments.JoueursFragment;
import com.example.thierrycouilleault.belotescore.Controller.Fragments.NellePartieEquipeFragment;
import com.example.thierrycouilleault.belotescore.Controller.Fragments.NellePartieFragment;
import com.example.thierrycouilleault.belotescore.R;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, NellePartieFragment.OnNellePartieFragmentListener {


    //Composants graphiques

    public FrameLayout fl;
    public TabLayout tabs;
    public TabLayout.Tab menu_nelle_partie, menu_historique, menu_joueurs;
    public android.support.v7.widget.Toolbar toolbar;
    public ActionBar actionBar;



    //Données

    public static final String EXTRA="com.example.thierrycouilleault.belotescore.MESSAGE";
    public String  mj ="MODE JOUEUR", me ="MODE EQUIPE", TAG;


    //instanciation des fragments

    NellePartieFragment nellePartieFragment = new NellePartieFragment();
    NellePartieEquipeFragment nellePartieEquipeFragment = new NellePartieEquipeFragment();
    JoueursFragment joueursFragment = new JoueursFragment();
    HistoFragment histoFragment = new HistoFragment();


    public FragmentTransaction transaction;


    //TODO Faire le Splash
    //TODO gérer le Lifecycle

                                  //LifeCycleActivity

    // Méthode lancée à OnCreate()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Gestion des préférences


        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        String nbPointsString = sharedPref.getString("nb_points_gagnés", "600");



        Toast.makeText(this, nbPointsString, Toast.LENGTH_LONG).show();


        // enable transitions
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_main);


        //gestion des fragments dynamiques

       fl = findViewById(R.id.fl);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl, nellePartieFragment).commit();


        //Gestion des onglets dans un Tablayout
        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Nouvelle partie"), 0, true);
        tabs.addTab(tabs.newTab().setText("Historique"), 1);
        tabs.addTab(tabs.newTab().setText("Joueurs"), 2);
        tabs.addOnTabSelectedListener(this);

        menu_nelle_partie=tabs.getTabAt(0);
        menu_historique=tabs.getTabAt(1);
        menu_joueurs=tabs.getTabAt(2);

        toolbar = findViewById(R.id.toolbar);

        //Utilisation de la toolbar
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Scores Belote");

    }


    //Méthode qui inflate le menu d'option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.belote_score_menu, menu);
        return true;
    }

    //Méthode qui indique quoi faire sur les items du menu d'options.

    //TODO : faire les "case" du menu d'options

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.it_preferences:

                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);

                return true;
            case R.id.it_noter_app:

                return true;

            case R.id.it_plus:

                return true;

            case R.id.it_mode:
                //gère le menu equipe
                if(mj.equals(item.getTitle().toString())){
                    item.setTitle("MODE EQUIPE");
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fl, nellePartieEquipeFragment).commit();


                    //gère le menu joueur
                }else if (me.equals(item.getTitle().toString())){
                    item.setTitle("MODE JOUEUR");
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fl, nellePartieFragment).commit();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    //Méthodes pour les onglets

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab==menu_nelle_partie){

            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fl, nellePartieFragment).commit();

        }else if (tab==menu_historique){

            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fl, histoFragment).commit();

        }else if (tab==menu_joueurs){

            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fl, joueursFragment).commit();

        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void commencerPartie() {

        getWindow().setExitTransition(new Explode());

        Intent intent = new Intent(this, ScoreActivity.class);

        startActivity(intent,
                ActivityOptions
                        .makeSceneTransitionAnimation(this).toBundle());

    }

    //TODO faire les menus

}





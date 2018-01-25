package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;

/**
 * Created by thierrycouilleault on 13/11/2017.
 */



public class Equipe {
    //Variables d'instance

    @ColumnInfo(name="nom_equipe")
    private String nomEquipe;

    @Embedded
    private Joueur joueur1;

    @Embedded
    private Joueur joueur2;


    //Variables statiques

    //Méthodes constructeurs

    public Equipe() {}

    public Equipe(String nomEquipe, Joueur joueur1, Joueur joueur2) {
        this.nomEquipe = nomEquipe;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public Equipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    //Autres méthodes

    //Getter et Setter


    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }
}

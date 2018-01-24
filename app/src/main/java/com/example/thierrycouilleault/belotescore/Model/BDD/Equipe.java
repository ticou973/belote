package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by thierrycouilleault on 13/11/2017.
 */


@Entity
public class Equipe {
    //Variables d'instance

    @PrimaryKey (autoGenerate = true)
    private int equipeId;

    @ColumnInfo(name="nom_equipe")
    private String nomEquipe;

    @ColumnInfo(name="joueur1")
    private int joueur1;

    @ColumnInfo(name="joueur2")
    private int joueur2;


    //Variables statiques

    //Méthodes constructeurs

    public Equipe() {}

    public Equipe (int joueur1, int joueur2, String nomEquipe){
        this.nomEquipe = nomEquipe;
        this.joueur1=joueur1;
        this.joueur2=joueur2;
    }


    public Equipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    //Autres méthodes

    //Getter et Setter


    public int getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(int equipeId) {
        this.equipeId = equipeId;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public int getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(int joueur1) {
        this.joueur1 = joueur1;
    }

    public int getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(int joueur2) {
        this.joueur2 = joueur2;
    }
}

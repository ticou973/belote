package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by thierrycouilleault on 13/11/2017.
 */


@Entity
public class Partie {

    // Variables d'instance

    @PrimaryKey(autoGenerate = true)
    private int partieId;


    @Embedded
    private TypeDePartie type;


    @Embedded
    private Equipes equipes;


    @Embedded
    private Joueur premierDistributeur;

    @ColumnInfo(name ="sens_jeu")
    private boolean sensJeu;



    //Méthodes constructeurs

    public Partie(TypeDePartie type, Equipes equipes, Joueur premierDistributeur, boolean sensJeu) {
        this.type = type;
        this.equipes = equipes;
        this.premierDistributeur = premierDistributeur;
        this.sensJeu = sensJeu;
    }

    @Ignore
    public Partie(TypeDePartie type, Equipes equipes) {
        this.type = type;
        this.equipes = equipes;
    }

    //Autres méthodes



    //Getter et Setter


    public int getPartieId() {
        return partieId;
    }

    public void setPartieId(int partieId) {
        this.partieId = partieId;
    }

    public TypeDePartie getType() {
        return type;
    }

    public void setType(TypeDePartie type) {
        this.type = type;
    }

    public Equipes getEquipes() {
        return equipes;
    }

    public void setEquipes(Equipes equipes) {
        this.equipes = equipes;
    }

    public Joueur getPremierDistributeur() {
        return premierDistributeur;
    }

    public void setPremierDistributeur(Joueur premierDistributeur) {
        this.premierDistributeur = premierDistributeur;
    }

    public boolean isSensJeu() {
        return sensJeu;
    }

    public void setSensJeu(boolean sensJeu) {
        this.sensJeu = sensJeu;
    }
}

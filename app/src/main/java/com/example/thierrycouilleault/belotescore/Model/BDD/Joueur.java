package com.example.thierrycouilleault.belotescore.Model.BDD;

/**
 * Created by thierrycouilleault on 17/01/2018.
 */



public class Joueur {

    private int uid;


    private String nomJoueur;


    //Méthodes constructeurs

    public Joueur (){
    }

    public Joueur (String nomJoueur) {
        this.nomJoueur = nomJoueur;

    }

    //Autres méthodes



    //Getter et Setter

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}




package com.example.thierrycouilleault.belotescore.Model.BDD;

/**
 * Created by thierrycouilleault on 13/11/2017.
 */

public class Equipe {
    //Variables d'instance

    private String nomEquipe;
    private Joueur[] listeJoueurs;
    private Joueur joueur1, joueur2;


    //Variables statiques

    //Méthodes constructeurs

    public Equipe() {}

    public Equipe (Joueur joueur1, Joueur joueur2, String nomEquipe){
        this.nomEquipe = nomEquipe;
        this.joueur1=joueur1;
        this.joueur2=joueur2;
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

    public Joueur getJoueurA() {
        return joueur1;
    }

    public void setJoueurA(Joueur joueurA) {
        this.joueur1 = joueurA;
    }

    public Joueur getJoueurB() {
        return joueur2;
    }

    public void setJoueurB(Joueur joueurB) {
        this.joueur2 = joueurB;
    }
}

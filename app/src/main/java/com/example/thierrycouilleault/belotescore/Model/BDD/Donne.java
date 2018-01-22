package com.example.thierrycouilleault.belotescore.Model.BDD;

/**
 * Created by thierrycouilleault on 13/11/2017.
 */

public class Donne {

    private Partie partie;
    private int numDonne;
    private Preneur preneur;
    private Couleur couleur;
    private boolean belote;
    private boolean capot;
    private int score1, score2;

    // constructeur




    //getter et setter


    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public int getNumDonne() {
        return numDonne;
    }

    public void setNumDonne(int numDonne) {
        this.numDonne = numDonne;
    }

    public Preneur getPreneur() {
        return preneur;
    }

    public void setPreneur(Preneur preneur) {
        this.preneur = preneur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public boolean isBelote() {
        return belote;
    }

    public void setBelote(boolean belote) {
        this.belote = belote;
    }

    public boolean isCapot() {
        return capot;
    }

    public void setCapot(boolean capot) {
        this.capot = capot;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }
}

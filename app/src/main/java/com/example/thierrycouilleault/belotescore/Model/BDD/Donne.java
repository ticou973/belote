package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by thierrycouilleault on 13/11/2017.
 */

@Entity (foreignKeys = @ForeignKey(entity = Partie.class,
        parentColumns = "partieId",
        childColumns = "partieId"))
public class Donne {

    @PrimaryKey (autoGenerate = true)
    private int donneId;

    @ColumnInfo (name ="num_partie")
    private int partieId;


    @ColumnInfo (name = "num_donne_partie")
    private int numDonne;

    @Embedded
    private Joueur preneur;

    @Embedded
    private Couleur couleur;

    @ColumnInfo (name ="belote")
    private boolean belote;

    @ColumnInfo (name ="capot")
    private boolean capot;

    @ColumnInfo (name = "score_equipeA")
    private int score1;

    @ColumnInfo (name = "score_equipeB")
    private int score2;



    // constructeur




    //getter et setter


    public int getDonneId() {
        return donneId;
    }

    public void setDonneId(int donneId) {
        this.donneId = donneId;
    }

    public int getPartieId() {
        return partieId;
    }

    public void setPartieId(int partieId) {
        this.partieId = partieId;
    }

    public int getNumDonne() {
        return numDonne;
    }

    public void setNumDonne(int numDonne) {
        this.numDonne = numDonne;
    }

    public Joueur getPreneur() {
        return preneur;
    }

    public void setPreneur(Joueur preneur) {
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

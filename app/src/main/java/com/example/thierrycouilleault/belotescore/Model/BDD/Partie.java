package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by thierrycouilleault on 13/11/2017.
 */


@Entity (foreignKeys = @ForeignKey(entity = Equipes.class,
        parentColumns = "equipesid",
        childColumns = "equipesid"))
public class Partie {

    // Variables d'instance

    @PrimaryKey(autoGenerate = true)
    private int partieId;


    @Embedded
    private TypeDePartie type;


    @ColumnInfo(name = "equipes")
    private int equipesId;


    @ColumnInfo(name="premier_distributeur")
    private Distributeur premierDistributeur;

    @ColumnInfo(name="sens_jeu")
    private SensJeu sensJeu;



    //Variables statiques


    //Méthodes constructeurs

    public Partie() {
    }

    public Partie(TypeDePartie type, Distributeur premierDistributeur, SensJeu sensJeu, int equipesId, int partieId) {
        this.type = type;
        this.premierDistributeur = premierDistributeur;
        this.sensJeu = sensJeu;
        this.equipesId = equipesId;
        this.partieId = partieId;
    }

    public Partie(TypeDePartie type, Distributeur premierDistributeur, SensJeu sensJeu, int equipesId) {
        this.type = type;
        this.premierDistributeur = premierDistributeur;
        this.sensJeu = sensJeu;
        this.equipesId = equipesId;
    }

    public Partie(TypeDePartie type, int equipesId) {
        this.type = type;
        this.equipesId = equipesId;
    }
    //Autres méthodes



    //Getter et Setter


}

package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
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


    @ColumnInfo(name = "equipeA")
    private Equipe equipeA;

    @ColumnInfo(name = "equipeB")
    private Equipe equipeB;


    @ColumnInfo(name="premier_distributeur")
    private Distributeur premierDistributeur;

    @ColumnInfo(name="sens_jeu")
    private SensJeu sensJeu;



    //Variables statiques


    //Méthodes constructeurs

    public Partie() {
    }

    public Partie(TypeDePartie type, Distributeur premierDistributeur, SensJeu sensJeu, Equipe equipeA, Equipe equipeB, int partieId) {
        this.type = type;
        this.premierDistributeur = premierDistributeur;
        this.sensJeu = sensJeu;
        this.equipeA = equipeA;
        this.equipeB = equipeB;
        this.partieId = partieId;
    }

    public Partie(TypeDePartie type, Distributeur premierDistributeur, SensJeu sensJeu, Equipe equipeA, Equipe equipeB) {
        this.type = type;
        this.premierDistributeur = premierDistributeur;
        this.sensJeu = sensJeu;
        this.equipeA = equipeA;
        this.equipeB = equipeB;
    }

    public Partie(TypeDePartie type, Equipe equipeA, Equipe equipeB) {
        this.type = type;
        this.equipeA = equipeA;
        this.equipeB = equipeB;
    }
    //Autres méthodes



    //Getter et Setter


}

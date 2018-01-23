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
        parentColumns = "equipesId",
        childColumns = "equipes"))
public class Partie {

    // Variables d'instance

    @PrimaryKey(autoGenerate = true)
    private int partieId;


    @Embedded
    private TypeDePartie type;


    @ColumnInfo(name = "equipes")
    private int equipesId;


    @Embedded
    private Joueur premierDistributeur;

    @ColumnInfo(name ="sens_jeu")
    private boolean sensJeu;


    //Variables statiques


    //Méthodes constructeurs


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

    public int getEquipesId() {
        return equipesId;
    }

    public void setEquipesId(int equipesId) {
        this.equipesId = equipesId;
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

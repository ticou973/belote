package com.example.thierrycouilleault.belotescore.Model.BDD;

/**
 * Created by thierrycouilleault on 13/11/2017.
 */

public class PartieDonnes extends Partie {


    // Variables d'instance
    private int nbDonnesPartie;


    //Variables statiques

    //Méthodes constructeurs

    public PartieDonnes(int nbDonnesPartie) {
        this.nbDonnesPartie = nbDonnesPartie;
    }

    public PartieDonnes(TypeDePartie type, Distributeur premierDistributeur, SensJeu sensJeu, Equipe equipeA, Equipe equipeB, int nbDonnesPartie) {
        super(type, premierDistributeur, sensJeu, equipeA, equipeB);
        this.nbDonnesPartie = nbDonnesPartie;
    }

    public PartieDonnes(TypeDePartie type, Equipe equipeA, Equipe equipeB, int nbDonnesPartie) {
        super(type, equipeA, equipeB);
        this.nbDonnesPartie = nbDonnesPartie;
    }

    //Autres méthodes

    //Getter et Setter


    public int getNbDonnesPartie() {
        return nbDonnesPartie;
    }

    public void setNbDonnesPartie(int nbDonnesPartie) {
        this.nbDonnesPartie = nbDonnesPartie;
    }
}

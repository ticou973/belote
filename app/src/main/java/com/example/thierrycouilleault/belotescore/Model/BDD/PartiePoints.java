package com.example.thierrycouilleault.belotescore.Model.BDD;

/**
 * Created by thierrycouilleault on 13/11/2017.
 */

public class PartiePoints extends Partie {


    // Variables d'instance
    private int nbPointsPartie;


    //Variables statiques

    //Méthodes constructeurs

    public PartiePoints(int nbPointsPartie) {
        this.nbPointsPartie = nbPointsPartie;
    }

    public PartiePoints(TypeDePartie type, Distributeur premierDistributeur, SensJeu sensJeu, Equipe equipeA, Equipe equipeB, int numeroPartie, int nbPointsPartie) {
        super(type, premierDistributeur, sensJeu, equipeA, equipeB, numeroPartie);
        this.nbPointsPartie = nbPointsPartie;
    }

    public PartiePoints(TypeDePartie type, Distributeur premierDistributeur, SensJeu sensJeu, Equipe equipeA, Equipe equipeB, int nbPointsPartie) {
        super(type, premierDistributeur, sensJeu, equipeA, equipeB);
        this.nbPointsPartie = nbPointsPartie;
    }

    public PartiePoints(TypeDePartie type, Equipe equipeA, Equipe equipeB, int nbPointsPartie) {
        super(type, equipeA, equipeB);
        this.nbPointsPartie = nbPointsPartie;
    }

    //Autres méthodes

    //Getter et Setter


    public int getNbPointsPartie() {
        return nbPointsPartie;
    }

    public void setNbPointsPartie(int nbPointsPartie) {
        this.nbPointsPartie = nbPointsPartie;
    }
}

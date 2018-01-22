package com.example.thierrycouilleault.belotescore.Model.BDD;

/**
 * Created by thierrycouilleault on 13/11/2017.
 */

public class Partie {


    // Variables d'instance

    
    private TypeDePartie type;
    private Distributeur premierDistributeur;
    private SensJeu sensJeu;
    private Equipe equipeA, equipeB;
    private int numeroPartie;

    //Variables statiques


    //Méthodes constructeurs

    public Partie() {
    }

    public Partie(TypeDePartie type, Distributeur premierDistributeur, SensJeu sensJeu, Equipe equipeA, Equipe equipeB, int numeroPartie) {
        this.type = type;
        this.premierDistributeur = premierDistributeur;
        this.sensJeu = sensJeu;
        this.equipeA = equipeA;
        this.equipeB = equipeB;
        this.numeroPartie = numeroPartie;
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

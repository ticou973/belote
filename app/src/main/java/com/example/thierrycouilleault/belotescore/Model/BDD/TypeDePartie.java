package com.example.thierrycouilleault.belotescore.Model.BDD;

/**
 * Created by thierrycouilleault on 16/11/2017.
 */

public class TypeDePartie {

    // Variables d'instance

    private TypeJeu typeJeu=TypeJeu.POINTS;
    private TypeAnnonce typeAnnonce = TypeAnnonce.SANS_ANNONCE;
    private int nbPoints;
    private int nbDonnes;


    //Variables statiques


    //Méthodes constructeurs

    public TypeDePartie(TypeAnnonce typeAnnonce, TypeJeu typeJeu) {
        this.typeAnnonce = typeAnnonce;
        this.typeJeu = typeJeu;
    }

     public TypeDePartie() {

    }


    //Autres méthodes

    //Getter et Setter

    public TypeAnnonce getTypeAnnonce() {
        return typeAnnonce;
    }

    public void setTypeAnnonce(TypeAnnonce typeAnnonce) {
        this.typeAnnonce = typeAnnonce;
    }

    public TypeJeu getTypeJeu() {
        return typeJeu;
    }

    public void setTypeJeu(TypeJeu typeJeu) {
        this.typeJeu = typeJeu;
    }
}

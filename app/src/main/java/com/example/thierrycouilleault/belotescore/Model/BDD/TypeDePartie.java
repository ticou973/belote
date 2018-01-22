package com.example.thierrycouilleault.belotescore.Model.BDD;

/**
 * Created by thierrycouilleault on 16/11/2017.
 */

public class TypeDePartie {

    // Variables d'instance

    private TypeAnnonce typeAnnonce = TypeAnnonce.SANS_ANNONCE;
    private TypeJeu typeJeu=TypeJeu.POINTS;
    private PartiePoints partiePoints;
    private PartieDonnes partieDonnes;


    //Variables statiques


    //Méthodes constructeurs

    public TypeDePartie(TypeAnnonce typeAnnonce, TypeJeu typeJeu) {
        this.typeAnnonce = typeAnnonce;
        this.typeJeu = typeJeu;

        if (typeJeu == TypeJeu.POINTS) {
            partiePoints = new PartiePoints(1001);

        }else{
            partieDonnes = new PartieDonnes(12);
        }
    }

     public TypeDePartie() {
         if (typeJeu == TypeJeu.POINTS) {
             partiePoints = new PartiePoints(1001);

         }else{
             partieDonnes = new PartieDonnes(12);
         }
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

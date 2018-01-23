package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by thierrycouilleault on 23/01/2018.
 */


@Database(entities ={Partie.class, Joueur.class, Equipes.class, Equipe.class, Donne.class }, version =1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PartieDao partieDao();
    public abstract JoueurDao joueurDao();
    public abstract EquipesDao equipesDao();
    public abstract EquipeDao equipeDao();
    public abstract DonneDao donneDao();

}

package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by thierrycouilleault on 17/01/2018.
 */


@Database(entities = {Joueur.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract JoueurDao joueurDao();
}

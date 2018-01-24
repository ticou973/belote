package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

/**
 * Created by thierrycouilleault on 23/01/2018.
 */

@Dao
public interface JoueurDao {

    @Query("SELECT * FROM joueur WHERE nom_joueur IN (:nomJoueur)")
    Joueur loadJoueurByName (String nomJoueur);

    @Insert
    void insertAll(Joueur joueur);


}

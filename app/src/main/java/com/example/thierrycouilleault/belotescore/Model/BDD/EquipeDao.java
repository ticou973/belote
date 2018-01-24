package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

/**
 * Created by thierrycouilleault on 23/01/2018.
 */

@Dao
public interface EquipeDao {

    @Query("SELECT * FROM equipe WHERE (joueur1 OR joueur2) IN (:joueurId1)" + "AND (joueur1 OR joueur2) IN (:joueurId2)")
    Equipe loadEquipeByJoueursIds (int joueurId1, int joueurId2);

    @Insert
    void insertAll(Equipe equipe);
}

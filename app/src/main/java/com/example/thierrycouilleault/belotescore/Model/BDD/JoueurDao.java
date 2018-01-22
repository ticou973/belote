package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by thierrycouilleault on 17/01/2018.
 */

@Dao
public interface JoueurDao {
    @Query("SELECT * FROM user")
    List<Joueur> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<Joueur> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    Joueur findByName(String first, String last);

    @Insert
    void insertAll(Joueur... joueurs);

    @Delete
    void delete(Joueur joueur);
}

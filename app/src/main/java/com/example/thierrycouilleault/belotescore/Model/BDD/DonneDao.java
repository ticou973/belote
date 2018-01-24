package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by thierrycouilleault on 23/01/2018.
 */


@Dao
public interface DonneDao {

    @Query("SELECT * FROM donne WHERE num_partie IN (:partieId)")
    List<Donne> getAllDonnesPartiesCourantes(int partieId);

}

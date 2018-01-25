package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

/**
 * Created by thierrycouilleault on 23/01/2018.
 */

@Dao
public interface EquipesDao {

    @Query("SELECT * FROM equipes WHERE equipesId IN (:equipesId)")
    Equipes loadEquipesbyIds(int equipesId);



    @Insert
    void insertAll(Equipes equipes);

}

package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

/**
 * Created by thierrycouilleault on 23/01/2018.
 */

@Dao
public interface PartieDao {

    @Insert
    void insertAll(Partie partie);
}

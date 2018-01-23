package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by thierrycouilleault on 22/01/2018.
 */

@Entity
public class Equipes {

   @PrimaryKey (autoGenerate = true)
    private int equipesId;

   @ColumnInfo (name = "equipeA")
    private Equipe equipeA;

   @ColumnInfo (name ="equipeB")
    private Equipe equipeB;




   //Getter et setter


    public int getEquipesId() {
        return equipesId;
    }

    public void setEquipesId(int equipesId) {
        this.equipesId = equipesId;
    }

    public Equipe getEquipeA() {
        return equipeA;
    }

    public void setEquipeA(Equipe equipeA) {
        this.equipeA = equipeA;
    }

    public Equipe getEquipeB() {
        return equipeB;
    }

    public void setEquipeB(Equipe equipeB) {
        this.equipeB = equipeB;
    }
}

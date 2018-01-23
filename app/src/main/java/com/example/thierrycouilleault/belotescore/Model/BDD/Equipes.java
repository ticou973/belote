package com.example.thierrycouilleault.belotescore.Model.BDD;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by thierrycouilleault on 22/01/2018.
 */

@Entity(foreignKeys = @ForeignKey(entity = Equipe.class,
        parentColumns = {"equipeId", "equipeId"},
        childColumns = {"equipeA","equipeB"}))
public class Equipes {

   @PrimaryKey (autoGenerate = true)
    private int equipesId;

   @ColumnInfo(name ="equipeA")
    private int equipeIdA;

    @ColumnInfo(name ="equipeB")
    private int equipeIdB;







   //Getter et setter


    public int getEquipesId() {
        return equipesId;
    }

    public void setEquipesId(int equipesId) {
        this.equipesId = equipesId;
    }

    public int getEquipeIdA() {
        return equipeIdA;
    }

    public void setEquipeIdA(int equipeIdA) {
        this.equipeIdA = equipeIdA;
    }

    public int getEquipeIdB() {
        return equipeIdB;
    }

    public void setEquipeIdB(int equipeIdB) {
        this.equipeIdB = equipeIdB;
    }
}

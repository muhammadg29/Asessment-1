package org.d3if3017.assesment2_mobpro.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AmoebaDao {

    @Insert
    fun insert(amoeba: AmoebaEntity)

    @Query("SELECT * FROM amoeba ORDER BY id")
    fun getLastBmi(): LiveData<List<AmoebaEntity>>

    @Delete
    fun clearData(amoeba: AmoebaEntity)

    @Query("Delete FROM amoeba")
    fun hapusdata()
}
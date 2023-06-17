package org.d3if3017.assesment3_mobpro.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "amoeba")
data class AmoebaEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var awalAmoeba: Float,
    var pembelahanAmoeba: Float,
    var rentangWaktu: Float,
    var jangkaWaktu: Float
)
package org.d3if3017.assesment2_mobpro.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3017.assesment2_mobpro.db.AmoebaDao
import org.d3if3017.assesment2_mobpro.db.AmoebaEntity
import org.d3if3017.assesment2_mobpro.model.HasilAmoeba
import org.d3if3017.assesment2_mobpro.model.hitungAmoeba

class HitungViewModel(private val db: AmoebaDao): ViewModel() {

    private val hasilAmoeba = MutableLiveData<HasilAmoeba?>()

    fun hitungAmoeba(awalAmoeba : Float, pembelahanAmoeba: Float, rentangWaktu: Float, jangkaWaktu: Float, saveDatabase: Boolean){

        val dataAmoeba = AmoebaEntity(
            awalAmoeba = awalAmoeba,
            pembelahanAmoeba = pembelahanAmoeba,
            rentangWaktu = rentangWaktu,
            jangkaWaktu = jangkaWaktu,
        )

        hasilAmoeba.value = dataAmoeba.hitungAmoeba()

        if(saveDatabase){
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    db.insert(dataAmoeba)
                }
            }
        }
    }

    fun getHasilAmoeba(): LiveData<HasilAmoeba?> = hasilAmoeba

    fun deleteHasilAmoeba(){
        hasilAmoeba.value = null
    }
}
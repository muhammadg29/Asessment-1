package org.d3if3017.assesment3_mobpro.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3017.assesment3_mobpro.db.AmoebaDao
import org.d3if3017.assesment3_mobpro.db.AmoebaEntity

class HistoriViewModel(private val db: AmoebaDao) : ViewModel() {
    val data = db.getLastBmi()

    fun hapusData(amoeba: AmoebaEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData(amoeba)
        }
    }
    fun hapusdataAll() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.hapusdata()
        }
    }
}
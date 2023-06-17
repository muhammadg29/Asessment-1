package org.d3if3017.assesment3_mobpro.ui.berkembang_biak

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3017.assesment3_mobpro.model.Berkembang
import org.d3if3017.assesment3_mobpro.network.ApiStatus
import org.d3if3017.assesment3_mobpro.network.ServiceAPI
import org.d3if3017.assesment3_mobpro.network.UpdateWorker
import java.util.concurrent.TimeUnit

class BerkembangViewModel : ViewModel() {
    private val data = MutableLiveData<List<Berkembang>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(ServiceAPI.sukuService.getBiak())
                status.postValue(ApiStatus.SUCCES)
            } catch (e: Exception) {
                Log.d("BerkambangViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<Berkembang>> = data

    fun scheduleUpdater(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(app).enqueueUniqueWork(
            UpdateWorker.WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }

    fun getStatus(): LiveData<ApiStatus> = status
}
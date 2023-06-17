package org.d3if3017.assesment3_mobpro.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3017.assesment3_mobpro.model.Berkembang
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface BiakApi {
    @GET("berkembang.json")
    suspend fun getBiak(): List<Berkembang>
}

object ServiceAPI {
    private const val BASE_URL_BIAK = "https://raw.githubusercontent.com/" +
            "rifanmuhammadhidayat/rifan-resolusi/dataAPI/"
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofitBiak = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL_BIAK)
        .build()

    //Retrofit Create


    val sukuService: BiakApi by lazy {
        retrofitBiak.create(BiakApi::class.java)
    }

    //Function


    fun getBiakUrl(imageId: String): String {
        return "$BASE_URL_BIAK$imageId.jpg"
    }
}


enum class ApiStatus { LOADING, SUCCES,FAILED}
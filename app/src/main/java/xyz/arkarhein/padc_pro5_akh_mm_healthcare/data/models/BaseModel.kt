package xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.models

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.network.HealthcareApi
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.persistence.AppDatabase
import java.util.concurrent.TimeUnit

abstract class BaseModel protected constructor(context: Context) {

    protected var mTheApi: HealthcareApi
    protected var mTheDB: AppDatabase

    init {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/mm-healthcare/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        mTheApi = retrofit.create<HealthcareApi>(HealthcareApi::class.java)
        mTheDB = AppDatabase.getDatabase(context)
    }
}
package xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.models

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.MMHealthcareApp
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos.HealthcareVO
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.network.responses.GetHealthcareResponse

class HealthcareModel(context: Context) : BaseModel(context) {

    companion object {
        private var INSTANCE: HealthcareModel? = null

        fun getInstance(): HealthcareModel {
            if (INSTANCE == null) {
//                throw RuntimeException("HealthcareModel is being invoked before initializing.")
            }

            val i = INSTANCE
            return i!!
        }

        fun initHealthcareModel(context: Context) {
            INSTANCE = HealthcareModel(context)
        }
    }


    fun startLoadingMMNews(healthcareLD: MutableLiveData<List<HealthcareVO>>?) {
        mTheApi.loadHealthcareInfo(MMHealthcareApp.ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<GetHealthcareResponse> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onComplete() {

                    }

                    override fun onNext(healthcareResponse: GetHealthcareResponse) {
                        if (healthcareResponse.getHealthcareInfo().isNotEmpty()) {
                            persistHealthcareList(healthcareResponse.getHealthcareInfo())
                            healthcareLD!!.value = (healthcareResponse.getHealthcareInfo())
                        }
                    }

                    override fun onError(e: Throwable) {

                    }
                })
    }

    private fun persistHealthcareList(healthcareList: List<HealthcareVO>) {
        mTheDB.healthcareDao().insertHealthcare(healthcareList)

        val insertedHealthcare = mTheDB.healthcareDao().insertHealthcare(healthcareList)
        Log.d(MMHealthcareApp.TAG, "insertedHealthcareList : ${insertedHealthcare.size}")
    }

}
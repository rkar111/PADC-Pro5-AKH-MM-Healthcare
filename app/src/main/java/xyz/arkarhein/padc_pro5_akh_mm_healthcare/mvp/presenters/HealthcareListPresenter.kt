package xyz.arkarhein.padc_pro5_akh_mm_healthcare.mvp.presenters

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.models.HealthcareModel
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos.HealthcareVO
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.delegates.HealthcareItemDelegate
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.mvp.views.HealthcareListView

class HealthcareListPresenter : BasePresenter<HealthcareListView>(), HealthcareItemDelegate {


    override fun initPresenter(mView: HealthcareListView) {
        super.initPresenter(mView)
        HealthcareModel.getInstance().startLoadingMMNews(mErrorLD)
    }

    fun getHealthcareLD(): LiveData<List<HealthcareVO>> {
        return HealthcareModel.getInstance().getAllHealthcareData()
    }

    override fun onTapHealthcareItem(healthcareVO: HealthcareVO) {
        mView.launchHealthcareUrl(healthcareVO.completeUrl!!)
    }

    fun forceRefresh(): LiveData<List<HealthcareVO>> {
        return HealthcareModel.getInstance().getAllHealthcareData()
    }
}
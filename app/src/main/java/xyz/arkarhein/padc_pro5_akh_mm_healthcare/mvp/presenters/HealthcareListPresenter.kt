package xyz.arkarhein.padc_pro5_akh_mm_healthcare.mvp.presenters

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.models.HealthcareModel
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos.HealthcareVO
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.delegates.HealthcareItemDelegate
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.mvp.views.HealthcareListView

class HealthcareListPresenter : BasePresenter<HealthcareListView>(), HealthcareItemDelegate {


    private lateinit var healthcareLD: MutableLiveData<List<HealthcareVO>>

    override fun initPresenter(mView: HealthcareListView) {
        super.initPresenter(mView)
        healthcareLD = MutableLiveData()
        HealthcareModel.getInstance().startLoadingMMNews(healthcareLD)
    }

    fun getHealthcareLD(): MutableLiveData<List<HealthcareVO>> {
        return healthcareLD
    }

    override fun onTapHealthcareItem(healthcareVO: HealthcareVO) {
        mView.launchHealthcareUrl(healthcareVO.completeUrl!!)
    }
}
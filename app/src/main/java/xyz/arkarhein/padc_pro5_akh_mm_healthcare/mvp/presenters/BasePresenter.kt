package xyz.arkarhein.padc_pro5_akh_mm_healthcare.mvp.presenters

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.mvp.views.BaseView

abstract class BasePresenter<T : BaseView> : ViewModel() {

    lateinit var mView: T
    lateinit var mErrorLD: MutableLiveData<String>

    open fun initPresenter(mView: T) {
        this.mView = mView
        mErrorLD = MutableLiveData()
    }

}
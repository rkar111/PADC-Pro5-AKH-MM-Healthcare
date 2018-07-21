package xyz.arkarhein.padc_pro5_akh_mm_healthcare.activities


import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), Observer<String> {

    override fun onChanged(errorMsg: String?) {
        displayErrorMsg(errorMsg)
    }

    protected open fun displayErrorMsg(errorMsg: String?) {

    }

}
package xyz.arkarhein.padc_pro5_akh_mm_healthcare.activities

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.padcmyanmar.mmnews.kotlin.components.SmartScrollListener

import kotlinx.android.synthetic.main.activity_healthcare_list.*
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.R
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.adapters.HealthcareListAdapter
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.models.HealthcareModel
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos.HealthcareVO
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.mvp.presenters.HealthcareListPresenter
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.mvp.views.HealthcareListView

class HealthCareListActivity : BaseActivity(), HealthcareListView {


    private lateinit var mAdapter: HealthcareListAdapter
    private lateinit var mPresenter: HealthcareListPresenter
    private var mSmartScrollListener: SmartScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healthcare_list)
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setTitle(R.string.app_name)
            supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        /*    fab.setOnClickListener { view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }*/

        mPresenter = ViewModelProviders.of(this).get(HealthcareListPresenter::class.java)
        mPresenter.initPresenter(this)

        mAdapter = HealthcareListAdapter(applicationContext, mPresenter)

        rvNews.setEmptyView(vpEmptyNews)

        mSmartScrollListener = SmartScrollListener(object : SmartScrollListener.OnSmartScrollListener {
            override fun onListEndReach() {
                Snackbar.make(rvNews, "End of Data", Snackbar.LENGTH_LONG).show()
            }
        })
        rvNews.addOnScrollListener(mSmartScrollListener)
        rvNews.layoutManager = LinearLayoutManager(applicationContext)
        rvNews.adapter = mAdapter

        mPresenter.getHealthcareLD().observe(this, Observer<List<HealthcareVO>> { healthcareList ->
            displaytHealthcareList(healthcareList!!)
        })
    }

    fun displaytHealthcareList(healthcareList: List<HealthcareVO>) {
        mAdapter.appendNewData(healthcareList)
    }

    override fun launchHealthcareUrl(url: String) {
        var builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        var customTabIntent: CustomTabsIntent = builder.build()
        customTabIntent.launchUrl(applicationContext, Uri.parse(url))

    }
/*    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/
}

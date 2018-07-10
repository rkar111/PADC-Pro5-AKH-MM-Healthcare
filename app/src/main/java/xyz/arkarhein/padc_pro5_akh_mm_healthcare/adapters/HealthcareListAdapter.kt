package xyz.arkarhein.padc_pro5_akh_mm_healthcare.adapters

import android.content.Context
import android.view.ViewGroup
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.R
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos.HealthcareVO
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.delegates.HealthcareItemDelegate
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.viewholders.ItemHealthcareViewHolder

class HealthcareListAdapter(context: Context,
                            private val mHealthcareItemDelegate: HealthcareItemDelegate) : BaseRecyclerAdapter<ItemHealthcareViewHolder, HealthcareVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHealthcareViewHolder {
        val itemHealthcareView = mLayoutInflator.inflate(R.layout.item_healthcare, parent, false)
        return ItemHealthcareViewHolder(itemHealthcareView, mHealthcareItemDelegate)
    }

}
package xyz.arkarhein.padc_pro5_akh_mm_healthcare.viewholders

import android.view.View
import com.bumptech.glide.Glide
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos.HealthcareVO
import kotlinx.android.synthetic.main.item_healthcare.view.*
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.delegates.HealthcareItemDelegate

class ItemHealthcareViewHolder(itemView: View,
                               private val mHealthcareItemDelegate: HealthcareItemDelegate) : BaseViewHolder<HealthcareVO>(itemView) {


    override fun setData(data: HealthcareVO) {
        mData = data
        itemView.tvHealthcareHeading!!.text = data.title
        itemView.tvPublishDate!!.text = data.publishedDate
        if (data.author != null) {
            itemView.tvAuthorName!!.text = data.author!!.authorName
            Glide.with(itemView.context)
                    .load(data.author!!.authorPicture)
                    .into(itemView.ivAuthor)
        }
        if (!data.image!!.isEmpty()) {
            itemView.ivHealthcare!!.visibility = View.VISIBLE
            Glide.with(itemView.context)
                    .load(data.image!!)
                    .into(itemView.ivHealthcare)
        } else {
            itemView.ivHealthcare!!.visibility = View.GONE
        }
        itemView.tvShortDesc!!.text = data.shortDescription
    }

    override fun onClick(v: View?) {
        mHealthcareItemDelegate.onTapHealthcareItem(this.mData!!)
    }
}
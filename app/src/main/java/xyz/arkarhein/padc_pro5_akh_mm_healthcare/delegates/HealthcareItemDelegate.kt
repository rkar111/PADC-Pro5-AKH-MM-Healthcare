package xyz.arkarhein.padc_pro5_akh_mm_healthcare.delegates

import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos.HealthcareVO

interface HealthcareItemDelegate {
    fun onTapHealthcareItem(healthcareVO: HealthcareVO)
}
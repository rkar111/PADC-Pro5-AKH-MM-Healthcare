package xyz.arkarhein.padc_pro5_akh_mm_healthcare.network.responses

import com.google.gson.annotations.SerializedName
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos.HealthcareVO

class GetHealthcareResponse {

    @SerializedName("code")
    var code: Long = 0

    @SerializedName("message")
    var message: String? = null

    @SerializedName("healthcare-info")
    private var healthcareInfo: List<HealthcareVO>? = null

    fun getHealthcareInfo(): List<HealthcareVO> {
        if (healthcareInfo == null) {
            healthcareInfo = ArrayList()
        }
        val healthcareInfoVal = healthcareInfo
        return healthcareInfoVal!!
    }
}
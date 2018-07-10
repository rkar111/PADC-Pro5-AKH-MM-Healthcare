package xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos

import com.google.gson.annotations.SerializedName

class HealthcareVO {

    @SerializedName("id")
    var id: Long = 0

    @SerializedName("title")
    var title: String? = ""

    @SerializedName("image")
    var image: String? = ""

    @SerializedName("author")
    var author: AuthorVO? = null

    @SerializedName("short-description")
    var shortDescription: String? = ""

    @SerializedName("published-date")
    var publishedDate: String? = ""

    @SerializedName("complete-url")
    var completeUrl: String? = ""

}
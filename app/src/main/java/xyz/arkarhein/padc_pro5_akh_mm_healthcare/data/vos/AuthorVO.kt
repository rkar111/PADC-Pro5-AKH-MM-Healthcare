package xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos

import com.google.gson.annotations.SerializedName

class AuthorVO {

    @SerializedName("author-id")
    var authorId: Long = 0

    @SerializedName("author-name")
    var authorName: String? = ""

    @SerializedName("author-picture")
    var authorPicture: String? = ""
}
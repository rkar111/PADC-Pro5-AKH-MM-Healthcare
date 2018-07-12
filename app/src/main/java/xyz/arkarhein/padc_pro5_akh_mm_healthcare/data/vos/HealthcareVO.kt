package xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Healthcare")
open class HealthcareVO {

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Long = 0

    @SerializedName("title")
    @ColumnInfo(name = "title")
    var title: String? = ""

    @SerializedName("image")
    @ColumnInfo(name = "image")
    var image: String? = ""

    @SerializedName("author")
    @Embedded
    var author: AuthorVO? = null

    @SerializedName("short-description")
    @ColumnInfo(name = "short-description")
    var shortDescription: String? = ""

    @SerializedName("published-date")
    @ColumnInfo(name = "published-date")
    var publishedDate: String? = ""

    @SerializedName("complete-url")
    @ColumnInfo(name = "complete-url")
    var completeUrl: String? = ""

    @SerializedName("info-type")
    @ColumnInfo(name = "info-type")
    var infoType: String? = ""

}
package xyz.arkarhein.padc_pro5_akh_mm_healthcare.network

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.network.responses.GetHealthcareResponse

interface HealthcareApi {

    @FormUrlEncoded
    @POST("GetHealthcareInfo.php")
    fun loadHealthcareInfo(@Field("access_token") accessToken: String): Observable<GetHealthcareResponse>
}
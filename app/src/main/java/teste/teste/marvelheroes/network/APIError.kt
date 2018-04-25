package teste.teste.marvelheroes.network

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

internal class APIError(errorMessage: String) {

    @SerializedName("message")
    private val errorDetail: MutableList<APIErrorDetail>

    fun getErrorDetail(): APIErrorDetail {
        return errorDetail[0]
    }

    init {
        errorDetail = ArrayList()
        errorDetail.add(APIErrorDetail(errorMessage))
        errorDetail[0]
    }

    inner class APIErrorDetail(@field:SerializedName("message")
                               var message: String?) {

        @SerializedName("code")
        var code: String? = null
    }

}
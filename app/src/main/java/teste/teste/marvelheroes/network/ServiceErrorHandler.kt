package teste.teste.marvelheroes.network

import android.content.Context
import android.text.TextUtils
import retrofit2.Response
import retrofit2.Retrofit
import teste.teste.marvelheroes.R

open class ServiceErrorHandler(protected val retrofit: Retrofit, protected val context: Context) {

    internal fun parseError(response: Response<*>): APIError {
        val converter = retrofit.responseBodyConverter<APIError>(APIError::class.java, APIError::class.java.annotations)

        val error: APIError

        try {
            error = converter.convert(response.errorBody())
            if (TextUtils.isEmpty(error.getErrorDetail().message)) {
                return APIError(context.getString(R.string.error_default))
            }
        } catch (e: Exception) {
            return APIError(context.getString(R.string.error_default))
        }

        return error
    }

}
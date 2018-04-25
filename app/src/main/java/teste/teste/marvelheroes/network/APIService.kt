package teste.teste.marvelheroes.network

import retrofit2.Call
import retrofit2.Retrofit
import teste.teste.marvelheroes.model.GetHeroesResponseModel
import android.content.Context

class APIService(retrofit: Retrofit, context: Context) : ServiceErrorHandler(retrofit, context) {

    fun getHeroes(limit: String, offSet:String): Call<GetHeroesResponseModel> {
        return retrofit.create(APIServiceConsumerInterface::class.java).getHeroes(limit, offSet)
    }
}
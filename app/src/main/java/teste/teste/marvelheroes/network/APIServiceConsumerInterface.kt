package teste.teste.marvelheroes.network

import retrofit2.Call
import retrofit2.http.*
import teste.teste.marvelheroes.model.GetHeroesResponseModel

interface APIServiceConsumerInterface {

    @GET("/v1/public/characters")
    fun getHeroes(@Query("limit") limit: String, @Query("offset") offset: String): Call<GetHeroesResponseModel>

}
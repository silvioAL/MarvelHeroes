package teste.teste.marvelheroes.model

import com.google.gson.annotations.SerializedName

class GetHeroesResponseModel(@field:SerializedName("data") val data: HeroesResultsModel)
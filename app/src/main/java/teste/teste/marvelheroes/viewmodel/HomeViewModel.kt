package teste.teste.marvelheroes.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import teste.teste.marvelheroes.contract.AppContract
import teste.teste.marvelheroes.interactions.GenericNotification
import teste.teste.marvelheroes.interactions.HomeInteraction
import teste.teste.marvelheroes.model.GetHeroesResponseModel
import teste.teste.marvelheroes.model.Heroes
import teste.teste.marvelheroes.network.APIService
import teste.teste.marvelheroes.utils.StringUtils
import kotlin.math.sign

class HomeViewModel(apiService: APIService) : ViewModel() {

    val service = apiService
    lateinit var notifications: GenericNotification
    lateinit var homeInteraction: HomeInteraction
    var overRange = 0
    var maxRange = 50
    var listOfHeroes = MutableLiveData<List<Heroes>>()


    fun setupNotificationHandler(notificationHandler: GenericNotification) {
        notifications = notificationHandler
    }

    fun setupHomeInteraction(homeInteractions: HomeInteraction) {
        homeInteraction = homeInteractions
    }

    fun incrementRange(){
        overRange += 50
    }

    open fun fetchNext50() {

        homeInteraction.setupBar(true)

        service.getHeroes(maxRange.toString(), overRange.toString()).enqueue(object : Callback<GetHeroesResponseModel> {
            override fun onFailure(call: Call<GetHeroesResponseModel>?, t: Throwable?) {

                notifications.openAlertDialog(t?.message.toString())
                homeInteraction.setupBar(false)

            }

            override fun onResponse(call: Call<GetHeroesResponseModel>?, response: Response<GetHeroesResponseModel>?) {

                listOfHeroes.value = response?.body()?.data?.results
                val size = listOfHeroes.value?.size
                listOfHeroes.value!![size!!-1].isLast = true
                homeInteraction.refreshList(listOfHeroes.value!!)
                incrementRange()
                homeInteraction.setupBar(false)

            }
        })
    }

}
package teste.teste.marvelheroes.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Intent
import teste.teste.marvelheroes.contract.AppContract
import teste.teste.marvelheroes.interactions.DetailsInteraction
import teste.teste.marvelheroes.model.Heroes


class DetailsActivityViewModel : ViewModel() {

    var heroName = MutableLiveData<String>()
    var imgUrl = MutableLiveData<String>()
    private lateinit var interaction: DetailsInteraction

    fun setupInteraction(detailsInteraction: DetailsInteraction) {
        interaction = detailsInteraction
    }

    fun setupFields(heroData: Intent) {
        val hero = heroData.extras.getParcelable<Heroes>(AppContract().HERO)
        heroName.value = hero.name
        imgUrl.value = hero.thumbnail.path + "/landscape_amazing." + hero.thumbnail.extension
        val listSize = hero.comics.items.size
        if (listSize > 0) {
            interaction.fetchList(hero.comics.items)
        } else {
            interaction.notifyHasntComics()
        }

    }
}
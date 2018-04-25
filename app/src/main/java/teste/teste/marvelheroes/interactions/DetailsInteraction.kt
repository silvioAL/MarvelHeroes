package teste.teste.marvelheroes.interactions

import teste.teste.marvelheroes.model.Items

interface DetailsInteraction{
    fun fetchList(comics:List<Items> )
    fun notifyHasntComics()
}
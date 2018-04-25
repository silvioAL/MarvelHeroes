package teste.teste.marvelheroes.interactions

import teste.teste.marvelheroes.model.Heroes

interface HomeInteraction {
    fun setupList()
    fun refreshList(heroes: List<Heroes>)
    fun setupBar(turn: Boolean)
}
package teste.teste.marvelheroes.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import teste.teste.marvelheroes.model.Heroes
import teste.teste.marvelheroes.viewholder.HomeCardViewHolder
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import teste.teste.marvelheroes.R


class HomeListAdapter(var listOfHeroes: ArrayList<Heroes>, var context: Context): RecyclerView.Adapter<HomeCardViewHolder>() {

    fun refreshList(moreHoroes:List<Heroes>){
        listOfHeroes.addAll(moreHoroes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardViewHolder {
        return HomeCardViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_card, parent, false))
    }
    override fun getItemCount(): Int {
      return  listOfHeroes.size
    }

    override fun onBindViewHolder(holder: HomeCardViewHolder, position: Int) {
       holder.bind(listOfHeroes[position])
    }

}
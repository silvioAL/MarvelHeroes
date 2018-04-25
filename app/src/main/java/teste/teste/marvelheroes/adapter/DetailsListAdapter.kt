package teste.teste.marvelheroes.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import teste.teste.marvelheroes.R
import teste.teste.marvelheroes.model.Items
import teste.teste.marvelheroes.viewholder.DetailsViewHolder

class DetailsListAdapter(comics:List<Items>, mcontext: Context): RecyclerView.Adapter<DetailsViewHolder>() {

    private val context = mcontext
    private var comicsList = comics

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        return DetailsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_details_card, parent, false))
    }

    override fun getItemCount(): Int {
       return comicsList.size
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
       holder.bind(comicsList[position])
    }
}
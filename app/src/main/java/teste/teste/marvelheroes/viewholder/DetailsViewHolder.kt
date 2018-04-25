package teste.teste.marvelheroes.viewholder

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View
import teste.teste.marvelheroes.BR
import teste.teste.marvelheroes.model.Items

class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding: ViewDataBinding = DataBindingUtil.bind(itemView)!!


    fun bind(hero: Items) {
        binding.setVariable(BR.comic, hero)
        binding.executePendingBindings()

    }

}
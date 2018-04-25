package teste.teste.marvelheroes.viewholder

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View
import org.jetbrains.anko.intentFor
import teste.teste.marvelheroes.BR
import teste.teste.marvelheroes.contract.AppContract
import teste.teste.marvelheroes.model.Heroes
import teste.teste.marvelheroes.view.DetailsActivity

class HomeCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var binding: ViewDataBinding = DataBindingUtil.bind(itemView)!!
    var url = ""
    var name = ""
    lateinit var passBy: Heroes

    fun bind(heroCard: Heroes) {

        url = heroCard.thumbnail.path + "/portrait_fantastic." + heroCard.thumbnail.extension
        name = heroCard.name
        binding.setVariable(BR.holder, this)
        binding.executePendingBindings()
        passBy = heroCard
    }

    fun moveToDetails(){
        itemView.context.startActivity(
                itemView.context.intentFor<DetailsActivity>()
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .putExtra(AppContract().HERO, passBy)
        )
    }
}
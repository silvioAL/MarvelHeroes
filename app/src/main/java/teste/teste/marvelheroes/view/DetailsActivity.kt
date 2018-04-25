package teste.teste.marvelheroes.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_details.*
import org.koin.android.architecture.ext.getViewModel
import teste.teste.marvelheroes.R
import teste.teste.marvelheroes.adapter.DetailsListAdapter
import teste.teste.marvelheroes.databinding.ActivityDetailsBinding
import teste.teste.marvelheroes.interactions.DetailsInteraction
import teste.teste.marvelheroes.model.Items
import teste.teste.marvelheroes.viewmodel.DetailsActivityViewModel

class DetailsActivity : GenericActivity(), DetailsInteraction {

    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.detailsVM = getViewModel()
        binding.detailsVM?.setupInteraction(this)
        binding.detailsVM?.setupFields(intent)
        ViewModelProviders.of(this).get(DetailsActivityViewModel::class.java)

    }

    override fun fetchList(comics: List<Items>) {
        binding.rvComics.layoutManager = LinearLayoutManager(baseContext)
        binding.rvComics.adapter = DetailsListAdapter(comics, baseContext)
    }

    override fun notifyHasntComics() {
        header_comics.text = getString(R.string.HAVE_NOT_COMICS)
    }
}

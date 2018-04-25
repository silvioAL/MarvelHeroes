package teste.teste.marvelheroes.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import org.koin.android.architecture.ext.getViewModel
import teste.teste.marvelheroes.R
import teste.teste.marvelheroes.adapter.HomeListAdapter
import teste.teste.marvelheroes.databinding.ActivityHomeBinding
import teste.teste.marvelheroes.interactions.HomeInteraction
import teste.teste.marvelheroes.model.Heroes
import teste.teste.marvelheroes.utils.EndlessScrollListener

class HomeActivity : GenericActivity(), HomeInteraction {

    lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: HomeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.homeVM = getViewModel()
        binding.homeVM?.setupNotificationHandler(this)
        binding.homeVM?.setupHomeInteraction(this)
        binding.homeVM?.fetchNext50()
        val empty = arrayListOf<Heroes>()
        adapter = HomeListAdapter(empty, baseContext)
        setupList()
        binding.homeVM?.fetchNext50()
    }

    override fun setupList() {

        binding.rvHeroes.adapter = adapter
        val layoutManager = StaggeredGridLayoutManager(2, 1)

        binding.rvHeroes.layoutManager = layoutManager
        binding.rvHeroes.setHasFixedSize(true)
        binding.rvHeroes.addOnScrollListener(object : EndlessScrollListener(layoutManager) {
            override fun onLoadMore(current_page: Int) {
                binding.homeVM?.fetchNext50()
            }
        })
    }

    override fun setupBar(turn: Boolean) {
        if (turn) {
            binding.progress.visibility = View.VISIBLE
        } else {
            binding.progress.visibility = View.GONE
        }
    }

    override fun refreshList(heroes: List<Heroes>) {
        adapter.refreshList(heroes)
    }
}

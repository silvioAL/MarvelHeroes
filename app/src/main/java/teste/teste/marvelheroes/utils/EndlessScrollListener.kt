package teste.teste.marvelheroes.utils

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager

abstract class EndlessScrollListener(private val mStaggeredGridLayoutManager: StaggeredGridLayoutManager) : RecyclerView.OnScrollListener() {
    private var scrolledDistance = 0
    private var controlsVisible = false

    private var loading = true // True if we are still waiting for the last set of data to load.
    private val visibleThreshold = 5 // The minimum amount of items to have below your current scroll position before loading more.

    private var pastVisibleItems: Int = 0
    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0

    private var current_page = 1
    private var previousTotal: Int = 0

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        visibleItemCount = recyclerView!!.childCount
        totalItemCount = mStaggeredGridLayoutManager.itemCount
        var firstVisibleItems: IntArray? = null
        firstVisibleItems = mStaggeredGridLayoutManager.findFirstVisibleItemPositions(firstVisibleItems)
        if (firstVisibleItems != null && firstVisibleItems.size > 0) {
            pastVisibleItems = firstVisibleItems[0]
        }


        if (loading) {
            if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                loading = false
                previousTotal = totalItemCount
            }
        }
        if (!loading && totalItemCount - visibleItemCount <= pastVisibleItems + visibleThreshold) {
            // End has been reached

            // Do something
            current_page++

            onLoadMore(current_page)

            loading = true
        }

        if (scrolledDistance > 1 && controlsVisible) {
            controlsVisible = false
            scrolledDistance = 0
        } else if (scrolledDistance < -1 && !controlsVisible) {
            controlsVisible = true
            scrolledDistance = 0
        }

        if (controlsVisible && dy > 0 || !controlsVisible && dy < 0) {
            scrolledDistance += dy
        }
    }

    abstract fun onLoadMore(current_page: Int)

    companion object {
        var TAG = EndlessScrollListener::class.java.simpleName
    }

}

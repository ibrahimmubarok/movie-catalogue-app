package com.ibeybeh.submission.moviecatalogue.presentation.favorite.tvshows

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.snackbar.Snackbar
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.presentation.detail.DetailActivity
import com.ibeybeh.submission.moviecatalogue.presentation.favorite.FavoriteViewModel
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.TvShowAdapter
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.TvShowAdapter.TvShowCallback
import com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows.TvShowsFragment
import com.ibeybeh.submission.moviecatalogue.utils.ext.setVisibility
import com.ibeybeh.submission.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite_tv_show.rvFavTvShows
import kotlinx.android.synthetic.main.layout_empty.emptyLayout

class FavoriteTvShowFragment : Fragment(), TvShowCallback {

    private lateinit var favTvShowViewModel: FavoriteViewModel

    private val tvShowAdapter: TvShowAdapter by lazy {
        TvShowAdapter(
            callback = this
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(rvFavTvShows)

        if (context != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            favTvShowViewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            favTvShowViewModel.getAllTvShowsFavorite().observe(this, { tvShows ->
                if (tvShows != null) {
                    if (!tvShows.isEmpty()) {
                        emptyStatePage(false)
                        tvShowAdapter.submitList(tvShows)
                    }else{
                        emptyStatePage(true)
                        tvShowAdapter.submitList(tvShows)
                    }
                }
            })
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvFavTvShows.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: ViewHolder): Int {
            return makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        }

        override fun onMove(recyclerView: RecyclerView, viewHolder: ViewHolder, target: ViewHolder): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvShowEntity = tvShowAdapter.getSwipedData(swipedPosition)
                tvShowEntity?.let {
                    favTvShowViewModel.setTvShowFavorite(it)
                }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(resources.getString(R.string.label_ok)) { view ->
                    tvShowEntity?.let {
                        favTvShowViewModel.setTvShowFavorite(it)
                    }
                }
                snackbar.show()
            }
        }
    })

    private fun emptyStatePage(boolean: Boolean) {
        if (boolean) {
            emptyLayout.setVisibility(true)
            rvFavTvShows.setVisibility(false)
        }else{
            emptyLayout.setVisibility(false)
            rvFavTvShows.setVisibility(true)
        }
    }

    override fun onTvShowClicked(data: TvShowEntity) {
        data.id.let { id ->
            DetailActivity.start(requireContext(), id, TvShowsFragment::class.java.simpleName)
        }
    }
}
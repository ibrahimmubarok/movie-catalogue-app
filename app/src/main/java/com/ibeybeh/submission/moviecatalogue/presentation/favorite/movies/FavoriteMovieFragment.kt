package com.ibeybeh.submission.moviecatalogue.presentation.favorite.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.Callback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.snackbar.Snackbar
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.R.string
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.presentation.detail.DetailActivity
import com.ibeybeh.submission.moviecatalogue.presentation.favorite.FavoriteViewModel
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter.MoviesCallback
import com.ibeybeh.submission.moviecatalogue.presentation.main.movies.MoviesFragment
import com.ibeybeh.submission.moviecatalogue.utils.ext.setVisibility
import com.ibeybeh.submission.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite_movie.pbFavMovies
import kotlinx.android.synthetic.main.fragment_favorite_movie.rvFavMovies
import kotlinx.android.synthetic.main.layout_empty.emptyLayout

class FavoriteMovieFragment : Fragment(), MoviesCallback {

    private lateinit var favMoviesViewModel: FavoriteViewModel

    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter(
            callback = this
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(rvFavMovies)

        if (context != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            favMoviesViewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            pbFavMovies.setVisibility(true)
            favMoviesViewModel.getAllMoviesFavorite().observe(this, { movies ->
                if (movies != null) {
                    pbFavMovies.setVisibility(false)
                    emptyLayout.setVisibility(false)
                    moviesAdapter.submitList(movies)
                }else{
                    pbFavMovies.setVisibility(false)
                    emptyLayout.setVisibility(true)
                }
            })
        }

        initRecyclerView()
    }

    private val itemTouchHelper = ItemTouchHelper(object : Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: ViewHolder): Int {
            return makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        }

        override fun onMove(recyclerView: RecyclerView, viewHolder: ViewHolder, target: ViewHolder): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val moviesEntity = moviesAdapter.getSwipedData(swipedPosition)
                moviesEntity?.let {
                    favMoviesViewModel.setMovieFavorite(it)
                }

                val snackbar = Snackbar.make(view as View, string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(resources.getString(string.label_ok)) { view ->
                    moviesEntity?.let {
                        favMoviesViewModel.setMovieFavorite(it)
                    }
                }
                snackbar.show()
            }
        }
    })

    private fun initRecyclerView() {
        rvFavMovies.apply {
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onMoviesClicked(data: MoviesEntity) {
        data.id.let { id ->
            DetailActivity.start(requireContext(), id, MoviesFragment::class.java.simpleName)
        }
    }
}
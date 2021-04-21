package com.ibeybeh.submission.moviecatalogue.presentation.main.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.MoviesData
import com.ibeybeh.submission.moviecatalogue.presentation.detail.DetailActivity
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter.MoviesCallback
import com.ibeybeh.submission.moviecatalogue.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_movies.rvMovies

class MoviesFragment : Fragment(), MoviesCallback {

    private lateinit var mMoviesViewModel: MoviesViewModel

    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter(
            mutableListOf(),
            callback = this
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mMoviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        val dataMovies = mMoviesViewModel.getDataDummyListMovies() as MutableList<MoviesData>
        moviesAdapter.setData(dataMovies)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvMovies.apply {
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onMoviesClicked(data: MoviesData) {
        data.id?.let { id ->
            DetailActivity.start(requireContext(), id, MoviesFragment::class.java.simpleName)
        }
    }
}
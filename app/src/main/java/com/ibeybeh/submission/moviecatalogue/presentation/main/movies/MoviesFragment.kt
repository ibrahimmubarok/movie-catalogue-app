package com.ibeybeh.submission.moviecatalogue.presentation.main.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.source.local.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.presentation.detail.DetailActivity
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter.MoviesCallback
import com.ibeybeh.submission.moviecatalogue.utils.ext.setVisibility
import com.ibeybeh.submission.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movies.pbMovies
import kotlinx.android.synthetic.main.fragment_movies.rvMovies

class MoviesFragment : Fragment(), MoviesCallback {

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
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireContext())
        val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]
        viewModel.getAllMovies().observe(viewLifecycleOwner, { movies ->
            pbMovies.setVisibility(false)
            moviesAdapter.setData(movies as MutableList<MoviesEntity>)
        })

        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvMovies.apply {
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
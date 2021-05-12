package com.ibeybeh.submission.moviecatalogue.presentation.main.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.presentation.detail.DetailActivity
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter.MoviesCallback
import com.ibeybeh.submission.moviecatalogue.utils.ext.setVisibility
import com.ibeybeh.submission.moviecatalogue.viewmodel.ViewModelFactory
import com.ibeybeh.submission.moviecatalogue.vo.Status
import kotlinx.android.synthetic.main.fragment_movies.pbMovies
import kotlinx.android.synthetic.main.fragment_movies.rvMovies

class MoviesFragment : Fragment(), MoviesCallback {

    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter(
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
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> pbMovies.setVisibility(true)
                    Status.SUCCESS -> {
                        pbMovies.setVisibility(false)
                        moviesAdapter.submitList(movies.data)
                    }
                    Status.ERROR -> {
                        pbMovies.setVisibility(false)
                        Toast.makeText(context, resources.getString(R.string.label_error), Toast.LENGTH_SHORT).show()
                    }
                }
            }
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
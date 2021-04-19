package com.ibeybeh.submission.moviecatalogue.presentation.main.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.MoviesData
import com.ibeybeh.submission.moviecatalogue.presentation.detail.DetailActivity
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter.MoviesCallback
import com.ibeybeh.submission.moviecatalogue.utils.Const.SECTION_PAGER
import kotlinx.android.synthetic.main.fragment_movies.rvMovies

class MoviesFragment : Fragment(), MoviesCallback {

    companion object {

        fun newInstance(index: Int): MoviesFragment {
            val fragment = MoviesFragment()
            val bundle = Bundle()
            bundle.putInt(SECTION_PAGER, index)
            fragment.arguments = bundle
            return fragment
        }
    }

    private val moviesAdapter: MoviesAdapter by lazy {
        MoviesAdapter(
            getDataDummy(6),
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

        var index = 1

        if (arguments != null) {
            index = arguments?.getInt(SECTION_PAGER, 0) as Int
        }

        initRecyclerView()
    }

    private fun getDataDummy(size: Int): MutableList<MoviesData> {
        val data: MutableList<MoviesData> = mutableListOf()
        repeat((0..size).count()) {
            data.add(MoviesData(
                title = "Resident Evil 4",
                releaseDate = "24 Januari 2020",
                runtime = "128",
                rating = 8.5,
                photo = "https://image.tmdb.org/t/p/original//7d6EY00g1c39SGZOoCJ5Py9nNth.jpg",
                overview = "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \\\"Kingpin\\\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."
            ))
        }
        return data
    }

    private fun initRecyclerView() {
        rvMovies.apply {
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onMoviesClicked(data: MoviesData, position: Int) {
        DetailActivity.start(requireContext(), data, position)
    }
}
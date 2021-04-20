package com.ibeybeh.submission.moviecatalogue.presentation.main.movies

import android.os.Bundle
import android.util.Log
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
import com.ibeybeh.submission.moviecatalogue.utils.Const.SECTION_PAGER
import com.ibeybeh.submission.moviecatalogue.utils.DataDummy
import com.ibeybeh.submission.moviecatalogue.viewmodel.MainViewModel
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

    private lateinit var mainViewModel: MainViewModel

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

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        var index = 1

        if (arguments != null) {
            index = arguments?.getInt(SECTION_PAGER, 0) as Int
            val dataMovies = mainViewModel.getDataDummyListMovies(DataDummy.generateDummyMovies()) as MutableList<MoviesData>
            moviesAdapter.setData(dataMovies)
            Log.d("JUMLAH DATA", dataMovies.size.toString())
        }

        initRecyclerView()
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
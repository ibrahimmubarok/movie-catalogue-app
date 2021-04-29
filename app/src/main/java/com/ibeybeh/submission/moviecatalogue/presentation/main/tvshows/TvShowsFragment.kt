package com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.presentation.detail.DetailActivity
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.TvShowAdapter
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.TvShowAdapter.TvShowCallback
import com.ibeybeh.submission.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_shows.rvTvShows

class TvShowsFragment : Fragment(), TvShowCallback {

    private val tvShowAdapter: TvShowAdapter by lazy {
        TvShowAdapter(
            mutableListOf(),
            callback = this
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_shows, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireContext())
        val viewModel = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]
        val tvShows = viewModel.getAllTvShows() as MutableList<TvShowEntity>

        tvShowAdapter.setData(tvShows)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvTvShows.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onTvShowClicked(data: TvShowEntity) {
        data.id?.let { id ->
            DetailActivity.start(requireContext(), id, TvShowsFragment::class.java.simpleName)
        }
    }
}
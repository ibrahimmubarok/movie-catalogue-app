package com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.source.domain.TvShow
import com.ibeybeh.submission.moviecatalogue.presentation.detail.DetailActivity
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.TvShowAdapter
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.TvShowAdapter.TvShowCallback
import com.ibeybeh.submission.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_shows.pbTvShow
import kotlinx.android.synthetic.main.fragment_tv_shows.rvTvShows

class TvShowsFragment : Fragment(), TvShowCallback{

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

        viewModel.getAllTvShows("224f6797a2665e28bce03b9e0655510a", "en-US").observe(viewLifecycleOwner, {
            pbTvShow.visibility = View.GONE
            tvShowAdapter.setData(it as MutableList<TvShow>)
        })

        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvTvShows.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onTvShowClicked(data: TvShow) {
        data.id?.let { id ->
            DetailActivity.start(requireContext(), id, TvShowsFragment::class.java.simpleName)
        }
    }
}
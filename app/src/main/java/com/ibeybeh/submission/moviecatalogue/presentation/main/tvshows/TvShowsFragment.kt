package com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.presentation.detail.DetailActivity
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.TvShowAdapter
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.TvShowAdapter.TvShowCallback
import com.ibeybeh.submission.moviecatalogue.utils.ext.setViewVisibility
import com.ibeybeh.submission.moviecatalogue.viewmodel.ViewModelFactory
import com.ibeybeh.submission.moviecatalogue.vo.Status
import kotlinx.android.synthetic.main.fragment_tv_shows.pbTvShow
import kotlinx.android.synthetic.main.fragment_tv_shows.rvTvShows

class TvShowsFragment : Fragment(), TvShowCallback {

    private val tvShowAdapter: TvShowAdapter by lazy {
        TvShowAdapter(
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
        viewModel.getAllTvShows().observe(viewLifecycleOwner, { tvShows ->
            if (tvShows != null) {
                when (tvShows.status) {
                    Status.LOADING -> pbTvShow.setViewVisibility(true)
                    Status.SUCCESS -> {
                        pbTvShow.setViewVisibility(false)
                        tvShowAdapter.submitList(tvShows.data)
                    }
                    Status.ERROR -> {
                        pbTvShow.setViewVisibility(false)
                        Toast.makeText(context, resources.getString(R.string.label_error), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvTvShows.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onTvShowClicked(data: TvShowEntity) {
        data.id.let { id ->
            DetailActivity.start(requireContext(), id, TvShowsFragment::class.java.simpleName)
        }
    }
}
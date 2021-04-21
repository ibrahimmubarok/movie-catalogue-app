package com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.TvShowData
import com.ibeybeh.submission.moviecatalogue.presentation.detail.DetailActivity
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.TvShowAdapter
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.TvShowAdapter.TvShowCallback
import com.ibeybeh.submission.moviecatalogue.viewmodel.TvShowViewModel
import kotlinx.android.synthetic.main.fragment_tv_shows.rvTvShows

class TvShowsFragment : Fragment(), TvShowCallback {

    private lateinit var tvShowViewModel: TvShowViewModel

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_shows, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvShowViewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)

        val dataTvShow = tvShowViewModel.getDataDummyListTvShows() as MutableList<TvShowData>
        tvShowAdapter.setData(dataTvShow)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvTvShows.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onTvShowClicked(data: TvShowData) {
        data.id?.let { id ->
            DetailActivity.start(requireContext(), id, TvShowsFragment::class.java.simpleName)
        }
    }
}
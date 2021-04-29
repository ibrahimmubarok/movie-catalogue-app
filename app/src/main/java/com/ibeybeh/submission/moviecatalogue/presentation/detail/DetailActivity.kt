package com.ibeybeh.submission.moviecatalogue.presentation.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.source.local.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.presentation.main.movies.MoviesFragment
import com.ibeybeh.submission.moviecatalogue.utils.Const.EXTRA_ID
import com.ibeybeh.submission.moviecatalogue.utils.Const.EXTRA_CLASS_NAME
import com.ibeybeh.submission.moviecatalogue.utils.setImageUrl
import com.ibeybeh.submission.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.imgBackdropDetail
import kotlinx.android.synthetic.main.activity_detail.pbBanner
import kotlinx.android.synthetic.main.activity_detail.ratingBarDetail
import kotlinx.android.synthetic.main.activity_detail.tvDetailDesc
import kotlinx.android.synthetic.main.activity_detail.tvDetailEpisodes
import kotlinx.android.synthetic.main.activity_detail.tvDetailGenre
import kotlinx.android.synthetic.main.activity_detail.tvDetailRating
import kotlinx.android.synthetic.main.activity_detail.tvDetailSeason
import kotlinx.android.synthetic.main.activity_detail.tvDetailTitle
import kotlinx.android.synthetic.main.activity_detail.tvDetailUrl
import kotlinx.android.synthetic.main.layout_toolbar.toolbar

class DetailActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context, id: Int, name: String) {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
                putExtra(EXTRA_CLASS_NAME, name)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val factory = ViewModelFactory.getInstance(this)
        val mDetailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = intent.getIntExtra(EXTRA_ID, 0)
            val className = intent.getStringExtra(EXTRA_CLASS_NAME)
            if (className != null) {
                if (className == MoviesFragment::class.java.simpleName) {
                    mDetailViewModel.setSelectedMovieId(id)
                    initViewMovies(mDetailViewModel.getDetailMovies())
                }else{
                    mDetailViewModel.setSelectedTvShowId(id)
                    initViewTvShows(mDetailViewModel.getDetailTvShows())
                }
            }
        }

        setSupportActionBar(toolbar)
        supportActionBar?.title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun initViewMovies(data: MoviesEntity) {
        tvDetailTitle.text = data.title
        tvDetailDesc.text = data.overview
        tvDetailRating.text = data.rating.toString()
        tvDetailGenre.text = data.genre

        val detailUrl = "${resources.getString(R.string.text_visit)} ${Html.fromHtml(data.homepage)}"
        tvDetailUrl.text = detailUrl

        val rating = data.rating?.div(2)
        ratingBarDetail.rating = rating?.toFloat() ?: 0F

        tvDetailEpisodes.visibility = View.GONE
        tvDetailSeason.visibility = View.GONE

        imgBackdropDetail.setImageUrl(this, data.backdropPath.toString(), pbBanner)
    }

    private fun initViewTvShows(data: TvShowEntity) {
        tvDetailTitle.text = data.name
        tvDetailDesc.text = data.overview
        tvDetailRating.text = data.rating.toString()
        tvDetailGenre.text = data.genre

        val detailUrl = "${resources.getString(R.string.text_visit)} ${Html.fromHtml(data.homepage)}"
        tvDetailUrl.text = detailUrl

        val detailSeason = "${resources.getString(R.string.text_season)} ${data.seasons}"
        tvDetailSeason.text = detailSeason

        val detailEpisode = "${resources.getString(R.string.text_episode)} ${data.episodes}"
        tvDetailEpisodes.text = detailEpisode

        val rating = data.rating?.div(2)
        ratingBarDetail.rating = rating?.toFloat() ?: 0F

        imgBackdropDetail.setImageUrl(this, data.backdropPath.toString(), pbBanner)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return true
    }
}
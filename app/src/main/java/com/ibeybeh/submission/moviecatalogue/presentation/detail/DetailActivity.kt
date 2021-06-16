package com.ibeybeh.submission.moviecatalogue.presentation.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.presentation.main.movies.MoviesFragment
import com.ibeybeh.submission.moviecatalogue.utils.Const.EXTRA_ID
import com.ibeybeh.submission.moviecatalogue.utils.Const.EXTRA_CLASS_NAME
import com.ibeybeh.submission.moviecatalogue.utils.ext.setViewImageUrl
import com.ibeybeh.submission.moviecatalogue.utils.ext.setViewVisibility
import com.ibeybeh.submission.moviecatalogue.viewmodel.ViewModelFactory
import com.ibeybeh.submission.moviecatalogue.vo.Status
import kotlinx.android.synthetic.main.activity_detail.btnFavorite
import kotlinx.android.synthetic.main.activity_detail.imgBackdropDetail
import kotlinx.android.synthetic.main.activity_detail.layoutDetail
import kotlinx.android.synthetic.main.activity_detail.pbBanner
import kotlinx.android.synthetic.main.activity_detail.ratingBarDetail
import kotlinx.android.synthetic.main.activity_detail.tvDetailDesc
import kotlinx.android.synthetic.main.activity_detail.tvDetailEpisodes
import kotlinx.android.synthetic.main.activity_detail.tvDetailGenre
import kotlinx.android.synthetic.main.activity_detail.tvDetailRating
import kotlinx.android.synthetic.main.activity_detail.tvDetailSeason
import kotlinx.android.synthetic.main.activity_detail.tvDetailTitle
import kotlinx.android.synthetic.main.activity_detail.tvDetailUrl
import kotlinx.android.synthetic.main.layout_empty.emptyLayout
import kotlinx.android.synthetic.main.layout_empty.tvDescEmpty
import kotlinx.android.synthetic.main.layout_empty.tvTitleEmpty
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

    private lateinit var movie: MoviesEntity
    private lateinit var tvShow: TvShowEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val factory = ViewModelFactory.getInstance(this)
        val mDetailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        setSupportActionBar(toolbar)
        supportActionBar?.title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        if (extras != null) {
            val id = intent.getIntExtra(EXTRA_ID, 0)
            val className = intent.getStringExtra(EXTRA_CLASS_NAME)
            if (className != null) {
                if (className == MoviesFragment::class.java.simpleName) {
                    mDetailViewModel.setSelectedMovieId(id)
                    mDetailViewModel.getDetailMovies().observe(this, { movies ->
                        if (movies != null) {
                            when(movies.status) {
                                Status.LOADING -> {
                                    pbBanner.setViewVisibility(true)
                                    btnFavorite.setViewVisibility(false)
                                }
                                Status.SUCCESS -> {
                                    if (movies.data != null) {
                                        pbBanner.setViewVisibility(false)
                                        btnFavorite.setViewVisibility(true)

                                        movie = movies.data

                                        setFavoriteState(movie.isFavorite)

                                        initViewMovies(movies.data)
                                    }else{
                                        layoutDetail.setViewVisibility(false)
                                        emptyLayout.setViewVisibility(true)

                                        tvTitleEmpty.text = resources.getString(R.string.label_data_kosong)
                                        tvDescEmpty.text = resources.getString(R.string.label_desc_data_kosong)
                                    }
                                }
                                Status.ERROR -> {
                                    pbBanner.setViewVisibility(false)
                                    layoutDetail.setViewVisibility(false)
                                    emptyLayout.setViewVisibility(true)

                                    tvTitleEmpty.text = resources.getString(R.string.label_error)
                                    tvDescEmpty.text = resources.getString(R.string.label_desc_error)
                                }
                            }
                        }
                    })
                }else{
                    mDetailViewModel.setSelectedTvShowId(id)
                    mDetailViewModel.getDetailTvShows().observe(this, { tvShows ->
                        if (tvShows != null) {
                            when(tvShows.status) {
                                Status.LOADING -> {
                                    pbBanner.setViewVisibility(true)
                                    btnFavorite.setViewVisibility(false)
                                }
                                Status.SUCCESS -> {
                                    if (tvShows.data != null) {
                                        pbBanner.setViewVisibility(false)
                                        btnFavorite.setViewVisibility(true)

                                        tvShow = tvShows.data

                                        setFavoriteState(tvShow.isFavorite)

                                        initViewTvShows(tvShows.data)
                                    }else{
                                        layoutDetail.setViewVisibility(false)
                                        emptyLayout.setViewVisibility(true)

                                        tvTitleEmpty.text = resources.getString(R.string.label_data_kosong)
                                        tvDescEmpty.text = resources.getString(R.string.label_desc_data_kosong)
                                    }
                                }
                                Status.ERROR -> {
                                    pbBanner.setViewVisibility(false)
                                    layoutDetail.setViewVisibility(false)
                                    emptyLayout.setViewVisibility(true)

                                    tvTitleEmpty.text = resources.getString(R.string.label_error)
                                    tvDescEmpty.text = resources.getString(R.string.label_desc_error)
                                }
                            }
                        }
                    })
                }
            }

            btnFavorite.setOnClickListener {
                if (className == MoviesFragment::class.java.simpleName) {
                    val state = movie.isFavorite
                    setFavoriteState(state)
                    setShowSnackbar(state)
                    mDetailViewModel.setMovieFavorite(movie)
                }else{
                    val state = tvShow.isFavorite
                    setFavoriteState(state)
                    setShowSnackbar(state)
                    mDetailViewModel.setTvShowFavorite(tvShow)
                }
            }
        }
    }

    private fun initViewMovies(data: MoviesEntity) {
        tvDetailTitle.text = data.title
        tvDetailDesc.text = data.overview
        tvDetailRating.text = data.voteAverage.toString()
        tvDetailGenre.text = data.genre

        val detailUrl = "${resources.getString(R.string.text_visit)} ${Html.fromHtml(data.homepage)}"
        tvDetailUrl.text = detailUrl

        val rating = data.voteAverage?.div(2)
        ratingBarDetail.rating = rating?.toFloat() ?: 0F

        tvDetailEpisodes.visibility = View.GONE
        tvDetailSeason.visibility = View.GONE

        imgBackdropDetail.setViewImageUrl(this, data.backdropPath.toString(), pbBanner)
    }

    private fun initViewTvShows(data: TvShowEntity) {
        tvDetailTitle.text = data.name
        tvDetailDesc.text = data.overview
        tvDetailRating.text = data.voteAverage.toString()
        tvDetailGenre.text = data.genre

        val detailUrl = "${resources.getString(R.string.text_visit)} ${Html.fromHtml(data.homepage)}"
        tvDetailUrl.text = detailUrl

        val detailSeason = "${resources.getString(R.string.text_season)} ${data.numberOfSeasons}"
        tvDetailSeason.text = detailSeason

        val detailEpisode = "${resources.getString(R.string.text_episode)} ${data.numberOfEpisodes}"
        tvDetailEpisodes.text = detailEpisode

        val rating = data.voteAverage?.div(2)
        ratingBarDetail.rating = rating?.toFloat() ?: 0F

        imgBackdropDetail.setViewImageUrl(this, data.backdropPath.toString(), pbBanner)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return true
    }

    private fun setFavoriteState(state: Boolean) {
        if (state) {
            btnFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
        }else{
            btnFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border))
        }
    }

    private fun setShowSnackbar(state: Boolean) {
        if (!state) {
            showSnackBar(resources.getString(R.string.message_success_added))
        }else{
            showSnackBar(resources.getString(R.string.message_remove_favorite))
        }
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }
}
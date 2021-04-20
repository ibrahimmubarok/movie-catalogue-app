package com.ibeybeh.submission.moviecatalogue.presentation.detail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.MenuItem
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.MoviesData
import com.ibeybeh.submission.moviecatalogue.utils.Const.EXTRA_MOVIES_DATA
import com.ibeybeh.submission.moviecatalogue.utils.Const.EXTRA_POSITION
import com.ibeybeh.submission.moviecatalogue.utils.setImageUrl
import com.ibeybeh.submission.moviecatalogue.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_detail.imgBackdropDetail
import kotlinx.android.synthetic.main.activity_detail.pbBanner
import kotlinx.android.synthetic.main.activity_detail.ratingBarDetail
import kotlinx.android.synthetic.main.activity_detail.tvDetailDesc
import kotlinx.android.synthetic.main.activity_detail.tvDetailGenre
import kotlinx.android.synthetic.main.activity_detail.tvDetailRating
import kotlinx.android.synthetic.main.activity_detail.tvDetailTitle
import kotlinx.android.synthetic.main.activity_detail.tvDetailUrl
import kotlinx.android.synthetic.main.item_row_catalogue.view.ratingBarItem
import kotlinx.android.synthetic.main.layout_toolbar.toolbar

class DetailActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context, data: MoviesData, position: Int) {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_MOVIES_DATA, data)
                putExtra(EXTRA_POSITION, position)
            }
            context.startActivity(intent)
        }
    }

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<MoviesData>(EXTRA_MOVIES_DATA)

        setSupportActionBar(toolbar)
        supportActionBar?.title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (data != null) {
            val movies = mainViewModel.getDataDummyMovies(data)
            initView(movies)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initView(data: MoviesData) {
        tvDetailTitle.text = data.title
        tvDetailDesc.text = data.overview
        tvDetailRating.text = data.rating.toString()
        tvDetailGenre.text = data.genre
        tvDetailUrl.text = "${resources.getString(R.string.text_visit)} ${Html.fromHtml(data.homepage)}"

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
package com.ibeybeh.submission.moviecatalogue.presentation.favorite

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.presentation.favorite.adapter.FavoriteSectionsPager
import kotlinx.android.synthetic.main.activity_favorite.tabLayoutFav
import kotlinx.android.synthetic.main.activity_favorite.toolbarFav
import kotlinx.android.synthetic.main.activity_favorite.viewPagerFav

class FavoriteActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, FavoriteActivity::class.java))
        }
    }

    private val mTabSectionsAdapter: FavoriteSectionsPager by lazy {
        FavoriteSectionsPager(
            this,
            supportFragmentManager
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        setSupportActionBar(toolbarFav)
        supportActionBar?.title = resources.getString(R.string.title_favorite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initViewPager()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initViewPager() {
        viewPagerFav.apply {
            adapter = mTabSectionsAdapter
        }
        tabLayoutFav.setupWithViewPager(viewPagerFav)
    }
}
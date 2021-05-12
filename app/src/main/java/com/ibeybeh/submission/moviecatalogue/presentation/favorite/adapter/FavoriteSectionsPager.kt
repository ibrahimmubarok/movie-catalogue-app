package com.ibeybeh.submission.moviecatalogue.presentation.favorite.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.presentation.favorite.movies.FavoriteMovieFragment
import com.ibeybeh.submission.moviecatalogue.presentation.favorite.tvshows.FavoriteTvShowFragment

class FavoriteSectionsPager(
    mContext: Context,
    fm: FragmentManager
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabTitles = arrayOf(
        mContext.resources.getString(R.string.title_movies),
        mContext.resources.getString(R.string.title_tv_shows)
    )

    override fun getCount(): Int = tabTitles.size

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTvShowFragment()
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}
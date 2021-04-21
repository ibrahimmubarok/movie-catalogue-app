package com.ibeybeh.submission.moviecatalogue.presentation.main.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.presentation.main.movies.MoviesFragment
import com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows.TvShowsFragment

class MainSectionsPagerAdapter(
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
            0 -> MoviesFragment()
            1 -> TvShowsFragment()
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}
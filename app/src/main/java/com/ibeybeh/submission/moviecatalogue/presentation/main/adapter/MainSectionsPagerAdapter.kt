package com.ibeybeh.submission.moviecatalogue.presentation.main.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ibeybeh.submission.moviecatalogue.presentation.main.movies.MoviesFragment

class MainSectionsPagerAdapter(
    private val mContext: Context,
    fm: FragmentManager
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabTitles = arrayOf(
        "Movies",
        "Tv Shows"
    )

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return MoviesFragment.newInstance(position+1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}
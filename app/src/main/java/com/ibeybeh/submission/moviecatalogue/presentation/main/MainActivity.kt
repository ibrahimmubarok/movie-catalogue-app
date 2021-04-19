package com.ibeybeh.submission.moviecatalogue.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ibeybeh.submission.moviecatalogue.R.layout
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MainSectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.tabLayoutMain
import kotlinx.android.synthetic.main.activity_main.viewPagerMain

class MainActivity : AppCompatActivity() {

    private val mTabSectionsAdapter: MainSectionsPagerAdapter by lazy {
        MainSectionsPagerAdapter(
            this,
            supportFragmentManager
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        initViewPager()
    }

    private fun initViewPager() {
        viewPagerMain.apply {
            adapter = mTabSectionsAdapter
        }
        tabLayoutMain.setupWithViewPager(viewPagerMain)
    }
}
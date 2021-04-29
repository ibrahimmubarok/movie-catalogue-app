package com.ibeybeh.submission.moviecatalogue.presentation.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper
import org.junit.*

class MainActivityTest {

    private val dummyMovies = DataDummyHelper.generateDummyMovies()
    private val dummyTvShows = DataDummyHelper.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rvMovies)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailFromMovies() {
        onView(withId(R.id.rvMovies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tvDetailTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDetailTitle)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.tvDetailDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDetailDesc)).check(matches(withText(dummyMovies[0].overview)))
        onView(withId(R.id.tvDetailGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDetailGenre)).check(matches(withText(dummyMovies[0].genre)))
        onView(withId(R.id.tvDetailRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDetailRating)).check(matches(withText(dummyMovies[0].rating.toString())))
    }

    @Test
    fun loadTvShows() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rvTvShows)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun loadDetailFromTvShows() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rvTvShows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tvDetailTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDetailTitle)).check(matches(withText(dummyTvShows[0].name)))
        onView(withId(R.id.tvDetailDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDetailDesc)).check(matches(withText(dummyTvShows[0].overview)))
        onView(withId(R.id.tvDetailGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDetailGenre)).check(matches(withText(dummyTvShows[0].genre)))
        onView(withId(R.id.tvDetailRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDetailRating)).check(matches(withText(dummyTvShows[0].rating.toString())))
        onView(withId(R.id.tvDetailSeason)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDetailSeason)).check(matches(withText("Season : "+dummyTvShows[0].seasons.toString())))
        onView(withId(R.id.tvDetailEpisodes)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDetailEpisodes)).check(matches(withText("Episode : "+dummyTvShows[0].episodes.toString())))
    }
}
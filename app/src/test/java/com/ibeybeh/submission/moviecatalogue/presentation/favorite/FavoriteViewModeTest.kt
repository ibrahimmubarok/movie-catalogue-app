package com.ibeybeh.submission.moviecatalogue.presentation.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.mockito.junit.*
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModeTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MoviesEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<PagedList<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(catalogueRepository)
    }

    @Test
    fun getMoviesSuccess() {
        val movies = MutableLiveData<PagedList<MoviesEntity>>()
        movies.value = PagedTestDataMoviesSources.snapshot(DataDummyHelper.generateDummyMoviesEntity())

        Mockito.`when`(catalogueRepository.getAllMoviesFavorite()).thenReturn(movies)

        viewModel.getAllMoviesFavorite().observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(movies.value)

        val expectedValue = movies.value
        val actualValue = viewModel.getAllMoviesFavorite().value
        Assert.assertEquals(expectedValue, actualValue)
        Assert.assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        Assert.assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun getMovieEmpty() {
        val movies = MutableLiveData<PagedList<MoviesEntity>>()
        movies.value = PagedTestDataMoviesSources.snapshot()

        Mockito.`when`(catalogueRepository.getAllMoviesFavorite()).thenReturn(movies)

        viewModel.getAllMoviesFavorite().observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(movies.value)

        val actualValueDataSize = viewModel.getAllMoviesFavorite().value?.size
        Assert.assertTrue("size of data should be 0, actual is $actualValueDataSize", actualValueDataSize == 0)
    }

    @Test
    fun getTvShowSuccess() {
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = PagedTestDataTvShowSources.snapshot(DataDummyHelper.generateDummyTvShowsEntity())

        Mockito.`when`(catalogueRepository.getAllTvShowsFavorite()).thenReturn(tvShow)

        viewModel.getAllTvShowsFavorite().observeForever(tvShowObserver)
        Mockito.verify(tvShowObserver).onChanged(tvShow.value)

        val expectedValue = tvShow.value
        val actualValue = viewModel.getAllTvShowsFavorite().value
        Assert.assertEquals(expectedValue, actualValue)
        Assert.assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        Assert.assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun getTvShowEmpty() {
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = PagedTestDataTvShowSources.snapshot()

        Mockito.`when`(catalogueRepository.getAllTvShowsFavorite()).thenReturn(tvShow)

        viewModel.getAllTvShowsFavorite().observeForever(tvShowObserver)
        Mockito.verify(tvShowObserver).onChanged(tvShow.value)

        val actualValueDataSize = viewModel.getAllTvShowsFavorite().value?.size
        Assert.assertTrue("size of data should be 0, actual is $actualValueDataSize", actualValueDataSize == 0)
    }

    class PagedTestDataMoviesSources private constructor(private val items: List<MoviesEntity>) : PositionalDataSource<MoviesEntity>() {
        companion object {
            fun snapshot(items: List<MoviesEntity> = listOf()): PagedList<MoviesEntity> {
                return PagedList.Builder(PagedTestDataMoviesSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<MoviesEntity>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<MoviesEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }

    class PagedTestDataTvShowSources private constructor(private val items: List<TvShowEntity>) : PositionalDataSource<TvShowEntity>() {
        companion object {
            fun snapshot(items: List<TvShowEntity> = listOf()): PagedList<TvShowEntity> {
                return PagedList.Builder(PagedTestDataTvShowSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<TvShowEntity>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<TvShowEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}
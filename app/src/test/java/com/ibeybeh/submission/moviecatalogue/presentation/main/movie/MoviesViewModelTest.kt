package com.ibeybeh.submission.moviecatalogue.presentation.main.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.presentation.main.movies.MoviesViewModel
import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper
import com.ibeybeh.submission.moviecatalogue.vo.Resources
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantiationException = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<Resources<PagedList<MoviesEntity>>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(catalogueRepository)
    }

    @Test
    fun getMoviesSuccess() {
        val movies = PagedTestDataSources.snapshot(DataDummyHelper.generateDummyMoviesEntity())
        val expected = MutableLiveData<Resources<PagedList<MoviesEntity>>>()
        expected.value = Resources.success(movies)

        `when`(catalogueRepository.getAllMovies()).thenReturn(expected)

        viewModel.getAllMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getAllMovies().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.data, actualValue?.data)
        assertEquals(expectedValue?.data?.size, actualValue?.data?.size)
    }

    @Test
    fun getMovieEmpty() {
        val movies = PagedTestDataSources.snapshot()
        val expected = MutableLiveData<Resources<PagedList<MoviesEntity>>>()
        expected.value = Resources.success(movies)

        `when`(catalogueRepository.getAllMovies()).thenReturn(expected)

        viewModel.getAllMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(expected.value)

        val actualValueDataSize = viewModel.getAllMovies().value?.data?.size
        assertTrue("size of data should be 0, actual is $actualValueDataSize", actualValueDataSize == 0)
    }

    @Test
    fun getMovieError() {
        val expectedMessage = "Something happen dude!"
        val expected = MutableLiveData<Resources<PagedList<MoviesEntity>>>()
        expected.value = Resources.error(expectedMessage, null)

        `when`(catalogueRepository.getAllMovies()).thenReturn(expected)

        viewModel.getAllMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(expected.value)

        val actualMessage = viewModel.getAllMovies().value?.message
        assertEquals(expectedMessage, actualMessage)
    }

    class PagedTestDataSources private constructor(private val items: List<MoviesEntity>) : PositionalDataSource<MoviesEntity>() {
        companion object {
            fun snapshot(items: List<MoviesEntity> = listOf()): PagedList<MoviesEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
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
}
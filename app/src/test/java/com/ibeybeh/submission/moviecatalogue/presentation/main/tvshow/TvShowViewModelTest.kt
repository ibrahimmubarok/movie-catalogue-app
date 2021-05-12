package com.ibeybeh.submission.moviecatalogue.presentation.main.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows.TvShowsViewModel
import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper
import com.ibeybeh.submission.moviecatalogue.vo.Resources
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.mockito.junit.*
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var tvShowObserver: Observer<Resources<PagedList<TvShowEntity>>>

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel(catalogueRepository)
    }

    @Test
    fun getTvShowSuccess() {
        val tvShow = PagedTestDataSources.snapshot(DataDummyHelper.generateDummyTvShowsEntity())
        val expected = MutableLiveData<Resources<PagedList<TvShowEntity>>>()
        expected.value = Resources.success(tvShow)

        Mockito.`when`(catalogueRepository.getAllTvShows()).thenReturn(expected)

        viewModel.getAllTvShows().observeForever(tvShowObserver)
        Mockito.verify(tvShowObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getAllTvShows().value
        Assert.assertEquals(expectedValue, actualValue)
        Assert.assertEquals(expectedValue?.data, actualValue?.data)
        Assert.assertEquals(expectedValue?.data?.size, actualValue?.data?.size)
    }

    @Test
    fun getTvShowEmpty() {
        val tvShow = PagedTestDataSources.snapshot()
        val expected = MutableLiveData<Resources<PagedList<TvShowEntity>>>()
        expected.value = Resources.success(tvShow)

        Mockito.`when`(catalogueRepository.getAllTvShows()).thenReturn(expected)

        viewModel.getAllTvShows().observeForever(tvShowObserver)
        Mockito.verify(tvShowObserver).onChanged(expected.value)

        val actualValueDataSize = viewModel.getAllTvShows().value?.data?.size
        Assert.assertTrue("size of data should be 0, actual is $actualValueDataSize", actualValueDataSize == 0)
    }

    @Test
    fun getTvShowError() {
        val expectedMessage = "Something happen dude!"
        val expected = MutableLiveData<Resources<PagedList<TvShowEntity>>>()
        expected.value = Resources.error(expectedMessage, null)

        Mockito.`when`(catalogueRepository.getAllTvShows()).thenReturn(expected)

        viewModel.getAllTvShows().observeForever(tvShowObserver)
        Mockito.verify(tvShowObserver).onChanged(expected.value)

        val actualMessage = viewModel.getAllTvShows().value?.message
        Assert.assertEquals(expectedMessage, actualMessage)
    }

    class PagedTestDataSources private constructor(private val items: List<TvShowEntity>) : PositionalDataSource<TvShowEntity>() {
        companion object {
            fun snapshot(items: List<TvShowEntity> = listOf()): PagedList<TvShowEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
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
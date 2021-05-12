package com.ibeybeh.submission.moviecatalogue.presentation.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.utils.ext.setImageUrl
import kotlinx.android.synthetic.main.item_row_tv_shows.view.imgCatalogueTvShow
import kotlinx.android.synthetic.main.item_row_tv_shows.view.pbItemTvShow
import kotlinx.android.synthetic.main.item_row_tv_shows.view.ratingBarItemTvShow
import kotlinx.android.synthetic.main.item_row_tv_shows.view.tvItemFirstAirDate
import kotlinx.android.synthetic.main.item_row_tv_shows.view.tvItemName
import kotlinx.android.synthetic.main.item_row_tv_shows.view.tvItemRatingTvShow
import kotlinx.android.synthetic.main.item_row_tv_shows.view.tvItemSeason

class TvShowAdapter(
    val callback: TvShowCallback? = null
) : PagedListAdapter<TvShowEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: TvShowEntity) {
            with(itemView) {
                tvItemName.text = data.name
                tvItemFirstAirDate.text = data.firstAirDate

                val itemSeason = "${resources.getString(R.string.text_season)} ${data.numberOfSeasons}"
                tvItemSeason.text = itemSeason
                tvItemRatingTvShow.text = data.voteAverage.toString()
                imgCatalogueTvShow.setImageUrl(context, data.posterPath.toString(), pbItemTvShow)

                val rating = data.voteAverage?.div(2)
                ratingBarItemTvShow.rating = rating?.toFloat() ?: 0F

                itemView.setOnClickListener {
                    callback?.onTvShowClicked(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_tv_shows, parent, false))
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    fun getSwipedData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

    interface TvShowCallback {

        fun onTvShowClicked(data: TvShowEntity)
    }
}
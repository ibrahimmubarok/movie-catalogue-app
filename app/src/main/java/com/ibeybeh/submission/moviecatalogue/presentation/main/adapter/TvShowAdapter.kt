package com.ibeybeh.submission.moviecatalogue.presentation.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.TvShowAdapter.TvShowViewHolder
import com.ibeybeh.submission.moviecatalogue.utils.setImageUrl
import kotlinx.android.synthetic.main.item_row_tv_shows.view.imgCatalogueTvShow
import kotlinx.android.synthetic.main.item_row_tv_shows.view.pbItemTvShow
import kotlinx.android.synthetic.main.item_row_tv_shows.view.ratingBarItemTvShow
import kotlinx.android.synthetic.main.item_row_tv_shows.view.tvItemFirstAirDate
import kotlinx.android.synthetic.main.item_row_tv_shows.view.tvItemName
import kotlinx.android.synthetic.main.item_row_tv_shows.view.tvItemRatingTvShow
import kotlinx.android.synthetic.main.item_row_tv_shows.view.tvItemSeason

class TvShowAdapter(
    private val data: MutableList<TvShowEntity>,
    val callback: TvShowCallback? = null
) : RecyclerView.Adapter<TvShowViewHolder>() {

    inner class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: TvShowEntity) {
            with(itemView) {
                tvItemName.text = data.name
                tvItemFirstAirDate.text = data.firstAirDate

                val itemSeason = "${resources.getString(R.string.text_season)} ${data.seasons}"
                tvItemSeason.text = itemSeason
                tvItemRatingTvShow.text = data.rating.toString()
                imgCatalogueTvShow.setImageUrl(context, data.photo.toString(), pbItemTvShow)

                val rating = data.rating?.div(2)
                ratingBarItemTvShow.rating = rating?.toFloat() ?: 0F

                itemView.setOnClickListener {
                    callback?.onTvShowClicked(data)
                }
            }
        }
    }

    fun setData(data: MutableList<TvShowEntity>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_tv_shows, parent, false))
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    interface TvShowCallback {

        fun onTvShowClicked(data: TvShowEntity)
    }
}
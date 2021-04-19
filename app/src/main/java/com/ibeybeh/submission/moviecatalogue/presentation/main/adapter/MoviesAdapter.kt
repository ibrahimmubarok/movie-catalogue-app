package com.ibeybeh.submission.moviecatalogue.presentation.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.MoviesData
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter.MoviesViewHolder
import kotlinx.android.synthetic.main.item_row_catalogue.view.tvItemFirstSubCatalogue
import kotlinx.android.synthetic.main.item_row_catalogue.view.tvItemRating
import kotlinx.android.synthetic.main.item_row_catalogue.view.tvItemSecSubCatalogue
import kotlinx.android.synthetic.main.item_row_catalogue.view.tvItemTitle

class MoviesAdapter(
    private val data: MutableList<MoviesData>,
    val callback: MoviesCallback? = null
) : RecyclerView.Adapter<MoviesViewHolder>() {

    inner class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bind(data: MoviesData, position: Int) {
            with(itemView) {
                tvItemTitle.text = data.title
                tvItemFirstSubCatalogue.text = data.releaseDate
                tvItemSecSubCatalogue.text = "${resources.getString(R.string.text_time)} ${data.runtime} ${resources.getString(R.string.text_minute)}"
                tvItemRating.text = data.rating.toString()

                itemView.setOnClickListener {
                    callback?.onMoviesClicked(data, position)
                }
            }
        }
    }

    private fun setData(data: MutableList<MoviesData>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_catalogue, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int = data.size

    interface MoviesCallback {
        fun onMoviesClicked(data: MoviesData, position: Int)
    }
}
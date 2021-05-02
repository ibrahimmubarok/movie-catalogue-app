package com.ibeybeh.submission.moviecatalogue.presentation.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibeybeh.submission.moviecatalogue.R
import com.ibeybeh.submission.moviecatalogue.data.source.domain.Movie
import com.ibeybeh.submission.moviecatalogue.presentation.main.adapter.MoviesAdapter.MoviesViewHolder
import com.ibeybeh.submission.moviecatalogue.utils.setImageUrl
import kotlinx.android.synthetic.main.item_row_movies.view.imgCatalogueMovies
import kotlinx.android.synthetic.main.item_row_movies.view.pbItemMovies
import kotlinx.android.synthetic.main.item_row_movies.view.ratingBarItemMovies
import kotlinx.android.synthetic.main.item_row_movies.view.tvItemRatingMovies
import kotlinx.android.synthetic.main.item_row_movies.view.tvItemReleaseDate
import kotlinx.android.synthetic.main.item_row_movies.view.tvItemTitle

class MoviesAdapter(
    private val data: MutableList<Movie>,
    val callback: MoviesCallback? = null
) : RecyclerView.Adapter<MoviesViewHolder>() {

    inner class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: Movie) {
            with(itemView) {
                tvItemTitle.text = data.title
                tvItemReleaseDate.text = data.releaseDate

                tvItemRatingMovies.text = data.voteAverage.toString()
                imgCatalogueMovies.setImageUrl(context, data.posterPath.toString(), pbItemMovies)

                val rating = data.voteAverage?.div(2)
                ratingBarItemMovies.rating = rating?.toFloat() ?: 0F

                itemView.setOnClickListener {
                    callback?.onMoviesClicked(data)
                }
            }
        }
    }

    fun setData(data: MutableList<Movie>) {
        if (data.isEmpty()) {
            return
        }else {
            this.data.clear()
            this.data.addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_movies, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    interface MoviesCallback {

        fun onMoviesClicked(data: Movie)
    }
}
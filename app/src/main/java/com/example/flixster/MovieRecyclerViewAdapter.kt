package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flixster.R.id

/**
 * [RecyclerView.Adapter] that can display a [Movie] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MovieRecyclerViewAdapter (
    private val movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
    )
    : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_movie, parent, false)
            return MovieViewHolder(view)
        }

        /**
         * This inner class lets us refer to all the different View elements
         * (Yes, the same ones as in the XML layout files!)
         */
        inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            var mItem: Movie? = null
            val mMovieTitle: TextView = mView.findViewById<View>(id.movieTitle) as TextView
            val mMovieDetail: TextView = mView.findViewById<View>(id.movieDetail) as TextView
            val mMovieImage: ImageView = mView.findViewById<View>(id.movieImage) as ImageView

            override fun toString(): String {
                return mMovieTitle.toString() + " '" + mMovieDetail.text + "'"
            }
        }

        /**
         * This lets us "bind" each Views in the ViewHolder to its' actual data!
         */
        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie = movies[position]
            val imageUrl = "ttps://image.tmdb.org/t/p/w500/"

            holder.mItem = movie
            holder.mMovieTitle.text = movie.title
            holder.mMovieDetail.text = movie.detail

            holder.mView.setOnClickListener {
                holder.mItem?.let { book ->
                    mListener?.onItemClick(book)
                }
            }
        }

        /**
         * Remember: RecyclerView adapters require a getItemCount() method.
         */
        override fun getItemCount(): Int {
            return movies.size
        }
}
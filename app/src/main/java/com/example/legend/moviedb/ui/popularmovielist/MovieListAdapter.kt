package com.example.legend.moviedb.ui.popularmovielist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.legend.moviedb.R
import com.example.legend.moviedb.service.model.PopularList
import com.example.legend.moviedb.ui.CustomItemClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_cardview.view.*


class MovieListAdapter(popularList: PopularList?) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private lateinit var listener: CustomItemClickListener
    private val mutableList: PopularList? = popularList

    init {

    }

    fun setListener(listener: CustomItemClickListener) {
        this.listener = listener
    }
    override fun getItemCount(): Int {
        return mutableList?.results?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_cardview, parent, false)

        view.setOnClickListener { v ->
                listener.onItemClick(v, ViewHolder(view).adapterPosition)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = mutableList?.results?.get(position)?.title
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500" + mutableList?.results?.get(position)?.posterPath)
            .into(holder.imageView)
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView = itemView.movie_name
        val imageView = itemView.movie_image
    }


    fun clear() {
    }

}

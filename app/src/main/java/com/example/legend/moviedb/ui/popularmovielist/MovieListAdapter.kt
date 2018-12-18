package com.example.legend.moviedb.ui.popularmovielist

import android.arch.lifecycle.LiveData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.legend.moviedb.R
import com.example.legend.moviedb.service.model.PopularList
import com.example.legend.moviedb.service.network.Resource
import com.example.legend.moviedb.ui.CustomItemClickListener
import kotlinx.android.synthetic.main.movie_cardview.view.*

import java.util.ArrayList

/**
 * Created by Legend on 10.05.2018.
 */

class MovieListAdapter (livePopularList : LiveData<Resource<PopularList>>): RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private lateinit var listener: CustomItemClickListener
    private val mutableList: LiveData<Resource<PopularList>> = livePopularList

    init {

    }

    override fun getItemCount(): Int {
        return mutableList.value?.data?.results?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_cardview, parent, false)

        view.setOnClickListener { v ->
                listener.onItemClick(v, ViewHolder(view).adapterPosition)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.photo_title_id.setText(mutableList[position].results())
//        //holder.textBoxTextViewCount.setText(mutableList.get(position).getCommentCount().toString());
//        holder.textView_username.setText(mutableList[position].getUserName())
//        holder.textView_description.setText(mutableList[position].getBody())
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView = itemView.movie_name
        val imageView = itemView.movie_image
    }


    fun clear() {
    }

}

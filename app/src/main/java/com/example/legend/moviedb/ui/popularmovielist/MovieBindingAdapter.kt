package com.example.legend.moviedb.ui.popularmovielist

import android.support.v7.widget.RecyclerView
import android.databinding.BindingAdapter
import com.example.legend.moviedb.service.model.PopularList


class MovieBindingAdapter {

    object MovieBindingAdapter {

        @BindingAdapter(value = ["data"])
        fun bindPostList(recyclerView: RecyclerView, posts: List<PopularList>) {
            val rvAdapter = recyclerView.adapter as MovieListAdapter?
            if (rvAdapter != null) {
                rvAdapter.notifyDataSetChanged()
            }
        }
    }
}
package com.example.legend.moviedb.ui.popularmovielist

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.legend.moviedb.R
import com.example.legend.moviedb.service.model.Movie
import com.example.legend.moviedb.service.model.PopularList
import com.example.legend.moviedb.service.network.Resource


data class MainViewState(val ResourceResult: Resource<PopularList>?) {
    fun isPostListLoading(): Int? {
        return if (ResourceResult?.status === Resource.Status.LOADING) View.VISIBLE else View.GONE
    }

    fun getPopularList(): PopularList? {
        return if (ResourceResult?.status == Resource.Status.SUCCESS) ResourceResult.data as PopularList else null

    }

}
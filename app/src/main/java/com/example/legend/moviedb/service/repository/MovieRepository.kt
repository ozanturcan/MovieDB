package com.example.legend.moviedb.service.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ozanturcan.com.moviedbsampleapp.service.repository.MovieDBService
import ozanturcan.com.moviedbsampleapp.ui.MainActivity

class MovieRepository {

    private var disposable: Disposable? = null

    private val movieDBService by lazy {
        MovieDBService.create()
    }
    val API_Key: String get() = "dacd1496570d87582daffe00a7ac0a68"

    fun getPopularMovieList(): Disposable? {
        return movieDBService.getPopular("1")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> Log.d("success", result.results.toString())},
                { error -> Log.d("success", error.message) }
            )
    }


}

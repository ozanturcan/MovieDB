package com.example.legend.moviedb.service.network

import com.example.legend.moviedb.service.model.PopularList
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


class MovieRepository {

    private val movieDBService by lazy {
        MovieDBService.create()
    }

    fun getPopularMovieList(pageNumber: String): Observable<Resource<PopularList>>? {
        return Observable.just<Resource<PopularList>>(Resource.loading(null))
            .concatWith(
                movieDBService
                    .getPopular(pageNumber)
                    .map { success -> Resource.success(success) }
                    .onErrorReturn { error -> Resource.error(error) }
                    .toObservable())
            .subscribeOn(Schedulers.io())
    }
}

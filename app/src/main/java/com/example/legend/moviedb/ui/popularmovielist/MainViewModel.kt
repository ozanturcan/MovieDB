package com.example.legend.moviedb.ui.popularmovielist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.legend.moviedb.service.network.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class MainViewModel : ViewModel() {

    private val _popularList = MutableLiveData<MainViewState>()

    init {
        loadPopular()
    }

    val popularListLiveDate: LiveData<MainViewState>
        get() = _popularList

    private fun loadPopular() =
        MovieRepository().getPopularMovieList("2")
            ?.map { MainViewState(it) }
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(_popularList::setValue)

// Maplenerek result alanabilir fakat hata kontrolü yapmak zorlaşır.


}
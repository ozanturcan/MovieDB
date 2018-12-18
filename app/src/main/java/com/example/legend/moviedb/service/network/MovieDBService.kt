package com.example.legend.moviedb.service.network

import com.example.legend.moviedb.service.model.Genre
import com.example.legend.moviedb.service.model.Movie
import com.example.legend.moviedb.service.model.PopularList
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieDBService {
    companion object {
        private val BASE_URL: String get() = "https://api.themoviedb.org/3/"
        val API_Key: String get() = "dacd1496570d87582daffe00a7ac0a68"

        fun create(): MovieDBService {

            val retrofit =
                Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(MovieDBService::class.java)
        }
    }

    @GET("genre/movie/")
    fun getMovieCategories(): Call<List<Genre>>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movie_id: Number, @Query("api_key") api_key: String): Single<Movie>

    @GET("movie/popular")
    fun getPopular(@Query("page") page: String, @Query("api_key") api_key: String = API_Key): Single<PopularList>

}
package com.example.legend.moviedb.ui.popularmovielist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.legend.moviedb.R
import com.example.legend.moviedb.service.model.PopularList
import com.example.legend.moviedb.ui.CustomItemClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    lateinit var movieListAdapter: MovieListAdapter
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        viewModel.popularListLiveDate.observe(this, Observer {
            setAdapter(it?.getPopularList())
        })


    }

    fun init() {

        recyclerView = findViewById(R.id.recyclerView_MovieList)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    fun setAdapter(data: PopularList?) {
        if (data != null) {
            movieListAdapter = MovieListAdapter(data)
            movieListAdapter.setListener(object : CustomItemClickListener {
                override fun onItemClick(v: View, position: Int) {

                }
            })
            recyclerView.adapter = movieListAdapter
        }

    }

}

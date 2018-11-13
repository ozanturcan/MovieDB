package ozanturcan.com.moviedbsampleapp.ui

import android.os.Bundle
import com.example.legend.moviedb.R
import com.example.legend.moviedb.service.repository.MovieRepository
import io.reactivex.disposables.Disposable

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test : Disposable? = MovieRepository().getPopularMovieList()
        }
}

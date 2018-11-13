package ozanturcan.com.moviedbsampleapp.ui
import android.R.string.cancel
import android.content.Context
import android.support.v7.app.AppCompatActivity


open class BaseActivity : AppCompatActivity(){
    private val TAG = "BaseActivity"
    override fun getApplicationContext(): Context {
        return super.getApplicationContext()
    }

}
package ui.smartpro.cleanarchgeekbrains.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import ui.smartpro.cleanarchgeekbrains.R
import ui.smartpro.cleanarchgeekbrains.ui.main.MainActivity
import ui.smartpro.cleanarchgeekbrains.utils.replaceActivity

class SplashActivity : AppCompatActivity() {

    var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler.postDelayed({
            replaceActivity(MainActivity())
        }, DELAY_MILLS)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }

    companion object{
        private const val DELAY_MILLS = 1000L
    }
}
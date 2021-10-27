package ui.smartpro.cleanarchgeekbrains.ui.main

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnticipateInterpolator
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import ui.smartpro.cleanarchgeekbrains.R
import ui.smartpro.cleanarchgeekbrains.databinding.ActivityMainBinding
private const val SLIDE_LEFT_DURATION = 1000L
private const val COUNTDOWN_DURATION = 2000L
private const val COUNTDOWN_INTERVAL = 1000L
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    // навигация
    lateinit var navController: NavController
    lateinit var bottom_navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        setDefaultSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // инициализируем BottomNavigationView
        bottom_navigation = binding.bottomNavigation
        // main_activity - fragment сюда будут устанавливаться наши все фрагменеты
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
//        navController = findNavController(R.id.nav_host_fragment)
//        replaceFragment(TranslateFragment())
        initBottomNavigation()

    }

    private fun initBottomNavigation() {
        bottom_navigation.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.nav_home-> {
                    navController.navigate(R.id.translateFragment)
                    true
                }
                R.id.nav_favorite -> {
                    navController.navigate(R.id.favouriteFragment)
                    true
                }
                R.id.nav_search -> {
                    navController.navigate(R.id.searchFragment)
                    true
                }
                R.id.nav_profile -> {
//                    navController.navigate(R.id.profileFragment)
                    true
                }
                else -> true
            }
        }
    }

    private fun setDefaultSplashScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            setSplashScreenHideAnimation()
        }

        setSplashScreenDuration()
    }

    @RequiresApi(31)
    private fun setSplashScreenHideAnimation() {
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            val slideLeft = ObjectAnimator.ofFloat(
                    splashScreenView,
                    View.TRANSLATION_X,
                    0f,
                    -splashScreenView.height.toFloat()
            )
            slideLeft.interpolator = AnticipateInterpolator()
            slideLeft.duration = SLIDE_LEFT_DURATION

            slideLeft.doOnEnd { splashScreenView.remove() }
            slideLeft.start()
        }
    }

    private fun setSplashScreenDuration() {
        var isHideSplashScreen = false

        object : CountDownTimer(COUNTDOWN_DURATION, COUNTDOWN_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                isHideSplashScreen = true
            }
        }.start()

        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
                object : ViewTreeObserver.OnPreDrawListener {
                    override fun onPreDraw(): Boolean {
                        return if (isHideSplashScreen) {
                            content.viewTreeObserver.removeOnPreDrawListener(this)
                            true
                        } else {
                            false
                        }
                    }
                }
        )
    }
}
package ui.smartpro.cleanarchgeekbrains.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import ui.smartpro.cleanarchgeekbrains.R
import ui.smartpro.cleanarchgeekbrains.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    // навигация
    lateinit var navController: NavController
    lateinit var bottom_navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}
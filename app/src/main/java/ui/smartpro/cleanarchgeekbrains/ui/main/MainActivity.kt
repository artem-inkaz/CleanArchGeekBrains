package ui.smartpro.cleanarchgeekbrains.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ui.smartpro.cleanarchgeekbrains.R
import ui.smartpro.cleanarchgeekbrains.ui.translate.TranslateFragment
import ui.smartpro.cleanarchgeekbrains.utils.replaceFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(TranslateFragment())
    }
}
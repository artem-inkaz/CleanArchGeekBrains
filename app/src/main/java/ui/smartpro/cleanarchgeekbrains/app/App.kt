package ui.smartpro.cleanarchgeekbrains.app

import android.app.Application
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ui.smartpro.cleanarchgeekbrains.di.appModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            if (BuildConfig.DEBUG)
                printLogger()
            modules(
                arrayListOf(
                    appModule
                )
            )
        }
    }
}
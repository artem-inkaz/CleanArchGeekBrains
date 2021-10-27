package ui.smartpro.cleanarchgeekbrains.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ui.smartpro.cleanarchgeekbrains.api.RetrofitModule
import ui.smartpro.cleanarchgeekbrains.ui.translate.Interactor
import ui.smartpro.cleanarchgeekbrains.ui.translate.TranslateViewModel
import ui.smartpro.geekbrainskursovoimvp.scheduler.DefaultSchedulers

val appModule = module {

    single { RetrofitModule.create() }
    single { Interactor( get()) }
    single { DefaultSchedulers() }

    viewModel { TranslateViewModel(get()) }
}
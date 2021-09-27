package ui.smartpro.cleanarchgeekbrains.di

import androidx.room.Room
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ui.smartpro.cleanarchgeekbrains.api.RetrofitModule
import ui.smartpro.cleanarchgeekbrains.storage.Database
import ui.smartpro.cleanarchgeekbrains.ui.translate.Interactor
import ui.smartpro.cleanarchgeekbrains.ui.translate.TranslateViewModel

val appModule = module {

    single { RetrofitModule.create() }
    single { Interactor( get()) }
    single { Room.databaseBuilder(get(), Database::class.java, "HistoryDB").build() }
    single { get<Database>().dao() }
    viewModel { TranslateViewModel(get()) }
}
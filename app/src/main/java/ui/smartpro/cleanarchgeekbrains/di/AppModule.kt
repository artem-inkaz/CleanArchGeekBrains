package ui.smartpro.cleanarchgeekbrains.di

import androidx.room.Room
import ui.smartpro.cleanarchgeekbrains.model.repository.Repository
import ui.smartpro.cleanarchgeekbrains.model.repository.RepositoryImplementation
import ui.smartpro.cleanarchgeekbrains.model.repository.RepositoryImplementationLocal
import ui.smartpro.cleanarchgeekbrains.model.repository.RepositoryLocal
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ui.smartpro.repository.api.RetrofitModule
import ui.smartpro.model.data.ResponseItem
import ui.smartpro.cleanarchgeekbrains.model.datasource.RetrofitImplementation
import ui.smartpro.cleanarchgeekbrains.model.datasource.RoomDataBaseImplementation
import ui.smartpro.cleanarchgeekbrains.storage.Database
import ui.smartpro.cleanarchgeekbrains.ui.translate.Interactor
import ui.smartpro.cleanarchgeekbrains.ui.translate.TranslateFragment
import ui.smartpro.cleanarchgeekbrains.ui.translate.TranslateViewModel

val appModule = module {

    single { RetrofitModule.create() }
    single { Room.databaseBuilder(get(), Database::class.java, "HistoryDB").build() }
    single { get<Database>().dao() }
    single<Repository<List<ResponseItem>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<ResponseItem>>> {
        RepositoryImplementationLocal(
                RoomDataBaseImplementation(get())
        )
    }
    scope(named<TranslateFragment>()) {
        scoped { Interactor(get(), get()) }
        viewModel { TranslateViewModel(get()) }
    }
}
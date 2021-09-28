package ui.smartpro.cleanarchgeekbrains.ui.translate

import ui.smartpro.cleanarchgeekbrains.common.BaseInteractor
import ui.smartpro.cleanarchgeekbrains.model.data.AppState
import ui.smartpro.cleanarchgeekbrains.model.data.ResponseItem
import ui.smartpro.cleanarchgeekbrains.model.repository.Repository
import ui.smartpro.cleanarchgeekbrains.model.repository.RepositoryLocal
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem

class Interactor(
        private val repositoryRemote: Repository<List<ResponseItem>>,
        private val repositoryLocal: RepositoryLocal<List<ResponseItem>>,
) : BaseInteractor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }

    override suspend fun getDataByWord(orig: String): TranslationItem =
            repositoryLocal.getDataByWord(orig)


    override suspend fun getAllLocal(): List<TranslationItem> =
            repositoryLocal.getAllLocal()


    override suspend fun getFavorite(): List<TranslationItem> =
            repositoryLocal.getFavorite()


    override suspend fun addToFavorite(id: Int) =
            repositoryLocal.addToFavorite(id)


    override suspend fun removeFromFavorite(id: Int) =
            repositoryLocal.removeFromFavorite(id)

}

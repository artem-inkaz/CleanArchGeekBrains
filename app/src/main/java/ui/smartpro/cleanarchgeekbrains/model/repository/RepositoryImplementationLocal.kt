package ui.smartpro.cleanarchgeekbrains.model.repository

import ui.smartpro.cleanarchgeekbrains.model.data.AppState
import ui.smartpro.cleanarchgeekbrains.model.data.ResponseItem
import ui.smartpro.cleanarchgeekbrains.model.datasource.DataSourceLocal
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<ResponseItem>>) :
        RepositoryLocal<List<ResponseItem>> {

    override suspend fun getData(word: String): List<ResponseItem> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }

    override suspend fun getDataByWord(orig: String): TranslationItem =
            dataSource.getDataByWord(orig)


    override suspend fun getAllLocal(): List<TranslationItem> {
        return dataSource.getAllLocal()
    }

    override suspend fun getFavorite(): List<TranslationItem> {
        return dataSource.getFavorite()
    }

    override suspend fun addToFavorite(id: Int) {
        return dataSource.addToFavorite(id)
    }

    override suspend fun removeFromFavorite(id: Int) {
        return dataSource.removeFromFavorite(id)
    }
}

package ui.smartpro.cleanarchgeekbrains.model.repository

import ui.smartpro.model.data.AppState
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
    suspend fun getDataByWord(orig: String): TranslationItem
    suspend fun getAllLocal(): List<TranslationItem>

    suspend fun getFavorite(): List<TranslationItem>

    suspend fun addToFavorite(id: Int)

    suspend fun removeFromFavorite(id: Int)
}

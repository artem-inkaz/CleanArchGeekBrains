package ui.smartpro.core.common

import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem

//3
/**
 * Ещё выше стоит интерактор. Здесь уже чистая бизнес-логика
 */
interface BaseInteractor<T> {

   suspend fun getData(word: String, fromRemoteSource: Boolean): T

   suspend fun getDataByWord(orig: String): TranslationItem

   suspend fun getAllLocal(): List<TranslationItem>

   suspend fun getFavorite(): List<TranslationItem>

   suspend fun addToFavorite(id: Int)

   suspend fun removeFromFavorite(id: Int)

}
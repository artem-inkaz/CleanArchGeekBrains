package ui.smartpro.cleanarchgeekbrains.common.cleanarch

//3
/**
 * Ещё выше стоит интерактор. Здесь уже чистая бизнес-логика
 */
interface BaseInteractor<T> {
    suspend fun getTranslate(word: String, fromRemoteSource: Boolean): T
   suspend fun getData(word: String, fromRemoteSource: Boolean): T
}
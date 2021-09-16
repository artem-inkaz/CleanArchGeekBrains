package ui.smartpro.cleanarchgeekbrains.common.cleanarch

import io.reactivex.Observable

//4
/**
 * Репозиторий представляет собой слой получения и хранения данных, которые он
 * передаёт интерактору
 */
interface Repository<T> {

    fun getData(word: String): Observable<T>
}
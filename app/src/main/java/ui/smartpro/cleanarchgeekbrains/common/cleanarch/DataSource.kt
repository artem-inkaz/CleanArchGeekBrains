package ui.smartpro.cleanarchgeekbrains.common.cleanarch

import io.reactivex.Observable

//5
/**
 * Источник данных для репозитория (Интернет, БД и т. п.)
 */
interface DataSource<T> {
    fun getData(word: String): Observable<T>
}
package ui.smartpro.cleanarchgeekbrains.common.cleanarch

import io.reactivex.Single

//3
/**
 * Ещё выше стоит интерактор. Здесь уже чистая бизнес-логика
 */
interface BaseInteractor<T> {
    // Use Сase: получение данных для вывода на экран
    // Используем RxJava
    fun getData(word: String, fromRemoteSource: Boolean): Single<T>
}
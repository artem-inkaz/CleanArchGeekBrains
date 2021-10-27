package ui.smartpro.cleanarchgeekbrains.common.cleanarch

import ui.smartpro.cleanarchgeekbrains.common.AppState
import ui.smartpro.cleanarchgeekbrains.common.MvpView

//2
/**
 * На уровень выше находится презентер, который уже ничего не знает ни о контексте, ни о фреймворке
 */
interface Presenter<T : AppState, V : MvpView> {

    fun attachView(view: V)

    fun detachView(view: V)

    // Получение данных с флагом isOnline(из Интернета или нет)
    fun getData(word: String, isOnline: Boolean)
}
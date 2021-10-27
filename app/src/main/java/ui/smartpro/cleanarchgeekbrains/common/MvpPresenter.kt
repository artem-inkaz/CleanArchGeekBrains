package ui.smartpro.cleanarchgeekbrains.common

interface MvpPresenter<T : AppState, V : MvpView> {

    fun attach(view: V)

    fun detach(view: V)

    // Получение данных с флагом isOnline(из Интернета или нет)
    fun getData(word: String, isOnline: Boolean)
}
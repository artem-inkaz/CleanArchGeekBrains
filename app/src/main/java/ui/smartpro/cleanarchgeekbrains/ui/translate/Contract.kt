package ui.smartpro.cleanarchgeekbrains.ui.translate

import io.reactivex.Observable
import ui.smartpro.cleanarchgeekbrains.common.AppState
import ui.smartpro.cleanarchgeekbrains.common.MvpPresenter
import ui.smartpro.cleanarchgeekbrains.common.MvpView
import ui.smartpro.cleanarchgeekbrains.data.ResponseItem

interface Contract {

    interface View : MvpView

    interface Presenter : MvpPresenter<AppState, View> {
        fun getTranslate(word: String): Observable<List<ResponseItem>>
    }
}
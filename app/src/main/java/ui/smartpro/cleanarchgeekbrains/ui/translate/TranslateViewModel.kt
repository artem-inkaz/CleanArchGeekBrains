package ui.smartpro.cleanarchgeekbrains.ui.translate

import androidx.lifecycle.LiveData
import io.reactivex.observers.DisposableObserver
import io.reactivex.rxkotlin.plusAssign
import ui.smartpro.cleanarchgeekbrains.common.BaseViewModel
import ui.smartpro.cleanarchgeekbrains.data.AppState

class TranslateViewModel(
        private val interactor: Interactor
):BaseViewModel<AppState>() {

    private var appState: AppState? = null

    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable +=
                interactor
                        .getData(word,isOnline)
                        .subscribeOn(schedulers.background())
                        .observeOn(schedulers.main())
                        .subscribeOn(schedulers.background())
                        .doOnSubscribe{liveDataForViewToObserve.value= AppState.Loading(null)}
                        .subscribeWith(getObserver())

        return super.getData(word, isOnline)
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(state: AppState) {
                appState = state
                liveDataForViewToObserve.value = state
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }

            override fun onComplete() {
            }
        }
    }
}
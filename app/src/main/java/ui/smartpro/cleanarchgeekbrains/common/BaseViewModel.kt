package ui.smartpro.cleanarchgeekbrains.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.core.KoinComponent
import ui.smartpro.cleanarchgeekbrains.data.AppState
import ui.smartpro.geekbrainskursovoimvp.scheduler.DefaultSchedulers

abstract class BaseViewModel<T : AppState>(
        protected val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
        protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
        protected val schedulers: DefaultSchedulers = DefaultSchedulers()
) : ViewModel(), KoinComponent {

//    private val compositeDisposable = CompositeDisposable()

    open fun getData(word: String, isOnline: Boolean): LiveData<T> = liveDataForViewToObserve

    protected fun Disposable.disposeOnCleared(): Disposable {
        compositeDisposable.add(this)
        return compositeDisposable
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
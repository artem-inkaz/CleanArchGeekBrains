package ui.smartpro.cleanarchgeekbrains.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import ui.smartpro.cleanarchgeekbrains.data.AppState

abstract class BaseViewModel<T : AppState>(
        protected open val _mutableLiveData: MutableLiveData<T> = MutableLiveData(),
) : ViewModel(), KoinComponent {

    abstract fun getData(word: String, isOnline: Boolean)

    protected val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    protected fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }
    abstract fun handleError(error: Throwable)

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }
}
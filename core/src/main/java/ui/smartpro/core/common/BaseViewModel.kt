package ui.smartpro.core.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import ui.smartpro.model.data.AppState

abstract class BaseViewModel<T : AppState, V>(
        protected open val _mutableLiveData: MutableLiveData<T> = MutableLiveData(),
        protected open val _mutableLiveDataLocal: MutableLiveData<V> = MutableLiveData(),
) : ViewModel(), KoinComponent {

    abstract fun getData(word: String, isOnline: Boolean)

    abstract fun getDataByWord(orig: String)

    abstract fun getAllLocal()

    abstract fun getFavorite()

    abstract fun addToFavorite(id: Int)

    abstract fun removeFromFavorite(id: Int)

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
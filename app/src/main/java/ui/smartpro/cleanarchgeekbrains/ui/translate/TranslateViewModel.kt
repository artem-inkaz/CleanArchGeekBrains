package ui.smartpro.cleanarchgeekbrains.ui.translate

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ui.smartpro.cleanarchgeekbrains.common.BaseViewModel
import ui.smartpro.cleanarchgeekbrains.data.AppState
import ui.smartpro.cleanarchgeekbrains.utils.parseSearchResults

class TranslateViewModel(
    private val interactor: Interactor
) : BaseViewModel<AppState>() {

    private val liveData: LiveData<AppState> = _mutableLiveData

    fun subscribe(): LiveData<AppState> {
        return liveData
    }

    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) =
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(parseSearchResults(interactor.getTranslate(word, isOnline)))
        }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
    }

    override fun onCleared() {
        _mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }

}
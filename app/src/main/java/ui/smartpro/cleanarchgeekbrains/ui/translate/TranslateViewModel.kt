package ui.smartpro.cleanarchgeekbrains.ui.translate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ui.smartpro.cleanarchgeekbrains.common.BaseViewModel
import ui.smartpro.cleanarchgeekbrains.model.data.AppState
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem
import ui.smartpro.cleanarchgeekbrains.utils.parseOnlineSearchResults

class TranslateViewModel(
        private val interactor: Interactor,
) : BaseViewModel<AppState, List<TranslationItem>>() {

    private val liveData: LiveData<AppState> = _mutableLiveData

    val liveDataLocal: MutableLiveData<List<TranslationItem>> = _mutableLiveDataLocal

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
                _mutableLiveData.postValue(parseOnlineSearchResults(interactor.getData(word, isOnline)))
            }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
    }

    override fun onCleared() {
        _mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }

    override fun getDataByWord(orig: String) {
        viewModelCoroutineScope.launch { getDataByWordInteractor(orig) }
    }

    private suspend fun getDataByWordInteractor(word: String) =
            withContext(Dispatchers.IO) {
                _mutableLiveDataLocal.postValue(listOf(interactor.getDataByWord(word)))
            }

    override fun getAllLocal() {
        viewModelScope.launch {
            _mutableLiveDataLocal.postValue(interactor.getAllLocal())
        }
    }

    override fun getFavorite() {
        viewModelScope.launch {
            _mutableLiveDataLocal.postValue(interactor.getFavorite())
        }
    }

    override fun addToFavorite(id: Int) {
        viewModelCoroutineScope.launch { addToFavoriteInteractor(id) }
    }

    private suspend fun addToFavoriteInteractor(id: Int) =
            withContext(Dispatchers.IO) {
//                _mutableLiveDataLocal.postValue(listOf(interactor.addToFavorite(id)))
            }

    override fun removeFromFavorite(id: Int) {
        viewModelScope.launch {
//            _mutableLiveDataLocal.postValue(listOf(interactor.removeFromFavorite(id)))
        }
    }
}
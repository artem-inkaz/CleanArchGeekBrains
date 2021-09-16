package ui.smartpro.cleanarchgeekbrains.common

import ui.smartpro.cleanarchgeekbrains.data.ResponseItem

sealed class AppState {
    data class Success(val data: List<ResponseItem>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}
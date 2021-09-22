package ui.smartpro.cleanarchgeekbrains.ui.translate

import ui.smartpro.cleanarchgeekbrains.api.Api
import ui.smartpro.cleanarchgeekbrains.common.cleanarch.BaseInteractor
import ui.smartpro.cleanarchgeekbrains.data.AppState

class Interactor(
    private val api: Api
) : BaseInteractor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(api.getTranslate(word))
    }

    override suspend fun getTranslate(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(api.getTranslate(word))
    }
}
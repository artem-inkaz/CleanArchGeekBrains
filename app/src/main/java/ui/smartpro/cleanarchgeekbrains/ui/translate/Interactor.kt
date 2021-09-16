package ui.smartpro.cleanarchgeekbrains.ui.translate

import io.reactivex.Single
import ui.smartpro.cleanarchgeekbrains.api.Api
import ui.smartpro.cleanarchgeekbrains.common.AppState
import ui.smartpro.cleanarchgeekbrains.common.cleanarch.BaseInteractor
import ui.smartpro.cleanarchgeekbrains.data.ResponseItem

class Interactor(
    private val api: Api
) : BaseInteractor<AppState> {
    fun getTranslate(word: String): Single<List<ResponseItem>> = api.getTranslate(word)
    override fun getData(word: String, fromRemoteSource: Boolean): Single<AppState> {
        return api.getTranslate(word).map { AppState.Success(it) }
    }
}
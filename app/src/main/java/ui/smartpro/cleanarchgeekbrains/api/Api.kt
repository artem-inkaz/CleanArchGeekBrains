package ui.smartpro.cleanarchgeekbrains.api

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ui.smartpro.cleanarchgeekbrains.data.Response
import ui.smartpro.cleanarchgeekbrains.data.ResponseItem

interface Api {

    @GET("api/v2/entries/en/{word}")
    fun getTranslate(@Path("word") word_translate: String): Observable<List<ResponseItem>>
}
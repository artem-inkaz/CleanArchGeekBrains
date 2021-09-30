package ui.smartpro.repository.api

import retrofit2.http.GET
import retrofit2.http.Path
import ui.smartpro.model.data.ResponseItem

interface Api {

    @GET("api/v2/entries/en/{word}")
    suspend fun getTranslate(@Path("word") word_translate: String): List<ResponseItem>
}
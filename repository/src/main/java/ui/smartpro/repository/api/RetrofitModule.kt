package ui.smartpro.repository.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {
    private const val BASE_URL = "https://api.dictionaryapi.dev/"
    private val gson: Gson =
            GsonBuilder()
                    .create()

    fun create(): Api =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(
                            OkHttpClient.Builder()
                                    .addInterceptor(ApiInterceptor)
                                    .addInterceptor(HttpLoggingInterceptor().apply {
                                        level = HttpLoggingInterceptor.Level.BODY
                                    })
                                    .build()
                    )
                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .addCallAdapterFactory(CoroutineCallAdapterFactory.create())
                    .build()
                    .create(Api::class.java)

}
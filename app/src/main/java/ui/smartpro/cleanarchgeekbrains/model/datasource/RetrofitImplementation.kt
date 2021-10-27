package ui.smartpro.cleanarchgeekbrains.model.datasource

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ui.smartpro.cleanarchgeekbrains.BuildConfig
import ui.smartpro.cleanarchgeekbrains.api.Api
import ui.smartpro.cleanarchgeekbrains.api.BaseInterceptor
import ui.smartpro.cleanarchgeekbrains.model.data.ResponseItem

class RetrofitImplementation : DataSource<List<ResponseItem>> {

    override suspend fun getData(word: String): List<ResponseItem> {
        return getService(BaseInterceptor.interceptor).getTranslate(word)
    }

    private fun getService(interceptor: Interceptor): Api {
        return createRetrofit(interceptor).create(Api::class.java)
    }

    private fun createRetrofit(interceptor: Interceptor): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(createOkHttpClient(interceptor))
                .build()
    }

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return httpClient.build()
    }
}

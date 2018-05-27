package com.khinthirisoe.test.core.di.module

import com.google.gson.Gson
import com.khinthirisoe.test.core.App
import com.khinthirisoe.test.core.model.ApiService
import com.khinthirisoe.test.core.model.ApiUrl
import com.khinthirisoe.test.core.model.MainInteractor
import com.khinthirisoe.test.main.presenter.MainPresenter
import com.khinthirisoe.test.main.ui.MainContract
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * List of injected classes
 */
@Module
class ApplicationModule(private val app: App) {

    @Provides
    @Singleton
    fun app(): App = app


    @Provides
    @Singleton
    fun mainInteractor(apiService: ApiService): MainInteractor = MainInteractor(apiService)

    @Provides
    @Singleton
    fun ApiService(): ApiService {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder().baseUrl(ApiUrl.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
                .create(ApiService::class.java)
    }

    @Provides
    fun mainPresenter(interactor: MainInteractor): MainContract.Presenter = MainPresenter(interactor)
}

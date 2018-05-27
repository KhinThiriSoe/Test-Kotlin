package com.khinthirisoe.test.core.di.component

import com.khinthirisoe.test.core.App
import com.khinthirisoe.test.core.di.module.ApplicationModule
import com.khinthirisoe.test.core.model.ApiService
import com.khinthirisoe.test.core.model.MainInteractor
import com.khinthirisoe.test.main.ui.MainActivity
import com.khinthirisoe.test.main.ui.MainContract
import com.khinthirisoe.test.second.SecondActivity
import dagger.Component
import javax.inject.Singleton

/**
 * List of activities, fragments, views that need injection
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface AppComponent {

    fun inject(application: App)

    fun inject(activity: MainActivity)

    fun app(): App

    fun mainInteractor(): MainInteractor

    fun ApiService(): ApiService

    fun inject(activity: SecondActivity)

    fun mainPresenter(): MainContract.Presenter
}
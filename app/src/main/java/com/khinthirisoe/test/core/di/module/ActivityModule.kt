package com.khinthirisoe.test.core.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(internal val mActivity: Activity) {

    @Provides
    fun activityContext(): Context = mActivity
}
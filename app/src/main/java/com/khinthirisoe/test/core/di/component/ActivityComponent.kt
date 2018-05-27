package com.khinthirisoe.test.core.di.component

import com.khinthirisoe.test.core.di.scope.ActivityScope

import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class))
interface ActivityComponent : AppComponent

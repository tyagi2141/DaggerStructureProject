package com.example.daggerproject.di

import com.example.daggerproject.App
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject


@Module
class AppModule @Inject constructor(var app: App) {

    @AppScope
    @Provides
    fun provideApp(): App = app


    @AppScope
    @Provides
    fun provideExecutor(): Executor = Executors.newFixedThreadPool(2)!!


}
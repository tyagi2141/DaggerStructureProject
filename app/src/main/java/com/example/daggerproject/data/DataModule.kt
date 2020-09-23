package com.example.daggerproject.data

import com.example.daggerproject.App
import com.example.daggerproject.data.network.NetworkModule
import com.example.daggerproject.data.network.Routes
import com.example.daggerproject.di.AppModule
import com.example.daggerproject.di.AppScope
import dagger.Module
import dagger.Provides
import com.example.daggerproject.preferences.PreferencesModule

@Module(includes = [AppModule::class, NetworkModule::class, PreferencesModule::class])
class DataModule {

    @AppScope
    @Provides
    fun provideAppDataRepository(app: App, apiService: Routes): DataRepository =
        AppDataRepository(app, apiService)

}
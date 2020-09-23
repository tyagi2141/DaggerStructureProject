package com.example.daggerproject.preferences


import com.example.daggerproject.App
import com.example.daggerproject.di.AppModule
import com.example.daggerproject.di.AppScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [AppModule::class])
class PreferencesModule {

    @AppScope
    @Provides
    fun provideAppPreferences(app: App, @Named("prefs") gson: Gson): AppSharedPreferences =
        AppPreferences(app, gson)

    @AppScope
    @Provides
    fun provideAuthPreferences(app: App): AuthSharedPreferences =
        AuthPreferences(app)

    @Provides
    @Named("prefs")
    fun provideGson() = Gson()
}
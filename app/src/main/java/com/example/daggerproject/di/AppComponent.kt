package com.example.daggerproject.di


import com.example.daggerproject.App
import com.example.daggerproject.data.network.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import com.example.daggerproject.data.DataModule
import com.example.daggerproject.preferences.PreferencesModule


@AppScope
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        PreferencesModule::class,
        DataModule::class,

        ViewModelFactoryModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {

        fun create(appModule: AppModule): AppComponent
    }


}
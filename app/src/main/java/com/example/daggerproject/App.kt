package com.example.daggerproject

import com.example.daggerproject.di.AppComponent
import com.example.daggerproject.di.AppModule
import com.example.daggerproject.di.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import zerobranch.androidremotedebugger.AndroidRemoteDebugger


class App : DaggerApplication() {
    private lateinit var component: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }


    override fun onCreate() {


        component = DaggerAppComponent.factory().create(AppModule(this))
        component.inject(this)
        super.onCreate()

        libsInitialization()

        instance = this


        /*ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath(getString(R.string.app_font_regular))
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )*/

    }


    fun libsInitialization() {

        //Stetho
        Stetho.initializeWithDefaults(this);

        //Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        AndroidRemoteDebugger.init(this)
    }

    companion object {

        @JvmStatic
        var instance: App? = null
            private set

    }
}
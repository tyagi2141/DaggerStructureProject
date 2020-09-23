package com.example.daggerproject.di

import com.example.daggerproject.MainActivity
import com.example.daggerproject.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@Suppress("UNUSED")
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainModule::class
            //fragments scope ->
//            HomeFragmentModule::class,
//            SearchFragmentModule::class,

            //child fragments scope ->
//            RestInfoBottomSheetModule::class
        ]
    )

    abstract fun contributeMainActivity(): MainActivity



    /*@ActivityScope
    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun contributeSearchCity(): SearchCityActivity


    @ActivityScope
    @ContributesAndroidInjector(modules = [RestaurantModule::class])
    abstract fun contributeRestaurantsActivity(): RestaurantsActivity*/


}

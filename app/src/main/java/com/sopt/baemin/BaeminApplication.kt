package com.sopt.baemin

import android.app.Application
import timber.log.Timber

class BaeminApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}
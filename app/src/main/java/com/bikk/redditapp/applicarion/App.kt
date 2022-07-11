package com.bikk.redditapp.applicarion

import android.app.Application
import com.bikk.redditapp.di.DI
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    DI.sourceModules(),
                    DI.repositoryModule(),
                    DI.viewModules()
                )
            )
        }
    }
}
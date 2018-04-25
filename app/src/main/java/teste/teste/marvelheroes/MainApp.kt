package teste.teste.marvelheroes

import android.app.Application
import org.koin.android.ext.android.startKoin
import teste.teste.marvelheroes.di.module.appModule
import teste.teste.marvelheroes.di.module.contextModule
import teste.teste.marvelheroes.di.module.netWorkModule

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, netWorkModule, contextModule))
    }
}
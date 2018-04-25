package teste.teste.marvelheroes.di.module

import android.app.Application
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext
import teste.teste.marvelheroes.MainApp
import teste.teste.marvelheroes.network.APIService
import teste.teste.marvelheroes.viewmodel.DetailsActivityViewModel
import teste.teste.marvelheroes.viewmodel.HomeViewModel

val appModule = applicationContext {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailsActivityViewModel() }

    bean { provideApplication(get()) }
    bean { provideAccountService(get()) }
    bean { APIService(get(), get()) }
    bean { provideFragmentManager(get()) }
}

fun provideApplication(application: MainApp): Application {
    return application
}

fun provideFragmentManager(manager: android.support.v4.app.FragmentManager): android.support.v4.app.FragmentManager {
    return manager
}

fun provideAccountService(apiService: APIService): APIService {
    return apiService
}
package teste.teste.marvelheroes.di.module


import android.app.Application
import android.util.Base64
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import teste.teste.marvelheroes.BuildConfig
import teste.teste.marvelheroes.contract.AppContract
import teste.teste.marvelheroes.network.MarvelAPIAuthenticator
import teste.teste.marvelheroes.utils.StringUtils
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit


val netWorkModule = applicationContext {

    bean { provideOkhttpClient(get()) }
    bean { provideGson() }
    bean { provideHttpCache(get()) }
    bean { provideRetrofit(get(), get()) }

}

fun provideHttpCache(application: Application): Cache {
    val cacheSize = 10 * 1024 * 1024
    return Cache(application.cacheDir, cacheSize.toLong())
}


fun provideGson(): Gson {
    val gsonBuilder = GsonBuilder()
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)

    gsonBuilder.registerTypeAdapter(Date::class.java, JsonDeserializer { json, _, _ -> Date(json.asJsonPrimitive.asLong) })

    return gsonBuilder.create()
}


fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {

    return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(AppContract().BASE_URL)
            .client(okHttpClient)
            .build()
}

fun provideOkhttpClient(cache: Cache): OkHttpClient {

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val authenticator = MarvelAPIAuthenticator()

    val builder = OkHttpClient.Builder()
            .cache(cache)
            .readTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(authenticator)
            .addInterceptor(interceptor)
         //   .authenticator(MarvelAPIAuthenticator())
            .followSslRedirects(true)


    return builder.build()

}
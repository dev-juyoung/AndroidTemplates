package io.cro.android.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.cro.android.BuildConfig
import io.cro.android.data.network.HttpHeaderInterceptor
import io.cro.android.extensions.isDebuggable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {
    @JvmStatic
    @Provides
    fun provideHttpHeaderInterceptor(): Interceptor = HttpHeaderInterceptor()

    @JvmStatic
    @Provides
    fun provideHttpClient(context: Context, headerInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder().apply {
            if (context.isDebuggable) addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })

            addInterceptor(headerInterceptor)
        }.build()

    @Singleton
    @JvmStatic
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}

package com.chainreaction.assignment.core.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val TIMEOUT_MINUTES = 8L
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Reusable
    fun provideOkHttp(): OkHttpClient {
        val builder = OkHttpClient.Builder().readTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
            .writeTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
            .connectTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
            .followSslRedirects(false)
        return builder.build()
    }

    @Provides
    @Reusable
    fun provideMainRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Reusable
    fun provideMoshi(): Converter.Factory {
        return MoshiConverterFactory.create()
    }
}

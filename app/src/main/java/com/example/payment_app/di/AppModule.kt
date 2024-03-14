package com.example.payment_app.di

import com.example.payment_app.data.constants.Constants.BASE_URL
import com.example.payment_app.data.impl.PaymentRepository
import com.example.payment_app.data.remote.PaymentApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun providePaymentApi(): PaymentApi {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
            .baseUrl(BASE_URL)
            .build()
            .create(PaymentApi::class.java)
    }

    @Singleton
    @Provides
    fun providePaymentRepository(api: PaymentApi) = PaymentRepository(api)
}
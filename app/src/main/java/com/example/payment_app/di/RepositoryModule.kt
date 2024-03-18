package com.example.payment_app.di

import com.example.payment_app.data.impl.PaymentRepository
import com.example.payment_app.data.service.local.PaymentDao
import com.example.payment_app.data.service.remote.PaymentApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePaymentRepository(api: PaymentApi, dao: PaymentDao) = PaymentRepository(api, dao)

}
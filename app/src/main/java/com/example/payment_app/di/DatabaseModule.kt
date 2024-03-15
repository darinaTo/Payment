package com.example.payment_app.di

import android.content.Context
import androidx.room.Room
import com.example.payment_app.data.service.local.PaymentDao
import com.example.payment_app.data.service.local.PaymentDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDao(appDatabase: PaymentDatabase) : PaymentDao = appDatabase.paymentDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context) : PaymentDatabase =
        Room.databaseBuilder(
            appContext,
            PaymentDatabase::class.java,
            "payment_database"
        ).fallbackToDestructiveMigration().build()
}
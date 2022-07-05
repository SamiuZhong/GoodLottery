package com.samiu.lottery.di

import com.samiu.lottery.api.MxnApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author samiu
 * @email samiuzhong@outlook.com
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideMxnService(): MxnApiService {
        return MxnApiService.create()
    }
}
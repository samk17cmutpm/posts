package com.post.di.repositories

import com.post.data.repositories.SalesDataRepository
import com.post.domain.repositories.SalesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/17/18.
 */
@Module
class SalesRepositoryModule {
    @Provides
    @Singleton
    fun providesSalesRepository() : SalesRepository {
        return SalesDataRepository()
    }
}
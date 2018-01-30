package com.post.data.di

import com.post.data.net.SalesService
import com.post.data.net.ServiceGenerator
import com.post.data.source.SalesDataSource
import com.post.data.source.remote.SalesDataSourceRemote
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/29/18.
 */
@Module
class SalesDataModule constructor() {

    @Provides
    @Singleton
    fun providesSalesDataSourceRemote() : SalesDataSource {
        return SalesDataSourceRemote();
    }
}
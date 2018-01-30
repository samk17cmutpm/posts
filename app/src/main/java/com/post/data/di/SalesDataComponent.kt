package com.post.data.di

import com.post.data.repositories.SalesDataRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/29/18.
 */
@Singleton
@Component(modules = [SalesDataModule::class])
interface SalesDataComponent {
    fun inject(mSalesDataRepository: SalesDataRepository)
}
package com.post.presentation.sales_sign_in

import com.post.di.repositories.RepositoryComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/17/18.
 */
@Singleton
@Component(dependencies = [RepositoryComponent::class], modules = [SalesSignInModule::class])
interface SalesSignInComponent {
    fun inject(salesSignInActivity: SalesSignInActivity)
}
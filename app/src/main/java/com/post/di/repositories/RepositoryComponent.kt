package com.post.di.repositories

import dagger.Component

/**
 * Created by sam_nguyen on 1/11/18.
 */
@Component(modules = [SalesRepositoryModule::class])
interface RepositoryComponent {
}
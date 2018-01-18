package com.post.di.repositories

import com.post.di.repositories.PostRepositoryModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/11/18.
 */
@Component(modules = [PostRepositoryModule::class, SalesRepositoryModule::class])
interface RepositoryComponent {
}
package com.post.di.repositories

import com.post.di.repositories.PostRepositoryModule
import dagger.Component

/**
 * Created by sam_nguyen on 1/11/18.
 */
@Component(modules = [PostRepositoryModule::class])
interface RepositoryComponent {
}
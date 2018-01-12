package com.post.di

import dagger.Component

/**
 * Created by sam_nguyen on 1/11/18.
 */
@Component(modules = arrayOf(PostRepositoryModule::class))
interface RepositoryComponent {
}
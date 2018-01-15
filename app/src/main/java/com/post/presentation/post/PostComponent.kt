package com.post.presentation.post

import com.post.di.RepositoryComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/11/18.
 */
@Singleton
@Component(dependencies = [RepositoryComponent::class], modules = [PostModule::class])
interface PostComponent {
    fun inject(postActivity: PostActivity)
}
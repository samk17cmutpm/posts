package com.post.di.repositories

import com.post.data.repositories.PostDataRepository
import com.post.domain.repositories.PostRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/11/18.
 */
@Module
class PostRepositoryModule constructor() {
    @Provides
    @Singleton
    fun providesPostRepository() : PostRepository {
        return PostDataRepository()
    }
}
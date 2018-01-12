package com.post.presentation.post

import com.post.data.repositories.PostDataRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/11/18.
 */
@Module
class PostModule constructor() {
    @Provides
    @Singleton
    fun providesPostPresenter(postDataRepository: PostDataRepository) : PostContract.Presenter {
        return PostPresenter(postDataRepository)
    }
}
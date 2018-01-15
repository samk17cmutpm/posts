package com.post.presentation.post

import com.post.data.repositories.PostDataRepository
import com.post.domain.interactors.FetchingPostInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sam_nguyen on 1/11/18.
 */
@Module
class PostModule constructor(val mView: PostContract.View) {

    @Provides
    @Singleton
    fun providesPostPresenter(mFetchingPostInteractor: FetchingPostInteractor) : PostContract.Presenter {
        return PostPresenter(mView, mFetchingPostInteractor)
    }

    @Provides
    @Singleton
    fun providesPostView() : PostContract.View {
        return mView
    }

    @Provides
    @Singleton
    fun providesFetchingPostInteractor(postDataRepository: PostDataRepository) : FetchingPostInteractor {
        return FetchingPostInteractor(postDataRepository)
    }
}
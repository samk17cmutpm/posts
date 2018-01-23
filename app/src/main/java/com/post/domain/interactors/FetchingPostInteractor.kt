package com.post.domain.interactors

import com.post.domain.ObservableUseCase
import com.post.domain.repositories.PostRepository
import com.post.data.responses.Post
import io.reactivex.Observable

/**
 * Created by sam_nguyen on 1/11/18.
 */
class FetchingPostInteractor constructor(private val mPostRepository: PostRepository) : ObservableUseCase<FetchingPostInteractor.RequestValues, List<Post>>() {

    override fun buildUseCaseObservable(requestValues: RequestValues): Observable<List<Post>> {
        return mPostRepository.fetchPost()
    }

    class RequestValues : ObservableUseCase.RequestValues
}
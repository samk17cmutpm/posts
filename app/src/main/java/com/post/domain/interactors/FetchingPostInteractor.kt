package com.post.domain.interactors

import com.post.domain.UseCase
import com.post.domain.repositories.PostRepository
import com.post.entity.Post
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/11/18.
 */
class FetchingPostInteractor constructor(val mPostRepository: PostRepository) : UseCase<FetchingPostInteractor.RequestValues, List<Post>>() {

    override fun buildUseCaseObservable(requestValues: RequestValues): Observable<Response<List<Post>>> {
        return mPostRepository.fetchPost()
    }

    class RequestValues : UseCase.RequestValues
}
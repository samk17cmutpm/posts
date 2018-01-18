package com.post.data.repositories

import com.post.data.request_params.SalesSignInParams
import com.post.domain.repositories.SalesRepository
import com.post.data.responses.Sale
import com.post.data.source.remote.SalesDataSourceRemote
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by sam_nguyen on 1/17/18.
 */
class SalesDataRepository @Inject constructor(): SalesRepository {

    /**
     * For Data From Local
     */
    private val mSalesDataSourceRemote = SalesDataSourceRemote()

    override fun signIn(salesSignInParams: SalesSignInParams): Observable<Response<Sale>> {
        return mSalesDataSourceRemote.signIn(salesSignInParams)
    }
}
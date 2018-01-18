package com.post.data.repositories

import com.post.data.mapper.SalesMapper
import com.post.data.request_params.SalesSignInParams
import com.post.domain.repositories.SalesRepository
import com.post.data.source.remote.SalesDataSourceRemote
import com.post.entity.SalesEntity
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by sam_nguyen on 1/17/18.
 */
class SalesDataRepository @Inject constructor(): SalesRepository {
    /**
     * For Data From Local
     */
    private val mSalesDataSourceRemote = SalesDataSourceRemote()

    override fun signIn(email: String, password: String): Observable<SalesEntity> {
        val salesSignInParams = SalesSignInParams(email = email, password = password)
        return mSalesDataSourceRemote.signIn(salesSignInParams).map { t ->
            val sale = t.body()
            SalesMapper.convertSalesToSalesEntity(sale!!)
        }
    }
}
package com.post.data.repositories

import com.post.data.mapper.SalesMapper
import com.post.data.request_params.SalesSignInParams
import com.post.data.responses.Sale
import com.post.data.responses.SignInHeader
import com.post.domain.repositories.SalesRepository
import com.post.data.source.remote.SalesDataSourceRemote
import com.post.entity.SalesEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.functions.Function
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by sam_nguyen on 1/17/18.
 */
class SalesDataRepository @Inject constructor(): SalesRepository {

    override fun signInWithFlowable(email: String, password: String): Flowable<SalesEntity> {
        val salesSignInParams = SalesSignInParams(email = email, password = password)
        return mSalesDataSourceRemote.signInWithFlowable(salesSignInParams).map { t ->
            if (t.isSuccessful) {
                val sale = t.body()
                val uid = t.headers().get(UID)
                val client = t.headers().get(CLIENT)
                val accessToken = t.headers().get(ACCESS_TOKEN)
                val signInHeader = SignInHeader(uid = uid, client = client, accessToken = accessToken)
                SalesMapper.convertSalesToSalesEntity(sale!!, signInHeader)
            } else{
                SalesEntity()
            }

        }
    }

    companion object {
        const val UID: String = "uid"
        const val CLIENT: String = "client"
        const val ACCESS_TOKEN: String = "access-token"
    }

    /**
     * For Data From Local
     */
    private val mSalesDataSourceRemote = SalesDataSourceRemote()

    override fun signIn(email: String, password: String): Observable<SalesEntity> {
        val salesSignInParams = SalesSignInParams(email = email, password = password)
        return mSalesDataSourceRemote.signIn(salesSignInParams).map { t ->
            if (t.isSuccessful) {
                val sale = t.body()
                val uid = t.headers().get(UID)
                val client = t.headers().get(CLIENT)
                val accessToken = t.headers().get(ACCESS_TOKEN)
                val signInHeader = SignInHeader(uid = uid, client = client, accessToken = accessToken)
                SalesMapper.convertSalesToSalesEntity(sale!!, signInHeader)
            } else{
                SalesEntity()
            }

        }
    }
}
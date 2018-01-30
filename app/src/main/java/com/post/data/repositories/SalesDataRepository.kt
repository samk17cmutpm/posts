package com.post.data.repositories

import com.post.data.di.DaggerSalesDataComponent
import com.post.data.exceptions.RemoteDataThrowable
import com.post.data.mapper.SalesMapper
import com.post.data.request_params.SalesSignInParams
import com.post.data.responses.SignInHeader
import com.post.domain.repositories.SalesRepository
import com.post.data.source.remote.SalesDataSourceRemote
import com.post.entity.SalesEntity
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by sam_nguyen on 1/17/18.
 */
class SalesDataRepository @Inject constructor(): SalesRepository {

    @Inject
    lateinit var mSalesDataSourceRemote: SalesDataSourceRemote

    init {
        DaggerSalesDataComponent.builder().build().inject(this)
    }

    override fun signInWithFlowable(email: String, password: String): Flowable<SalesEntity> {
        val salesSignInParams = SalesSignInParams(email, password)
        return mSalesDataSourceRemote.signInWithFlowable(salesSignInParams).map { t ->
            if (t.isSuccessful) {
                val sale = t.body()
                val uid = t.headers().get(UID)
                val client = t.headers().get(CLIENT)
                val accessToken = t.headers().get(ACCESS_TOKEN)
                val signInHeader = SignInHeader(uid, client, accessToken)
                SalesMapper.convertSalesToSalesEntity(sale!!, signInHeader)
            } else {
                throw RemoteDataThrowable(t.errorBody()!!.string(), t.code())
            }
        }
    }

    companion object {
        const val UID: String = "uid"
        const val CLIENT: String = "client"
        const val ACCESS_TOKEN: String = "access-token"
    }


}
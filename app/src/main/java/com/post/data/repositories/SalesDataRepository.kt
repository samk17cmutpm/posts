package com.post.data.repositories

import com.post.data.request_params.SalesSignInParams
import com.post.domain.repositories.SalesRepository
import com.post.data.responses.Sale
import com.post.data.source.remote.SalesDataSourceRemote
import com.post.entity.SalesEntity
import io.reactivex.Observable
import io.reactivex.functions.Function
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

    override fun signIn(salesSignInParams: SalesSignInParams): Observable<SalesEntity> {
        return mSalesDataSourceRemote.signIn(salesSignInParams).map(object : Function<Response<Sale>, SalesEntity>{
            override fun apply(t: Response<Sale>): SalesEntity {
                val sale = t.body()
                return SalesEntity(image = sale?.image!!, name = sale?.name!!, id = sale?.id!!)
            }
        })
    }
}
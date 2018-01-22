package com.post.data.mapper

import com.post.data.responses.Sale
import com.post.data.responses.SignInHeader
import com.post.entity.SalesEntity

/**
 * Created by sam_nguyen on 1/18/18.
 */
class SalesMapper private constructor(){
    companion object {
        fun convertSalesToSalesEntity(sale: Sale, signInHeader: SignInHeader) : SalesEntity {
            return SalesEntity(
                    image = sale.image,
                    name = sale.name,
                    email = sale.email,
                    id = sale.id,
                    uuid = signInHeader.uid,
                    accessToken = signInHeader.accessToken,
                    client = signInHeader.client
            )
        }
    }
}
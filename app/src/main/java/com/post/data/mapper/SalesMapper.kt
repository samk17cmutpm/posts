package com.post.data.mapper

import com.post.data.responses.Sale
import com.post.entity.SalesEntity

/**
 * Created by sam_nguyen on 1/18/18.
 */
class SalesMapper {
    companion object {
        fun convertSalesToSalesEntity(sale: Sale) : SalesEntity {
            return SalesEntity(
                    image = sale.image,
                    name = sale.name,
                    email = sale.email,
                    id = sale.id
            )
        }
    }
}
package kz.sd.shop.network

import com.google.android.gms.common.api.Api
import kz.sd.shop.models.ApiResponse

interface AmazonRepository {
    suspend fun searchProducts(query:String): ApiResponse?

}
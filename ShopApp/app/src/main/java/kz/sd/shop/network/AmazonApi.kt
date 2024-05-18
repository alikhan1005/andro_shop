package kz.sd.shop.network

import kz.sd.shop.models.ApiResponse
import kz.sd.shop.models.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface AmazonApi {
    @GET("search")
    suspend fun searchProducts(
        @Query("query") query: String,
        @Query("page") page:String,
        @Query("country") country:String,
    ): Response<ApiResponse>
}
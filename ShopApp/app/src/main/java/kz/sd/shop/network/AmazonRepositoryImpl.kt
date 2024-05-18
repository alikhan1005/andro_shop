package kz.sd.shop.network

import kz.sd.shop.models.ApiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AmazonRepositoryImpl @Inject constructor(
    val api: AmazonApi
) : AmazonRepository {

    override suspend fun searchProducts(query:String): ApiResponse? {
        val response = api.searchProducts(query, "1", "US")
        if(response.isSuccessful) return response.body()
        else throw Exception(response.message())
    }

}
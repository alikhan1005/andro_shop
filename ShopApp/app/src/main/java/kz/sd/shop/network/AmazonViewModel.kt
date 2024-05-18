package kz.sd.shop.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kz.sd.shop.base.BaseViewModel
import kz.sd.shop.models.ApiResponse
import javax.inject.Inject


@HiltViewModel
class AmazonViewModel @Inject constructor(
    private var repository: AmazonRepository
) : BaseViewModel() {

    private var _amazonLiveDate = MutableLiveData<ApiResponse?>()
    var amazonLiveDate: LiveData<ApiResponse?> = _amazonLiveDate


    fun searchProducts(query:String) {
        launch(
            request = {
                repository.searchProducts(query)
            },
            onSuccess = {
                _amazonLiveDate.postValue(it)
            }
        )
    }
    fun searchLaptops(){
        launch(
            request = {
                repository.searchProducts("Laptop")
            },
            onSuccess = {
                _amazonLiveDate.postValue(it)
            }
        )
    }
}
package com.example.daggerproject


import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggerproject.echomodel.EchoRequestModel
import io.reactivex.disposables.CompositeDisposable
import com.example.daggerproject.data.DataRepository
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(private var dataRepository: DataRepository) :
    ViewModel() {

    private val bag = CompositeDisposable()


    //    var locationDetailLiveData: MutableLiveData<LocationDetails> = MutableLiveData()


    /*fun getLocationDetails(entityId: String, entityType: String): MutableLiveData<LocationDetails> {
        locationDetailLiveData.value?.let {
            return locationDetailLiveData
        }
        loadCity(entityId, entityType)

        return locationDetailLiveData
    }


    fun loadCity(entityId: String, entityType: String) {
        compositeDisposable + dataRepository
            .locationDetails(entityId, entityType)
            .subscribe({
                locationDetailLiveData.postValue(it)
            }, {
                it.cause
            })
    }*/


    fun echo(echoRequestModel: EchoRequestModel) {
        dataRepository.echo(echoRequestModel)
            .subscribe({
                Log.d("MainActivity", "echo-success:$it ");
            }, {
                it.printStackTrace()
                Log.d("MainActivity", "echo-error:$it ");
            }, {
                Log.d("MainActivity", "echo-completed:");
            })
    }

    override fun onCleared() {
        bag.clear()
        super.onCleared()
    }

}
package com.example.daggerproject.data


import com.example.daggerproject.App
import com.example.daggerproject.data.network.Routes
import com.example.daggerproject.echomodel.EchoRequestModel
import com.example.daggerproject.echomodel.EchoResponseModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class AppDataRepository(
    private var app: App,
    private var apiService: Routes
) : DataRepository {


    override fun echo(echoRequestModel: EchoRequestModel): Observable<EchoResponseModel> {
        return apiService.echo(echoRequestModel)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())

    }

}
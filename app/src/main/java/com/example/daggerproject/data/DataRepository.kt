package com.example.daggerproject.data

import com.example.daggerproject.echomodel.EchoRequestModel
import com.example.daggerproject.echomodel.EchoResponseModel
import io.reactivex.Observable

interface DataRepository {

    fun echo(echoRequestModel: EchoRequestModel): Observable<EchoResponseModel>

}

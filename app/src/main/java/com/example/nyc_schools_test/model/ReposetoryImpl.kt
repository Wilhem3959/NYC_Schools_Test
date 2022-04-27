package com.example.nyc_schools_test.model

import com.example.nyc_schools_test.model.remote.NycApi
import com.example.nyc_schools_test.model.remote.SchoolListResponse
import com.example.nyc_schools_test.model.remote.SchoolSatResponse
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ReposetoryImpl:Repository {

    private val service = NycApi.initRetrofit()

    override fun useCaseSchoolList(): Flow<UIState> {
        return flow{
            emit(UIState.Loading(true))
            delay(500)
            val response = service.getSchoolList()
            emit(UIState.Loading())

            if(response.isSuccessful){
                response.body()?.let {
                    emit(
                        UIState.ResponseListSchool(it))
                }?:emit(UIState.Error(response.message()))
            }else{
                UIState.Error(response.message())
            }
        }

    }

    override fun useCaseSchoolSatByDBN(): (dbn: String) -> Flow<SchoolSatResponse> {
        TODO("Not yet implemented")
    }
}


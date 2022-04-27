package com.example.nyc_schools_test.model

import com.example.nyc_schools_test.model.remote.SchoolListResponse
import com.example.nyc_schools_test.model.remote.SchoolSatResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface Repository
{
    fun useCaseSchoolList(): Flow<UIState>
    fun useCaseSchoolSatByDBN(): (dbn : String) -> Flow<SchoolSatResponse>
}
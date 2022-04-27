package com.example.nyc_schools_test.model

import androidx.lifecycle.LiveData
import com.example.nyc_schools_test.model.remote.SchoolListResponse
import com.example.nyc_schools_test.model.remote.SchoolSatResponse

sealed class UIState
{
    data class ResponseListSchool(val data: List<SchoolListResponse>) : UIState()
    data class ResponseSchoolSat(val data: List<SchoolSatResponse>) : UIState()
    data class Error(val errorMessage: String) : UIState()
    data class Loading(val isLoading: Boolean = false) : UIState()
}
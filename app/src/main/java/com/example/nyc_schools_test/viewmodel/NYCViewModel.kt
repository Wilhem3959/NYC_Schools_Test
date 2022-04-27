package com.example.nyc_schools_test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nyc_schools_test.model.Repository
import com.example.nyc_schools_test.model.remote.SchoolListResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NYCViewModel(private val repository: Repository) : ViewModel()
{
    private val _schoolList = MutableLiveData<List<SchoolListResponse>>()
    val schoolList: LiveData<List<SchoolListResponse>>
    get() = _schoolList

    init {
        getSchoolList()
    }

    /**
     * Coroutine define container
     * Launch. create and forget
     * Async. create and wait
     *
     * Dispatchers.IO. - Network calls, database transactions, java.io.file
     * Dispatchers.Main. - Main thread reference.
     * Dispatchers.Default. - Default Thread pool.
     * Dispatchers.Unconfined. - Dont use! ANR (application not responding)
     */

    private fun getSchoolList()
    {
        CoroutineScope(Dispatchers.IO).launch{
            repository.useCaseSchoolList()
                .collect {
                _schoolList.value = it
            }
        }
    }
}
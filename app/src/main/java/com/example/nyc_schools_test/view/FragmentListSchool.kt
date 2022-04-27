package com.example.nyc_schools_test.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nyc_schools_test.databinding.ListSchoolFragmentLayoutBinding
import com.example.nyc_schools_test.model.ReposetoryImpl
import com.example.nyc_schools_test.model.Repository
import com.example.nyc_schools_test.viewmodel.NYCViewModel

class FragmentListSchool: Fragment() {
    private lateinit var binding: ListSchoolFragmentLayoutBinding
    private val viewModel: NYCViewModel by lazy {
        ViewModelProvider(this,object :  ViewModelProvider.Factory
        {
            override fun <T : ViewModel?>
                    create(modelClass: Class<T>): T {
                return NYCViewModel(repository) as T
            }
        })[NYCViewModel::class.java]
    }
    private val repository: Repository by lazy {
        ReposetoryImpl()
    }
    override fun onCreate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        super.onCreate(inflater, container, savedInstanceState)
        binding = ListSchoolFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root

    }

}

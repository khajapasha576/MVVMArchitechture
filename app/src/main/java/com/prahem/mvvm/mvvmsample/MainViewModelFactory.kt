package com.prahem.mvvm.mvvmsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory() : ViewModelProvider.Factory {
    override fun <viewModel : ViewModel?> create(modelClass: Class<viewModel>): viewModel {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as viewModel
        }
        throw IllegalArgumentException("UnknownViewModel")
    }

}
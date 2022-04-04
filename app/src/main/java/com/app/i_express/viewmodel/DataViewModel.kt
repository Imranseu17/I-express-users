package com.app.i_express.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.i_express.data.DataRepo
import com.app.i_express.data.model.BaseResponse
import com.app.i_express.data.model.User

class DataViewModel: ViewModel() {

    val text: LiveData<String> = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }

    fun login(user: User): LiveData<BaseResponse> {
        return DataRepo.login(user)
    }
}
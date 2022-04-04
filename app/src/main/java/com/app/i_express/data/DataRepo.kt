package com.app.i_express.data

import androidx.lifecycle.MutableLiveData
import com.app.i_express.data.model.BaseResponse
import com.app.i_express.data.model.User
import com.app.i_express.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataRepo {

    fun login(user: User): MutableLiveData<BaseResponse> {
        val data : MutableLiveData<BaseResponse> = MutableLiveData()
        ApiClient.create().loginUser(user).enqueue(object : Callback<BaseResponse?> {
            override fun onResponse(call: Call<BaseResponse?>, response: Response<BaseResponse?>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<BaseResponse?>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}
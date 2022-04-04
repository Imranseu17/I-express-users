package com.app.i_express.data.remote

import com.app.i_express.data.model.BaseResponse
import com.app.i_express.data.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

import retrofit2.http.Body


interface ApiEndPoint {

    @POST("login")
    fun loginUser(@Body user: User): Call<BaseResponse>
}
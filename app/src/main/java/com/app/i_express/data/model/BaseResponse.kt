package com.app.i_express.data.model

data class BaseResponse(
    var status: Int = 0,
    val msg: String?,
    val data: Any
)
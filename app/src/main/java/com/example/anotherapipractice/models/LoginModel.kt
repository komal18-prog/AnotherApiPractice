package com.example.anotherapipractice.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginModel(
    @SerializedName("status") var status: Int? = null,
    @SerializedName("Code") var Code: Int? = null,
    @SerializedName("data") var data: Data? = Data(),
    @SerializedName("message") var message: String? = null,
    @SerializedName("errors") var errors: String? = null
)

class Data : Serializable

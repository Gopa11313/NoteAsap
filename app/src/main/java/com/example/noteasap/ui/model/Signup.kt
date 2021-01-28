package com.example.noteasap.UI.model

import com.google.gson.annotations.SerializedName

class Signup(
    @SerializedName("user_name") val userName: String?,
    @SerializedName("user_email") val userEmail: String?,
    @SerializedName("user_password") val userAge: String?,
    @SerializedName("user_image") val userImage: String?
) {
}
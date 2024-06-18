package com.devissvtr.peaktime.network.retrofit

import com.devissvtr.peaktime.network.response.RegisterResponse
import com.devissvtr.peaktime.ui.customviews.CustomPassword
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    //login api
    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    )

    //register api
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("email") email: String
    ): RegisterResponse

    //form api

    //
}
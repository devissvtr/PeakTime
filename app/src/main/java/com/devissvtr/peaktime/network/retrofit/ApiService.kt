package com.devissvtr.peaktime.network.retrofit

import com.devissvtr.peaktime.network.preference.FormData
import com.devissvtr.peaktime.network.response.AutenticationHandler
import com.devissvtr.peaktime.network.response.FormRequest
import com.devissvtr.peaktime.network.response.FormResponse
import com.devissvtr.peaktime.network.response.NotificationRequest
import com.devissvtr.peaktime.network.response.NotificationResponse
import com.devissvtr.peaktime.network.response.PredictionResponse
import com.devissvtr.peaktime.network.response.PredictionResult
import com.devissvtr.peaktime.network.response.RegisterResponse
import com.devissvtr.peaktime.network.response.ScheduleRequest
import com.devissvtr.peaktime.network.response.ScheduleResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

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
    @POST("users")
    suspend fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): RegisterResponse

    @FormUrlEncoded
    @POST("users/{userId}")
    suspend fun autenticationHandler(
        @Field("code") code: String
    ): AutenticationHandler

    //form api
    @POST("users/{userId}/forms")
    suspend fun formData(
        @Path("userId") userId: String,
        @Body formRequest: FormRequest
    ): FormResponse

    //result prediction
    @POST("users/{userId}/model")
    suspend fun createPrediction(
        @Path("userId") userId: String
    ): PredictionResponse

    //visual prediction
    @GET("users/{userId}/visuals")
    suspend fun resultPrediction(
        @Path("userId") userId: String
    ): PredictionResult

    //schedule
    @POST("users/{userId}/events")
    suspend fun createSchedule(
        @Path("userId") userId: String,
        @Body eventRequest: ScheduleRequest
    ): Call<ScheduleResponse>

    //notifications
    @POST("users/{userId}/notifications")
    fun notification(
        @Path("userId") userId: String,
        @Body notificationRequest: NotificationRequest
    ): Call<NotificationResponse>
}
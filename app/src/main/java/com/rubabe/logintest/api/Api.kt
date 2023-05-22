package com.rubabe.logintest.api

import com.rubabe.logintest.model.Students
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("login.php")

    fun checkLoginStudent(@Query("username") username: String, @Query("password") password: String): Call<List<Students>>
}
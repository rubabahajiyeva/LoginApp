package com.rubabe.logintest

import com.rubabe.logintest.api.Api
import com.rubabe.logintest.network.RetrofitClient

class Constants {
    companion object {
        private const val BASE_URL = "https://unibook1234.000webhostapp.com/"

        fun getAPI(): Api {
            return RetrofitClient.getClient(BASE_URL).create(Api::class.java)
        }
    }
}
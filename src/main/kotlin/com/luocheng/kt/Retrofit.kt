package com.luocheng.kt

import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

suspend fun main() {
    val user = api.getUserCallback("luochengyeyu")
    println(user)
}


val api by lazy {
    val retrofit = retrofit2.Retrofit.Builder()
        .client(OkHttpClient.Builder().addInterceptor {
            it.proceed(it.request()).apply {
                println("request: ${code()}")
            }
        }.build())
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    retrofit.create(GitHubApi::class.java)
}

interface GitHubApi {

    @GET("users/{login}")
    suspend fun getUserCallback(@Path("login") login: String): User
}

data class User(val id: String, val name: String, val url: String)


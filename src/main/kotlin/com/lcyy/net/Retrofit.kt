package com.lcyy.net

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

suspend fun main() {
//    val user = api.getUserCallback("luochengyeyu")
//    println(user)

    api.getUserCallback2("luochengyeyu").enqueue(object : Callback<User> {
        override fun onResponse(call: Call<User>, response: Response<User>) {
            response.body()?.let {
                println(it)
            }
        }

        override fun onFailure(call: Call<User>, t: Throwable) {
            t.printStackTrace()
        }

    })
}

val api: GitHubApi by lazy {
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    retrofit.create(GitHubApi::class.java)
}

interface GitHubApi {

    @GET("users/{login}")
    suspend fun getUserCallback(@Path("login") login: String): User

    @GET("users/{login}")
    fun getUserCallback2(@Path("login") login: String): Call<User>

}

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String
)
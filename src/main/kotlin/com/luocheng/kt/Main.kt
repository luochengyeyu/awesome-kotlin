package com.luocheng.kt

import com.luocheng.kt.utils.log
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.suspendCoroutine

fun main() = runBlocking{
    val hello = hello()
    log(hello.toString())
}

suspend fun hello() = suspendCoroutine { continuation ->
    log("hello()")
    continuation.resumeWith(Result.success(10086))
}

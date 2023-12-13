package com.lcyy.di

fun main() {
    val engine = Engine()
    val car = Car(engine)
    car.start()
}

class Car(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

class Engine {
    fun start() {
        println("---- > 启动引擎 <----")
    }
}
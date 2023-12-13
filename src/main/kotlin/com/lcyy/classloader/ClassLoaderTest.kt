package com.lcyy.classloader

class Person{
    companion object{
        // 相当于Java中的static代码块
        init {
            println("init{}")
        }
    }
}
fun main() {
    // Class.forName 会执行初始化块
//    Class.forName("com.lcyy.features.Person")
    // loadClass 不会加载初始化块
//    Person::class.java.classLoader.loadClass("com.lcyy.features.Person")
    var classLoader = Person::class.java.classLoader
//    while (classLoader != null) {
//        println("ClassLoader：$classLoader");
//        classLoader = classLoader.getParent();
//    }
}
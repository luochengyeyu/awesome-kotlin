plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}
repositories {
    mavenCentral()
}

gradlePlugin{
    plugins{
        register("hello-plugin"){
            id = "com.lcyy.hello"
            implementationClass = "com.lcyy.GreetingPlugin"
        }

    }
}
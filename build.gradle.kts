plugins {
    kotlin("jvm") version "1.9.0"
//    id("com.lcyy.hello")
}
group = "com.lcyy"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    // https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-moshi
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    // https://mvnrepository.com/artifact/com.squareup.moshi/moshi-kotlin
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")


    testImplementation(kotlin("test"))
}
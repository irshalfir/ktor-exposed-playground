val ktor_version: String by project
val kotlin_version: String by project
val kotlin_serialization_version: String by project
val exposed_version: String by project
val mysql_connector_version: String by project
val logback_version: String by project
val kodein_version: String by project

plugins {
    application
    kotlin("jvm") version "1.3.70"
    kotlin("plugin.serialization") version "1.3.70"

}

group = "com.playground.ktor"
version = "0.0.1"

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

repositories {
    mavenLocal()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", "$kotlin_version")
    implementation("org.jetbrains.kotlinx", "kotlinx-serialization-runtime-common", "$kotlin_serialization_version")
    implementation("org.jetbrains.exposed", "exposed-core", "$exposed_version")
    implementation("org.jetbrains.exposed", "exposed-dao", "$exposed_version")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "$exposed_version")
    implementation("org.jetbrains.exposed", "exposed-java-time", "$exposed_version")

    implementation("io.ktor", "ktor-server-netty", "$ktor_version")
    implementation("io.ktor", "ktor-server-core", "$ktor_version")
    implementation("io.ktor", "ktor-serialization", "$ktor_version")
    testImplementation("io.ktor", "ktor-server-tests", "$ktor_version")

    implementation("mysql", "mysql-connector-java", "$mysql_connector_version")

    implementation("ch.qos.logback", "logback-classic", "$logback_version")
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")

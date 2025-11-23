plugins {
    id("java")
    kotlin("jvm")
}

group = "br.com.java-lab"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val lombokVersion = "1.18.42"
val slf4jVersion = "2.0.17"
val logbackVersion = "1.4.11"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Lombok
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    // SLF4J
    implementation("org.slf4j:slf4j-api:$slf4jVersion")

    // Runtime com Logback
    runtimeOnly("ch.qos.logback:logback-classic:$logbackVersion")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
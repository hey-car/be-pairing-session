import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
import org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    val kotlinVersion = "1.5.10"
    idea
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    id("org.springframework.boot") version "2.5.1"
    id("com.adarshr.test-logger") version "3.0.0"
}

repositories {
    mavenCentral()
}

// https://docs.gradle.org/current/samples/sample_jvm_multi_project_with_additional_test_types.html
val integrationTest: SourceSet by sourceSets.creating

integrationTest.run {
    compileClasspath += sourceSets["main"].output + sourceSets["test"].output + configurations["testRuntimeClasspath"]
    runtimeClasspath += output + compileClasspath + sourceSets["test"].runtimeClasspath
}

idea {
    module {
        sourceDirs.remove(integrationTest)
        resourceDirs.remove(integrationTest.resources)
        testSourceDirs.addAll(integrationTest.allSource)
        testResourceDirs.addAll(integrationTest.resources)
    }
}

defaultTasks = mutableListOf("clean", "build", "integrationTest")

tasks {
    withType<Test> {
        testLogging {
            exceptionFormat = FULL
            showStandardStreams = true
            events = setOf(PASSED, FAILED, SKIPPED)
            showExceptions = true
            showCauses = true
            showStackTraces = true
        }
        useJUnitPlatform()
        systemProperty("spring.profiles.active", "test")
    }

    withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "11"
        doFirst {
            sourceSets.forEach {
                it.allSource.srcDirs.forEach {
                    it.mkdirs()
                }
            }
        }
    }

    register<Test>("integrationTest") {
        description = "Runs integration tests"
        group = "verification"
        testClassesDirs = integrationTest.output.classesDirs
        classpath = integrationTest.runtimeClasspath
        systemProperty(
            "spring.profiles.active",
            "integrationTest,${environment["SPRING_PROFILES_ACTIVE"]}"
        )
    }
}

dependencies {
    implementation(platform(SpringBootPlugin.BOM_COORDINATES))
    kapt(platform(SpringBootPlugin.BOM_COORDINATES))

    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    //csv
    implementation("com.opencsv:opencsv:5.2")

    // Database
    runtimeOnly("com.h2database:h2")

    kapt("org.springframework.boot:spring-boot-configuration-processor")

    // Spring Boot Tests
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        exclude(group = "org.mockito", module = "mockito-junit-jupiter")
        exclude(group = "org.mockito", module = "mockito-core")
    }

    // Kotlin
    implementation(kotlin("stdlib"))
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    // Tests
    testImplementation("org.mockito.kotlin:mockito-kotlin:${properties["mockitoKotlin"]}")
}

// To be windows friendly
fun ExecSpec.osCommandLine(vararg args: String): ExecSpec {
    val prefixed = if (Os.isFamily(Os.FAMILY_WINDOWS)) {
        listOf("cmd", "/c", "bash")
    } else emptyList()
    return commandLine(prefixed + args)
}

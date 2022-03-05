import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.springframework.boot") version "2.6.4" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
}

allprojects {
    apply {
        plugin("java-library")
        plugin("maven-publish")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    group = "uno.d1s"
    version = "1.1.1-stable.0"
    java.sourceCompatibility = JavaVersion.VERSION_11

    repositories {
        mavenCentral()
    }

    extra["striktVersion"] = "0.34.1"
    extra["mockkVersion"] = "1.12.3"
    extra["junitVersion"] = "5.8.2"

    dependencies {
        implementation(kotlin("stdlib"))
        testImplementation("org.junit.jupiter:junit-jupiter-api:${property("junitVersion")}")
        testImplementation("io.strikt:strikt-jvm:${property("striktVersion")}")
        testImplementation("io.mockk:mockk:${property("mockkVersion")}")
    }

    tasks.withType<Test> {
        useJUnitPlatform()

        testLogging {
            events.addAll(
                listOf(
                    org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
                    org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
                    org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED
                )
            )
        }
    }

    tasks.withType<KotlinCompile> {
        targetCompatibility = "11"
    }

    tasks.withType<Jar> {
        archiveClassifier.set("")
    }

    tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
        enabled = false
    }

    tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootBuildImage> {
        enabled = false
    }

    tasks.withType<org.springframework.boot.gradle.tasks.run.BootRun> {
        enabled = false
    }


    kotlin {
        explicitApi = org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode.Warning
    }
}

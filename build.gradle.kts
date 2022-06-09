import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.0"
}

allprojects {
    apply {
        plugin("java-library")
        plugin("maven-publish")
        plugin("org.jetbrains.kotlin.jvm")
    }

    group = "dev.d1s"
    version = "7.5.1-stable.2"
    java.sourceCompatibility = JavaVersion.VERSION_11

    repositories {
        mavenCentral()
    }

    val striktVersion: String by project
    val mockkVersion: String by project
    val junitVersion: String by project

    dependencies {
        implementation(kotlin("stdlib"))
        testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
        testImplementation("io.strikt:strikt-jvm:$striktVersion")
        testImplementation("io.mockk:mockk:$mockkVersion")
    }

    tasks.withType<Test> {
        enabled = false

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
        kotlinOptions.jvmTarget = "11"
    }

    tasks.withType<Jar> {
        archiveClassifier.set("")
    }

    kotlin {
        explicitApiWarning()
    }
}

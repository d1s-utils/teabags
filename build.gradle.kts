import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}

allprojects {
    apply {
        plugin("maven-publish")
        plugin("org.jetbrains.kotlin.jvm")
    }

    group = "dev.d1s"
    version = "8.0.0-stable.0"
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

        kotlinOptions {
            freeCompilerArgs = listOf("-Xexplicit-api=strict")
        }
    }

    tasks.withType<Jar> {
        archiveClassifier.set("")
    }
}

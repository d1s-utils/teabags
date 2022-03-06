apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

val junitVersion: String by project

dependencies {
    compileOnly("org.springframework.boot:spring-boot-starter-logging")
    testImplementation("org.springframework.boot:spring-boot-starter-logging")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

publishing {
    publications {
        create<MavenPublication>("teabag-spring-logging") {
            from(components["java"])
        }
    }
}
dependencies {
    compileOnly("org.springframework.boot:spring-boot-starter-web")
    testImplementation(project(":teabag-testing"))
    testImplementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

publishing {
    publications {
        create<MavenPublication>("teabag-spring-web") {
            from(components["java"])
        }
    }
}
val log4jVersion: String by project

dependencies {
    api("org.apache.logging.log4j:log4j-api:$log4jVersion")
}

publishing {
    publications {
        create<MavenPublication>("teabag-log4j") {
            from(components["java"])
        }
    }
}
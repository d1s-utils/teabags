val log4jVersion: String by project
val junitVersion: String by project

dependencies {
    api("org.apache.logging.log4j:log4j-api:$log4jVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

publishing {
    publications {
        create<MavenPublication>("teabag-log4j") {
            from(components["java"])
        }
    }
}
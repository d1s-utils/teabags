val slf4jVersion: String by project
val junitVersion: String by project

dependencies {
    api("org.slf4j:slf4j-api:$slf4jVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

publishing {
    publications {
        create<MavenPublication>("teabag-slf4j") {
            from(components["java"])
        }
    }
}
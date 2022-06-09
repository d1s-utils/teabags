val slf4jVersion: String by project

dependencies {
    api("org.slf4j:slf4j-api:$slf4jVersion")
}

publishing {
    publications {
        create<MavenPublication>("teabag-slf4j") {
            from(components["java"])
        }
    }
}
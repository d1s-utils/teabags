val junitVersion: String by project

dependencies {
    testImplementation(project(":teabag-testing"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

publishing {
    publications {
        create<MavenPublication>("teabag-stdlib") {
            from(components["java"])
        }
    }
}
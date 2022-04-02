dependencies {
    implementation(project(":teabag-stdlib"))
    testImplementation(project(":teabag-testing"))
}

publishing {
    publications {
        create<MavenPublication>("teabag-dto") {
            from(components["java"])
        }
    }
}
publishing {
    publications {
        create<MavenPublication>("teabag-dto") {
            from(components["java"])
        }
    }
}
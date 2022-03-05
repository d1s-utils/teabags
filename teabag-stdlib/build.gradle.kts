publishing {
    publications {
        create<MavenPublication>("teabag-stdlib") {
            from(components["java"])
        }
    }
}
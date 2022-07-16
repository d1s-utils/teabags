val mapstructVersion: String by project
val junitVersion: String by project

dependencies {
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

publishing {
    publications {
        create<MavenPublication>("teabag-mapstruct") {
            from(components["java"])
        }
    }
}
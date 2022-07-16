val hibernateVersion: String by project
val junitVersion: String by project

dependencies {
    compileOnly("org.hibernate.orm:hibernate-core:$hibernateVersion")
    testImplementation(project(":teabag-testing"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

publishing {
    publications {
        create<MavenPublication>("teabag-hibernate") {
            from(components["java"])
        }
    }
}
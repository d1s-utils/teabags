val hibernateVersion: String by project

dependencies {
    compileOnly("org.hibernate.orm:hibernate-core:$hibernateVersion")
}

publishing {
    publications {
        create<MavenPublication>("teabag-hibernate") {
            from(components["java"])
        }
    }
}
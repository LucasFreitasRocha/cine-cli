// Removed Ant ReplaceTokens in favor of expand with Providers

plugins {
	java
	id("org.springframework.boot") version "3.5.6"
	id("io.spring.dependency-management") version "1.1.7"
    id("application")


}

group = "io.github.lucasfreitasrocha"
version = "0.0.1-SNAPSHOT"
description = "cli"


springBoot {
    mainClass = "io.github.lucasfreitasrocha.cine_cli.App"
}


java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}



dependencies {


    implementation("com.fasterxml.jackson.core:jackson-databind:2.20.0")

	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.processResources {
    // Use Providers to be compatible with configuration cache
    val baseUrl = providers.gradleProperty("BASE_URL")
        .orElse(providers.environmentVariable("BASE_URL"))
        .orElse("")
    val apiKey = providers.gradleProperty("API_KEY")
        .orElse(providers.environmentVariable("API_KEY"))
        .orElse("")

    // Declare inputs for task up-to-date checks and configuration cache friendliness
    inputs.property("token.BASE_URL", baseUrl)
    inputs.property("token.API_KEY", apiKey)

    filesMatching("application.yml") {
        // SimpleTemplateEngine-style expansion: ${BASE_URL}, ${API_KEY}
        expand(
            mapOf(
                "BASE_URL" to baseUrl.get(),
                "API_KEY" to apiKey.get()
            )
        )
        filteringCharset = "UTF-8"
    }
}

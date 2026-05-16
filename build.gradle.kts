plugins {
    kotlin("jvm") version "2.3.21"
    application
}

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java.srcDirs("source")
        kotlin.srcDirs("source")
    }
}

application {
    mainClass.set("source.Main")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

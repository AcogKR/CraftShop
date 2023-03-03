import kr.entree.spigradle.kotlin.lombok
import kr.entree.spigradle.kotlin.protocolLib
import kr.entree.spigradle.kotlin.spigot
import kr.entree.spigradle.kotlin.vault

plugins {
    java
    id("kr.entree.spigradle") version "2.4.3"
}

repositories {
    mavenLocal()
    vault()
    protocolLib()
}

dependencies {
    //compileOnly(vault())
    compileOnly(protocolLib())
    compileOnly(spigot("1.19.2"))

    compileOnly("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
    testCompileOnly("org.projectlombok:lombok:1.18.20")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.20")

    compileOnly("io.typecraft:command-bukkit:0.7.0")
    //compileOnly("dev.acog:pluginhelper-core:2.0.0")
}

spigot {
    name = "CraftShop"
    apiVersion = "1.19"
    authors = listOf("Acog")
    website = "https://github.com/Acogkr/${name}"

    commands {
        create("shop") {
            description = "CraftShop Base Command"
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
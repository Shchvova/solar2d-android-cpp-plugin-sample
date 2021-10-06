buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.70"))
        classpath("com.android.tools.build:gradle:4.2.1")
        classpath("com.beust:klaxon:5.0.1")
    }
}

val nativeDir : String = if (System.getProperty("os.name").toLowerCase().contains("windows")) {
    System.getenv("CORONA_ROOT")
} else {
    "${System.getenv("HOME")}/Library/Application Support/Corona/Native/"
}
rootProject.ext.set("s2dNative", nativeDir)

allprojects {
    repositories {
        google()
        jcenter()
        // maven(url = "https:// some custom repo")
        flatDir {
            dirs("$nativeDir/Corona/android/lib/gradle", "$nativeDir/Corona/android/lib/Corona/libs")
        }
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

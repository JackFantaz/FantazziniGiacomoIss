plugins {
    application
}

repositories {
    jcenter()
    flatDir { dirs("../../unibolibs") }
}

dependencies {
    testImplementation("junit:junit:4.13")
    implementation("com.google.guava:guava:29.0-jre")
    implementation("org.json:json:20201115")
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("uniboIssSupport:IssWsHttpJavaSupport")
}

application {
    mainClass.set("cautiousExplorerActors.App")
}

plugins {
    java
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.todocoder.gradle"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

//repositories {
//    mavenCentral()
//}
repositories {
    maven {
        setUrl("https://maven.aliyun.com/repository/public/")
    }
    maven {
        setUrl("https://maven.aliyun.com/repository/spring/")
    }
    mavenCentral()
}
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
val jarname= String.format("%s-%s.jar",project.name,version)
// 定义拷贝文件任务
val copyConfigFile by tasks.registering(Copy::class) {
    dependsOn("bootJar")
    // 清除 app 目录的历史文件
    delete("app/")
    // 从 build/libs/ 目录复制 jar 包到 app/ 目录
    from("build/libs/$jarname")
    into("app/")
    // 重命名成我们要的名字
    rename(jarname, "${project.name}.jar")
}

// 定义构建 TodoCoderJar 任务
val buildTodoCoderJar by tasks.registering {
    dependsOn("clean", copyConfigFile)
}

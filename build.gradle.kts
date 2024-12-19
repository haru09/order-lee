plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	id("war")
}

tasks.war {
	archiveFileName.set("order-lee.war")
}

group = "com.prod"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-jdbc") // DB연결을 위한 JDBC

	/* Spring Security 추가
	 * 포함된 의존성 목록
	 * 1. spring-security-core
	 * 2. spring-security-config
	 * 3. spring-security-web
	 */
	implementation("org.springframework.boot:spring-boot-starter-security")

	//https://shanepark.tistory.com/466
	//implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.2.2") // Mybatis
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")


	//runtimeOnly("com.mysql:mysql-connector-j") 			// Mysql Connector
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")    // mariadb connector
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.junit.jupiter:junit-jupiter-api")

	// https://mvnrepository.com/artifact/com.github.ulisesbocchio/jasypt-spring-boot-starter
	implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")

}
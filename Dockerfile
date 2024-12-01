FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml ./

COPY src ./src

COPY application.log ./

RUN mvn clean package

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/VerveRestService-1.0-jar-with-dependencies.jar /app/api-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/api-service.jar"]

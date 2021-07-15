FROM maven:3.8.1-openjdk-16-slim as build
WORKDIR /callbackhandler
COPY pom.xml .
COPY src  src/
RUN mvn clean package -DskipTests

FROM openjdk:16-alpine

COPY --from=build /callbackhandler/target/*.jar callbackhandler.jar
ENTRYPOINT ["java", "-jar", "callbackhandler.jar"]
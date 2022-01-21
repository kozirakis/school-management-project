FROM openjdk:11-jdk-slim-buster

ARG JAR_FILE=target/school-management-project-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app.jar" ]
FROM openjdk:11-jdk-slim-buster

COPY target/school-management-project-0.0.1-SNAPSHOT.jar school-management-project-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java -jar /school-management-project-0.0.1-SNAPSHOT.jar" ]
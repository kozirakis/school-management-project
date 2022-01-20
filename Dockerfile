FROM openjdk:11-jdk-slim-buster

ADD target/school-management-project-0.0.1-SNAPSHOT.jar school-management-project-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT [ "java","-jar /school-management-project-0.0.1-SNAPSHOT.jar" ]
FROM openjdk:8-jdk-alpine
COPY target/neo-task-0.0.1-SNAPSHOT.jar neo-task-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","neo-task-0.0.1-SNAPSHOT.jar"]
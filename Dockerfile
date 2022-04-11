FROM adoptopenjdk/openjdk11:latest
ADD target/spring-book-service-0.0.1-SNAPSHOT.jar spring-book-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-book-service-0.0.1-SNAPSHOT.jar"]
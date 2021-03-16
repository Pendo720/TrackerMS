FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/trackerms-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
FROM openjdk:14
ADD target/trilock-service.jar trilock-service.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "trilock-service.jar"]
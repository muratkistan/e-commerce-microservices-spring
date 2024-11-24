FROM eclipse-temurin:17-jre-alpine
LABEL maintainer="muratkistan"

ENV SPRING_PROFILES_ACTIVE=docker
ADD target/customer-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/app.jar"]
#ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.profiles.active=docker"]
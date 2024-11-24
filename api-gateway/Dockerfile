FROM eclipse-temurin:17-jre-alpine
LABEL maintainer="muratkistan"

ENV SPRING_PROFILES_ACTIVE=docker
ADD target/api-gateway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8020
ENTRYPOINT ["java", "-jar", "/app.jar"]
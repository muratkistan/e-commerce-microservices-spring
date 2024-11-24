FROM eclipse-temurin:17-jre-alpine
LABEL maintainer="muratkistan"

ENV SPRING_PROFILES_ACTIVE=docker
ADD target/order-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "/app.jar"]
FROM eclipse-temurin:17-jre-alpine
LABEL maintainer="muratkistan"

VOLUME /main-app
ADD target/review-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8030
ENTRYPOINT ["java", "-jar", "/app.jar"]
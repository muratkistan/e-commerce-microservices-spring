FROM eclipse-temurin:17-jre-alpine
LABEL maintainer="muratkistan"

VOLUME /main-app
ADD target/api-gateway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8222
ENTRYPOINT ["java", "-jar", "/app.jar"]
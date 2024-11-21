FROM eclipse-temurin:17-jre-alpine
LABEL maintainer="muratkistan"

VOLUME /main-app
ADD target/product-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8050
ENTRYPOINT ["java", "-jar", "/app.jar"]
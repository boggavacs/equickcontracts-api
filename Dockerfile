FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8080

USER 1000

ENTRYPOINT ["java","-jar","app.jar"]

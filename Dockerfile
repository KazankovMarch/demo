# syntax=docker/dockerfile:1
FROM openjdk:17
WORKDIR /app
RUN ./gradle build
COPY build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar
COPY build/data/demo.mv.db /app/data/demo.mv.db
CMD ["java", "-jar", "demo.jar", "spring.datasource.url=jdbc:h2:file:/app/data/demo"]
EXPOSE 8080
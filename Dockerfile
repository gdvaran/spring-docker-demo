# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk-focal

# set work directory
WORKDIR /app

# create jar file
RUN ./mvnw install

# run the application
CMD ["./mvnw", "spring-boot:run"]

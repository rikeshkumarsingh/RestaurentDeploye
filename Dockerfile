
# Stage 1: Build stage using Maven
FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

# Stage 2: Runtime stage with minimal Java image
FROM eclipse-temurin:17-alpine
COPY --from=build /target/Restaurants-0.0.1-SNAPSHOT.jar Restaurants.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "Restaurants.jar"]

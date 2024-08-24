# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file generated by Maven/Gradle to the container
COPY target/Restaurants.jar app.jar

# Expose the port the Spring Boot app runs on (adjust this if your app runs on a different port)
EXPOSE 9090

# Run the Spring Boot app by executing the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Use the official OpenJDK image as the base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build JAR file into the container
COPY target/survey-service-0.0.1-SNAPSHOT.jar /app/survey-service.jar

# Expose port 8080 for the Spring Boot app
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "survey-service.jar"]

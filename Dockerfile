# Use official OpenJDK image as base
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the project JAR file into the container
COPY target/smart-clinic-management.jar /app/smart-clinic-management.jar

# Expose port 8080 for the Spring Boot app
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "smart-clinic-management.jar"]

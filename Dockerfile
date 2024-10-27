FROM openjdk:17-jdk-slim

# Set the working directory inside the container to /app
WORKDIR /app

# Copy the JAR file into the working directory
COPY build/libs/spring-docker.jar /app/app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
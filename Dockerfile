
# Stage 1: Build the project using Maven
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy only the pom.xml first to leverage caching
COPY pom.xml ./

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY src ./src

# Package the application (skip tests for faster builds)
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR from the build stage (adjusted to your file structure)
COPY --from=build /app/target/Portfolio_Backend-1.0.jar app.jar

# Expose port (adjust according to your app)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

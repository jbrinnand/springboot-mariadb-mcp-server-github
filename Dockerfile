# Build stage
#FROM eclipse-temurin:21-jdk-jammy AS builder
#WORKDIR /build
#COPY . .
#RUN /usr/local/bin/apache-maven-3.9.10/bin/mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Create a non-root user
RUN useradd -r -u 1001 -g root mcp-user

# Copy the jar from builder stage
COPY target/*.jar app.jar
RUN chown mcp-user:root app.jar

# Use non-root user
USER mcp-user

# Expose ports
EXPOSE 8890

# Set default environment variables
ENV JAVA_OPTS="-Xmx512m -Xms256m" \
    SPRING_PROFILES_ACTIVE=docker \
    SPRING_AI_MCP_SERVER_SSE_ENDPOINT=/sse \
    SPRING_AI_MCP_SERVER_SSE_MESSAGE_ENDPOINT=/mcp/message

# Command to run the jar
ENTRYPOINT ["java","-jar","app.jar"]
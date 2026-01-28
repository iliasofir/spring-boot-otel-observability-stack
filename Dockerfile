FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/*.jar app.jar
COPY opentelemetry-javaagent.jar agent.jar
ENTRYPOINT ["java", "-javaagent:agent.jar", "-jar", "app.jar"]
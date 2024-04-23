FROM maven:3.8.7-eclipse-temurin-19-alpine
WORKDIR /app
COPY . .
RUN mvn package
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","target/ecommerce-graduacao-exempo-api-0.0.1-SNAPSHOT.jar"]
FROM maven:3.6.3-jdk-11-slim as builder

WORKDIR /app
COPY pom.xml .

RUN mvn dependency:go-offline

COPY ./src /app/src
RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=builder /app/target/*.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

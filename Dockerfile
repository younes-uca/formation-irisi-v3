FROM maven:3.6.1-jdk-17-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package -Dmaven.test.skip

FROM openjdk:17-alpine
COPY --from=build /workspace/target/*.jar my-springboot-image.jar
EXPOSE 8036
ENTRYPOINT ["java","-jar","my-springboot-image.jar"]

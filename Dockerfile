FROM amazoncorretto:17-alpine-jdk
MAINTAINER Portfolio
COPY target/portfolio-0.0.1-SNAPSHOT.jar Portfolio-app.jar
ENTRYPOINT ["java","-jar","/Portfolio-app.jar"]
EXPOSE 8080



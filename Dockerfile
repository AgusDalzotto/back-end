FROM amazoncorretto:17-alpine-jdk
MAINTAINER Portfolio
COPY target/portfolio-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]



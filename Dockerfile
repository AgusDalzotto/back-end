FROM amazoncorretto:11-alpine-jdk
MAINTAINER AGUS
COPY target/portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
ENTRYPOINT ["java","-jar","portfolio.jar"]



FROM amazoncorretto:11-alpine-jdk
MAINTAINER abeldev
COPY target/abeldev-0.0.1-SNAPSHOT.jar abel-app.jar
ENTRYPOINT ["java","-jar", "/abel-app.jar"]

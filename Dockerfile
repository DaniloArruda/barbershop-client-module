FROM amazoncorretto:11-alpine-jdk
LABEL maintainer="DaniloArruda"
COPY target/*.jar application.jar
ENTRYPOINT ["java","-jar","/application.jar"]
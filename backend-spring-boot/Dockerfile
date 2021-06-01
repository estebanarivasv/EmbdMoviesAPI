# Spring-boot JDK
FROM openjdk:11-jdk-alpine

#VOLUME /tmp
#COPY target/*.jar app.jar

COPY . /

RUN ./mvnw clean install

EXPOSE 8089
ENTRYPOINT ["java","-jar","/targer/app.jar"]
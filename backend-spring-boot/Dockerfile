# Spring-boot JDK
FROM openjdk:11-jdk

VOLUME /tmp
# Persist data in /temp
COPY target/*.jar app.jar
# Persist data in /temp
EXPOSE 8089
ENTRYPOINT ["java","-jar","/app.jar"]
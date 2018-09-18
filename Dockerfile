FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} oauthauthserver.jar
EXPOSE 8901
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/oauthauthserver.jar"]
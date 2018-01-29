FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} ticketresto-nc.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ticketresto-nc.jar"]
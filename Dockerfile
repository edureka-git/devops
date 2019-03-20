From maven:3-jdk-8-alpine

WORKDIR /app

COPY . /app

RUN mvn -X install

FROM tomcat:8.0.20-jre8

COPY target/addressbook.war /usr/local/tomcat/webapps/
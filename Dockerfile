FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /addressbook/
COPY src /addressbook/src/
WORKDIR /addressbook/
RUN mvn package

COPY --from=MAVEN_TOOL_CHAIN /addressbook/target ./target

FROM tomcat:9.0-jre8-alpine
COPY --from=MAVEN_TOOL_CHAIN /addressbook/target/addre*.war $CATALINA_HOME/webapps/addressbook.war

HEALTHCHECK --interval=1m --timeout=3s CMD wget --quiet --tries=1 --spider http://localhost:8080/addressbook/ || exit 

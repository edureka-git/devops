# FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
#COPY pom.xml /addressbook/
#COPY src /addressbook/src/
#WORKDIR /addressbook/
#RUN mvn package
#Deploying to tomcat
FROM tomcat:9.0-jre8-alpine
CMD  curl --output $CATALINA_HOME/webapps/addressbook.war localhost:8182/artifactory/libs-release-local/com/edurekademo/tutorial/addressbook/${latest_success}/addressbook-${latest_success}.war
#COPY --from=MAVEN_TOOL_CHAIN /addressbook/target/addre*.war $CATALINA_HOME/webapps/addressbook.war
HEALTHCHECK --interval=1m --timeout=3s CMD wget --quiet --tries=1 --spider http://localhost:8080/addressbook/ || exit 

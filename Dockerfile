FROM open-liberty:webProfile7
MAINTAINER Josef Kiefinger
ENV DEPLOYMENT_DIR /config/
ENV DEPLOYMENT_DIR_IBM /opt/ibm/wlp/usr/servers/defaultServer
COPY src/main/liberty/config/server.xml ${DEPLOYMENT_DIR}
COPY src/main/liberty/config/bootstrap.properties ${DEPLOYMENT_DIR}
COPY target/msg-api-mp-client-1.0.war ${DEPLOYMENT_DIR}/apps/msg-api-mp-client.war
#COPY target/wlp/usr/shared/resources/mongo-java-driver.jar /opt/ibm/wlp/usr/shared/resources 
#RUN installUtility install --acceptLicense defaultServer

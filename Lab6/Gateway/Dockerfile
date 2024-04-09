FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="0.0.1-SNAPSHOT"

LABEL build_version=""
LABEL maintainer=""

EXPOSE 8080
EXPOSE 8083
EXPOSE 8082
EXPOSE 8081

COPY target/Gateway-${VERSION}.jar /opt/Gateway/Gateway.jar

CMD ["java", "-jar", "/opt/Gateway/Gateway.jar"]

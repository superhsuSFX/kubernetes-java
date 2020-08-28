FROM openjdk:8-jre
ADD target/stockmanager-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8030
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

COPY signalfx-tracing.jar .

ENTRYPOINT ["java","-javaagent:./signalfx-tracing.jar -Djava.security.egd=file:/dev/./urandom -Dsignalfx.service.name=stockmanager -Dsignalfx.endpoint.url=http://192.168.0.112:9080/v1/trace","-jar","/app.jar"]
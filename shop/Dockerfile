FROM openjdk:8-jre
ADD target/shop-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8010

COPY signalfx-tracing.jar .

ENTRYPOINT ["java","-javaagent:signalfx-tracing.jar", "-Dsignalfx.service.name=shop","-jar","./app.jar"]

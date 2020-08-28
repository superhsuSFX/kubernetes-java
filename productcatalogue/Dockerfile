FROM openjdk:8-jre
ADD target/productcatalogue-0.0.1-SNAPSHOT.jar app.jar
ADD product-catalogue.yml app-config.yml
EXPOSE 8020
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar", "server", "app-config.yml"]

COPY signalfx-tracing.jar .

ENTRYPOINT ["java","-javaagent:signalfx-tracing.jar -Djava.security.egd=file:/dev/./urandom -Dsignalfx.service.name=productcatalogue -Dsignalfx.endpoint.url=http://192.168.0.112:9080/v1/trace","-jar","app.jar", "server", "app-config.yml"]

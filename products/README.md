product-catalogue
=================

java -jar target/product-1.0-SNAPSHOT.jar server product-catalogue.yml

docker build -t shabushabu/product .
docker run -p 9010:9010 -p 9011:9011 -d shabushabu/product

#Git clone to your k8s Master 
 https://github.com/shabuhabs/kubernetes-java.git
	
cd kubernetes-java

cd shopfront

docker build -t shabushabu/djshopfront:3.0 .
#login to docker
docker push shabushabu/djshopfront:3.0

Mvn clean install

cd ../kubernetes

kubectl apply -f shopfront-service.yaml

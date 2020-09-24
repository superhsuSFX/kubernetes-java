# Tested on Ubuntu 18.04 ( k8s master )

( Assumes SignalFx Smart Agent is installed as Daemonset according to: 

https://docs.signalfx.com/en/latest/integrations/kubernetes/k8s-quick-install.html

# If you have RBAC enabled you must give proper rights to SignalfxAgent as follows:

kubectl create clusterrolebinding add-on
-cluster-admin --clusterrole=cluster-admin --serviceaccount=default:signalfx-agent 

# You will also need:
Git, Java 8 or above, Maven, Docker.

# Steps

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

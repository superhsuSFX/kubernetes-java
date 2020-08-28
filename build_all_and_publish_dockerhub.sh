#!/bin/bash

cd shopfront
mvn clean install
if docker build -t shabushabu/djshopfront . ; then
  docker push shabushabu/djshopfront
fi
cd ..

cd productcatalogue
mvn clean install
if docker build -t shabushabu/djproductcatalogue . ; then
  docker push shabushabu/djproductcatalogue
fi
cd ..

cd stockmanager
mvn clean install
if docker build -t shabushabu/djstockmanager . ; then
  docker push shabushabu/djstockmanager
fi
cd ..

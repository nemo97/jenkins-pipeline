#!/bin/bash
docker stop $(docker ps -a -q -f "ancestor=jenkins-pipeline") >> /dev/null
docker rm $(docker ps -a -q -f "ancestor=jenkins-pipeline") >> /dev/null

docker build -t jenkins-pipeline .
# - local post : container port
docker run -d -p 9092:8080 jenkins-pipeline  >> pid.txt

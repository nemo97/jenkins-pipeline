#!/bin/bash
sh docker stop $(docker ps -a -q -f "ancestor=jenkins-pipeline") >> /dev/null
sh docker rm $(docker ps -a -q -f "ancestor=jenkins-pipeline") >> /dev/null

sh docker build -t jenkins-pipeline .
# - local post : container port
sh docker run -d -p 9092:8080 jenkins-pipeline  >> pid.txt

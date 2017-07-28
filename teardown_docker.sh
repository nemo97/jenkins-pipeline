#!/bin/bash
docker stop $(docker ps -a -q -f "ancestor=jenkins-pipeline") >> /dev/null
docker rm $(docker ps -a -q -f "ancestor=jenkins-pipeline") >> /dev/null
FROM subhasatdocker/mylinux:v1
MAINTAINER subhas.sing@gmail.com

# Set the working directory to /app
WORKDIR /app

# Copy  the current directory contents into the container at /app
#ADD . /app
copy ./build/libs/*jenkins-pipeline*.war /app/jenkins-pipeline.war

# Make port 80 available to the world outside this container
EXPOSE 8080

# Define environment variable
ENV NAME World

# Run app.py when the container launches
CMD ["java", "-jar","/app/jenkins-pipeline.war"]

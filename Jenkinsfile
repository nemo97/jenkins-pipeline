#!groovy
//properties([pipelineTriggers([githubPush()])])

node {
    git url: 'https://github.com/nemo97/jenkins-pipeline.git'

    currentBuild.result = "SUCCESS"
    try {
       stage('Checkout'){
          checkout scm
       }
       stage('Build'){
         sh './gradlew clean build'
       }

      stage('Test'){
        sh './gradlew check'
      }

    }
    catch (err) {

        currentBuild.result = "FAILURE"
/*
        mail body: "project build error is here: ${env.BUILD_URL}" ,
        from: 'xxxx@yyyy.com',
        replyTo: 'yyyy@yyyy.com',
        subject: 'project build failed',
        to: 'zzzz@yyyyy.com'
*/
        throw err
    }

}
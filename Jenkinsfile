#!groovy
properties([[$class: 'BuildDiscarderProperty',
                strategy: [$class: 'LogRotator', numToKeepStr: '10']],
                pipelineTriggers([cron('*/5 * * * *')]),
                ])
node {
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

        mail body: "project build error is here: ${env.BUILD_URL}" ,
        from: 'xxxx@yyyy.com',
        replyTo: 'yyyy@yyyy.com',
        subject: 'project build failed',
        to: 'zzzz@yyyyy.com'

        throw err
    }

}
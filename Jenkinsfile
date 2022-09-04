pipeline {
  agent any
    tools {
          maven 'Maven 3.8.6'
          jdk 'jdk11'
      }

      stages {
              stage ('Initialize') {
                  steps {
                      sh '''
                          echo "PATH = ${PATH}"
                          echo "M2_HOME = ${M2_HOME}"
                      '''
                  }
              }
    stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
    }
}
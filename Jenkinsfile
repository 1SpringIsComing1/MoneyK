pipeline {
  agent any
    tools {
          maven 'Maven 3.8.6'
      }
        stage('Build'){
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
         }
	}
}
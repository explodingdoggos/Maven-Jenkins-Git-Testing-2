pipeline {
    agent any
	environment {
	    PATH = "c:/Oracle/Middleware/Oracle_Home/oracle_common/modules/thirdparty/apache-maven_bundle/3.6.1.0.0/apache-maven-3.6.1/bin/mvn"
	}

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn clean install test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
            }
        }
    }
}

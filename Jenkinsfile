pipeline {
        agent any
    stages {
        stage('clean'){
            steps {
                sh echo Cleaning ...
            }
        }
        stage('Build') { 
            steps {
                sh echo Building ...
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Install') { 
            steps {
                sh echo Installing ...
            }
        }            
        stage('Deploymeny') { 
            steps {
                sh echo Deploying ...
            }
        }            
    }
}

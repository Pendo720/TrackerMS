pipeline {
        agent any
    stages {
        stage('clean'){
            steps {
                echo 'Cleaning...'
                git url: 'https://github.com/Pendo720/TrackerMS'
                    withMaven{
                        sh 'mvn clean'
                    }
            }
        }
        stage('Build') { 
            steps {
                echo 'Building...'
                    withMaven {
                        sh 'mvn build'
                    }
            }
        }
        stage('Install') { 
            steps {
                echo 'Installing...'
            }
        }            
        stage('Deployment') { 
            steps {
                echo 'Deploying...'
            }
        }            
    }
}

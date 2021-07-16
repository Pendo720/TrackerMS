pipeline {
        agent any
    stages {
        stage('clean'){
            steps {
                echo 'Cleaning...'
                git url: 'https://github.com/Pendo720/TrackerMS'
            }
        }
        stage('Build') { 
            steps {
                echo 'Building...'
                sh "mvn clean install"
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

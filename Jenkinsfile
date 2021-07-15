pipeline {
        agent any
    stages {
        stage('clean'){
            steps {
                echo 'Cleaning...'
            }
        }
        stage('Build') { 
            steps {
                echo 'Building...'
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Install') { 
            steps {
                echo 'Installing...'
            }
        }            
        stage('Deploymeny') { 
            steps {
                echo 'Deploying...'
            }
        }            
    }
}

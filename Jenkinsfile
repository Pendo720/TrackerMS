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
                
                withMaven {
                        sh "mvn clean verify"
                } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
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

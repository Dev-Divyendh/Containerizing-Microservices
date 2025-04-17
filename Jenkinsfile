pipeline {
    agent any
    environment {
        DOCKER_IMAGE = 'devdivyendh10/survey-service:latest'
        K8S_NAMESPACE = 'default'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    dir('survey-service') { //  pom.xml 
                        sh 'mvn clean package -DskipTests'
                    }
                }
            }
        }
        stage('Docker Build and Push') {
            steps {
                script {
                    // Build Docker image
                    sh 'docker build -t $DOCKER_IMAGE .'
                    // Push Docker image to Docker Hub
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                script {
                    // Deploy to Kubernetes using the provided YAML files
                    sh 'kubectl apply -f k8s-config/deployment.yaml'
                    sh 'kubectl apply -f k8s-config/service.yaml'
                }
            }
        }
    }
    post {
        success {
            echo 'CI/CD Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the logs for errors.'
        }
    }
}

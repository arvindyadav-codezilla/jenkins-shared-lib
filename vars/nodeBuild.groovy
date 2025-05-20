def call() {
    stage('Checkout') {
        checkout scm
    }

    stage('Install Dependencies') {
        sh 'npm install'
    }

    stage('Run Tests') {
        sh 'npm test'
    }

    stage('Build') {
        sh 'npm run build'
    }
}

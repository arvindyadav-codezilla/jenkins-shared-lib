def call() {
    tools {
        nodejs 'nodejs'
    }

    stage('Checkout') {
        git 'https://github.com/arvindyadav-codezilla/nodeapp.git'
    }

    stage('Install Dependencies') {
        sh 'npm install'
    }

    stage('Run Tests') {
        sh 'npm test'
    }
}

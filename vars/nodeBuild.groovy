def call() {
    node {
        stage('Checkout') {
            git 'https://github.com/arvindyadav-codezilla/nodeapp.git'
        }

        stage('Install Dependencies') {
            sh 'npm install'
        }

        stage('Run Tests') {
            sh 'npm test'
        }
         stage('Archive Artifacts') {
            archiveArtifacts artifacts: '**/test-results/**/*.xml', allowEmptyArchive: true
            junit '**/test-results/**/*.xml'
        }
    }
}

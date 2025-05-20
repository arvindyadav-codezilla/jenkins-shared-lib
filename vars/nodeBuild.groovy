def call(String repoUrl = 'https://github.com/arvindyadav-codezilla/nodeapp.git') {
    node {
        tools {
            nodejs 'nodejs'
        }

        stage('Checkout') {
            git repoUrl
        }

        stage('Install Dependencies') {
            sh 'npm install'
        }

        stage('Run Tests') {
            sh 'npm test'
        }

        stage('Build App') {
            sh 'npm run build'
        }

        stage('Archive Build') {
            archiveArtifacts artifacts: 'dist/**', fingerprint: true
        }
    }
}

node {
    def mvnHome

    stage('Preparation') {

        git "${params.GIT_URL}"

        mvnHome = tool "Maven353"
    }

    stage('Generating Unit Test Report'){
        junit '**/target/surefire-reports/TEST-*.xml'
    }


}
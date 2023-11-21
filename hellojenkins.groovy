#!groovy

// Hello World

pipeline{
    agent any
    triggers { pollSCM('* * * * *') }
    options{
        timestamps()
        }
    stages{
        stage("Hello World"){
            steps{
                echo "========executing A========"
            }
        }
    
    }
}

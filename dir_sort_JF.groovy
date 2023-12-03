pipeline {
  agent any

  options {
        timeout(time: 5, unit: 'MINUTES') 
    }
  
  environment {

    PATH = "C:\\WINDOWS\\SYSTEM32"
    PYTHONIOENCODING='IBM866'
    PYTHON_ENV = "C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python311\\python.exe"
    PATH_PYTHON = "\\workspace\\GitPaiplain\\main.py"
}

    stages{
    stage("Выполнение скрипта") {
      steps {
        bat '''
        @chcp 1251
        %PYTHON_ENV% %JENKINS_HOME%%PATH_PYTHON% %DIR_NAME%
        '''

      }
    }
  }

  post{
      success{
        archiveArtifacts 'list_dir.txt'
      }
    }
}
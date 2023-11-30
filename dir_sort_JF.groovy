pipeline {
  agent any
  
  environment {

    PATH = "C:\\WINDOWS\\SYSTEM32"
    PYTHONIOENCODING='IBM866'
    PYTHON_ENV = "C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python311\\python.exe"
    PATH_PYTHON = "\\workspace\\GitPaiplain\\main.py"
}

    stages{
    stage("deploy") {
      steps {

        echo "Calling multi line batch command"
        bat '''
        echo %DIR_NAME% 
        echo %JENKINS_HOME%%PATH_PYTHON%
        
        %PYTHON_ENV% %JENKINS_HOME%%PATH_PYTHON% %DIR_NAME%
        '''


      }
    }
  }
}
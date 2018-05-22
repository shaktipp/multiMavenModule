def v_bitBucketUrl = 'https://ShaktiPrasadaPanda@gitserver.fairisaac.com:8443/scm/ompto/apm50.git'
def v_githubUrl = 'https://github.com/shaktipp/multiMavenModule.git'
def v_branchName = 'develop'
def v_cucumberReportPath = '**/cucumber.json'
def v_junitReportPath = '*/**/target/surefire-reports/*.xml'
def v_htmlReportPath = 'target/site/jacoco/'
def v_successNotification = 'shaktiprasadapanda@fico.com,shaktipp@gmail.com';
def v_failNotification = 'shaktiprasadapanda@fico.com,shaktipp@gmail.com';

//http://www.sahajamit.com/post/cucumber-jvm-with-testng/
//////////////////////////////////////////////////////////////////////PLEASE DONT MODIFY BELOW SCRIPT   ////////////////////////////////////////////////////////////////////////////

pipeline {	

	agent any

	tools {
		maven 'Maven352'
	}

	stages {
		
		stage('Checkout') {
			steps {
				//git credentialsId: 'BitBucket', url: v_bitBucketUrl, branch: v_branchName
				git url: v_githubUrl, branch: v_branchName
			}
		}
		stage('Compile2Docker Push'){
            steps{
                script{
                    try{
                        //sh "mvn install -DskipITs"
                        sh "mvn install"
                    }
                    catch(err){
                        currentBuild.result = 'UNSTABLE'
                        //throw error
                        throw err
                    }
                }//End of script block
            }//end of steps
		}
       
		/*
		stage('Sonar Scan') {
			steps {
				sh "mvn sonar:sonar"
			}
		}
		*/

        /*
        stage('Call Remote Pipeline Job') {
            steps {
                  // Call a remote system to start execution, passing a callback url
                  sh "curl -X POST -H 'Content-Type: application/json' -d '{\"callback\":\"${env.BUILD_URL}input/Async-input/proceedEmpty\"}' http://192.168.252.130:8080/job/ExecuteIT_MultiModule/build?token=17057"

            }
        }
        */
		
		

	}//End of stages	
	post{
		always {
            //generate cucumber reports
            cucumber "${v_cucumberReportPath}"            
            //junit "${v_junitReportPath}"
            
            /*
            publishHTML( target: [
	            allowMissing: false,
	            alwaysLinkToLastBuild: false,
	            keepAll: true,
	            reportDir: "${v_htmlReportPath}",
	            reportFiles: 'index.html',
	            reportName: 'JaCoCo Report'
	          ])
              */
	       
	        
        }
		success {
            mail to: "${v_successNotification}",
            subject: "Success Jenkins Build: ${currentBuild.fullDisplayName}",
            body: "Build is Successful, URL : ${env.BUILD_URL}"
        }
        unstable {
            mail to: "${v_failNotification}",
            subject: "Unstable Jenkins Build: ${currentBuild.fullDisplayName}",
            body: "Build is Unstable due to a few error, URL : ${env.BUILD_URL}"
        }
        failure {
            mail to: "${v_failNotification}",
            subject: "Failed Jenkins Build: ${currentBuild.fullDisplayName}",
            body: "Something is wrong with Pipeline Build , URL : ${env.BUILD_URL}"
        }
	
	}//End of post
		
}

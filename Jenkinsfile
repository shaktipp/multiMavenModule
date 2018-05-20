def v_bitBucketUrl = 'https://ShaktiPrasadaPanda@gitserver.fairisaac.com:8443/scm/ompto/apm50.git'
def v_githubUrl = 'https://github.com/shaktipp/multiMavenModule.git'
def v_branchName = 'develop'
def v_cucumberReportPath = '*/**/target/cucumber.json'
def v_junitReportPath = '*/**/target/surefire-reports/*.xml'
def v_htmlReportPath = 'target/site/jacoco/'
def v_successNotification = 'shaktiprasadapanda@fico.com,shaktipp@gmail.com';
def v_failNotification = 'shaktiprasadapanda@fico.com,shaktipp@gmail.com';


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
		stage('Compile2Docker Push') {
			steps {
				sh "mvn install -DskipITs"
			}
		}
       
		/*
		stage('Package and Checkmarx') {
			steps {
				
				step([$class: 'CxScanBuilder', comment: 'Checkmark Static Code Analyss', credentialsId: '', excludeFolders: '', excludeOpenSourceFolders: '', exclusionsSetting: 'job', failBuildOnNewResults: false, failBuildOnNewSeverity: 'HIGH', filterPattern: 	'''!**/_cvs/**/*, !**/.svn/**/*,   !**/.hg/**/*,   !**/.git/**/*,  !**/.bzr/**/*, !**/bin/**/*,
				!**/obj/**/*,  !**/backup/**/*, !**/.idea/**/*, !**/*.DS_Store, !**/*.ipr,     !**/*.iws,
				!**/*.bak,     !**/*.tmp,       !**/*.aac,      !**/*.aif,      !**/*.iff,     !**/*.m3u, !**/*.mid, !**/*.mp3,
				!**/*.mpa,     !**/*.ra,        !**/*.wav,      !**/*.wma,      !**/*.3g2,     !**/*.3gp, !**/*.asf, !**/*.asx,
				!**/*.avi,     !**/*.flv,       !**/*.mov,      !**/*.mp4,      !**/*.mpg,     !**/*.rm,  !**/*.swf, !**/*.vob,
				!**/*.wmv,     !**/*.bmp,       !**/*.gif,      !**/*.jpg,      !**/*.png,     !**/*.psd, !**/*.tif, !**/*.swf,
				 !**/*.rar,      !**/*.exe,      !**/*.dll,     !**/*.pdb, !**/*.7z,  !**/*.gz,
				!**/*.tar.gz,  !**/*.tar,       !**/*.gz,       !**/*.ahtm,     !**/*.ahtml,   !**/*.fhtml, !**/*.hdm,
				!**/*.hdml,    !**/*.hsql,      !**/*.ht,       !**/*.hta,      !**/*.htc,     !**/*.htd, 
				!**/*.htmls,   !**/*.ihtml,     !**/*.mht,      !**/*.mhtm,     !**/*.mhtml,   !**/*.ssi, !**/*.stm,
				!**/*.stml,    !**/*.ttml,      !**/*.txn,      !**/*.xhtm,     !**/*.xhtml,   !**/*.class, !**/*.iml, !Checkmarx/Reports/*.*''', fullScanCycle: 10, groupId: '77817e0d-9700-46b5-aa44-16b474ba8416', includeOpenSourceFolders: '', jobStatusOnError: 'FAILURE', osaArchiveIncludePatterns: '*.zip, *.war, *.ear, *.tgz', password: '{AQAAABAAAAAQY8vsvHNzrPNGcSmj4kTwzkcy3DupBli81CPJO+Hv6zU=}', preset: '100000', projectName: 'omApmcbMetadataService', serverUrl: 'https://bnpappwis403.corp.fairisaac.com', sourceEncoding: '1', username: '', vulnerabilityThresholdResult: 'FAILURE'])

			}
		}
		stage('Cucumber') {
			steps {
				sh "mvn verify"
			}
		}
		*/
		
		stage('Sonar Scan') {
			steps {
				sh "mvn sonar:sonar"
			}
		}		
		
		

	}//End of stages	
	post{
		always {
            //generate cucumber reports
            cucumber "${v_cucumberReportPath}"            
            junit "${v_junitReportPath}"
            
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

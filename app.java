pipeline {
 agent any
     stages{
         stage("hello world"){
             steps {
                 echo "hi my first pipeline script"
         }
             
        }
    
    }
    
} 
Date:-
6-11-23

P=PIPELINE
A=AGENT                  
S=STAGES
S=STAGE 
S=STEPS 
Jenkins piplene: is a combination of plugins that supports integration and implementation of continuous delivery pipelines.
A pipeline is a group of evnets interlinked with each other in a sequence.
There are two types of Jenkins pipeline syntax used for defining your Jenkinsfile
Declarative 
Scripted
NEW ITEM --->NAME --->PIPELINE --->SAVE 
DECLARATIVE.                        Scripted
Pipeline{
      agent any.                      node{            
     stages{.                               stage("stage"){
       stage("hello"){.                      echo "hai"
          steps{.                                }
               echo "hello world"
             }
        }
   }
}








Pipeline{
    agent any 
    Stages {
           stage ("hello world") {
            Steps{
                echo "hi this is my pipeline job"
                    }
               }
  
           }
}
Pipeline scriptలో command's perform చేయాలంటే stategsలోని Stageలో sh అని ఇచ్చి cmd ఇవ్వలే::Ex:
Pipeline{
        agent any
        Stages{
             stage ("command ex") {
                 steps {
                     sh 'timedatectl
                     }
                 }
                  stage ("Second command") {
                       steps {
                             sh "cal"
                     }
                }
                 stage ("third cmd") {
                     steps {
                          sh  'touch AWS. text '
                 }
              }
          }
     }
పైన fileని చూడాలంటే మన Jenkins surverలోకి పోయి దాని path లో (/var/lib/Jenkins/worksapce/)చూడాలి..
 Note: ఒక stage లో ఒక steps మాత్రమే తీసుకోవచ్చు కానీ ఒక steps లో  ఏన్నీ అయిన Cmd's రాసుకోవచ్చు..Ex:

Pipeline{
       agente any
             stages{
                  stage  ("multiple Cmd's with using one step"){
                    steps {
                            sh 'timedatectl'
                            sh 'cal'
                            sh 'mkdir reddy'
                   }
             }
          }
      }
   అదే ఓకే shell script (sh)లో   sh ఒకటే use చేసి multipule Cmd's రాయచ్చు ...sh''' tripul single columns open చేసి tripule single columnsతోclose చేసి వాటి మధ్యలో ఏన్ని Cmd's అయిన రాయచ్చు....EX:
           pipeline{
                 agent any
                   Stages {
                         stage ("using one sh") {
                               steps {
                                      sh'''
                                      touch aws
                                      mkdir devops 
                                     cat /etc/passwd 
                                      hostname  -i
                                      '''
                               }                    
                    }
       
            }
   }
DATE:-7-11-23  
              
Declarative pipeline లో  variables , parameters,input functions,

  




Variables: 
A=2
B=3
C=a+b
C=2+3
C=5
Variables ఏoదుకు వాడుతం అంటే:
value'sని store చేసుకోవడం కోసం or asain the value's ,,,,,,variable రాయడానికి agent any కింద నుడ్డి రాయాలి....EX:-
pipeline {
       agent any
       environment {
              name="jeevan reddy"
             course="DevOps"
            cloud= "aws"
}
      stages {
          stage("variables asain"){
                steps {
                    echo "my name is $name iam learning $course with using$cloud"
          }
     }
}
}
Note:పైప్‌లైన్‌లో వేరియబుల్‌ను మీరు ఎలా నిర్వచిస్తారు?
NAME = VALUE సింటాక్స్ ఉపయోగించి ఎన్విరాన్‌మెంట్ వేరియబుల్స్ నిర్వచించవచ్చు . వేరియబుల్ విలువను యాక్సెస్ చేయడానికి మీరు ఈ మూడు పద్ధతులను ఉపయోగించవచ్చు $env.NAME , $NAME లేదా ${NAME} ఈ పద్ధతుల మధ్య తేడాలు లేవు. పర్యావరణ వేరియబుల్స్ ఉదాహరణతో పూర్తి పైప్‌లైన్ నమూనా ఇక్కడ ఉంది

Stages లో ఏన్ని stage లు ఉన్న అక్కడ ఇ value's ని use చేసుకోవచ్చు..
EX:
pipeline {
       agent any
       environment {
              name="jeevan reddy"
             course="DevOps"
            cloud= "aws"
}
      stages {
          stage("variables asain"){
                steps {
                    echo "my name is $name iam learning $course with using$cloud"
          }
     }
         stage ("one") {
             steps {
                  echo $name is a DevOps engineer"
             }
        }
       stage ("two") {
          steps {
               echo "$name is completed $cloud"
          }
      }

    }
}
Jenkins variables 2types they are:
Global environment:we can access those values from any stage
local environment:we can access only particular stage
Pipeline {
       agent any
      environment{
           X= "5"
}
stages {
         stage("one"){
             steps { 
                    echo "the value is $x"
                 }
         }
         stage ("two"){
                 Steps{ 
                   echo “the value is $x"
             }
       }
       stage ("three"){
                environment {
                x= "55"
         }
                 Steps{ 
                   echo “the value is $x"
             }
    }
      stage ("four"){
                 Steps{ 
                   echo “the value is $x"
             }
      }

}

పైన ఉన్న stage:1,2,4లో 5print అవుతుంది దాన్ని Global variable అంటాం, 
అదే stage 3లో 55print అవుతుంది దాన్ని local variable అంటాం...
ఆ stage--3లో ఉన్న environment only అక్కడి stage వరకే work అవుతుంది ఎందుకంటే ఆ stage లో ఉంది కాబట్టి... దాన్నే lokacl varibale అంటాం..
What are the default environment variables in Jenkins?
Built in environment variables
BUILD_NUMBER - The current build number. ...
BUILD_ID - The current build id. ...
BUILD_DISPLAY_NAME - The name of the current build. ...
JOB_NAME - Name of the project of this build. ...
BUILD_TAG - String of "jenkins-${JOB_NAME}-${BUILD_NUMBER}".
Jenkinsలో వున్న అన్నీ pree defined variables తెలుసుకోవాలంటే echo దగ్గర sh with single court లో 'printenv' ఈస్తం:---->EX:
stages{
      stage("hello"){
           steps {
                  sh  'printenv'
         }
}
PROJECT PARAMETERISED:
Manual:ఇది general లో ఉంది..కాని ఇలా కాకుండా 
Automate:
pipeline లో కూడ రాసి parameterise enble చేయచ్చు.----->EX::
pipeline{
Agent any
Parameters {
     string (name:'g1', defaultValue: 'devops', description: 'this is my parameter')
}
stages {
     stage("hello"){
           steps {
                  echo "hello world
            }
       }  
   }
Build చెస్తే parameters enable అవుతాయి.. వాటిని save చెస్తే build with parameters అని వొస్తుంది..
Boolean parameters:
pipeline{
Agent any
Parameters {
     Booleanparam(name:'g1', defaultValue: true/false, description: 'this is my parameter')
}
stages {
     stage("hello"){
           steps {
                  echo "hello world
            }
       }  
   }
Choice parameters:
pipeline{
Agent any
Parameters {
     choice (name:'g1', choices: ['main', 'master','devops']description: 'this is my parameter')
}
stages {
     stage("hello"){
           steps {
                  echo "hello world
            }
       }  
   }
}
Input functions:
pipeline {
    agent any

    stages {
        stage('code') {
            steps {
                echo 'Hello World'
            }
        }
        stage('build') {
            steps {
                echo 'Hello World'
            }
        }
        stage('test') {
            steps {
                echo 'Hello World'
            }
        }
        stage('deploy') {
            input {
                message 'can i deploy?'
                ok 'yes'
            }    
            steps {
                echo 'Hello World'
            }
        }
    }
 }

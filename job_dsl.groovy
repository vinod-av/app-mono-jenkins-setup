pipelineJob('k8s-deploy') {

  def repo = 'https://vinodA@bitbucket.org/vinodA/app-mono-helmstate.git'

  triggers {
    githubPush()
  }
  description("Pipeline for $repo")

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            credentials('vinod-bitbucket')
            url(repo)
          }
          branch('master')
          scriptPath('Jenkinsfile')
          extensions { }
        }
      }
    }
  }
}


pipelineJob('image-orchestrator-job') {

  def repo = 'https://vinodA@bitbucket.org/vinodA/app-mono-orchestrator.git'

  description("Pipeline for $repo")

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            credentials('vinod-bitbucket')
            url(repo)
          }
          branch('master')
          scriptPath('Jenkinsfile')
          extensions { }
        }
      }
    }
  }
}

pipelineJob('app-mono-build-job') {

  def repo = 'https://vinodA@bitbucket.org/vinodA/app-mono.git'

  description("Pipeline for $repo")

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            credentials('vinod-bitbucket')
            url(repo)
          }
          branch('master')
          scriptPath('Jenkinsfile')
          extensions { }
        }
      }
    }
  }
}

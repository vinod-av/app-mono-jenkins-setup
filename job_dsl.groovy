pipelineJob('k8s-deploy') {

  def repo = 'https://github.com/vinod-avk/app-mono-helmstate.git'

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
            credentials('vinod-github_crede')
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

  def repo = 'https://github.com/vinod-avk/app-mono-orchestrator.git'

  description("Pipeline for $repo")

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            credentials('vinod-github_crede')
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

  def repo = 'https://github.com/vinod-avk/app-mono.git'

  description("Pipeline for $repo")

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            credentials('vinod-github_crede')
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

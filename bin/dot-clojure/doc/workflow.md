# Workflow engines with clojure.
https://www.youtube.com/watch?v=M1HrLAud6MA

Clojure on Camunda

Businss Logic as Workflow?

- Humans
  Taskts to be completed by humans
- Decisions
  whcih taks are needed?
- Seqence of Tasks
  Which tasks are depend on another?
- Time
  SLA? How long will we wait?

# Roll your own Business Process Engine or State Machine?

- Timers
- Framework
- SLA

# Sombody solved it?

BPMN based

- Camunda
- Flowable
- Activiti

Are there any UML state machine based?

# Camunda
- Modeler
- Process deployment (BPMN file)
```clojure
(defn deploy-process [definition-file]
 (let [repo-service (.getRepositoryService camunda)
       name         
```

- Start a process instance
(defn start-instance-by-key [key variables]
,,,
)
- Gateways
can use script format as Clojure
	
- Delegates
There is JavaDelegate

(ns engine-clojure.mail-delegate
 (:gen-class
  :name de.javahippie.camunda.MailDelegate
  :implements [org.camunda.bpm.engine.delegte.JavaDelegate])
  (:require [my-mailer :as mailer]))

(defn -execute [this execution]
,,,
)

- The task list

User Task example. Wrap the task service

(defn get tasks-for-candidate-group [group])
(defn claim-task [id user])
(defn get-task-variables [id])
(defn complete-task [id variables])

- Timers

- And many more
Process versions


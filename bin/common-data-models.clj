(ns common-data-models)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Core
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

[:map
 {:title "Organization"
  :description "Top level of business hierarchy."}
 [:id string?
  :name string?
  :]]
[:map
 {:title "BusinessUnit"
  :descripton "Business, division, or department."}

 [:id string?
  :organization-id string?]]

[:map
 {:title "User"
  :description "Person with access to system and owns objects in the system to create, modify etc."}
 [:id string?
  :organization-id string?
  :business-unit-id string?]]
[:map
 {:title "Position"
  :description "Position of a user in the hierarchy"}]

[:map
 {:title "Team"
  :description "Collection of system users that routinely collaborate. Teams can be used to simplify record sharing and provide team members with common access to organization data when team members belong to different Business Units."}]

[:map
 {:title "Owner"
  :description "Group of undeleted system users and undeleted teams. Owners can be used to control access to specific objects."}]

[:map
 {:title "TeamMembership"
  :description "User membership in Teams"}]

[:map
 {:title "Task"
  :description "Generic activity representing work needed to be done."}]

[:map
 {:title "Note"
  :description "Note that is attached to one or more objects, including other notes."}]
[:map
 {:title "Letter"
  :description "Activity that tracks the delivery of a letter. The activity can contain the electronic copy of the letter."}]

[:map
 {:title "Account"
  :description "Business that represents a customer or potential customer. The company that is billed in business transactions."}
 [:id string?
  :version int?]]

[:map
 {:title "Activity"
  :description "Task performed, or to be performed, by a user. An activity is any action for which an entry can be made on a calendar."}]

[:map
 {:title "ActivityParty"
  :description "Person or group associated with an activity. An activity can have multiple activity parties."}]

[:map
 {:title "Address"
  :description "Address and shipping information. Used to store additional addresses for an account or contact."}]

[:map
 {:title "Queue"}
 [:id string?
  :business-unit-id string?
  :organization-id string?]]
[:map
 {:title "QueueItem"}
 [:id string?
  :entered-on inst?]]


[:map
 {:title "SLA"
  :description "Contains information about the tracked service-level KPIs for cases that belong to different customers."}]

[:map
 {:title "SLAItem"
  :description "Contains information about a tracked support KPI for a specific customer."}]

[:map
 {:title "SLAKPIInstance"
  :description "Service level agreement (SLA) key performance indicator (KPI) instance that is tracked for an individual case"}]

[:map
 {:title "Goal"
  :description "Target objective for a user or a team for a specified time period."}]

[:map
 {:title "GoalMetric"
  :description "Type of measurement for a goal, such as money amount or count."}]
[:map
 {:title "Currency"
  :description "Currency in which a financial transaction is carried out."}]

[:map
 {:title "Country"
  :description "Countries is of interest to business."}]

[:map
 {:title "Contact"
  :description "Person with whom a business unit has a relationship, such as customer, supplier, and colleague."}]

[:map
 {:title "Connection"
  :description "Relationship between two entities."}]

[:map
 {:title "ConnectionRole"
  :description "Role describing a relationship between a two records."}]

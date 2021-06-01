(ns atlassian.jira.core
  "Business Project Managment Software")
;; https://developer.atlassian.com/cloud/jira/platform/rest/v3/api-group-application-roles/#api-rest-api-3-applicationrole-get

;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Sys Admin
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def application-roles
  [
   {
    "key": "jira-software",
    "groups": [
               "jira-software-users",
               "jira-testers"
               ],
    "name": "Jira Software",
    "defaultGroups": [
                      "jira-software-users"
                      ],
    "selectedByDefault": false,
    "defined": false,
    "numberOfSeats": 10,
    "remainingSeats": 5,
    "userCount": 5,
    "userCountDescription": "5 developers",
    "hasUnlimitedSeats": false,
    "platform": false
    },
   {
    "key": "jira-core",
    "groups": [
               "jira-core-users"
               ],
    "name": "Jira Core",
    "defaultGroups": [
                      "jira-core-users"
                      ],
    "selectedByDefault": false,
    "defined": false,
    "numberOfSeats": 1,
    "remainingSeats": 1,
    "userCount": 0,
    "userCountDescription": "0 users",
    "hasUnlimitedSeats": false,
    "platform": true
    }
   ])
(def audit-records
  {
  "offset": 0,
  "limit": 1000,
  "total": 1,
  "records": [
    {
      "id": 1,
      "summary": "User created",
      "remoteAddress": "192.168.1.1",
      "authorKey": "administrator",
      "authorAccountId": "5ab8f18d741e9c2c7e9d4538",
      "created": "2014-03-19T18:45:42.967+0000",
      "category": "user management",
      "eventSource": "Jira Connect Plugin",
      "description": "Optional description",
      "objectItem": {
        "id": "user",
        "name": "user",
        "typeName": "USER",
        "parentId": "1",
        "parentName": "Jira Internal Directory"
      },
      "changedValues": [
        {
          "fieldName": "email",
          "changedFrom": "user@atlassian.com",
          "changedTo": "newuser@atlassian.com"
        }
      ],
      "associatedItems": [
        {
          "id": "jira-software-users",
          "name": "jira-software-users",
          "typeName": "GROUP",
          "parentId": "1",
          "parentName": "Jira Internal Directory"
        }
      ]
    }
  ]
   }
  )
(def avatar
  {
   "system": [
              {
               "id": "1000",
               "isSystemAvatar": true,
               "isSelected": false,
               "isDeletable": false,
               "urls": {
                        "16x16": "/secure/useravatar?size=xsmall&avatarId=10040&avatarType=project",
                        "24x24": "/secure/useravatar?size=small&avatarId=10040&avatarType=project",
                        "32x32": "/secure/useravatar?size=medium&avatarId=10040&avatarType=project",
                        "48x48": "/secure/useravatar?avatarId=10040&avatarType=project"
                        }
               }
              ]
   })
(def dashboards
  {
  "startAt": 10,
  "maxResults": 10,
  "total": 143,
  "prev": "https://your-domain.atlassian.net/rest/api/3/dashboard?startAt=0",
  "next": "https://your-domain.atlassian.net/rest/api/3/dashboard?startAt=10",
  "dashboards": [
    {
      "id": "10000",
      "isFavourite": false,
      "name": "System Dashboard",
      "popularity": 1,
      "self": "https://your-domain.atlassian.net/rest/api/3/dashboard/10000",
      "sharePermissions": [
        {
          "type": "global"
        }
      ],
      "view": "https://your-domain.atlassian.net/secure/Dashboard.jspa?selectPageId=10000"
    },
    {
      "id": "20000",
      "isFavourite": true,
      "name": "Build Engineering",
      "owner": {
        "key": "Mia",
        "self": "https://your-domain.atlassian.net/rest/api/3/user?accountId=5b10a2844c20165700ede21g",
        "name": "mia",
        "displayName": "Mia Krystof",
        "avatarUrls": {
          "16x16": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=16&s=16",
          "32x32": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=32&s=32",
          "24x24": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=24&s=24",
          "48x48": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=48&s=48"
        }
      },
      "popularity": 1,
      "self": "https://your-domain.atlassian.net/rest/api/3/dashboard/20000",
      "sharePermissions": [
        {
          "id": 10105,
          "type": "group",
          "group": {
            "name": "administrators",
            "self": "https://your-domain.atlassian.net/rest/api/3/group?groupname=administrators"
          }
        }
      ],
      "view": "https://your-domain.atlassian.net/secure/Dashboard.jspa?selectPageId=20000"
    }
  ]
   })
(def filters
  [
  {
    "self": "https://your-domain.atlassian.net/rest/api/3/filter/10000",
    "id": "10000",
    "name": "All Open Bugs",
    "description": "Lists all open bugs",
    "owner": {
      "self": "https://your-domain.atlassian.net/rest/api/3/user?accountId=5b10a2844c20165700ede21g",
      "key": "",
      "accountId": "5b10a2844c20165700ede21g",
      "name": "",
      "avatarUrls": {
        "48x48": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=48&s=48",
        "24x24": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=24&s=24",
        "16x16": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=16&s=16",
        "32x32": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=32&s=32"
      },
      "displayName": "Mia Krystof",
      "active": false
    },
    "jql": "type = Bug and resolution is empty",
    "viewUrl": "https://your-domain.atlassian.net/issues/?filter=10000",
    "searchUrl": "https://your-domain.atlassian.net/rest/api/3/search?jql=type%20%3D%20Bug%20and%20resolutino%20is%20empty",
    "favourite": true,
    "favouritedCount": 0,
    "sharePermissions": [],
    "subscriptions": {
      "size": 0,
      "items": [],
      "max-results": 0,
      "start-index": 0,
      "end-index": 0
    }
  },
  {
    "self": "https://your-domain.atlassian.net/rest/api/3/filter/10010",
    "id": "10010",
    "name": "My issues",
    "description": "Issues assigned to me",
    "owner": {
      "self": "https://your-domain.atlassian.net/rest/api/3/user?accountId=5b10a2844c20165700ede21g",
      "key": "",
      "accountId": "5b10a2844c20165700ede21g",
      "name": "",
      "avatarUrls": {
        "48x48": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=48&s=48",
        "24x24": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=24&s=24",
        "16x16": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=16&s=16",
        "32x32": "https://avatar-management--avatars.server-location.prod.public.atl-paas.net/initials/MK-5.png?size=32&s=32"
      },
      "displayName": "Mia Krystof",
      "active": false
    },
    "jql": "assignee = currentUser() and resolution is empty",
    "viewUrl": "https://your-domain.atlassian.net/issues/?filter=10010",
    "searchUrl": "https://your-domain.atlassian.net/rest/api/3/search?jql=assignee+in+%28currentUser%28%29%29+and+resolution+is+empty",
    "favourite": true,
    "favouritedCount": 0,
    "sharePermissions": [
      {
        "id": 10000,
        "type": "global"
      },
      {
        "id": 10010,
        "type": "project",
        "project": {
          "self": "https://your-domain.atlassian.net/rest/api/3/project/EX",
          "id": "10000",
          "key": "EX",
          "name": "Example",
          "avatarUrls": {
            "48x48": "https://your-domain.atlassian.net/secure/projectavatar?size=large&pid=10000",
            "24x24": "https://your-domain.atlassian.net/secure/projectavatar?size=small&pid=10000",
            "16x16": "https://your-domain.atlassian.net/secure/projectavatar?size=xsmall&pid=10000",
            "32x32": "https://your-domain.atlassian.net/secure/projectavatar?size=medium&pid=10000"
          },
          "projectCategory": {
            "self": "https://your-domain.atlassian.net/rest/api/3/projectCategory/10000",
            "id": "10000",
            "name": "FIRST",
            "description": "First Project Category"
          },
          "simplified": false,
          "style": "classic",
          "insight": {
            "totalIssueCount": 100,
            "lastIssueUpdateTime": "2021-03-15T06:50:56.034+0000"
          }
        }
      }
    ],
    "subscriptions": {
      "size": 0,
      "items": [],
      "max-results": 0,
      "start-index": 0,
      "end-index": 0
    }
  }
   ])


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Project Administration
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def groups)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; User
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def issues)
(def issue-attachments)
(def issue-comments)
(def issue-comment-properties)
(def issue-fields)
(def issue-field-configurations)
(def issue-field-options)
(def issue-links)
(def issue-link-types)
(def issue-navigaor-settings)
(def issue-notification-schemes)
(def issue-priorities)
(def issue-properties)
(def issue-remote-links)
(def issue-resolutions)
(def issue-search)
(def issue-search-level)
(def issue-security-level)
(def issue-security-schemes)
(def issue-types)
(def issue-type-schemes)
(def issue-type-screen-schemes)
(def issue-type-properties)
(def issue-votes)
(def issue-watchers)
(def issue-worklogs)
(def issue-worklog-properties)
(def jira-expressions)
(def jira-settings)
(def jql)
(def labels)
(def my-self)
(def permissions)
(def permission-schemes)
(def projects)
(def project-avatars)
(def project-categories)
(def project-components)
(def project-email)
(def project-key-and-name-validation)
(def project-permission-schemes)
(def project-properties)
(def project-roles)
(def project-role-actors)
(def project-types)
(def project-versions)
(def screens)
(def screen-tabs)
(def screen-tab-fields)
(def screen-schemes)
(def server-info)
(def tasks)
(def time-tracking)
(def users)
(def user-properties)
(def user-search)
(def webhooks)
(def workflows)
(def workflow-transition-rules)
(def workflow-schemes)
(def workflow-scheme-project-associations)
(def workflow-scheme-drafts)
(def workflow-statuses)
(def workflow-transition-properties)
(def app-properties)
(def dynamic-modules)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(ns atlassian.jira.service-management)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def customer)
(def info)
(def knowledgebase)
(def organization)
(def request)
(def request-type)
(def service-desk)


(ns atlassian.jira.software)

(def backlog)
(def board)
(def epic)
(def issue)
(def sprint)
(def development-info)
(def feature-flags)
(def deployments)
(def builds)
(def remote-links)
(def other-operations)


(ns atlassian.trello)

;; https://developer.atlassian.com/cloud/trello/rest/api-group-actions/#api-actions-id-get

(def actions)
(def applications)
(def batch)
(def boards)
(def cards)
(def check-lists)
(def custom-fields)
(def emoji)
(def enterprises)
(def labels)
(def lists)
(def members)
(def notifications)
(def organizations)
(def plugins)
(def search)
(def tokens)
(def webhooks)





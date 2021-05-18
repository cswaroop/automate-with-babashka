(ns zoho.sales-marketing "Give your sales team the perfect set of apps to help close more business deals in less time.")
(ns zoho.sales-marketing.crm)

(ns zoho.email "Empower your workforce with apps to collaborate and transform the way they work.")

(ns zoho.finance "Solve business accounting challenges using our perfect set of finance apps on the cloud.")
(ns zoho.finance.books)
(ns zoho.finance.invoice)
(ns zoho.finance.inventory)
(ns zoho.finance.payroll)
(ns zoho.finance.expense)

(ns zoho.human-resources "Focus on your people while our apps automate your human resources processes.")
(ns zoho.human-resources.recruit)
(ns zoho.human-resources.people)

(ns zoho.it-management "Support your end users, empower technicians")
(ns zoho.it-management.service-desk "Be right where your customers are with apps to help your business engage with them.")
(ns zoho.it-management.catalyst)
(ns zoho.it-management.iam "Identity Access Management")

(ns zoho.customer-service "Give your service team the right tools and context necessary to make every customer successful.")
(ns zoho.customer-service.desk)
(ns zoho.customer-service.assist)
(ns zoho.customer-service.lens)

(ns zoho.remotely "For distributed teams")
(ns zoho.remotely.sprints)
(ns zoho.remotely.cliq)
(ns zoho.remotely.meeting)
(ns zoho.remotely.assist)

;; xLOB/apps/tools

(ns zoho.bi "Businss Intelligence")
(ns zoho.sigma "Build Extensions")
(ns zoho.orchestly "Orchestration")
(ns zoho.creator "Lowcode platform")

(def components
  {:form
   {:elements
    {:url :image :percent :currency :decimal :date-time :sub-form :lookup :signature :file-upload :audio :video :auto-number :formula :section :add-notes :users :integration}}
   :report {}
   :page {}
   :workflow {:when-to-run #{:on-a-form-event :on-a-scheduled-date :on-an-approval-activity :on-a-payment-activity :on-a-function-call}}})





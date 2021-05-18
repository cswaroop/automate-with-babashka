(ns intuit.quickbooks.online)

;; OLTP Entities

(def account
  {
   "Account": {
               "FullyQualifiedName": "MyJobs", 
               "domain": "QBO", 
               "Name": "MyJobs", 
               "Classification": "Asset", 
               "AccountSubType": "AccountsReceivable", 
               "CurrencyRef": {
                               "name": "United States Dollar", 
                               "value": "USD"
                               }, 
               "CurrentBalanceWithSubAccounts": 0, 
               "sparse": false, 
               "MetaData": {
                            "CreateTime": "2014-12-31T09:29:05-08:00", 
                            "LastUpdatedTime": "2014-12-31T09:29:05-08:00"
                            }, 
               "AccountType": "Accounts Receivable", 
               "CurrentBalance": 0, 
               "Active": true, 
               "SyncToken": "0", 
               "Id": "94", 
               "SubAccount": false
               }, 
   "time": "2014-12-31T09:29:05.717-08:00"
   })
(def bill 
  {
   "Bill": {
            "SyncToken": "2", 
            "domain": "QBO", 
            "APAccountRef": {
                             "name": "Accounts Payable (A/P)", 
                             "value": "33"
                             }, 
            "VendorRef": {
                          "name": "Norton Lumber and Building Materials", 
                          "value": "46"
                          }, 
            "TxnDate": "2014-11-06", 
            "TotalAmt": 103.55, 
            "CurrencyRef": {
                            "name": "United States Dollar", 
                            "value": "USD"
                            }, 
            "LinkedTxn": [
                          {
                           "TxnId": "118", 
                           "TxnType": "BillPaymentCheck"
                           }
                          ], 
            "SalesTermRef": {
                             "value": "3"
                             }, 
            "DueDate": "2014-12-06", 
            "sparse": false, 
            "Line": [
                     {
                      "DetailType": "AccountBasedExpenseLineDetail", 
                      "Amount": 103.55, 
                      "Id": "1", 
                      "AccountBasedExpenseLineDetail": {
                                                        "TaxCodeRef": {
                                                                       "value": "TAX"
                                                                       }, 
                                                        "AccountRef": {
                                                                       "name": "Job Expenses:Job Materials:Decks and Patios", 
                                                                       "value": "64"
                                                                       }, 
                                                        "BillableStatus": "Billable", 
                                                        "CustomerRef": {
                                                                        "name": "Travis Waldron", 
                                                                        "value": "26"
                                                                        }
                                                        }, 
                      "Description": "Lumber"
                      }
                     ], 
            "Balance": 0, 
            "Id": "25", 
            "MetaData": {
                         "CreateTime": "2014-11-06T15:37:25-08:00", 
                         "LastUpdatedTime": "2015-02-09T10:11:11-08:00"
                         }
            }, 
   "time": "2015-02-09T10:17:20.251-08:00"
   })
(def bill-payment)
(def budget)
(def company-info
  {
  "CompanyInfo": {
    "SyncToken": "4", 
    "domain": "QBO", 
    "LegalAddr": {
      "City": "Mountain View", 
      "Country": "US", 
      "Line1": "2500 Garcia Ave", 
      "PostalCode": "94043", 
      "CountrySubDivisionCode": "CA", 
      "Id": "1"
    }, 
    "SupportedLanguages": "en", 
    "CompanyName": "Larry's Bakery", 
    "Country": "US", 
    "CompanyAddr": {
      "City": "Mountain View", 
      "Country": "US", 
      "Line1": "2500 Garcia Ave", 
      "PostalCode": "94043", 
      "CountrySubDivisionCode": "CA", 
      "Id": "1"
    }, 
    "sparse": false, 
    "Id": "1", 
    "WebAddr": {}, 
    "FiscalYearStartMonth": "January", 
    "CustomerCommunicationAddr": {
      "City": "Mountain View", 
      "Country": "US", 
      "Line1": "2500 Garcia Ave", 
      "PostalCode": "94043", 
      "CountrySubDivisionCode": "CA", 
      "Id": "1"
    }, 
    "PrimaryPhone": {
      "FreeFormNumber": "(650)944-4444"
    }, 
    "LegalName": "Larry's Bakery", 
    "CompanyStartDate": "2015-06-05", 
    "Email": {
      "Address": "donotreply@intuit.com"
    }, 
    "NameValue": [
      {
        "Name": "NeoEnabled", 
        "Value": "true"
      }, 
      {
        "Name": "IndustryType", 
        "Value": "Bread and Bakery Product Manufacturing"
      }, 
      {
        "Name": "IndustryCode", 
        "Value": "31181"
      }, 
      {
        "Name": "SubscriptionStatus", 
        "Value": "PAID"
      }, 
      {
        "Name": "OfferingSku", 
        "Value": "QuickBooks Online Plus"
      }, 
      {
        "Name": "PayrollFeature", 
        "Value": "true"
      }, 
      {
        "Name": "AccountantFeature", 
        "Value": "false"
      }
    ], 
    "MetaData": {
      "CreateTime": "2015-06-05T13:55:54-07:00", 
      "LastUpdatedTime": "2015-07-06T08:51:50-07:00"
    }
  }, 
  "time": "2015-07-10T09:38:58.155-07:00"
   })
(def company
  {
  "Customer": {
    "PrimaryEmailAddr": {
      "Address": "Surf@Intuit.com"
    }, 
    "SyncToken": "0", 
    "domain": "QBO", 
    "GivenName": "Bill", 
    "DisplayName": "Bill's Windsurf Shop", 
    "BillWithParent": false, 
    "FullyQualifiedName": "Bill's Windsurf Shop", 
    "CompanyName": "Bill's Windsurf Shop", 
    "FamilyName": "Lucchini", 
    "sparse": false, 
    "PrimaryPhone": {
      "FreeFormNumber": "(415) 444-6538"
    }, 
    "Active": true, 
    "Job": false, 
    "BalanceWithJobs": 85.0, 
    "BillAddr": {
      "City": "Half Moon Bay", 
      "Line1": "12 Ocean Dr.", 
      "PostalCode": "94213", 
      "Lat": "37.4307072", 
      "Long": "-122.4295234", 
      "CountrySubDivisionCode": "CA", 
      "Id": "3"
    }, 
    "PreferredDeliveryMethod": "Print", 
    "Taxable": false, 
    "PrintOnCheckName": "Bill's Windsurf Shop", 
    "Balance": 85.0, 
    "Id": "2", 
    "MetaData": {
      "CreateTime": "2014-09-11T16:49:28-07:00", 
      "LastUpdatedTime": "2014-09-18T12:56:01-07:00"
    }
  }, 
  "time": "2015-07-23T11:04:15.496-07:00"
   })
(def credit-memo
  {
  "CreditMemo": {
    "DocNumber": "1026", 
    "SyncToken": "3", 
    "domain": "QBO", 
    "Balance": 0, 
    "BillAddr": {
      "Line4": "Bayshore, CA  94326", 
      "Line3": "4581 Finch St.", 
      "Id": "79", 
      "Line1": "Amy Lauterbach", 
      "Line2": "Amy's Bird Sanctuary"
    }, 
    "BillEmail": {
      "Address": "Birds@Intuit.com"
    }, 
    "TxnDate": "2014-09-02", 
    "TotalAmt": 100.0, 
    "CustomerRef": {
      "name": "Amy's Bird Sanctuary", 
      "value": "1"
    }, 
    "CustomerMemo": {
      "value": "Updated customer memo."
    }, 
    "ShipAddr": {
      "CountrySubDivisionCode": "CA", 
      "City": "Bayshore", 
      "PostalCode": "94326", 
      "Id": "108", 
      "Line1": "4581 Finch St."
    }, 
    "RemainingCredit": 0, 
    "PrintStatus": "NeedToPrint", 
    "EmailStatus": "NotSet", 
    "sparse": false, 
    "Line": [
      {
        "Description": "Pest Control Services", 
        "DetailType": "SalesItemLineDetail", 
        "SalesItemLineDetail": {
          "TaxCodeRef": {
            "value": "NON"
          }, 
          "Qty": 1, 
          "UnitPrice": 100, 
          "ItemRef": {
            "name": "Pest Control", 
            "value": "10"
          }
        }, 
        "LineNum": 1, 
        "Amount": 100.0, 
        "Id": "1"
      }, 
      {
        "DetailType": "SubTotalLineDetail", 
        "Amount": 100.0, 
        "SubTotalLineDetail": {}
      }
    ], 
    "ApplyTaxAfterDiscount": false, 
    "CustomField": [
      {
        "DefinitionId": "1", 
        "Type": "StringType", 
        "Name": "Crew #"
      }
    ], 
    "Id": "73", 
    "TxnTaxDetail": {
      "TotalTax": 0
    }, 
    "MetaData": {
      "CreateTime": "2014-09-18T12:51:27-07:00", 
      "LastUpdatedTime": "2015-07-01T09:16:28-07:00"
    }
  }, 
  "time": "2015-07-23T09:10:45.624-07:00"
   })
(def credit-card-payment
  {
   "CreditCardPaymentTxn": {
                            "SyncToken": "0", 
                            "domain": "QBO", 
                            "CreditCardAccountRef": {
                                                     "name": "Credit Card", 
                                                     "value": "57"
                                                     }, 
                            "TxnDate": "2020-03-27", 
                            "CurrencyRef": {
                                            "name": "United States Dollar", 
                                            "value": "USD"
                                            }, 
                            "Amount": 10.0, 
                            "sparse": false, 
                            "BankAccountRef": {
                                               "name": "Checking", 
                                               "value": "37"
                                               }, 
                            "Id": "29", 
                            "MetaData": {
                                         "CreateTime": "2020-03-27T07:01:04-07:00", 
                                         "LastUpdatedTime": "2020-03-27T07:01:04-07:00"
                                         }
                            }, 
   "time": "2020-03-27T07:06:45.630-07:00"
   })
(def customer
  {
  "Customer": {
    "PrimaryEmailAddr": {
      "Address": "Surf@Intuit.com"
    }, 
    "SyncToken": "0", 
    "domain": "QBO", 
    "GivenName": "Bill", 
    "DisplayName": "Bill's Windsurf Shop", 
    "BillWithParent": false, 
    "FullyQualifiedName": "Bill's Windsurf Shop", 
    "CompanyName": "Bill's Windsurf Shop", 
    "FamilyName": "Lucchini", 
    "sparse": false, 
    "PrimaryPhone": {
      "FreeFormNumber": "(415) 444-6538"
    }, 
    "Active": true, 
    "Job": false, 
    "BalanceWithJobs": 85.0, 
    "BillAddr": {
      "City": "Half Moon Bay", 
      "Line1": "12 Ocean Dr.", 
      "PostalCode": "94213", 
      "Lat": "37.4307072", 
      "Long": "-122.4295234", 
      "CountrySubDivisionCode": "CA", 
      "Id": "3"
    }, 
    "PreferredDeliveryMethod": "Print", 
    "Taxable": false, 
    "PrintOnCheckName": "Bill's Windsurf Shop", 
    "Balance": 85.0, 
    "Id": "2", 
    "MetaData": {
      "CreateTime": "2014-09-11T16:49:28-07:00", 
      "LastUpdatedTime": "2014-09-18T12:56:01-07:00"
    }
  }, 
  "time": "2015-07-23T11:04:15.496-07:00"
   })
(def department)
(def deposit)
(def employee
  {
   "Employee": {
                "SyncToken": "0", 
                "domain": "QBO", 
                "DisplayName": "Bill Miller", 
                "PrimaryPhone": {
                                 "FreeFormNumber": "234-525-1234"
                                 }, 
                "PrintOnCheckName": "Bill Miller", 
                "FamilyName": "Miller", 
                "Active": true, 
                "SSN": "XXX-XX-XXXX", 
                "PrimaryAddr": {
                                "CountrySubDivisionCode": "CA", 
                                "City": "Middlefield", 
                                "PostalCode": "93242", 
                                "Id": "116", 
                                "Line1": "45 N. Elm Street"
                                }, 
                "sparse": false, 
                "BillableTime": false, 
                "GivenName": "Bill", 
                "Id": "71", 
                "MetaData": {
                             "CreateTime": "2015-07-24T09:34:35-07:00", 
                             "LastUpdatedTime": "2015-07-24T09:34:35-07:00"
                             }
                }, 
   "time": "2015-07-24T09:35:54.805-07:00"
   })
(def entitlements)
(def estimate
  {
  "Estimate": {
    "DocNumber": "1001", 
    "SyncToken": "0", 
    "domain": "QBO", 
    "TxnStatus": "Pending", 
    "BillEmail": {
      "Address": "Cool_Cars@intuit.com"
    }, 
    "TxnDate": "2015-03-26", 
    "TotalAmt": 31.5, 
    "CustomerRef": {
      "name": "Cool Cars", 
      "value": "3"
    }, 
    "CustomerMemo": {
      "value": "Thank you for your business and have a great day!"
    }, 
    "ShipAddr": {
      "CountrySubDivisionCode": "CA", 
      "City": "Half Moon Bay", 
      "PostalCode": "94213", 
      "Id": "104", 
      "Line1": "65 Ocean Dr."
    }, 
    "PrintStatus": "NeedToPrint", 
    "BillAddr": {
      "CountrySubDivisionCode": "CA", 
      "City": "Half Moon Bay", 
      "PostalCode": "94213", 
      "Id": "103", 
      "Line1": "65 Ocean Dr."
    }, 
    "sparse": false, 
    "EmailStatus": "NotSet", 
    "Line": [
      {
        "Description": "Pest Control Services", 
        "DetailType": "SalesItemLineDetail", 
        "SalesItemLineDetail": {
          "TaxCodeRef": {
            "value": "NON"
          }, 
          "Qty": 1, 
          "UnitPrice": 35, 
          "ItemRef": {
            "name": "Pest Control", 
            "value": "10"
          }
        }, 
        "LineNum": 1, 
        "Amount": 35.0, 
        "Id": "1"
      }, 
      {
        "DetailType": "SubTotalLineDetail", 
        "Amount": 35.0, 
        "SubTotalLineDetail": {}
      }, 
      {
        "DetailType": "DiscountLineDetail", 
        "Amount": 3.5, 
        "DiscountLineDetail": {
          "DiscountAccountRef": {
            "name": "Discounts given", 
            "value": "86"
          }, 
          "PercentBased": true, 
          "DiscountPercent": 10
        }
      }
    ], 
    "ApplyTaxAfterDiscount": false, 
    "CustomField": [
      {
        "DefinitionId": "1", 
        "Type": "StringType", 
        "Name": "Crew #"
      }
    ], 
    "Id": "177", 
    "TxnTaxDetail": {
      "TotalTax": 0
    }, 
    "MetaData": {
      "CreateTime": "2015-03-26T13:25:05-07:00", 
      "LastUpdatedTime": "2015-03-26T13:25:05-07:00"
    }
  }, 
  "time": "2015-03-26T13:25:05.473-07:00"
   })
(def exchange-rate)
(def journal-code)
(def journal-entry)
(def invoice
  {
  "Invoice": {
    "TxnDate": "2014-09-19", 
    "domain": "QBO", 
    "PrintStatus": "NeedToPrint", 
    "SalesTermRef": {
      "value": "3"
    }, 
    "TotalAmt": 362.07, 
    "Line": [
      {
        "Description": "Rock Fountain", 
        "DetailType": "SalesItemLineDetail", 
        "SalesItemLineDetail": {
          "TaxCodeRef": {
            "value": "TAX"
          }, 
          "Qty": 1, 
          "UnitPrice": 275, 
          "ItemRef": {
            "name": "Rock Fountain", 
            "value": "5"
          }
        }, 
        "LineNum": 1, 
        "Amount": 275.0, 
        "Id": "1"
      }, 
      {
        "Description": "Fountain Pump", 
        "DetailType": "SalesItemLineDetail", 
        "SalesItemLineDetail": {
          "TaxCodeRef": {
            "value": "TAX"
          }, 
          "Qty": 1, 
          "UnitPrice": 12.75, 
          "ItemRef": {
            "name": "Pump", 
            "value": "11"
          }
        }, 
        "LineNum": 2, 
        "Amount": 12.75, 
        "Id": "2"
      }, 
      {
        "Description": "Concrete for fountain installation", 
        "DetailType": "SalesItemLineDetail", 
        "SalesItemLineDetail": {
          "TaxCodeRef": {
            "value": "TAX"
          }, 
          "Qty": 5, 
          "UnitPrice": 9.5, 
          "ItemRef": {
            "name": "Concrete", 
            "value": "3"
          }
        }, 
        "LineNum": 3, 
        "Amount": 47.5, 
        "Id": "3"
      }, 
      {
        "DetailType": "SubTotalLineDetail", 
        "Amount": 335.25, 
        "SubTotalLineDetail": {}
      }
    ], 
    "DueDate": "2014-10-19", 
    "ApplyTaxAfterDiscount": false, 
    "DocNumber": "1037", 
    "sparse": false, 
    "CustomerMemo": {
      "value": "Thank you for your business and have a great day!"
    }, 
    "Deposit": 0, 
    "Balance": 362.07, 
    "CustomerRef": {
      "name": "Sonnenschein Family Store", 
      "value": "24"
    }, 
    "TxnTaxDetail": {
      "TxnTaxCodeRef": {
        "value": "2"
      }, 
      "TotalTax": 26.82, 
      "TaxLine": [
        {
          "DetailType": "TaxLineDetail", 
          "Amount": 26.82, 
          "TaxLineDetail": {
            "NetAmountTaxable": 335.25, 
            "TaxPercent": 8, 
            "TaxRateRef": {
              "value": "3"
            }, 
            "PercentBased": true
          }
        }
      ]
    }, 
    "SyncToken": "0", 
    "LinkedTxn": [
      {
        "TxnId": "100", 
        "TxnType": "Estimate"
      }
    ], 
    "BillEmail": {
      "Address": "Familiystore@intuit.com"
    }, 
    "ShipAddr": {
      "City": "Middlefield", 
      "Line1": "5647 Cypress Hill Ave.", 
      "PostalCode": "94303", 
      "Lat": "37.4238562", 
      "Long": "-122.1141681", 
      "CountrySubDivisionCode": "CA", 
      "Id": "25"
    }, 
    "EmailStatus": "NotSet", 
    "BillAddr": {
      "Line4": "Middlefield, CA  94303", 
      "Line3": "5647 Cypress Hill Ave.", 
      "Line2": "Sonnenschein Family Store", 
      "Line1": "Russ Sonnenschein", 
      "Long": "-122.1141681", 
      "Lat": "37.4238562", 
      "Id": "95"
    }, 
    "MetaData": {
      "CreateTime": "2014-09-19T13:16:17-07:00", 
      "LastUpdatedTime": "2014-09-19T13:16:17-07:00"
    }, 
    "CustomField": [
      {
        "DefinitionId": "1", 
        "StringValue": "102", 
        "Type": "StringType", 
        "Name": "Crew #"
      }
    ], 
    "Id": "130"
  }, 
  "time": "2015-07-24T10:48:27.082-07:00"
   })
(def item
  {
   "Item": {
            "FullyQualifiedName": "Trees", 
            "domain": "QBO", 
            "Name": "Trees", 
            "SyncToken": "0", 
            "sparse": false, 
            "Active": true, 
            "Type": "Category", 
            "Id": "29", 
            "MetaData": {
                         "CreateTime": "2015-10-06T08:50:34-07:00", 
                         "LastUpdatedTime": "2015-10-06T08:50:34-07:00"
                         }
            }, 
   "time": "2015-10-06T08:50:34.863-07:00"
   })
(def payment
  {
  "Payment": {
    "SyncToken": "0", 
    "domain": "QBO", 
    "DepositToAccountRef": {
      "value": "4"
    }, 
    "UnappliedAmt": 10.0, 
    "TxnDate": "2015-01-16", 
    "TotalAmt": 65.0, 
    "ProcessPayment": false, 
    "sparse": false, 
    "Line": [
      {
        "Amount": 55.0, 
        "LineEx": {
          "any": [
            {
              "name": "{http://schema.intuit.com/finance/v3}NameValue", 
              "nil": false, 
              "value": {
                "Name": "txnId", 
                "Value": "70"
              }, 
              "declaredType": "com.intuit.schema.finance.v3.NameValue", 
              "scope": "javax.xml.bind.JAXBElement$GlobalScope", 
              "globalScope": true, 
              "typeSubstituted": false
            }, 
            {
              "name": "{http://schema.intuit.com/finance/v3}NameValue", 
              "nil": false, 
              "value": {
                "Name": "txnOpenBalance", 
                "Value": "71.00"
              }, 
              "declaredType": "com.intuit.schema.finance.v3.NameValue", 
              "scope": "javax.xml.bind.JAXBElement$GlobalScope", 
              "globalScope": true, 
              "typeSubstituted": false
            }, 
            {
              "name": "{http://schema.intuit.com/finance/v3}NameValue", 
              "nil": false, 
              "value": {
                "Name": "txnReferenceNumber", 
                "Value": "1024"
              }, 
              "declaredType": "com.intuit.schema.finance.v3.NameValue", 
              "scope": "javax.xml.bind.JAXBElement$GlobalScope", 
              "globalScope": true, 
              "typeSubstituted": false
            }
          ]
        }, 
        "LinkedTxn": [
          {
            "TxnId": "70", 
            "TxnType": "Invoice"
          }
        ]
      }
    ], 
    "CustomerRef": {
      "name": "Red Rock Diner", 
      "value": "20"
    }, 
    "Id": "163", 
    "MetaData": {
      "CreateTime": "2015-01-16T15:08:12-08:00", 
      "LastUpdatedTime": "2015-01-16T15:08:12-08:00"
    }
  }, 
  "time": "2015-07-28T15:16:15.435-07:00"
   })
(def payment-method)
(def preferences
  {
  "Preferences": {
    "EmailMessagesPrefs": {
      "InvoiceMessage": {
        "Message": "Your invoice is attached.  Please remit payment at your earliest convenience.\nThank you for your business - we appreciate it very much.\n\nSincerely,\nCraig's Design and Landscaping Services", 
        "Subject": "Invoice from Craig's Design and Landscaping Services"
      }, 
      "EstimateMessage": {
        "Message": "Please review the estimate below.  Feel free to contact us if you have any questions.\nWe look forward to working with you.\n\nSincerely,\nCraig's Design and Landscaping Services", 
        "Subject": "Estimate from Craig's Design and Landscaping Services"
      }, 
      "SalesReceiptMessage": {
        "Message": "Your sales receipt is attached.\nThank you for your business - we appreciate it very much.\n\nSincerely,\nCraig's Design and Landscaping Services", 
        "Subject": "Sales Receipt from Craig's Design and Landscaping Services"
      }, 
      "StatementMessage": {
        "Message": "Your statement is attached.  Please remit payment at your earliest convenience.\nThank you for your business - we appreciate it very much.\n\nSincerely,\nCraig's Design and Landscaping Services", 
        "Subject": "Statement from Craig's Design and Landscaping Services"
      }
    }, 
    "ProductAndServicesPrefs": {
      "QuantityWithPriceAndRate": true, 
      "ForPurchase": true, 
      "QuantityOnHand": true, 
      "ForSales": true
    }, 
    "domain": "QBO", 
    "SyncToken": "6", 
    "ReportPrefs": {
      "ReportBasis": "Accrual", 
      "CalcAgingReportFromTxnDate": false
    }, 
    "AccountingInfoPrefs": {
      "FirstMonthOfFiscalYear": "January", 
      "UseAccountNumbers": true, 
      "TaxYearMonth": "January", 
      "ClassTrackingPerTxn": false, 
      "TrackDepartments": true, 
      "TaxForm": "6", 
      "CustomerTerminology": "Customers", 
      "BookCloseDate": "2018-12-31", 
      "DepartmentTerminology": "Location", 
      "ClassTrackingPerTxnLine": true
    }, 
    "SalesFormsPrefs": {
      "ETransactionPaymentEnabled": false, 
      "CustomTxnNumbers": false, 
      "AllowShipping": false, 
      "AllowServiceDate": false, 
      "ETransactionEnabledStatus": "NotApplicable", 
      "DefaultCustomerMessage": "Thank you for your business and have a great day!", 
      "EmailCopyToCompany": false, 
      "AllowEstimates": true, 
      "DefaultTerms": {
        "value": "3"
      }, 
      "AllowDiscount": true, 
      "DefaultDiscountAccount": "86", 
      "AllowDeposit": true, 
      "AutoApplyPayments": true, 
      "IPNSupportEnabled": false, 
      "AutoApplyCredit": true, 
      "CustomField": [
        {
          "CustomField": [
            {
              "BooleanValue": false, 
              "Type": "BooleanType", 
              "Name": "SalesFormsPrefs.UseSalesCustom3"
            }, 
            {
              "BooleanValue": false, 
              "Type": "BooleanType", 
              "Name": "SalesFormsPrefs.UseSalesCustom2"
            }, 
            {
              "BooleanValue": true, 
              "Type": "BooleanType", 
              "Name": "SalesFormsPrefs.UseSalesCustom1"
            }
          ]
        }, 
        {
          "CustomField": [
            {
              "StringValue": "Crew #", 
              "Type": "StringType", 
              "Name": "SalesFormsPrefs.SalesCustomName1"
            }
          ]
        }
      ], 
      "UsingPriceLevels": false, 
      "ETransactionAttachPDF": false
    }, 
    "VendorAndPurchasesPrefs": {
      "BillableExpenseTracking": true, 
      "TrackingByCustomer": true, 
      "POCustomField": [
        {
          "CustomField": [
            {
              "BooleanValue": false, 
              "Type": "BooleanType", 
              "Name": "PurchasePrefs.UsePurchaseCustom3"
            }, 
            {
              "BooleanValue": true, 
              "Type": "BooleanType", 
              "Name": "PurchasePrefs.UsePurchaseCustom2"
            }, 
            {
              "BooleanValue": true, 
              "Type": "BooleanType", 
              "Name": "PurchasePrefs.UsePurchaseCustom1"
            }
          ]
        }, 
        {
          "CustomField": [
            {
              "StringValue": "Sales Rep", 
              "Type": "StringType", 
              "Name": "PurchasePrefs.PurchaseCustomName2"
            }, 
            {
              "StringValue": "Crew #", 
              "Type": "StringType", 
              "Name": "PurchasePrefs.PurchaseCustomName1"
            }
          ]
        }
      ]
    }, 
    "TaxPrefs": {
      "TaxGroupCodeRef": {
        "value": "2"
      }, 
      "UsingSalesTax": true
    }, 
    "OtherPrefs": {
      "NameValue": [
        {
          "Name": "SalesFormsPrefs.DefaultCustomerMessage", 
          "Value": "Thank you for your business and have a great day!"
        }, 
        {
          "Name": "SalesFormsPrefs.DefaultItem", 
          "Value": "1"
        }, 
        {
          "Name": "DTXCopyMemo", 
          "Value": "false"
        }, 
        {
          "Name": "UncategorizedAssetAccountId", 
          "Value": "32"
        }, 
        {
          "Name": "UncategorizedIncomeAccountId", 
          "Value": "30"
        }, 
        {
          "Name": "UncategorizedExpenseAccountId", 
          "Value": "31"
        }, 
        {
          "Name": "SFCEnabled", 
          "Value": "true"
        }, 
        {
          "Name": "DataPartner", 
          "Value": "false"
        }, 
        {
          "Name": "Vendor1099Enabled", 
          "Value": "true"
        }, 
        {
          "Name": "TimeTrackingFeatureEnabled", 
          "Value": "true"
        }, 
        {
          "Name": "FDPEnabled", 
          "Value": "false"
        }, 
        {
          "Name": "ProjectsEnabled", 
          "Value": "false"
        }, 
        {
          "Name": "DateFormat", 
          "Value": "Month Date Year separated by a slash"
        }, 
        {
          "Name": "DateFormatMnemonic", 
          "Value": "MMDDYYYY_SEP_SLASH"
        }, 
        {
          "Name": "NumberFormat", 
          "Value": "US Number Format"
        }, 
        {
          "Name": "NumberFormatMnemonic", 
          "Value": "US_NB"
        }, 
        {
          "Name": "WarnDuplicateCheckNumber", 
          "Value": "true"
        }, 
        {
          "Name": "WarnDuplicateBillNumber", 
          "Value": "false"
        }, 
        {
          "Name": "SignoutInactiveMinutes", 
          "Value": "60"
        }, 
        {
          "Name": "AccountingInfoPrefs.ShowAccountNumbers", 
          "Value": "false"
        }
      ]
    }, 
    "sparse": false, 
    "TimeTrackingPrefs": {
      "WorkWeekStartDate": "Monday", 
      "MarkTimeEntriesBillable": true, 
      "ShowBillRateToAll": false, 
      "UseServices": true, 
      "BillCustomers": true
    }, 
    "CurrencyPrefs": {
      "HomeCurrency": {
        "value": "USD"
      }, 
      "MultiCurrencyEnabled": false
    }, 
    "Id": "1", 
    "MetaData": {
      "CreateTime": "2017-10-25T01:05:43-07:00", 
      "LastUpdatedTime": "2018-03-08T13:24:26-08:00"
    }
  }, 
  "time": "2018-03-12T08:22:43.280-07:00"
   })
(def purchase)
(def purchase-order)
(def recurring-transaction)
(def refund-receipt)
(def reimburse-charge)
(def sales-receipt)
(def tax-classification)
(def tax-code)
(def tax-payment)
(def tax-rate)
(def tax-service)
(def tax-agency
  {
   "time": "2015-07-27T14:30:33.478-07:00", 
   "TaxAgency": {
                 "SyncToken": "0", 
                 "domain": "QBO", 
                 "DisplayName": "Arizona Dept. of Revenue", 
                 "TaxTrackedOnSales": true, 
                 "TaxTrackedOnPurchases": false, 
                 "sparse": false, 
                 "Id": "1", 
                 "MetaData": {
                              "CreateTime": "2014-09-18T12:17:04-07:00", 
                              "LastUpdatedTime": "2014-09-18T12:17:04-07:00"
                              }
                 }
   })
(def term)
(def time-activity)
(def transfer)
(def vendor
  {
   "Vendor": {
              "PrimaryEmailAddr": {
                                   "Address": "Books@Intuit.com"
                                   }, 
              "Vendor1099": false, 
              "domain": "QBO", 
              "GivenName": "Bessie", 
              "DisplayName": "Books by Bessie", 
              "BillAddr": {
                           "City": "Palo Alto", 
                           "Line1": "15 Main St.", 
                           "PostalCode": "94303", 
                           "Lat": "37.445013", 
                           "Long": "-122.1391443", 
                           "CountrySubDivisionCode": "CA", 
                           "Id": "31"
                           }, 
              "SyncToken": "0", 
              "PrintOnCheckName": "Books by Bessie", 
              "FamilyName": "Williams", 
              "PrimaryPhone": {
                               "FreeFormNumber": "(650) 555-7745"
                               }, 
              "AcctNum": "1345", 
              "CompanyName": "Books by Bessie", 
              "WebAddr": {
                          "URI": "http://www.booksbybessie.co"
                          }, 
              "sparse": false, 
              "Active": true, 
              "Balance": 0, 
              "Id": "30", 
              "MetaData": {
                           "CreateTime": "2014-09-12T10:07:56-07:00", 
                           "LastUpdatedTime": "2014-09-17T11:13:46-07:00"
                           }
              }, 
   "time": "2015-07-28T13:33:09.453-07:00"
   })
(def vendor-credit)
(def attachable
  {
   "Attachable": {
                  "SyncToken": "0", 
                  "domain": "QBO", 
                  "AttachableRef": [
                                    {
                                     "IncludeOnSend": false, 
                                     "EntityRef": {
                                                   "type": "Invoice", 
                                                   "value": "95"
                                                   }
                                     }
                                    ], 
                  "Note": "This is an attached note.", 
                  "sparse": false, 
                  "Id": "200900000000000008541", 
                  "MetaData": {
                               "CreateTime": "2015-11-17T11:05:15-08:00", 
                               "LastUpdatedTime": "2015-11-17T11:05:15-08:00"
                               }
                  }, 
   "time": "2015-11-17T11:05:15.797-08:00"
   })
(def batch
  "The batch operation enables an application to perform multiple operations in a single request.  For example, in a single batch request an application can create a customer, update an invoice, and read an account.  Compared to multiple requests, a single batch request can improve an application's performance by decreasing network roundtrips and increasing throughput. The individual operations within a batch request are called BatchItemRequest objects."
  {})
(def change-data-capture)
(def class
  {
   "Class": {
             "FullyQualifiedName": "France", 
             "domain": "QBO", 
             "Name": "France", 
             "SyncToken": "0", 
             "SubClass": false, 
             "sparse": false, 
             "Active": true, 
             "Id": "5000000000000007280", 
             "MetaData": {
                          "CreateTime": "2015-07-22T13:57:27-07:00", 
                          "LastUpdatedTime": "2015-07-22T13:57:27-07:00"
                          }
             }, 
   "time": "2015-07-22T13:57:27.84-07:00"
   })
(def company-currency
  {
   "CompanyCurrency": {
                       "SyncToken": "0", 
                       "domain": "QBO", 
                       "Code": "EUR", 
                       "Name": "Euro", 
                       "sparse": false, 
                       "Active": true, 
                       "Id": "2", 
                       "MetaData": {
                                    "CreateTime": "2015-06-05T13:59:42-07:00", 
                                    "LastUpdatedTime": "2015-06-05T13:59:42-07:00"
                                    }
                       }, 
   "time": "2015-07-06T13:30:04.123-07:00"
   })
(def customer-type
  {
   "CustomerType": {
                    "SyncToken": "1", 
                    "domain": "QBO", 
                    "Name": "ActiveNew", 
                    "sparse": false, 
                    "Active": true, 
                    "Id": "5000000000000003466", 
                    "MetaData": {
                                 "CreateTime": "2019-04-10T15:18:04-07:00", 
                                 "LastUpdatedTime": "2019-04-10T15:36:53-07:00"
                                 }
                    }, 
   "time": "2019-04-12T16:19:36.824-07:00"
   })
(def department)

;; Report Entities

(def account-list-detail
  {
  "Header": {
    "ReportName": "AccountList", 
    "Currency": "USD", 
    "Option": [
      {
        "Name": "NoReportData", 
        "Value": "false"
      }
    ], 
    "Time": "2016-03-08T11:56:36-08:00"
  }, 
  "Rows": {
    "Row": [
      {
        "ColData": [
          {
            "value": "Billable Expense Income"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Design income"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Discounts given"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Fees Billed"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Landscaping Services"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Landscaping Services:Job Materials"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Landscaping Services:Job Materials:Decks and Patios"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Landscaping Services:Job Materials:Fountains and Garden Lighting"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Landscaping Services:Job Materials:Plants and Soil"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Landscaping Services:Job Materials:Sprinklers and Drip Systems"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Landscaping Services:Labor"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Landscaping Services:Labor:Installation"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Landscaping Services:Labor:Maintenance and Repair"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Other Income"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Pest Control Services"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Refunds-Allowances"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Sales of Product Income"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Services"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Shipping Income"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Unapplied Cash Payment Income"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }, 
      {
        "ColData": [
          {
            "value": "Uncategorized Income"
          }, 
          {
            "value": "Income"
          }
        ], 
        "type": "Data"
      }
    ]
  }, 
  "Columns": {
    "Column": [
      {
        "ColType": "account_name", 
        "ColTitle": "Account"
      }, 
      {
        "ColType": "account_type", 
        "ColTitle": "Type"
      }
    ]
  }
   })
(def ap-aging-detail
  {
  "Header": {
    "ReportName": "AgedPayableDetail", 
    "Currency": "USD", 
    "EndPeriod": "2015-06-30", 
    "Option": [
      {
        "Name": "report_date", 
        "Value": "2015-06-30"
      }, 
      {
        "Name": "NoReportData", 
        "Value": "false"
      }
    ], 
    "Time": "2016-03-08T14:34:28-08:00"
  }, 
  "Rows": {
    "Row": [
      {
        "Header": {
          "ColData": [
            {
              "value": "31 - 60 days past due"
            }, 
            {
              "value": ""
            }
          ]
        }, 
        "Rows": {
          "Row": [
            {
              "ColData": [
                {
                  "id": "32", 
                  "value": "Cal Telephone"
                }, 
                {
                  "value": "2015-05-24"
                }
              ], 
              "type": "Data"
            }
          ]
        }, 
        "type": "Section"
      }, 
      {
        "Header": {
          "ColData": [
            {
              "value": "Total for 31 - 60 days past due"
            }, 
            {
              "value": ""
            }
          ]
        }, 
        "Rows": {}, 
        "type": "Section"
      }, 
      {
        "Header": {
          "ColData": [
            {
              "value": "1 - 30 days past due"
            }, 
            {
              "value": ""
            }
          ]
        }, 
        "Rows": {
          "Row": [
            {
              "ColData": [
                {
                  "id": "48", 
                  "value": "PG&E"
                }, 
                {
                  "value": "2015-06-24"
                }
              ], 
              "type": "Data"
            }, 
            {
              "ColData": [
                {
                  "id": "51", 
                  "value": "Tim Philip Masonry"
                }, 
                {
                  "value": "2015-06-24"
                }
              ], 
              "type": "Data"
            }
          ]
        }, 
        "type": "Section"
      }, 
      {
        "Header": {
          "ColData": [
            {
              "value": "Total for 1 - 30 days past due"
            }, 
            {
              "value": ""
            }
          ]
        }, 
        "type": "Section"
      }
    ]
  }, 
  "Columns": {
    "Column": [
      {
        "ColType": "vend_name", 
        "ColTitle": "Vendor"
      }, 
      {
        "ColType": "due_date", 
        "ColTitle": "Due Date"
      }
    ]
  }
   })
(def ap-aging-summary
  {
  "Header": {
    "Customer": "4", 
    "ReportName": "AgedReceivables", 
    "Option": [
      {
        "Name": "report_date", 
        "Value": "2015-12-31"
      }, 
      {
        "Name": "NoReportData", 
        "Value": "false"
      }
    ], 
    "DateMacro": "last calendar year", 
    "StartPeriod": "2015-01-01", 
    "Currency": "USD", 
    "EndPeriod": "2015-12-31", 
    "Time": "2016-03-09T09:09:52-08:00"
  }, 
  "Rows": {
    "Row": [
      {
        "ColData": [
          {
            "id": "4", 
            "value": "Jane Litigious"
          }, 
          {
            "value": ""
          }, 
          {
            "value": ""
          }, 
          {
            "value": ""
          }, 
          {
            "value": ""
          }, 
          {
            "value": "37.50"
          }, 
          {
            "value": "37.50"
          }
        ]
      }, 
      {
        "group": "GrandTotal", 
        "type": "Section", 
        "Summary": {
          "ColData": [
            {
              "value": "TOTAL"
            }, 
            {
              "value": "0.00"
            }, 
            {
              "value": "0.00"
            }, 
            {
              "value": "0.00"
            }, 
            {
              "value": "0.00"
            }, 
            {
              "value": "37.50"
            }, 
            {
              "value": "37.50"
            }
          ]
        }
      }
    ]
  }, 
  "Columns": {
    "Column": [
      {
        "ColType": "Customer", 
        "ColTitle": ""
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "Current"
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "1 - 30"
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "31 - 60"
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "61 - 90"
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "91 and over"
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "Total"
      }
    ]
  }
   })
(def ar-aging-detail)
(def ar-aging-summary)
(def balance-sheet
  {
  "Header": {
    "ReportName": "BalanceSheet", 
    "Option": [
      {
        "Name": "AccountingStandard", 
        "Value": "GAAP"
      }, 
      {
        "Name": "NoReportData", 
        "Value": "false"
      }
    ], 
    "DateMacro": "this calendar year-to-date", 
    "ReportBasis": "Accrual", 
    "StartPeriod": "2016-01-01", 
    "Currency": "USD", 
    "EndPeriod": "2016-10-31", 
    "Time": "2016-10-31T09:42:21-07:00", 
    "SummarizeColumnsBy": "Total"
  }, 
  "Rows": {
    "Row": [
      {
        "Header": {
          "ColData": [
            {
              "value": "ASSETS"
            }, 
            {
              "value": ""
            }
          ]
        }, 
        "Rows": {
          "Row": [
            {
              "Header": {
                "ColData": [
                  {
                    "value": "Current Assets"
                  }, 
                  {
                    "value": ""
                  }
                ]
              }, 
              "Rows": {
                "Row": [
                  {
                    "Header": {
                      "ColData": [
                        {
                          "value": "Bank Accounts"
                        }, 
                        {
                          "value": ""
                        }
                      ]
                    }, 
                    "Rows": {
                      "Row": [
                        {
                          "ColData": [
                            {
                              "id": "35", 
                              "value": "Checking"
                            }, 
                            {
                              "value": "1350.55"
                            }
                          ], 
                          "type": "Data"
                        }, 
                        {
                          "ColData": [
                            {
                              "id": "36", 
                              "value": "Savings"
                            }, 
                            {
                              "value": "800.00"
                            }
                          ], 
                          "type": "Data"
                        }
                      ]
                    }, 
                    "type": "Section", 
                    "group": "BankAccounts", 
                    "Summary": {
                      "ColData": [
                        {
                          "value": "Total Bank Accounts"
                        }, 
                        {
                          "value": "2150.55"
                        }
                      ]
                    }
                  }, 
                  {
                    "Header": {
                      "ColData": [
                        {
                          "value": "Accounts Receivable"
                        }, 
                        {
                          "value": ""
                        }
                      ]
                    }, 
                    "Rows": {
                      "Row": [
                        {
                          "ColData": [
                            {
                              "id": "84", 
                              "value": "Accounts Receivable (A/R)"
                            }, 
                            {
                              "value": "6383.12"
                            }
                          ], 
                          "type": "Data"
                        }
                      ]
                    }, 
                    "type": "Section", 
                    "group": "AR", 
                    "Summary": {
                      "ColData": [
                        {
                          "value": "Total Accounts Receivable"
                        }, 
                        {
                          "value": "6383.12"
                        }
                      ]
                    }
                  }, 
                  {
                    "Header": {
                      "ColData": [
                        {
                          "value": "Other current assets"
                        }, 
                        {
                          "value": ""
                        }
                      ]
                    }, 
                    "Rows": {
                      "Row": [
                        {
                          "ColData": [
                            {
                              "id": "81", 
                              "value": "Inventory Asset"
                            }, 
                            {
                              "value": "596.25"
                            }
                          ], 
                          "type": "Data"
                        }, 
                        {
                          "ColData": [
                            {
                              "id": "4", 
                              "value": "Undeposited Funds"
                            }, 
                            {
                              "value": "2117.52"
                            }
                          ], 
                          "type": "Data"
                        }
                      ]
                    }, 
                    "type": "Section", 
                    "group": "OtherCurrentAssets", 
                    "Summary": {
                      "ColData": [
                        {
                          "value": "Total Other current assets"
                        }, 
                        {
                          "value": "2713.77"
                        }
                      ]
                    }
                  }
                ]
              }, 
              "type": "Section", 
              "group": "CurrentAssets", 
              "Summary": {
                "ColData": [
                  {
                    "value": "Total Current Assets"
                  }, 
                  {
                    "value": "11247.44"
                  }
                ]
              }
            }, 
            {
              "Header": {
                "ColData": [
                  {
                    "value": "Fixed Assets"
                  }, 
                  {
                    "value": ""
                  }
                ]
              }, 
              "Rows": {
                "Row": [
                  {
                    "Header": {
                      "ColData": [
                        {
                          "id": "37", 
                          "value": "Truck"
                        }, 
                        {
                          "value": ""
                        }
                      ]
                    }, 
                    "Rows": {
                      "Row": [
                        {
                          "ColData": [
                            {
                              "id": "38", 
                              "value": "Original Cost"
                            }, 
                            {
                              "value": "13495.00"
                            }
                          ], 
                          "type": "Data"
                        }
                      ]
                    }, 
                    "type": "Section", 
                    "Summary": {
                      "ColData": [
                        {
                          "value": "Total Truck"
                        }, 
                        {
                          "value": "13495.00"
                        }
                      ]
                    }
                  }
                ]
              }, 
              "type": "Section", 
              "group": "FixedAssets", 
              "Summary": {
                "ColData": [
                  {
                    "value": "Total Fixed Assets"
                  }, 
                  {
                    "value": "13495.00"
                  }
                ]
              }
            }
          ]
        }, 
        "type": "Section", 
        "group": "TotalAssets", 
        "Summary": {
          "ColData": [
            {
              "value": "TOTAL ASSETS"
            }, 
            {
              "value": "24742.44"
            }
          ]
        }
      }, 
      {
        "Header": {
          "ColData": [
            {
              "value": "LIABILITIES AND EQUITY"
            }, 
            {
              "value": ""
            }
          ]
        }, 
        "Rows": {
          "Row": [
            {
              "Header": {
                "ColData": [
                  {
                    "value": "Liabilities"
                  }, 
                  {
                    "value": ""
                  }
                ]
              }, 
              "Rows": {
                "Row": [
                  {
                    "Header": {
                      "ColData": [
                        {
                          "value": "Current Liabilities"
                        }, 
                        {
                          "value": ""
                        }
                      ]
                    }, 
                    "Rows": {
                      "Row": [
                        {
                          "Header": {
                            "ColData": [
                              {
                                "value": "Accounts Payable"
                              }, 
                              {
                                "value": ""
                              }
                            ]
                          }, 
                          "Rows": {
                            "Row": [
                              {
                                "ColData": [
                                  {
                                    "id": "33", 
                                    "value": "Accounts Payable (A/P)"
                                  }, 
                                  {
                                    "value": "1984.17"
                                  }
                                ], 
                                "type": "Data"
                              }
                            ]
                          }, 
                          "type": "Section", 
                          "group": "AP", 
                          "Summary": {
                            "ColData": [
                              {
                                "value": "Total Accounts Payable"
                              }, 
                              {
                                "value": "1984.17"
                              }
                            ]
                          }
                        }, 
                        {
                          "Header": {
                            "ColData": [
                              {
                                "value": "Credit Cards"
                              }, 
                              {
                                "value": ""
                              }
                            ]
                          }, 
                          "Rows": {
                            "Row": [
                              {
                                "ColData": [
                                  {
                                    "id": "41", 
                                    "value": "Mastercard"
                                  }, 
                                  {
                                    "value": "157.72"
                                  }
                                ], 
                                "type": "Data"
                              }
                            ]
                          }, 
                          "type": "Section", 
                          "group": "CreditCards", 
                          "Summary": {
                            "ColData": [
                              {
                                "value": "Total Credit Cards"
                              }, 
                              {
                                "value": "157.72"
                              }
                            ]
                          }
                        }, 
                        {
                          "Header": {
                            "ColData": [
                              {
                                "value": "Other Current Liabilities"
                              }, 
                              {
                                "value": ""
                              }
                            ]
                          }, 
                          "Rows": {
                            "Row": [
                              {
                                "ColData": [
                                  {
                                    "id": "89", 
                                    "value": "Arizona Dept. of Revenue Payable"
                                  }, 
                                  {
                                    "value": "4.55"
                                  }
                                ], 
                                "type": "Data"
                              }, 
                              {
                                "ColData": [
                                  {
                                    "id": "90", 
                                    "value": "Board of Equalization Payable"
                                  }, 
                                  {
                                    "value": "401.98"
                                  }
                                ], 
                                "type": "Data"
                              }, 
                              {
                                "ColData": [
                                  {
                                    "id": "43", 
                                    "value": "Loan Payable"
                                  }, 
                                  {
                                    "value": "4000.00"
                                  }
                                ], 
                                "type": "Data"
                              }
                            ]
                          }, 
                          "type": "Section", 
                          "group": "OtherCurrentLiabilities", 
                          "Summary": {
                            "ColData": [
                              {
                                "value": "Total Other Current Liabilities"
                              }, 
                              {
                                "value": "4406.53"
                              }
                            ]
                          }
                        }
                      ]
                    }, 
                    "type": "Section", 
                    "group": "CurrentLiabilities", 
                    "Summary": {
                      "ColData": [
                        {
                          "value": "Total Current Liabilities"
                        }, 
                        {
                          "value": "6548.42"
                        }
                      ]
                    }
                  }, 
                  {
                    "Header": {
                      "ColData": [
                        {
                          "value": "Long-Term Liabilities"
                        }, 
                        {
                          "value": ""
                        }
                      ]
                    }, 
                    "Rows": {
                      "Row": [
                        {
                          "ColData": [
                            {
                              "id": "44", 
                              "value": "Notes Payable"
                            }, 
                            {
                              "value": "25000.00"
                            }
                          ], 
                          "type": "Data"
                        }
                      ]
                    }, 
                    "type": "Section", 
                    "group": "LongTermLiabilities", 
                    "Summary": {
                      "ColData": [
                        {
                          "value": "Total Long-Term Liabilities"
                        }, 
                        {
                          "value": "25000.00"
                        }
                      ]
                    }
                  }
                ]
              }, 
              "type": "Section", 
              "group": "Liabilities", 
              "Summary": {
                "ColData": [
                  {
                    "value": "Total Liabilities"
                  }, 
                  {
                    "value": "31548.42"
                  }
                ]
              }
            }, 
            {
              "Header": {
                "ColData": [
                  {
                    "value": "Equity"
                  }, 
                  {
                    "value": ""
                  }
                ]
              }, 
              "Rows": {
                "Row": [
                  {
                    "ColData": [
                      {
                        "id": "34", 
                        "value": "Opening Balance Equity"
                      }, 
                      {
                        "value": "-9337.50"
                      }
                    ], 
                    "type": "Data"
                  }, 
                  {
                    "ColData": [
                      {
                        "id": "2", 
                        "value": "Retained Earnings"
                      }, 
                      {
                        "value": "91.25"
                      }
                    ], 
                    "type": "Data"
                  }, 
                  {
                    "ColData": [
                      {
                        "value": "Net Income"
                      }, 
                      {
                        "value": "2440.27"
                      }
                    ], 
                    "type": "Data", 
                    "group": "NetIncome"
                  }
                ]
              }, 
              "type": "Section", 
              "group": "Equity", 
              "Summary": {
                "ColData": [
                  {
                    "value": "Total Equity"
                  }, 
                  {
                    "value": "-6805.98"
                  }
                ]
              }
            }
          ]
        }, 
        "type": "Section", 
        "group": "TotalLiabilitiesAndEquity", 
        "Summary": {
          "ColData": [
            {
              "value": "TOTAL LIABILITIES AND EQUITY"
            }, 
            {
              "value": "24742.44"
            }
          ]
        }
      }
    ]
  }, 
  "Columns": {
    "Column": [
      {
        "ColType": "Account", 
        "ColTitle": "", 
        "MetaData": [
          {
            "Name": "ColKey", 
            "Value": "account"
          }
        ]
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "Total", 
        "MetaData": [
          {
            "Name": "ColKey", 
            "Value": "total"
          }
        ]
      }
    ]
  }
   })
(def cash-flow
  {
  "Header": {
    "ReportName": "CashFlow", 
    "Option": [
      {
        "Name": "NoReportData", 
        "Value": "false"
      }
    ], 
    "DateMacro": "last calendar year-to-date", 
    "StartPeriod": "2015-01-01", 
    "Currency": "USD", 
    "EndPeriod": "2015-03-09", 
    "Time": "2016-03-09T11:40:50-08:00", 
    "SummarizeColumnsBy": "Total"
  }, 
  "Rows": {
    "Row": [
      {
        "Header": {
          "ColData": [
            {
              "value": "OPERATING ACTIVITIES"
            }, 
            {
              "value": ""
            }
          ]
        }, 
        "Rows": {
          "Row": [
            {
              "ColData": [
                {
                  "value": "Net Income"
                }, 
                {
                  "value": "-300.00"
                }
              ], 
              "type": "Data", 
              "group": "NetIncome"
            }, 
            {
              "Header": {
                "ColData": [
                  {
                    "value": "Adjustments to reconcile Net Income to Net Cash provided by operations:"
                  }, 
                  {
                    "value": ""
                  }
                ]
              }, 
              "Rows": {
                "Row": [
                  {
                    "ColData": [
                      {
                        "id": "33", 
                        "value": "Accounts Payable (A/P)"
                      }, 
                      {
                        "value": "300.00"
                      }
                    ], 
                    "type": "Data"
                  }
                ]
              }, 
              "type": "Section", 
              "group": "OperatingAdjustments"
            }
          ]
        }, 
        "type": "Section", 
        "group": "OperatingActivities", 
        "Summary": {
          "ColData": [
            {
              "value": "Total Adjustments to reconcile Net Income to Net Cash provided by operations:"
            }, 
            {
              "value": "300.00"
            }
          ]
        }
      }, 
      {
        "Header": {
          "ColData": [
            {
              "value": "FINANCING ACTIVITIES"
            }, 
            {
              "value": ""
            }
          ]
        }, 
        "Rows": {
          "Row": [
            {
              "ColData": [
                {
                  "id": "34", 
                  "value": "Opening Balance Equity"
                }, 
                {
                  "value": "5000.00"
                }
              ], 
              "type": "Data"
            }
          ]
        }, 
        "type": "Section", 
        "group": "FinancingActivities", 
        "Summary": {
          "ColData": [
            {
              "value": "Net cash provided by financing activities"
            }, 
            {
              "value": "5000.00"
            }
          ]
        }
      }, 
      {
        "group": "CashIncrease", 
        "type": "Section", 
        "Summary": {
          "ColData": [
            {
              "value": "Net cash increase for period"
            }, 
            {
              "value": "5000.00"
            }
          ]
        }
      }, 
      {
        "group": "EndingCash", 
        "type": "Section", 
        "Summary": {
          "ColData": [
            {
              "value": "Cash at end of period"
            }, 
            {
              "value": "5000.00"
            }
          ]
        }
      }
    ]
  }, 
  "Columns": {
    "Column": [
      {
        "ColType": "Account", 
        "ColTitle": ""
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "Total"
      }
    ]
  }
   })
(def customer-balance
  {
  "Header": {
    "Customer": "1", 
    "ReportName": "CustomerBalance", 
    "Option": [
      {
        "Name": "report_date", 
        "Value": "2016-03-10"
      }, 
      {
        "Name": "NoReportData", 
        "Value": "false"
      }
    ], 
    "DateMacro": "all", 
    "Currency": "USD", 
    "Time": "2016-03-10T08:51:44-08:00"
  }, 
  "Rows": {
    "Row": [
      {
        "ColData": [
          {
            "id": "1", 
            "value": "Amy's Bird Sanctuary"
          }, 
          {
            "value": "1593.50"
          }
        ]
      }, 
      {
        "group": "GrandTotal", 
        "type": "Section", 
        "Summary": {
          "ColData": [
            {
              "value": "TOTAL"
            }, 
            {
              "value": "1593.50"
            }
          ]
        }
      }
    ]
  }, 
  "Columns": {
    "Column": [
      {
        "ColType": "Customer", 
        "ColTitle": ""
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "Total"
      }
    ]
  }
   })
(def customer-balance-detail
  {
  "Header": {
    "Customer": "1", 
    "ReportName": "CustomerBalanceDetail", 
    "Option": [
      {
        "Name": "report_date", 
        "Value": "2016-03-10"
      }, 
      {
        "Name": "NoReportData", 
        "Value": "false"
      }
    ], 
    "DateMacro": "all", 
    "Currency": "USD", 
    "Time": "2016-03-10T13:43:05-08:00"
  }, 
  "Rows": {
    "Row": [
      {
        "Header": {
          "ColData": [
            {
              "id": "1", 
              "value": "Amy's Bird Sanctuary"
            }, 
            {
              "value": ""
            }
          ]
        }, 
        "Rows": {
          "Row": [
            {
              "ColData": [
                {
                  "value": "2015-08-04"
                }, 
                {
                  "value": "100.0"
                }
              ], 
              "type": "Data"
            }, 
            {
              "ColData": [
                {
                  "value": "2015-08-04"
                }, 
                {
                  "value": "109.1"
                }
              ], 
              "type": "Data"
            }, 
            {
              "ColData": [
                {
                  "value": "2015-08-04"
                }, 
                {
                  "value": "109.1"
                }
              ], 
              "type": "Data"
            }, 
            {
              "ColData": [
                {
                  "value": "2015-08-04"
                }, 
                {
                  "value": "109.2"
                }
              ], 
              "type": "Data"
            }, 
            {
              "ColData": [
                {
                  "value": "2015-08-04"
                }, 
                {
                  "value": "109.2"
                }
              ], 
              "type": "Data"
            }, 
            {
              "ColData": [
                {
                  "value": "2015-08-04"
                }, 
                {
                  "value": "109.1"
                }
              ], 
              "type": "Data"
            }, 
            {
              "ColData": [
                {
                  "value": "2015-08-04"
                }, 
                {
                  "value": "100.0"
                }
              ], 
              "type": "Data"
            }, 
            {
              "ColData": [
                {
                  "value": "2015-08-04"
                }, 
                {
                  "value": "109.1"
                }
              ], 
              "type": "Data"
            }
          ]
        }, 
        "type": "Section", 
        "Summary": {
          "ColData": [
            {
              "value": "Total for Amy's Bird Sanctuary"
            }, 
            {
              "value": "854.8"
            }
          ]
        }
      }, 
      {
        "type": "Section", 
        "Summary": {
          "ColData": [
            {
              "value": "TOTAL"
            }, 
            {
              "value": "854.8"
            }
          ]
        }
      }
    ]
  }, 
  "Columns": {
    "Column": [
      {
        "ColType": "tx_date", 
        "ColTitle": "Date"
      }, 
      {
        "ColType": "subt_amount", 
        "ColTitle": "Amount"
      }
    ]
  }
   })
(def customer-income
  {
  "Header": {
    "Customer": "1", 
    "ReportName": "CustomerIncome", 
    "Option": [
      {
        "Name": "NoReportData", 
        "Value": "false"
      }
    ], 
    "DateMacro": "this calendar year-to-date", 
    "ReportBasis": "Accrual", 
    "StartPeriod": "2016-01-01", 
    "Currency": "USD", 
    "EndPeriod": "2016-03-10", 
    "Time": "2016-03-10T09:28:05-08:00"
  }, 
  "Rows": {
    "Row": [
      {
        "ColData": [
          {
            "id": "1", 
            "value": "Amy's Bird Sanctuary"
          }, 
          {
            "value": "247.66"
          }, 
          {
            "value": "-96.31"
          }, 
          {
            "value": "151.35"
          }
        ]
      }, 
      {
        "group": "GrandTotal", 
        "type": "Section", 
        "Summary": {
          "ColData": [
            {
              "value": "TOTAL"
            }, 
            {
              "value": "247.66"
            }, 
            {
              "value": "-96.31"
            }, 
            {
              "value": "151.35"
            }
          ]
        }
      }
    ]
  }, 
  "Columns": {
    "Column": [
      {
        "ColType": "Customer", 
        "ColTitle": ""
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "Income"
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "Expenses"
      }, 
      {
        "ColType": "Money", 
        "ColTitle": "Net Income"
      }
    ]
  }
   })
(def general-ledger)
(def inventory-valuation-summary)
(def journal-report)
(def journal-report-FR)
(def profit-and-loss)
(def profit-and-loss-detail)
(def sales-by-class-summary)
(def sales-by-customer)
(def sales-by-department)
(def sales-by-product)
(def tax-summary)
(def transaction-list)
(def transaction-list-by-customer)
(def transaction-list-by-vendor)
(def transaction-list-with-splits)
(def trail-balance)
(def vendor-balance)
(def vendor-balance-detail)
(def vendor-expenses)

(ns intuit.quickbooks.payments)

(def bank-account
  {
   "updated": "2015-03-25T22:05:39Z", 
   "name": "Richard Jones", 
   "accountNumber": "XXXX4534", 
   "default": false, 
   "created": "2015-03-25T22:05:39Z", 
   "inputType": "KEYED", 
   "phone": "6047296480", 
   "accountType": "PERSONAL_CHECKING", 
   "routingNumber": "XXXXX0358", 
   "id": "200161921532106731364534"
   })
(def card
  {
   "updated" "2015-03-25T222433Z", 
   "name" "Test User", 
   "created" "2015-03-25T222433Z", 
   "default" false, 
   "number" "xxxxxxxxxxxx7893", 
   "expMonth" "12", 
   "address" {
               "postalCode" "44112", 
               "city" "Richmond", 
               "region" "VA", 
               "streetAddress" "1245 Hana Rd", 
               "country" "US"
               }, 
   "expYear" "2026", 
   "isBusiness" false, 
   "id" "101101015602106732027893"
   })
(def charge
  {
   "status" "CAPTURED", 
   "created" "2014-11-03T164142Z", 
   "authCode" "792668", 
   "token" "bFy3h7W3D2tmOfYxl2msnLbUirY=", 
   "currency" "USD", 
   "amount" "10.55", 
   "id" "EMU254189574"
   })
(def e-check
  {
   "status" "SUCCEEDED", 
   "bankAccount" {
                   "phone" "1234567890", 
                   "routingNumber" "xxxxx0018", 
                   "name" "Fname LName", 
                   "accountType" "PERSONAL_SAVINGS", 
                   "accountNumber" "xxxxxxxxxxxxx6781"
                   }, 
   "description" "Check Auth test call", 
   "created" "2015-03-24T182024Z", 
   "checkNumber" "12345678", 
   "authCode" "698-256", 
   "paymentMode" "WEB", 
   "amount" "5.55", 
   "context" {
               "deviceInfo" {
                              "macAddress" "macaddress", 
                              "ipAddress" "34", 
                              "longitude" "longitude", 
                              "phoneNumber" "phonenu", 
                              "latitude" "latitude", 
                              "type" "type"
                              }
               }, 
   "id" "102088863639971869833376"
   })
(def token
  {
   "value" "bFy3h7W3D2tmOfYxl2msnLbUirY="
   })

(ns intuit.quickbooks.timesheets)

(def current-user
  {
  "results" {
    "users" {
      "933849" {
        "id" 933849,
        "first_name" "Mary",
        "last_name" "Samsonite",
        "group_id" 0,
        "active" true,
        "employee_number" 0,
        "salaried" false,
        "exempt" false,
        "username" "admin",
        "email" "admin@example.com",
        "email_verified" false,
        "payroll_id" "",
        "mobile_number" "2087231456",
        "hire_date" "0000-00-00",
        "term_date" "0000-00-00",
        "last_modified" "2018-03-28T172420+0000",
        "last_active" "",
        "created" "2018-03-27T161334+0000",
        "client_url" "api_sample_output",
        "company_name" "API Sample Output Company",
        "profile_image_url" "https\/\/www.gravatar.com\/avatar\/e64c7d89f26bd1972efa854d13d7dd61",
        "display_name" null,
        "pronouns" null,
        "pto_balances" {
          "2624351" 0,
          "2624353" 0,
          "2624355" 0
        },
        "submitted_to" "2000-01-01",
        "approved_to" "2000-01-01",
        "manager_of_group_ids" [ ],
        "require_password_change" false,
        "pay_rate" 0,
        "pay_interval" "hour",
        "permissions" {
          "admin" true,
          "mobile" true,
          "status_box" false,
          "reports" false,
          "manage_timesheets" false,
          "manage_authorization" false,
          "manage_users" false,
          "manage_my_timesheets" false,
          "manage_jobcodes" false,
          "pin_login" false,
          "approve_timesheets" false,
          "manage_schedules" false,
          "external_access" false,
          "manage_my_schedule" false,
          "manage_company_schedules" false,
          "view_company_schedules" false,
          "view_group_schedules" false,
          "manage_no_schedules" false,
          "view_my_schedules" false
        },
        "customfields" ""
      }
    }
  },
  "more" false,
  "supplemental_data" {
    "jobcodes" {
      "2624351" {
        "id" 2624351,
        "parent_id" 0,
        "assigned_to_all" true,
        "billable" false,
        "active" true,
        "type" "pto",
        ...
      },
      "2624353" {
        "id" 2624353,
        "parent_id" 0,
        "assigned_to_all" true,
        "billable" false,
        "active" true,
        "type" "pto",
        ...
      },
      "2624355" {
        "id" 2624355,
        "parent_id" 0,
        "assigned_to_all" true,
        "billable" false,
        "active" true,
        "type" "pto",
        ...
      }
    }
  }
   })
(def custom-field
  {
   "id" 134913,
   "active" true,
   "required" true,
   "applies_to" "timesheet",
   "type" "managed-list",
   "short_code" "Exp",
   "regex_filter" "",
   "name" "Experience",
   "last_modified" "2019-02-10T204041+0000",
   "created" "2019-02-03T183616+0000",
   "ui_preference" "drop_down",
   "required_customfields" [],
   "show_to_all" false
   })
(def custom-field-item
  {
   "id" 3875655,
   "customfield_id" 143369,
   "active" true,
   "short_code" "JS",
   "name" "Jungle Safari",
   "last_modified" "2019-02-11T174245+0000",
   "required_customfields" []
   })
(def custom-field-item-filter
  {
   "id" 861013,
   "active" true,
   "applies_to" "jobcodes",
   "applies_to_id" 1883683,
   "customfielditem_id" 703671,
   "customfield_id" 117893,
   "last_modified" "2018-07-17T234051+0000"
   })
(def effective-settings
  {
  "general" {
    "settings" {
      "calculate_overtime" "1",
      "clockout_override" 1,
      "clockout_override_hours" 10,
      "clockout_override_notify_admin" 1,
      "clockout_override_notify_mgrs" 0,
      "daily_doubletime" "0",
      "daily_overtime" "0",
      "daily_regular_hours" 8,
      "date_locale" "us",
      "emp_panel" 1,
      "emp_panel_email" "0",
      "emp_panel_passwd" "0",
      "emp_panel_tz" "0",
      "employee_pto_entry" 0,
      "enable_timesheet_notes" "1",
      "hide_working_time" "0",
      "jc_label" "Job",
      "lunch_deduct" 0,
      "lunch_length" 1,
      "lunch_threshold" 9,
      "max_customfielditems" "-1",
      "max_jobcodes" "-1",
      "parent_clockin_display" 0,
      "payroll_end_date" "2018-09-28",
      "payroll_first_end_day" "1",
      "payroll_last_end_day" "16",
      "payroll_month_end_day" "1",
      "payroll_type" "biweekly",
      "pto_entry" 1,
      "pto_overtime" 0,
      "simple_clockin" 0,
      "time_format" 12,
      "timecard_fields" "JOBCODE,134913,143369,143377",
      "timeclock_label" "Time Clock",
      "timesheet_edit_notes_for_all_users" 0,
      "timesheet_notes_notify_admin" 0,
      "timesheet_notes_notify_mgrs" 0,
      "timesheet_notes_required" 0,
      "tz" "America/Denver",
      "week_start" 0,
      "weekly_regular_hours" "40"
    },
    "last_modified" "2019-02-11T174518+0000"
  },
  "alerts" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  },
  "approvals" {
    "settings" {
      "installed" "1"
    },
    "last_modified" "2019-01-25T205352+0000"
  },
  "breaks" {
    "settings" {
      "hide_pre_clockout_option" 0
    },
    "last_modified" "2019-01-25T205352+0000"
  },
  "dcaa" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  },
  "dialin" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  },
  "files" {
    "settings" {
      "installed" "1",
      "files_addon_app_discovery_notification" "1"
    },
    "last_modified" "2019-01-25T205352+0000"
  },
  "invoicing" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  },
  "location_aware" {
    "settings" {
      "installed" 1,
      "show_location" "1"
    },
    "last_modified" "2019-01-25T205352+0000"
  },
  "mobile_app_integrations" {
    "settings" {
      "installed" 1,
      "apps" {
        "expensify" {
          "triggers" {
            "TSMTriggerButton" {
              "id" 553,
              "active" true,
              "jobcode_ids" [
                0
              ],
              "android_playstore_uri" "org.me.mobiexpensifyg",
              "android_call_scheme" "http//mobile.expensify.com/SmartScan",
              "iphone_appstore_url" "https//itunes.apple.com/us/app/expensify-expense-reports/id471713959",
              "iphone_call_scheme" "http//mobile.expensify.com",
              "call_url_host" "SmartScan",
              "call_uri_format" "tag=%JOBCODE_NAME%&billable=%JOBCODE_BILLABLE%&email=%EMAIL%&callbackURL=%TSHEETS_RETURN_URL%",
              "callback_uri_format" ""
            }
          }
        }
      }
    },
    "last_modified" "2019-01-25T205352+0000"
  },
  "mobile_app_settings" {
    "settings" {
      "installed" "1",
      "location_tracking" "off",
      "mandatory_location_services" "0"
    },
    "last_modified" "2019-02-09T183920+0000"
  },
  "reminders" {
    "settings" {
      "installed" 1
    },
    "last_modified" "2019-01-25T205352+0000"
  },
  "projects" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  },
  "quickbooks" {
    "settings" {
      "installed" "1",
      "connector" "qbia_online",
      "connector_type" "payroll_single_sku",
      "two_way_sync_enabled_for_user" 0
    },
    "last_modified" "2019-01-25T205352+0000"
  },
  "restapi" {
    "settings" {
      "installed" "1"
    },
    "last_modified" "2019-01-25T205352+0000"
  },
  "rounding" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  },
  "schedule" {
    "settings" {
      "installed" "1",
      "business_hours_end" "170000",
      "business_hours_start" "080000",
      "drafted_first_schedule_event_occurred" "1",
      "manage_schedule_permission" "company",
      "published_first_schedule_event_occurred" "1",
      "trial_expiration_date" "2018-10-17",
      "view_schedule_permission" "company",
      "learning_step" "7",
      "employee_view" "company",
      "manager_view" "company"
    },
    "last_modified" "2019-02-09T180355+0000"
  },
  "sms" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  },
  "sounds" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  },
  "customfields" {
    "settings" {
      "maximum_allowed_timesheet_custom_fields" 6,
      "installed" "1"
    },
    "last_modified" "2019-02-10T203410+0000"
  },
  "time_entry" {
    "settings" {
      "installed" 1,
      "time_entry_method" "timecard",
      "mtc_format_time_display" "hhmm",
      "time_entry" 0,
      "timecard" 1,
      "weekly_timecard" 1,
      "timecard_daily" 0,
      "timesheet_edit" 0,
      "timesheet_map" 1,
      "pto_entry" 1,
      "timesheet_list_date_range_selection" "month",
      "timesheet_list_show_days_with_no_time" 0,
      "timesheet_list_wrap_text" 0,
      "timesheet_list_column_selection" "time,job,location,kiosk,attachments,notes",
      "timesheet_list_bottomless_scroll" 1,
      "mtc_combine_regular_timesheets" "0"
    },
    "last_modified" "2019-01-25T205352+0000"
  },
  "toodledo" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  },
  "twitter" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  },
  "xero" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  },
  "zenpayroll" {
    "settings" {
      "installed" 0
    },
    "last_modified" "2001-01-01T120000+0000"
  }
   })
(def file
  {
   "id" 47765,
   "uploaded_by_user_id" 317046,
   "file_name" "IMG_20181004_214839.png",
   "active" true,
   "size" 369302,
   "last_modified" "2018-10-05T035749+0000",
   "created" "2018-10-05T035749+0000",
   "linked_objects" {
                      "timesheets" [
                                     "730045"
                                     ]
                      },
   "meta_data" {
                 "file_description" "on-site selfie",
                 "image_rotation" "0"
                 }
   })
(def geo-fence-config
  {
   "id" 151,
   "type" "location",
   "type_id" 282316,
   "active" true,
   "enabled" true,
   "radius" 150,
   "last_modified" "2017-09-07T190926+0000",
   "created" "2017-09-07T190926+0000"
   })
(def geo-location
  {
   "id" 185648268,
   "user_id" 29474,
   "accuracy" 21,
   "altitude" 0,
   "latitude" 43.6866258,
   "longitude" -116.3516646,
   "device_identifier" "",
   "source" "gps",
   "heading" 0,
   "speed" 0,  
   "created" "2018-08-16T175657+0000"
   })
(def group
  {
   "id" 6,
   "active" true,
   "name" "Group 1",
   "last_modified" "2018-08-19T162928+0000",
   "created" "2018-08-19T162928+0000",
   "manager_ids" [
                   "300",
                   "316"
                   ]
   })
(def invitation
  {
   "data" [
            {
             "contact_method" "email",
             "contact_info" "bobsmith@example.com",
             "user_id" "217432"
             },
            {
             "contact_method" "sms",
             "contact_info" "2085551234",
             "user_id" "217435"
             }
            ]
   }
  )
(def job-code
  {
   "id" 17288279,
   "parent_id" 0,
   "assigned_to_all" false,
   "billable" false,
   "active" true,
   "type" "regular",
   "has_children" false,
   "billable_rate" 0,
   "short_code" "asm",
   "name" "Assembly Line",
   "last_modified" "2018-07-12T211314+0000",
   "created" "2018-05-28T201817+0000",
   "filtered_customfielditems" "",
   "required_customfields" [],
   "locations" [],
   "connect_with_quickbooks" true
   })
(def job-code-assignments
  {
   "id" 26881275,
   "user_id" 1242515,
   "jobcode_id" 17285791,
   "active" true,
   "last_modified" "",
   "created" ""
   })
(def last-modified-timestamps
  {
   "results" {
               "last_modified_timestamps" {
                                            "current_user" "2018-03-28T172420+0000",
                                            "customfields" "2018-04-05T194719+0000",
                                            "customfielditems" "2018-04-04T161044+0000",
                                            "effective_settings" "2018-04-05T194719+0000",
                                            "geolocations" "2018-03-27T161328+0000",
                                            "jobcodes" "2018-04-05T194719+0000",
                                            "jobcode_assignments" "2018-04-05T194719+0000",
                                            "timesheets" "2018-03-28T201639+0000",
                                            "timesheets_deleted" "2018-03-27T161328+0000",
                                            "users" "2018-04-05T194718+0000",
                                            "reminders" "2018-03-27T161329+0000",
                                            "locations" "2018-07-16T233627+0000",
                                            "geofence_configs" "2018-05-20T123456+0000"
                                            }
               }
   })
(def location
  {
   "id" 65305,
   "addr1" "235 E Colchester Dr",
   "addr2" "101",
   "city" "Eagle",
   "state" "ID",
   "zip" "83616",
   "country" "US",
   "formatted_address" "235 E Colchester Dr 101, Eagle, ID 83616",
   "active" true,
   "latitude" 43.6700273,
   "longitude" -116.3520972,
   "place_id" "",
   "place_id_hash" "0ba5eaf96c5f63c3b76d5084c365b6e4",
   "label" "TSheets, East Colchester Drive, Eagle, ID, USA",
   "notes" "",
   "geocoding_status" "complete",
   "created" "2018-03-09T182657+0000",
   "last_modified" "2018-03-15T165114+0000",
   "linked_objects" {
                      "jobcodes" [
                                   2589531
                                   ]
                      },
   "geofence_config_id" null
   })
(def location-map
  {
   "id" 102839,
   "x_table" "job_codes",
   "x_id" 2597003,
   "location_id" 237053,
   "created" "2018-06-20T141426+0000",
   "last_modified" "2018-08-01T103116+0000"
   })
(def managed-client
  { 
   "id""1146",
   "company_url""acmedev",
   "company_name""Acme Dev",
   "active"true,
   "created""2018-05-31T165250+0000",
   "last_modified""2018-08-08T222334+0000"
   })
(def notification
  {
   "id" 94140223,
   "msg_tracking_id" "baabeb0ab03d62ce",
   "user_id" 1242515,
   "message" "Please clock in!",
   "method" "push",
   "delivery_time" "2018-06-24T150000+0000",
   "created" "2018-06-23T141757+0000",
   "precheck" "off_the_clock"
   })
(def reminder
  {
   "id" 72595,
   "reminder_type" "clock-in",
   "due_time" "230000",
   "due_days_of_week" "Mon,Tue,Thu,Fri",
   "distribution_methods" "Push,SMS",
   "active" true,
   "enabled" true,
   "last_modified" "2018-07-15T193357+0000",
   "created" "2018-07-15T190833+0000",
   "user_id" 0
   })
(def schedule-calenar
  {
   "id" 72595,
   "name" "Schedule Calendar Name",
   "last_modified" "2018-07-15T193357+0000",
   "created" "2018-07-15T190833+0000"
   })
(def schedule-event
  {
   "id" 894562,
   "user_id" 1283037,
   "unassigned" false,
   "schedule_calendar_id" 72595,
   "jobcode_id" 17285791,
   "start" "2018-08-08T080000-0600",
   "end" "2018-08-08T140000-0600",
   "timezone" "tsMT",
   "notes" "Some Custom Notes",
   "all_day" false,
   "assigned_user_ids" [
                         "332234"
                         ],
   "active" true,
   "draft" false,
   "title" "Shift work",
   "location" "235 E Colchester Dr 101, Eagle, ID 83616",
   "color" "#BF1959",
   "last_modified" "2018-08-09T173054-0600",
   "created" "2018-07-15T190833-0600",
   "customfields" {
                    "19142" "Item 1",
                    "19144" "Item 2"
                    }
   })
(def timesheet
  {
   "id" 135288482,
   "user_id" 1242515,
   "jobcode_id" 17288283,
   "start" "2018-07-16T090400-0600",
   "end" "2018-07-16T155700-0600",
   "duration" 24780,
   "date" "2018-07-16",
   "tz" -6,
   "tz_str" "tsMT",
   "type" "regular",
   "location" "(Eagle, ID?)",
   "on_the_clock" false,
   "locked" 0,
   "notes" "",
   "customfields" {
                    "19142" "Item 1",
                    "19144" "Item 2"
                    },
   "attached_files" [
                      50692,
                      44878
                      ],
   "last_modified" "1970-01-01T000000+0000"
   })
(def timesheet-deleted
  {
   "id" 135288460,
   "user_id" 1242509,
   "jobcode_id" 18080900,
   "start" "2018-07-18T080900-0600",
   "end" "2018-07-18T145800-0600",
   "duration" 24540,
   "date" "2018-07-18",
   "tz" -6,
   "tz_str" "tsMT",
   "type" "regular",
   "location" "(Eagle, ID?)",
   "active" "0",
   "locked" 0,
   "notes" "",
   "last_modified" "2018-08-05T212155+0000"
   })
(def time-off-request
  {
   "id" 1546922,
   "user_id" 423,
   "time_off_request_notes" [ 96024 ],
   "time_off_request_entries" [ 11374, 11375 ],
   "status" "pending",
   "active" true,
   "created" "2018-11-11T105615-0600",
   "last_modified" "2018-11-11T105615-0600"
   })
(def time-off-entry
  {
   "id" 11374,
   "time_off_request_id" 1546922,
   "status" "pending",
   "approver_user_id" 0,
   "date" "2018-11-15",
   "entry_method" "manual",
   "duration" 28800,
   "start_time" "2018-11-15T000000-0700",
   "end_time" "2018-11-15T235959-0700",
   "tz_string" "America/Denver",
   "jobcode_id" 1345687,
   "user_id" 423,
   "approved_timesheet_id" 0,
   "active" true,
   "created" "2018-11-11T105615-0600",
   "last_modified" "2018-11-11T105615-0600"
   })
(def user
  {
  "id" 933849,
  "first_name" "Mary",
  "last_name" "Samsonite",
  "group_id" 0,
  "active" true,
  "employee_number" 0,
  "salaried" false,
  "exempt" false,
  "username" "admin",
  "email" "admin@example.com",
  "email_verified" false,
  "payroll_id" "",
  "mobile_number" "2087231456",
  "hire_date" "0000-00-00",
  "term_date" "0000-00-00",
  "last_modified" "2018-03-28T172420+0000",
  "last_active" "",
  "created" "2018-03-27T161334+0000",
  "client_url" "api_sample_output",
  "company_name" "API Sample Output Company",
  "profile_image_url" "https\/\/www.gravatar.com\/avatar\/e64c7d89f26bd1972efa854d13d7dd61",
  "display_name" "",
  "pronouns" "",
  "pto_balances" {
    "2624351" 0,
    "2624353" 0,
    "2624355" 0
  },
  "submitted_to" "2000-01-01",
  "approved_to" "2000-01-01",
  "manager_of_group_ids" [

  ],
  "require_password_change" false,
  "pay_rate" 0,
  "pay_interval" "hour",
  "permissions" {
    "admin" true,
    "mobile" true,
    "status_box" false,
    "reports" false,
    "manage_timesheets" false,
    "manage_authorization" false,
    "manage_users" false,
    "manage_my_timesheets" false,
    "manage_jobcodes" false,
    "pin_login" false,
    "approve_timesheets" false,
    "manage_schedules" false,
    "external_access" false,
    "manage_my_schedule" false,
    "manage_company_schedules" false,
    "view_company_schedules" false,
    "view_group_schedules" false,
    "manage_no_schedules" false,
    "view_my_schedules" false,
    "time_tracking" false
  },
  "customfields" ""
})


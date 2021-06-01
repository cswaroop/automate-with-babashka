(ns fico.origination-manager)
;; Loan Origination application

;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Admin Model
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Businss Object Model
';; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def application
  {
   "CreditApplicationNumber" ""
   "ReceivedDate" ""
   "ApplicationStatusID" ""
   "Channel" ""
   "LoanSourceID" ""
   "LoanOfficerUserID" ""
   "IsVerfied" ""
   "IsCRARequired" ""
   "OverrideApplicationReasonID" ""
   "WithApplicationReasonID" ""
   "CreditApplicationNumber" ""
   "ReceivedDate" ""
   "ApplicationStatusID" ""
   "Channel" ""
   "LoanSourceID" ""
   "LoanOfficerUserID" ""
   "IsVerfied" ""
   "IsCRARequired" ""
   "OverrideApplicationReasonID" ""
   "WithApplicationReasonID" ""
   })
(def credit-application
  {
   "creditApplicationNumber" ""
   "receivedDate" ""
   "applicationStatusID" ""
   "channel" ""
   "loanSourceID" ""
   "loanOfficerUserID" ""
   "isVerfied" ""
   "isCRARequired" ""
   "overrideApplicationReasonID" ""
   "withApplicationReasonID" ""
   "combinedGrossMonthlyIncome"  ""
   "combinedNetMonthlyIncome"  ""
   "combinedAssetBalance"  ""
   "combinedTotalLiabilities" ""
   "combinedMonthlyPayments"  ""
   "combinedMonthlyHousingExpense"  ""
   "combinedNetDisposableIncome"  ""
   "combinedCurrentDebtToIncomeRatioWithoutHousing" ""
   "combinedCurrentDebtToIncomeRatioWithHousing"  ""
   "combinedHasCheckingAccount"  ""
   "combinedHasSavingsAccount"  ""
   "currentLoanToValueRatio"  ""
   "combinedLiabilities" ""
   "ourCombinedLiabilities" ""
   "ourCombinedMonthlyPayments" ""
   "EnteredTimestamp" ""
   "NumberDeclines" ""
   "NumberInvestigates" ""
   "NumberApproves" ""
   "IsPossibleDuplicate" ""
   "IsConfirmedDuplicate" ""
   "OrganizationID" ""
   "CreditLimit" ""
   "PrimaryBureau" ""
   "SecondaryBureau" ""
   "TertiaryBureau" ""
   "TotalHousingRatio" ""})
(def application-decision
  {
   "overrideDecision" ""
   "overrideReasonCode" ""
   "systemDecision" ""
   "inquiryIndicator" ""
   "reviewDecision" ""
   "recommendedDecision" ""
   "verificationDecision" ""
   "WithdrawalReason" ""
   "ReviewDecision" ""
   "CustomerDecision" ""
   "finalDecision" ""
   "declineReason" [{
                     "type" ""
                     "detailCode" ""
                     "displaySequence" ""
                     "detailCodeExternal" ""
                     }]
   "verification" [{
                    "verificationType" ""
                    "verifiedIndicator" ""}]
   "condition" [{
                 "ConditionType" ""
                 "ConditionDescription" ""
                 "ConditionSatisfiedFlag" ""
                 "ConditionAcceptedFlag" ""
}]
   })
(def person-applicant
  {
   "isExistingCustomer" ""
   "ApplicantType" ""
   "DecisionParty" ""
   "TotalLiabilities" ""
   "HousingRatio" ""
   "TotalMonthlyGrossIncome" ""
   "maritalStatus" ""
   "birthDate" ""
   "personalID" ""
   "ourEmployee" ""
   "applicantID" ""
   "netMonthlyIncome" ""
   "totalMonthlyHousingExpense" ""
   "totalLiability" ""
   "craPurchasedCount" ""
   "housingDebtToIncomeRatio" ""
   "debtToIncomeRatio" ""
   "debtToIncomeRatioCra" ""
   "housingDebtToIncomeRatioCra" ""
   "totMonthlyLiabilitiesPayment" ""
   "totalAssets" ""
   "checkReferenceAccountID" ""
   "totalMonthlyExpenses" ""
   "age" ""
   "HasCheckingAccount" ""
   "HasSavingsAccount" ""
   "HasUnlistedSavingsAccount" ""
   "HasUnlistedCheckingAccount" ""
   "monthsAtCurrentAddress" ""
   "monthsWithCurrentEmployer" ""
   "monthsWithPreviousEmployer"  ""
   "totalGrossmonthlyIncome"  ""
   "totalAssetBalance" ""
   "totalMonthlyPayments" ""
   "totalLiabilities" ""
   "currentDebtToIncomeRatio" ""
   "currentDebtToIncomeRatioWithHousing" ""
   "debtRatioCra" ""
   "debtRatioCraWithHousing" ""
   "monthlyHousingExpense" ""
   "netDisposableIncome" ""
   "ourTotalLiabilities" ""
   "ourTotalMonthlyPayments" ""
   "Type" ""
   "Id" ""
   "OFACFlag" ""
   "RegoFlag" ""
   "InProcess" ""
   })
(def person-characteristics
  {
   "avgBankRevCrAmt" ""
   "avgMosInFile" ""
   "avgMosInFileTLRptd0To2Mos" ""
   "highestBankNatlRevOpenBal" ""
   "highestBankRevCrAmt" ""
   "highestRetBal" ""
   "highestUtilOnBankNatlRevTL" ""
   "highestUtilOnHELOCTL" ""
   "highestUtilOnMtgTL" ""
   "lowestRating" ""
   "lowestRatingIL" ""
   "lowestRatingOpndLast12Mos" ""
   "lowestRatingOpndLast24Mos" ""
   "lowestRatingOpndLast36Mos" ""
   "lowestRatingRevOpen" ""
   "lowestRatingRptdLast24Mos" ""
   "maxDelqEver" ""
   "maxDelqEverHELOC" ""
   "maxDelqPR0To11Mos" ""
   "mosSncMostRcnt30pDelq" ""
   "mosSncMostRcnt30pDelqHELOC" ""
   "mosSncMostRcnt60pDelq" ""
   "mosSncMostRcnt90pDelqAutoLoanTL" ""
   "mosSncMostRcntBankNatlRevOpenTLOpnd" ""
   "mosSncMostRcntCollAssigned" ""
   "mosSncMostRcntCollAssignedGE500" ""
   "mosSncMostRcntDerog" ""
   "mosSncMostRcntDtOpnd" ""
   "mosSncMostRcntFinOpndNonStudentLoan" ""
   "mosSncMostRcntFinTLOpnd" ""
   "mosSncMostRcntForeclosure" ""
   "mosSncMostRcntHELOCTLOpnd" ""
   "mosSncMostRcntInq" ""
   "mosSncMostRcntInqExclLast14Days" ""
   "mosSncMostRcntInqExclLast30Days" ""
   "mosSncMostRcntInqExclLast7Days" ""
   "mosSncMostRcntMtgTLOpnd" ""
   "mosSncMostRcntRepossession" ""
   "mosSncOldestAutoLoanTLOpnd" ""
   "mosSncOldestBankNatlRevOpenTLOpnd" ""
   "mosSncOldestDtOpnd" ""
   "mosSncOldestMtgTLOpnd" ""
   "mosSncOldestRevOpenTLOpnd" ""
   "mosSncOldestRevTLOpnd" ""
   "netFrctAutoLoan" ""
   "netFrctAutoLoanIL" ""
   "netFrctBankRev" ""
   "netFrctHELOC" ""
   "netFrctIL" ""
   "netFrctMtg" ""
   "netFrctRev" ""
   "netFrctRev_PostBankruptcy" ""
   "numAuthorizedUserTL" ""
   "numAutoInq0to5Mos" ""
   "numAutoLoanILTLNeverDelq" ""
   "numAutoLoanILTLOpnd0To35Mos" ""
   "numAutoLoanRepossessions" ""
   "numAutoLoanTL" ""
   "numAutoLoanTL30p0To11Mos" ""
   "numAutoLoanTL60p0To11Mos" ""
   "numAutoLoanTL60p0To17Mos" ""
   "numAutoLoanTLNever60pDaysDelq" ""
   "numAutoLoanTLWBal75PctRptd0To2Mos" ""
   "numBankInq0to5Mos" ""
   "numBankNatlInq0to5Mos" ""
   "numBankNatlRevOpenTLOpnd0To23Mos" ""
   "numBankNatlRevTL90PctRptd0To2Mos" ""
   "numBankNatlRevTLOpnd0To11Mos" ""
   "numBankNatlRevTLWBal100PctAmt" ""
   "numBankNatlRevTLWBal75PctAmt" ""
   "numBankNatlRevTLWBal75PctAmtLT50K" ""
   "numBankNatlTLOpnd0To11Mos" ""
   "numCollection" ""
   "numCollExclMedical" ""
   "numCollExclPaid" ""
   "numCollGE100" ""
   "numCollGE200" ""
   "numCollGE500" ""
   "numDaysInq0to11MosExclLast30Days" ""
   "numDaysInq0to5Mos" ""
   "numDaysInq0to5MosExclLast14Days" ""
   "numDaysInq0to5MosExclLast30Days" ""
   "numDaysInq0to5MosExclLast7Days" ""
   "numDerogPR" ""
   "numFinInq0to5Mos" ""
   "numFinTL" ""
   "numFinTLExclStudentLoan" ""
   "numFrclsTL" ""
   "numHELOCTL" ""
   "numHELOCTLOpnd0To5Mos" ""
   "numHELOCTLWBal50PctAmt" ""
   "numILTL" ""
   "numILTL30pEver" ""
   "numILTLExclMtg" ""
   "numILTLNever120pDaysDelq" ""
   "numILTLWBal" ""
   "numILTLWBal50PctAmt" ""
   "numILTLWPmtGE100And30p0To11Mos" ""
   "numILTLWPmtGE100And30p0To5Mos" ""
   "numILTLWPmtGE100And60p0To17Mos" ""
   "numInq0to11MosExclLast30Days" ""
   "numInq0to2Mos" ""
   "numInq0to5Mos" ""
   "numInq0to5MosExclLast14Days" ""
   "numInq0to5MosExclLast30Days" ""
   "numInq0to5MosExclLast7Days" ""
   "numMtgTL" ""
   "numMtgTL30p0To11Mos" ""
   "numMtgTL60p0To11Mos" ""
   "numMtgTL60p0To17Mos" ""
   "numMtgTLOpnd0To23Mos" ""
   "numOpenAutoLoanTL" ""
   "numOpenBankNatlRevTL" ""
   "numOpenBankRevTL" ""
   "numOpenFinTL" ""
   "numOpenHELOCTL" ""
   "numOpenILTL" ""
   "numOpenMtgTL" ""
   "numOpenRevOpenTL" ""
   "numOpenRevTL" ""
   "numOpenStudentTL" ""
   "numOpenTL" ""
   "numPR" ""
   "numPRBktp" ""
   "numRetTLWBal" ""
   "numRevOpenTL30pDaysEver" ""
   "numRevOpenTLOpnd0To11WBal" ""
   "numRevOpenTLWBal" ""
   "numRevTL" ""
   "numRevTL30pDaysEver" ""
   "numRevTLNow30DaysOrLess" ""
   "numRevTLNow30DaysOrLessWBalGE2500" ""
   "numRevTLNow30DaysOrLessWBalGE500" ""
   "numRevTLOpnd0To11WBal" ""
   "numRevTLOpnd0To5Mos" ""
   "numRevTLWBal" ""
   "numRevTLWBal100PctAmt" ""
   "numRevTLWBal50PctAmt" ""
   "numRevTLWBalGE500And60p0To11Mos" ""
   "numRevTLWBalLT50PctAmt" ""
   "numSevDerogTL" ""
   "numStudentLoanExclFinTL" ""
   "numStudentLoanTL" ""
   "numStudentLoanTL30pDaysEver" ""
   "numStudentLoanTL60pDaysEver" ""
   "numStudentLoanTL90pDaysEver" ""
   "numTimes30TL0to11Mos" ""
   "numTL" ""
   "numTL30pDaysEverDerogPR" ""
   "numTL30pDaysEverOpnd0To11Mos" ""
   "numTL60pDaysEverDerogPR" ""
   "numTL90pDaysEverDerogPR" ""
   "numTLCurrently30p" ""
   "numTLExclStudentLoan" ""
   "numTLNever120pDaysDelq" ""
   "numTLNever60pDaysDelq" ""
   "numTLNever90pDaysDelq" ""
   "numTLNeverDelq" ""
   "numTLNowCurr" ""
   "numTLNowCurrNoOpenCheck" ""
   "numTLNowCurrNonStudentLoan" ""
   "numTLOpnd0To11Mos" ""
   "numTLOpnd3MosAndNotGT2x30Days" ""
   "numTLOpndLE2MosTNTRNeverDelq" ""
   "pctILTL" ""
   "pctStudentTL" ""
   "pctTL30pDaysEver" ""
   "pctTL30pDaysEverDerogPR" ""
   "pctTL60pDaysEver" ""
   "pctTL60pDaysEverDerogPR" ""
   "pctTL90pDaysEver" ""
   "pctTL90pDaysEverDerogPR" ""
   "pctTLNeverDelq" ""
   "pctTLNowCurr" ""
   "pctTLNowCurrNoOpenCheck" ""
   "pctTLWBalOpnd0To23Mos" ""
   "totalTLAvgMosInFile" ""
   "totAmtNowPastDue" ""
   "totBal" ""
   "totBalDelqTL" ""
   "totBankRevCrAmt" ""
   "totILBal" ""
   "totMonthlyPmts" ""
   "totMtgBal" ""
   "totRevBal" ""
   })
(def person-indicators
  {
   "NameMismatchIndicator" ""
   "ReasonCode04" ""
   "ReasonCode03" ""
   "ReasonCode02" ""
   "ReasonCode01" ""
   "EquifaxScore" ""
   "ThinFileIndicator" ""
   "NumILTLWBal" ""
   "NumSats" ""
   "NumMinorDerogs" ""
   "NumMajorDerogs" ""
   "SecurityReportIndicator" ""
   "LostOrStolenCardIndicator" ""
   "DisputedAccountIndicator" ""
   "CreditCounselingIndicator" ""
   "ContactSubscriberIndicator" ""
   "SsnVariationIndicator" ""
   "AddressMismatchIndicator" ""
   "BankruptcyOnFileIndicator" ""
   "FileVariationIndicator" ""
   "IrregularReportManualFileIndicator" ""
   "SecurityFrozenFileIndicator" ""
   "SecurityOfacIndicator" ""
   "AbnormalReportIndicator" ""
   "IrregularReportDeceasedIndicator" ""
   "ConsumerStatementIndicator" ""
   "AliasIndicator" ""
   "NoHitIndicator" ""
   })
(def credit-details
  {"id" ""
   "isCounterOffer" ""
   "totalFeesAmount" ""
   "feesFinancedAmount" ""
   "loanAmount" ""
   "loanPurpose" ""
   "termInMonths" ""
   "paymentFrequency" ""
   "paymentAmount" ""
   "totalFinanceChargeAmount" ""
   "totalPaymentAmount" ""
   "currentEquity" ""
   "currentLoanToValueRatio" ""
   "projectedEquityAmount" ""
   "projectedLoanToValueRatio" ""
   "totalBalanceTransferAmount" ""
   "totalFinancedAmount" ""
   "maximumLoanAmount" ""
   "netTradeInValue" ""
   "totalDownPayment" ""
   "tradeInAmount" ""
   "cashPaidDown" ""
   "tradeInOwedAmount" ""
   "manufacturerRebateAmount" ""
   "salesPrice" ""
   "purchasedFrom" ""
   "purchaseOrRefinanceState" ""
   "BalanceTransferFeePercent" ""
   "BalanceTransferFixedFeeAmount" ""
   "vehicleLoanToValueRatio" ""
})
(def application-malli
  [:map
   [:applicationType [:enum :consumer :commercial]]
   [:customerType [:enum :individual :company]]
   [:origin [:enum :us :ca :gb :de :at :st :ch :at :fr :it :mx :cl :co :br :my :sg :th :id :cn :za :dk]]
   [:referenceId ""?]
   [:processingStatus ""?]
   [:expirationTs inst?]
   [:createdOn inst?]
   [:receivedOn inst?]
   [:processingStatus [:enum :submitted :in-progress :finished]]
   [:ExpirationTimestamp inst?]
   [:submittedBy ""?]
   [:lockExpireOn inst?]
   [:lockedOn inst?]
   [:lockedBy ""?]
   [:receivedDate inst?]
   [:receivedByUserID ""?]
   [:externalID ""?]
   [:previousStatus [:enum :submitted :in-progress :finished]]
   [:previousStatusDateTime inst?]
   [:currentStatus]
   [:currentStatusDateTime]
   [:userTemplateID]
   [:submitterId]
   [:sWDecision]
   [:strategyVersion]
   [:deliveryOptionCode]
   [:decisioningRequestType]
   [:applicationType]
   [:resubmissionFlag]
   [:processingStatus]
   [:expirationTimestamp]
   [:workflowName]])
(def creditApplication
  :creditApplicationNumber
  :receivedDate
  :applicationStatusID
  :channel
  :loanSourceID
  :loanOfficerUserID
  :isVerfied
  :isCRARequired
  :overrideApplicationReasonID
  :combinedGrossMonthlyIncome
  :combinedNetMonthlyIncome
  :combinedAssetBalance
  :combinedTotalLiabilities
  :combinedMonthlyPayments
  :combinedMonthlyHousingExpense
  :combinedNetDisposableIncome
  :combinedCurrentDebtToIncomeRatioWithoutHousing
  :combinedCurrentDebtToIncomeRatioWithHousing
  :combinedHasCheckingAccount
  :combinedHasSavingsAccount
  :currentLoanToValueRatio
  :combinedLiabilities
  :ourCombinedLiabilities
  :ourCombinedMonthlyPayments
  :EnteredTimestamp
  :NumberDeclines
  :NumberInvestigates
  :NumberApproves
  :IsPossibleDuplicate
  :IsConfirmedDuplicate
  :OrganizationID
  :CreditLimit
  :PrimaryBureau
  :SecondaryBureau
  :TertiaryBureau
  :TotalHousingRatio)
(def applicationDecision
  :overrideDecision
  :overrideReasonCode
  :systemDecision
  :inquiryIndicator
  :reviewDecision
  :recommendedDecision
  :verificationDecision
  :WithdrawalReason
  :ReviewDecision
  :CustomerDecision
  :finalDecision)
(def declineReason
  :type
  :detailCode
  :displaySequence
  :detailCodeExternal)
(def verification
  :verificationType
  :verifiedIndicator)
(def Condition
  :ConditionType
  :ConditionDescription
  :ConditionSatisfiedFlag
  :ConditionAcceptedFlag)
(def ReviewReason
  :Code)
(def ManagerReviewReason
  :Code)
(def FraudReason
  :Code)
(def creditApplicationRequest)
(def creditDetails
  :id
  :isCounterOffer
  :totalFeesAmount
  :feesFinancedAmount
  :loanAmount
  :loanPurpose
  :termInMonths
  :paymentFrequency
  :paymentAmount
  :totalFinanceChargeAmount
  :totalPaymentAmount
  :currentEquity
  :currentLoanToValueRatio
  :projectedEquityAmount
  :projectedLoanToValueRatio
  :totalBalanceTransferAmount
  :totalFinancedAmount
  :maximumLoanAmount
  :netTradeInValue
  :totalDownPayment
  :tradeInAmount
  :cashPaidDown
  :tradeInOwedAmount
  :manufacturerRebateAmount
  :salesPrice
  :purchasedFrom
  :purchaseOrRefinanceState
  :BalanceTransferFeePercent
  :BalanceTransferFixedFeeAmount
  :vehicleLoanToValueRatio)
(def creditApplicationProduct
  :productName
  :loanPaymentType
  :interestRatePercent
  :interestRateType
  :annualRatePercent
  :minimumLoanAmount
  :maximumLoanAmount
  :minimumTerm
  :minimumInterestRatePercent
  :maximumInterestRatePercent
  :maximumDebtToIncomeRatio
  :creditCardType
  :minimumMonthlyPaymentPercent
  :balanceTransferRatePercent
  :balanceTransferAnnualRatePercent
  :balanceTransferRateTerm
  :cashAdvanceRatePercent
  :cashAdvanceAnnualRatePercent
  :cashAdvanceRateTerm
  :introductoryRatePercent
  :introductoryAnnualRatePercent
  :introductoryRateTerm
  :maximumLoanToValuePercent
  :maximumClosingCostPercent
  :rateFloorPercent
  :periodicRateCapPercent
  :periodicRateCapTerm
  :lifetimeRateCapPercent
  :ceilingPercent
  :modelCategory
  :productCategory
  :product
  :vehicleType)
(def creditApplicationProductRate
  :description
  :indexRateName
  :indexBaseRatePercent
  :marginPercent)
(def creditApplicationProductFee
  :id
  :type
  :feeAmount
  :feePercent
  :isFinanced
  :name)
(def balanceTransfer
  :id
  :accountNumber
  :TransferAmountRequested
  :TransferAmountAllowed
  :transferAmount
  :creditorName
  :balanceTransferExtension
  :feeAmount
  :creditorAddress
  :sourceId
  :balanceTransferRatePercent)
(def balanceTransferAnnualRatePercent
  :BalanceTransferTotalFeeAmount 0.000
  :FinancialInstitutionName ""
  :CardNumber	""
  :balanceTransferRateTerm "")
(def creditApplicationOffer)
(def creditDetails
  :id						""
  :isCounterOffer						false
  :totalFeesAmount						0.0
  :feesFinancedAmount						0.0
  :loanAmount						0.0
  :loanPurpose						""
  :termInMonths						0
  :paymentFrequency						""
  :paymentAmount						0.0
  :totalFinanceChargeAmount						0.0
  :totalPaymentAmount						0.0
  :currentEquity						0.0
  :currentLoanToValueRatio						0.0
  :projectedEquityAmount						0.0
  :projectedLoanToValueRatio						0.0
  :totalBalanceTransferAmount						0.0
  :totalFinancedAmount	0.0
  :maximumLoanAmount 0.0
  :netTradeInValue 0.0
  :totalDownPayment 0.0
  :tradeInAmount 0.0
  :cashPaidDown 0.0
  :tradeInOwedAmount 0.0
  :manufacturerRebateAmount 0.0
  :salesPrice	0.0
  :purchasedFrom ""
  :purchaseOrRefinanceState ""
  :vehicleLoanToValueRatio 0.00)
(def creditApplicationProduct
  :productName					""
  :loanPaymentType					""
  :interestRatePercent					0.0
  :interestRateType					""
  :annualRatePercent					0.0
  :minimumLoanAmount					0.0
  :maximumLoanAmount					0.0
  :minimumTerm					0
  :maximumTerm					0
  :minimumInterestRatePercent					0.0
  :maximumInterestRatePercent					0.0
  :maximumDebtToIncomeRatio					0.0
  :creditCardType					""
  :minimumMonthlyPaymentPercent					0.0
  :balanceTransferRatePercent					0.0
  :balanceTransferAnnualRatePercent					0.0
  :balanceTransferRateTerm					0
  :cashAdvanceRatePercent					0.0
  :cashAdvanceAnnualRatePercent					0.0
  :cashAdvanceRateTerm					0
  :introductoryRatePercent					0.0
  :introductoryAnnualRatePercent					0.0
  :introductoryRateTerm					0
  :maximumLoanToValuePercent					0.0
  :maximumClosingCostPercent					0.0
  :rateFloorPercent					0.0
  :periodicRateCapPercent					0.0
  :periodicRateCapTerm					0
  :lifetimeRateCapPercent					0.0
  :ceilingPercent					0.0
  :modelCategory					""
  :productCategory					""
  :product					""
  :vehicleType					"")
(def creditApplicationProductRate
  :description				""
  :indexRateName				""
  :indexBaseRatePercent				0.0
  :marginPercent)
(def creditApplicationProductFee
  :id				""
  :type				""
  :feeAmount				0.0
  :feePercent				0.0
  :isFinanced				false
  :name				""
  :balanceTransfer(n)
  :id					""
  :account0.0					""
  :transferAmount					""
  :creditorName					""
  :balanceTransferExtension					""
  :feeAmount					""
  :creditorAddress*					""
  :sourceID					""
  :balanceTransferRatePercent					""
  :balanceTransferAnnualRatePercent 0.0
  :balanceTransferRateTerm 0)
(def CreditApplicationBooking
  
  :CreditDetails {:id                  ""
                  :isCounterOffer						Date	11
                  :totalFeesAmount						""	800
                  :feesFinancedAmount						0.0	22
                  :loanAmount						0.0	22
                  :loanPurpose						""
                  :termInMonths						0.0	22
                  :paymentFrequency						0.0	22
                  :paymentAmount						0.0	22
                  :totalFinanceChargeAmount						0.0	22
                  :totalPaymentAmount						0.0	22
                  :currentEquity						0.0	22
                  :currentLoanToValueRatio						0.0	22
                  :projectedEquityAmount						""
                  :projectedLoanToValueRatio						""
                  :totalBalanceTransferAmount						0.0	22
                  :totalFinancedAmount						0.0	22
                  :maximumLoanAmount						0.0	22
                  :netTradeInValue						0.0	22
                  :totalDownPayment						0.0	22
                  :tradeInAmount						""
                  :cashPaidDown						0
                  :tradeInOwedAmount						""
                  :manufacturerRebateAmount						""
                  :salesPrice						0.0
                  :purchasedFrom
                  :purchaseOrRefinanceState						""	400
                  :vehicleLoanToValueRatio						""})
(def creditApplicationProduct
  
  :productName					""	800
  :loanPaymentType					""	800
  :interestRatePercent
  :interestRateType					""	800
  :annualRatePercent					""
  :minimumLoanAmount					0.0	22
  :maximumLoanAmount					0.0	22
  :minimumTerm					""	800
  :maximumTerm					""
  :minimumInterestRatePercent					""
  :maximumInterestRatePercent					""
  :maximumDebtToIncomeRatio					""
  :creditCardType					""	1600
  :minimumMonthlyPaymentPercent					""	1600
  :balanceTransferRatePercent					0.0	22
  :balanceTransferAnnualRatePercent					0.0	22
  :balanceTransferRateTerm
  :cashAdvanceRatePercent					0.0	22
  :cashAdvanceAnnualRatePercent					0.0	22
  :cashAdvanceRateTerm					""	80
  :introductoryRatePercent
  :introductoryAnnualRatePercent					0.0	22
  :introductoryRateTerm					""	1000
  :maximumLoanToValuePercent
  :maximumClosingCostPercent					""	800
  :rateFloorPercent					""	800
  :periodicRateCapPercent
  :periodicRateCapTerm					""
  :lifetimeRateCapPercent
  :ceilingPercent					""
  :modelCategory					""
  :productCategory					""
  :product					""
  :vehicleType)

(def :creditApplicationProductRate
  {:description		""
   :indexRateName	 ""
   :indexBaseRatePercent 0.0
   :marginPercent 0.0
   :Date (Date.)})

(def creditApplicationProductFee
  {}
  :id
  :type				DomainValue
  :feeAmount				DomainValue
  :feePercent				0.0	22
  :isFinanced				DomainValue
  :name)				0	11
(def personApplicant
  {
   :isExistingCustomer								0.0	22
   :ApplicantType
   :DecisionParty								0.0
   :TotalLiabilities
   :HousingRatio								""	400
   :TotalMonthlyGrossIncome								0.0	22
   :maritalStatus								""
   :birthDate								Date	11
   :personalID								""	800
   :ourEmployee								0.0	22
   :applicantID								0.0	22
   :netMonthlyIncome								0.0	22
   :totalMonthlyHousingExpense								0.0	22
   :totalLiability								0.0	22
   :craPurchasedCount								0.0	22
   :housingDebtToIncomeRatio								0.0	22
   :debtToIncomeRatio								0.0	22
   :debtToIncomeRatioCra								""
   :housingDebtToIncomeRatioCra								""
   :totMonthlyLiabilitiesPayment								0.0	22
   :totalAssets								0.0	22
   :checkReferenceAccountID								0.0	22
   :totalMonthlyExpenses								0.0	22
   :age								""
   :HasCheckingAccount
   :HasSavingsAccount
   :HasUnlistedSavingsAccount
   :HasUnlistedCheckingAccount
   :monthsAtCurrentAddress								0
   :monthsWithCurrentEmployer								""
   :monthsWithPreviousEmployer 								""
   :totalGrossmonthlyIncome 								0.0
   :totalAssetBalance								0.0
   :totalMonthlyPayments								0.0
   :totalLiabilities								0.0
   :currentDebtToIncomeRatio								0.0
   :currentDebtToIncomeRatioWithHousing								0.0
   :debtRatioCra								0.0
   :debtRatioCraWithHousing								0.0
   :monthlyHousingExpense								0.0
   :netDisposableIncome								0.0
   :ourTotalLiabilities								0.0
   :ourTotalMonthlyPayments								0.0
   :Type								""
   :Id								""
   :OFACFlag								""
   :RegoFlag								""
   :InProcess								0.0
   :name {
          :suffix							""	400
          :prefix							""
          :first							""	800
          :middle							""	800
          :last							""}
   :address {
             :postalCode							""	800
             :postalCodeExtension							""
             :countryID							0.0	22
             :stateID							0.0	22
             :city							""	800
             :county							""
             :unit0.0							""
             :street0.0							""
             :streetName							""
             :line2							""	1600
             :line1							""	1600
             :addressMonths							0.0	22
             :addressYears}
   :phone {
           :isPrimaryPhone							0.0	22
           :phoneType							0.0	22
           :phone 0.0}
   }
  :email {
          :isPrimaryEmail							0.0	22
          :emailAddress}
  :identification {
                   :identificationPlaceIssued							""	800
                   :identificationValue							""	800
                   :IssuedDate							""
                   :identificationType							""}
  :income {
           :incomeType							""
           :incomeAmount							""
           :source							""
           :frequency							""}
  
  :employmentDetails{
                     :employmentTypeId							0.0	22
                     :annualSalary							0.0	22
                     :MonthsWithEmployer							0.0	22
                     :startDate							Date	11
                     :employerName							""	400
                     :employerAddress}
  
  :asset {
          :type							""
          :value							""
          :assetName							""
          :Expense(n)								0
          :IsOurAccount							0
          :ExpensesType							0
          :MonthlyPayment							0
          :CreditorName							0}
  :liability {
              :type							""
              :monthlyPayment							0.0
              :creditorName							""
              :balanceOwed							0.0
              :isOurAccount						false
              :isPayingOff}
  
  :creditSummary {
                  :decisionBureau							""
                  :bureauScore							double
                  :totalTradelines							integer
                  :totalPublicRecords							integer
                  :totalCollections							integer
                  :totalInquiries							integer
                  :SSNMismatchIndicator							boolean
                  :noHitIndicator							boolean
                  :isDelinquent							boolean
                  :isDelinquent60days							boolean
                  :bankruptcyOnFileIndicator							boolean
                  :DMAttributesList [{
                                      :DMAttribute
                                      :labelname					""
                                      :labelValue					""
                                      :labelRank					""
                                      :isMainMenuLabel}]
                  }
  
  :customerReference {
                      :name})(1)
:suffix						""	400
:prefix						""
:first						""	800
:middle						""	800
:last						""	800
:address(1)
:postalCode						""	800
:postalCodeExtension						""
:countryID						0.0	22
:stateID						0.0	22
:city						""	800
:county						""
:unit0.0						""
:street0.0						""
:streetName						""
:line2						""	1600
:line1						""	1600
:addressMonths						0.0	22
:addressYears						0.0	22
:phone(1)
:isPrimaryPhone						0.0	22
:phoneType						0.0	22
:phone0.0						""	80
:email(1)
:isPrimaryEmail						0.0	22
:emailAddress						""	1000
:externalDataSource(1)
:DataConsumer(1)
:BureauDataSource(1)
:outputs(1)
:characteristics(1)
:avgBankRevCrAmt			0
:avgMosInFile			0
:avgMosInFileTLRptd0To2Mos			0
:highestBankNatlRevOpenBal			0.0
:highestBankRevCrAmt			0.0
:highestRetBal			0.0
:highestUtilOnBankNatlRevTL			0
:highestUtilOnHELOCTL			0
:highestUtilOnMtgTL			0
:lowestRating			""
:lowestRatingIL			""
:lowestRatingOpndLast12Mos			""
:lowestRatingOpndLast24Mos			""
:lowestRatingOpndLast36Mos			""
:lowestRatingRevOpen			""
:lowestRatingRptdLast24Mos			""
:maxDelqEver			0
:maxDelqEverHELOC			0
:maxDelqPR0To11Mos			0
:mosSncMostRcnt30pDelq			0
:mosSncMostRcnt30pDelqHELOC			0
:mosSncMostRcnt60pDelq			0
:mosSncMostRcnt90pDelqAutoLoanTL			0
:mosSncMostRcntBankNatlRevOpenTLOpnd			0
:mosSncMostRcntCollAssigned			0
:mosSncMostRcntCollAssignedGE500			0
:mosSncMostRcntDerog			0
:mosSncMostRcntDtOpnd			0
:mosSncMostRcntFinOpndNonStudentLoan			0
:mosSncMostRcntFinTLOpnd			0
:mosSncMostRcntForeclosure			0
:mosSncMostRcntHELOCTLOpnd			0
:mosSncMostRcntInq			0
:mosSncMostRcntInqExclLast14Days			0
:mosSncMostRcntInqExclLast30Days			0
:mosSncMostRcntInqExclLast7Days			0
:mosSncMostRcntMtgTLOpnd			0
:mosSncMostRcntRepossession			0
:mosSncOldestAutoLoanTLOpnd			0
:mosSncOldestBankNatlRevOpenTLOpnd			0
:mosSncOldestDtOpnd			0
:mosSncOldestMtgTLOpnd			0
:mosSncOldestRevOpenTLOpnd			0
:mosSncOldestRevTLOpnd			0
:netFrctAutoLoan			0
:netFrctAutoLoanIL			0
:netFrctBankRev			0
:netFrctHELOC			0
:netFrctIL			0
:netFrctMtg			0
:netFrctRev			0
:netFrctRev_PostBankruptcy			0
:numAuthorizedUserTL			0
:numAutoInq0to5Mos			0
:numAutoLoanILTLNeverDelq			0
:numAutoLoanILTLOpnd0To35Mos			0
:numAutoLoanRepossessions			0
:numAutoLoanTL			0
:numAutoLoanTL30p0To11Mos			0
:numAutoLoanTL60p0To11Mos			0
:numAutoLoanTL60p0To17Mos			0
:numAutoLoanTLNever60pDaysDelq			0
:numAutoLoanTLWBal75PctRptd0To2Mos			0
:numBankInq0to5Mos			0
:numBankNatlInq0to5Mos			0
:numBankNatlRevOpenTLOpnd0To23Mos			0
:numBankNatlRevTL90PctRptd0To2Mos			0
:numBankNatlRevTLOpnd0To11Mos			0
:numBankNatlRevTLWBal100PctAmt			0
:numBankNatlRevTLWBal75PctAmt			0
:numBankNatlRevTLWBal75PctAmtLT50K			0
:numBankNatlTLOpnd0To11Mos			0
:numCollection			0
:numCollExclMedical			0
:numCollExclPaid			0
:numCollGE100			0
:numCollGE200			0
:numCollGE500			0
:numDaysInq0to11MosExclLast30Days			0
:numDaysInq0to5Mos			0
:numDaysInq0to5MosExclLast14Days			0
:numDaysInq0to5MosExclLast30Days			0
:numDaysInq0to5MosExclLast7Days			0
:numDerogPR			0
:numFinInq0to5Mos			0
:numFinTL			0
:numFinTLExclStudentLoan			0
:numFrclsTL			0
:numHELOCTL			0
:numHELOCTLOpnd0To5Mos			0
:numHELOCTLWBal50PctAmt			0
:numILTL			0
:numILTL30pEver			0
:numILTLExclMtg			0
:numILTLNever120pDaysDelq			0
:numILTLWBal			0
:numILTLWBal50PctAmt			0
:numILTLWPmtGE100And30p0To11Mos			0
:numILTLWPmtGE100And30p0To5Mos			0
:numILTLWPmtGE100And60p0To17Mos			0
:numInq0to11MosExclLast30Days			0
:numInq0to2Mos			0
:numInq0to5Mos			0
:numInq0to5MosExclLast14Days			0
:numInq0to5MosExclLast30Days			0
:numInq0to5MosExclLast7Days			0
:numMtgTL			0
:numMtgTL30p0To11Mos			0
:numMtgTL60p0To11Mos			0
:numMtgTL60p0To17Mos			0
:numMtgTLOpnd0To23Mos			0
:numOpenAutoLoanTL			0
:numOpenBankNatlRevTL			0
:numOpenBankRevTL			0
:numOpenFinTL			0
:numOpenHELOCTL			0
:numOpenILTL			0
:numOpenMtgTL			0
:numOpenRevOpenTL			0
:numOpenRevTL			0
:numOpenStudentTL			0
:numOpenTL			0
:numPR			0
:numPRBktp			0
:numRetTLWBal			0
:numRevOpenTL30pDaysEver			0
:numRevOpenTLOpnd0To11WBal			0
:numRevOpenTLWBal			0
:numRevTL			0
:numRevTL30pDaysEver			0
:numRevTLNow30DaysOrLess			0
:numRevTLNow30DaysOrLessWBalGE2500			0
:numRevTLNow30DaysOrLessWBalGE500			0
:numRevTLOpnd0To11WBal			0
:numRevTLOpnd0To5Mos			0
:numRevTLWBal			0
:numRevTLWBal100PctAmt			0
:numRevTLWBal50PctAmt			0
:numRevTLWBalGE500And60p0To11Mos			0
:numRevTLWBalLT50PctAmt			0
:numSevDerogTL			0
:numStudentLoanExclFinTL			0
:numStudentLoanTL			0
:numStudentLoanTL30pDaysEver			0
:numStudentLoanTL60pDaysEver			0
:numStudentLoanTL90pDaysEver			0
:numTimes30TL0to11Mos			0
:numTL			0
:numTL30pDaysEverDerogPR			0
:numTL30pDaysEverOpnd0To11Mos			0
:numTL60pDaysEverDerogPR			0
:numTL90pDaysEverDerogPR			0
:numTLCurrently30p			0
:numTLExclStudentLoan			0
:numTLNever120pDaysDelq			0
:numTLNever60pDaysDelq			0
:numTLNever90pDaysDelq			0
:numTLNeverDelq			0
:numTLNowCurr			0
:numTLNowCurrNoOpenCheck			0
:numTLNowCurrNonStudentLoan			0
:numTLOpnd0To11Mos			0
:numTLOpnd3MosAndNotGT2x30Days			0
:numTLOpndLE2MosTNTRNeverDelq			0
:pctILTL			0.0
:pctStudentTL			0.0
:pctTL30pDaysEver			0.0
:pctTL30pDaysEverDerogPR			0.0
:pctTL60pDaysEver			0.0
:pctTL60pDaysEverDerogPR			0.0
:pctTL90pDaysEver			0.0
:pctTL90pDaysEverDerogPR			0.0
:pctTLNeverDelq			0.0
:pctTLNowCurr			0.0
:pctTLNowCurrNoOpenCheck			0.0
:pctTLWBalOpnd0To23Mos			0.0
:totalTLAvgMosInFile			0
:totAmtNowPastDue			0.0
:totBal			0.0
:totBalDelqTL			0.0
:totBankRevCrAmt			0.0
:totILBal			0.0
:totMonthlyPmts			0.0
:totMtgBal			0.0
:totRevBal			0.0
:parsedResponseList(1)
:scoring(n)



(ns fico.debt-manager)
;;;;;;;;;;;;;;;;
;; Admin Model
;;;;;;;;;;;;;;;


(def Client
  [:map])
(def User
  [:map])
(def DomainValues
  [:map])

;;;;;;;;;;;;;;;;;;;;;;;;
;; Business Object Model
;;;;;;;;;;;;;;;;;;;;;;;;
(def Account
  [:map
   [:tenant-code ""?]
   [:account-id ""?]
   [:consolidated-unit-flag boolean?]
   [:account-open-date inst?]
   [:debt-manager [:map
                   [:recoverable-balance-amt decimal?]
                   [:non-sufficient-funds-count int?]
                   [:balance-at-risk-amt decimal?]
                   [:owing-group-id ""?]
                   [:stop-corrospondance-flag boolean?]
                   [:owing-set-date inst?]
                   [:charge-off-date inst?]
                   [:last-non-sufficient-funds-amt decimal?]
                   [:last-non-sufficient-funds-date inst?]
                   [:dispute-amt decimal?]
                   ]
    :collection-score [:map
                       [:account-score int?]
                       [:score-odds-rank int?]
                       [:score-model-description ""?]
                       [:score-risk-factor integer?]
                       [:scored-at inst?]]
    :service-provider [:map]
    :work-history [:map]
    :accounting-balance-history [:map]
    :accounting-financial-transaction [:map]
    :acr-record [:map]
    :asset [:map]
    ]])
(def AccountingUnit
  [:map
   [:account-id ""?]
   [:currency-code ""?]
   [:balance [:map]]
   []])
(def Asset
  [:map])
(def ActionContactResult
  [:map])
(def Bankruptcy
  [:map])
(def Customer
  [:map
   [:customerType ""?]
   [:vip-flag boolean?]
   [:customer-score [:map]]
   [:employment []]
   [:expenses []]
   [:financial-account]
   [:customer-financial-summary]
   [:customer-hardship]
   [:customer-identification-verification]
   [:customer-income-items]
   [:customer-insurance]
   [:customer-insurance-claim]
   [:customer-insurance-policy]
   [:customer-liability-item]
   [:customer-champion-challenger]
   [:customer-reference]
   [:customer-relationship]
   [:customer-service-provider]
   [:customer-work-history]])
(def Legal
  [:map
   [:legal-foreclosure]
   [:legal-garnishment]
   [:legal-items]
   [:legal-item-accounts]
   [:legal-judgement]
   [:legal-probate]
   [:legal-repossession]
   [:legal-warrant]
   [:]])
(def Address [])
(def Party
  [:map])
(def PaymentPlan
  [:map])
(def ProductAccount
  [:map])
(def Work
  [:map])
(def Workout
  [:map])


(ns fico.alert-and-case-manager "https://www.gofrugal.com/")
;;
;; Can be used in Banking for Financial Crimes Investigation such as AML, KYC, DD etc.
;;
;; Similar to Security Information and Event Manager (SIEM)  in terms of platform
;; Similar products SAS AML
;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; Administration
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def groups
  [:compliance-officers {:name ""
                         :description ""
                         :email ""
                         }
   [:assigned-roles]
   [:group-attributes]
   [:access-control-settings]]
  [:managers]
  [:super-users]
  [:quality-control]
  [:administrators])
(def acl-contexts
  [:alert {:doc "Define rules that determine the alerts a group can display and edit. Use these
attributes to create rules in the Alert context."}]
  [:suspecious-entity {:doc "Define rules that determine the suspicious entities (e.g. persons) a group can
display and edit. Use these attributes to create rules in the Suspicious Entity
context."}]
  [:case {:doc "Define rules that determine the cases a group can display and edit. Use these
attributes to create rules in the Case context."}])
(def acm-permissions
  [:home]
  [:find-alerts]
  [:find-cases]
  [:find-customers]
  [:find-fiu-reports]
  [:create-app-menu-cases]
  [:manage-groups-and-roles]
  [:assign-permissions])
(def aml-permissions [])
(def kys-permissions [])
(def roles
  "Roles are packaging of set permissions under names such as SuperUser, authenticated user, anonymous user etc."
  [:super-user {:doc "The Super User role is meant for users who need unrestricted permissions to execute activities on all systems. It contains these functional permissions:"}
   [:assigned-permissions
    [:edit-tags-for-vcases
     :create-case-time-span-report
     :assign-permissions
     :manage-approval-templates
     :edit-my-tasks-in-alert]]]
  [:admin {:doc "The Admin role is meant for administrators who can assign permissions and define workflows, but don't edit alerts or cases. The Admin role contains these functional permissions:"}]
  [:customer-advisor {:doc "The Customer Advisor role is meant for customer advisors who contribute information to alerts and cases. It contains these functional permissions:"}]
  [:junior-alert-manager {:doc "The Junior Alert Manager role is meant for junior alert managers who work on alerts, cases, and suspicious entities. It contains these permissions:"}]
  [:senior-alert-manager {:doc "The Senior Alert Manager role is meant for senior alert managers who work on alerts, cases, and suspicious entities. It contains these permissions:"}]
  [:junior-case-manager {:doc "The Junior Case Manager role is meant for junior case managers who work on alerts, cases, and suspicious entities. It contains these permissions:"}]
  [:senior-case-manager {:doc "The Senior Case Manager role is meant for senior case managers who work on alerts, cases, and suspicious entities. It contains these permissions:"}]
  [:auditor {:doc "The Auditor role is meant for auditors who work on cases and suspicious entities. It contains these permissions:"}])
(def queues
  [:alert-queues {:name "" :description ""}
   [:assigned-groups]
   [:filter-criteria]
   [:sort-criteria]
   [:status :activev]]
  [:case-queues]
  [:fiu-report-queues])

;; Workflows can be
;; implemented using automation rules and tasks combined with approval
;; management. At each workflow step, one group is responsible for a specific task.
;; Once a workflow step is complete, ACM ensures that the group responsible
;; for the next step receive the information required to execute their task

;; Event based or Time based automation rules


(def automation-rules
  [:rule {:name "Rule-1"
          :context "Alert/Case/SuspiciousEntity/Hit"
          :description ""
          :start ""
          :duration ""
          :enabled "yes"}
   [:event "Alert"]
   [:condition]
   [:action]]
  )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Business Object Model
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def alertCase
  {:id ""})

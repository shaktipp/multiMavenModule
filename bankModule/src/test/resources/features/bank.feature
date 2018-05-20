Feature: Bank Operation Feature

Scenario: Scenario1: Create Bank With Multiple Branch
  When the client submit  POST Request to "/bank/addBank" body as JSON
  """
  [
      {
        "bankCode" : "SBI",
        "bankName" : "State Bank of India",
        "branches" : [
                {
                        "branchCode" : "SBI001",
                        "branchName" : "SBI-NAYAPALLI",
                        "branchAddress" : "Nayapalli"
                },
                {
                        "branchCode" : "SBI002",
                        "branchName" : "SBI-SAHIDNAGAR",
                        "branchAddress" : "Sahid Nagar"
                },
                {
                        "branchCode" : "SBI003",
                        "branchName" : "SBI-UNIT6",
                        "branchAddress" : "Unit-6, Boys High School"
                }
        ]
      }
  ]
  """
  Then receive HTTP Status code of POST Operation is 200
  And response body contains following JSON
  """
   {
      "bankCode": "SBI",
      "bankName": "State Bank of India",
      "branches": [{
          "branchCode": "SBI001",
          "branchName": "SBI-NAYAPALLI",
          "branchAddress": "Nayapalli"
      },
      {
          "branchCode": "SBI002",
          "branchName": "SBI-SAHIDNAGAR",
          "branchAddress": "Sahid Nagar"
      },
      {
          "branchCode": "SBI003",
          "branchName": "SBI-UNIT6",
          "branchAddress": "Unit-6, Boys High School"
      }]
  }
  """

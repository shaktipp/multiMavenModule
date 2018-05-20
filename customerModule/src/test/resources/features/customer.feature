Feature: Customer Operation Feature

Scenario: Scenario1: Create Customer
  When the client submit  POST Request to "/customer/addCustomer" to create new Customer with following JSON as input
  """
    [{
        "customerId": "CUST-001",
        "customerName": "Shakti",
        "customerSex": "M",
        "customerDateofBirth": "1990-12-27",
        "customerMailingAddress": "202,Kodihali,Gangamma Temple,Bangalore",
        "customerPermanentAddress": "Nayapalli,Bhubaneswar",
        "customerContactNumber": "08041371800",
        "customerAlternateNumber": "9620672500",
        "customerEmails": "shaktipp@gmail.com;shaktipp@yahoo.com",
        "customerCreditRating": "A",
        "customerAccountNumberList": ["SB1001","SB1002","CR001","CR5005"],
        "customerLoanNumberList": ["Loan12300", "Loan12301"]
    }]
  """
  Then receive HTTP Status code of POST Operation is 200
  And response body contains following JSON if Customer is created
   """
      [{
            "customerId": "CUST-001",
            "customerName": "Shakti",
            "customerSex": "M",
            "customerDateofBirth": "1990-12-27",
            "customerMailingAddress": "202,Kodihali,Gangamma Temple,Bangalore",
            "customerPermanentAddress": "Nayapalli,Bhubaneswar",
            "customerContactNumber": "08041371800",
            "customerAlternateNumber": "9620672500",
            "customerEmails": "shaktipp@gmail.com;shaktipp@yahoo.com",
            "customerCreditRating": "A",
            "customerAccountNumberList": ["SB1001", "SB1002", "CR001", "CR5005"],
            "customerLoanNumberList": ["Loan12300", "Loan12301"]
        }]
    """

Feature: User Operation Feature

Scenario: Scenario1: Add new User
  When the client submit  POST Request to "/user/addUser" to create new User with following JSON as input
  """
    [{
      "userId": "shaktipp",
      "userPassword": "shaktipp",
      "passwordHistory": {},
      "userShortName": "Shakti",
      "userFullName": "Shakti Panda",
      "userSex": "M",
      "userDateofBirth": "2080-06-16",
      "userContactNumber": "9620672500",
      "userAlternateNumber": "08043071203",
      "userMails": "shaktipp@gmail.com;shaktipp@yahoo.com",
      "userType": "Admin",
      "userDepartment": "Origination Manager",
      "userEmpNumber": "51260"
    }]
  """
  Then receive HTTP Status code of POST Operation for add new user is 200
  And response body contains following JSON if User is created
   """
    [{
      "userId": "shaktipp",
      "userPassword": "shaktipp",
      "passwordHistory": {},
      "userShortName": "Shakti",
      "userFullName": "Shakti Panda",
      "userSex": "M",
      "userDateofBirth": "2080-06-16",
      "userContactNumber": "9620672500",
      "userAlternateNumber": "08043071203",
      "userMails": "shaktipp@gmail.com;shaktipp@yahoo.com",
      "userType": "Admin",
      "userDepartment": "Origination Manager",
      "userEmpNumber": "51260"
    }]
    """

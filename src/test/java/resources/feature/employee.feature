Feature: End to End testing of Employee data

  Scenario: Create a new Employee data & verify if the Employee is added
    When    I sends the Post Request for create the Employee Data
    And     I insert the name, salary,age,employee_name,employee_salary,employee_age,
    Then    I verify the status code 200 for Employee data
    And     I get the id of new created Employee data

  Scenario: Verify the Employee data are successfully created
    When I sends a GET request for fatching Employee data by given ID
    Then I verify the name is for created record for Employee

  Scenario: Update the Employee data for given ID
    When    I send the Put Request for updating the Employee data
    And     I update the profile_image
    Then    I verify the status code 200 for update Employee data
    And     I verify the name for updating the Employee data

  Scenario: Delete the Prodct data for given ID & verify the record are deleted successfully
    When    I sends the Delete Request for deleting the Employee  given ID
    Then    I verify the status code 200 for delete Employee data
    And     I get the data for deleted record ID for Employee data
    And     I verify the status code 404 for verifing the delete record
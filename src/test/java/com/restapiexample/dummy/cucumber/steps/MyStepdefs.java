package com.restapiexample.dummy.cucumber.steps;

import com.restapiexample.dummy.employeeSteps.EmployeeSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs {
    static String name = "john";
    static int salary = 50000;
    static int age = 24;
    static String employee_name = "smith";
    static int employee_salary = 50000;
    static int employee_age = 24;
    static int employeeId;
    static String profile_image;
    ValidatableResponse response;

    @Steps
    EmployeeSteps employeeSteps;
    @When("^I sends the Post Request for create the Employee Data$")
    public void iSendsThePostRequestForCreateTheEmployeeData() {
    }

    @And("^I insert the name, salary,age,employee_name,employee_salary,employee_age,$")
    public void iInsertTheNameSalaryAgeEmployee_nameEmployee_salaryEmployee_age() {
        response = employeeSteps.createTheRecord(name,salary,age);
    }

    @Then("^I verify the status code (\\d+) for Employee data$")
    public void iVerifyTheStatusCodeForEmployeeData(int statusCode) {
        response.log().all()
                .statusCode(statusCode);
    }

    @And("^I get the id of new created Employee data$")
    public void iGetTheIdOfNewCreatedEmployeeData() {
        employeeId = response.extract().path("data.id");
    }

    @When("^I sends a GET request for fatching Employee data by given ID$")
    public void iSendsAGETRequestForFatchingEmployeeDataByGivenID() {
    }

    @Then("^I verify the name is for created record for Employee$")
    public void iVerifyTheNameIsForCreatedRecordForEmployee() {
        response = employeeSteps.getEmployeeById(employeeId);
        response.log().all().statusCode(200);
    }

    @When("^I send the Put Request for updating the Employee data$")
    public void iSendThePutRequestForUpdatingTheEmployeeData() {
    }

    @And("^I update the profile_image$")
    public void iUpdateTheProfile_image() {
        response = employeeSteps.updateTheEmployee(employeeId,employee_name,employee_salary,employee_age,profile_image);
        response.log().all().statusCode(200);
    }

    @Then("^I verify the status code (\\d+) for update Employee data$")
    public void iVerifyTheStatusCodeForUpdateEmployeeData(int arg0) {
    }

    @And("^I verify the name for updating the Employee data$")
    public void iVerifyTheNameForUpdatingTheEmployeeData() {
    }

    @When("^I sends the Delete Request for deleting the Employee  given ID$")
    public void iSendsTheDeleteRequestForDeletingTheEmployeeGivenID() {
        response = employeeSteps.deleteEmployeeById(employeeId);
    }

    @Then("^I verify the status code (\\d+) for delete Employee data$")
    public void iVerifyTheStatusCodeForDeleteEmployeeData(int statusCode) {
        response.log().all().statusCode(statusCode);
    }

    @And("^I get the data for deleted record ID for Employee data$")
    public void iGetTheDataForDeletedRecordIDForEmployeeData() {
        response = employeeSteps.getEmployeeById(employeeId);
    }

    @And("^I verify the status code (\\d+) for verifing the delete record$")
    public void iVerifyTheStatusCodeForVerifingTheDeleteRecord(int statusCode) {
        response.log().all().statusCode(statusCode);
    }
}

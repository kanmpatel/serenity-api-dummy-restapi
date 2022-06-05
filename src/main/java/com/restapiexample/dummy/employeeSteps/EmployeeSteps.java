package com.restapiexample.dummy.employeeSteps;

import com.restapiexample.dummy.constants.EndPoints;
import com.restapiexample.dummy.model.EmployeePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class EmployeeSteps {

    @Step
    public ValidatableResponse createTheRecord(String name, int salary, int age){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName(name);
        employeePojo.setSalary(salary);
        employeePojo.setAge(age);

        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(employeePojo)
                .when()
                .post(EndPoints.CREATE_EMPLOYEE)
                .then();

    }

    @Step
    public ValidatableResponse getEmployeeById(int employeeId){
        return SerenityRest.given()
                .pathParam("employeeID", employeeId)
                .when()
                .get(EndPoints.GET_SINGLE_EMPLOYEE)
                .then();
    }

    @Step
    public ValidatableResponse updateTheEmployee(int employeeId,String name, int salary, int age,String profile){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setEmployee_name(name);
        employeePojo.setEmployee_salary(salary);
        employeePojo.setEmployee_age(age);
        employeePojo.setProfile_image(profile);

        return SerenityRest.given()
                .pathParam("employeeID", employeeId)
                .contentType(ContentType.JSON)
                .body(employeePojo)
                .when()
                .put(EndPoints.UPDATE_EMPLOYEE_BY_ID)
                .then();

    }

    @Step
    public ValidatableResponse deleteEmployeeById(int employeeId){
        return SerenityRest.given()
                .pathParam("employeeID", employeeId)
                .when()
                .delete(EndPoints.DELETE_EMPLOYEE_BY_ID)
                .then();
    }
}

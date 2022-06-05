package com.restapiexample.dummy.dummyapiemployeeinfo;

import com.restapiexample.dummy.employeeSteps.EmployeeSteps;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class EmployeeCurdTest extends TestBase {

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

    @Test
    public void test001(){
        response = employeeSteps.createTheRecord(name,salary,age);
        response.log().all()
                .statusCode(200);
        employeeId = response.extract().path("data.id");
    }

    @Test
    public void test002(){
        response = employeeSteps.getEmployeeById(employeeId);
        response.log().all().statusCode(200);
    }

    @Test
    public void test003(){
        response = employeeSteps.updateTheEmployee(employeeId,employee_name,employee_salary,employee_age,profile_image);
        response.log().all().statusCode(200);
    }

    @Test
    public void test004(){
        response = employeeSteps.deleteEmployeeById(employeeId);
        response.log().all().statusCode(200);
    }




}

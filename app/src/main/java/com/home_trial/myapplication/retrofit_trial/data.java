package com.home_trial.myapplication.retrofit_trial;

import com.google.gson.annotations.SerializedName;


public class data {
    private String id;

    @SerializedName("employee_name")
    private String employeeName;


    @SerializedName("employee_salary")
    private String employeeSalary;


    @SerializedName("employee_age")
    private String employeeAge;

    @SerializedName("profile_image")
    private String profileImage;


    public String getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }
}

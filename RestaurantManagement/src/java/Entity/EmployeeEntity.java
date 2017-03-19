/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author zinia
 */
public class EmployeeEntity {
     private Integer employeeId;
     private String firstName;
     private String lastName;
     private String address;
     private String contactNo;
     private String nationalId;
     private String position;
     private Double salary;
     
    
    public String getemployeeId() {
        
        String employee= employeeId.toString();
        return employee;
    }

    public void setemployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName ) {
        this.lastName = lastName;
    }

   
     public String getAddress() {
        return address;
    }

    public void setAddress(String address ) {
        this.address = address;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getContactNo() {
       
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public String getnationalId() {
     
        return nationalId;
    }

    public void setnationalId(String nationalId) {
        this.nationalId = nationalId;
    }
    public String getsalary() {
        String Salary_=salary.toString();
        return Salary_;
    }

    public void setsalary(Double salary) {
        this.salary = salary;
    }

   
    
}

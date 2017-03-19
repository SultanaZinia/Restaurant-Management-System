/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import BEANS.KEYVALUEPAIR;
import Entity.EmployeeEntity;
import Entity.FoodTableEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zinia
 */
public class EmployeeHelper {

    public static void addEmployee(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();

            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");

            String address = request.getParameter("address");
            String contact = request.getParameter("contact_no");

            String nationalId = request.getParameter("national_id");

            String position = request.getParameter("position");
            String salary_ = request.getParameter("salary");
            double salary = Double.parseDouble(salary_);
            String emp = request.getParameter("employee_id");
            System.out.println(emp);
            Integer empId = Integer.parseInt(emp);

            String query = "INSERT INTO " + Constant.EMPLOYEETABLE + "(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,ADDRESS,CONTACT_NO,NATIONAL_ID,POSITION,SALARY) VALUES (" + empId + ",'"
                    + firstName + "','"
                    + lastName + "','"
                    + address + "','"
                    + contact + "','"
                    + nationalId + "','"
                    + position + "',"
                    + salary + ")";

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            String status = "failure";
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);

            if (rs == null) {
                status = "success";
            }

            out.println(status);
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void FindEmployeeId(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();

            String query = "SELECT MAX(EMPLOYEE_ID) AS EMPLOYEE_ID FROM EMPLOYEE ";
            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();

            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            Integer idNo = null;
            while (rs.next()) {
                idNo = rs.getInt("EMPLOYEE_ID");

            }

            String EmployeeId = idNo.toString();

            //String responseStr = gson.toJson(new KEYVALUEPAIR("status", status));
            out.println(EmployeeId);
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(FoodListHelper.class.getName()).log(Level.SEVERE, null, ex);
        } //catch (SQLException ex) {
        //} 
        finally {
            out.close();
        }
    }

    public static void displayEmployee(HttpServletRequest request, HttpServletResponse response) {

        PrintWriter out = null;
        List<EmployeeEntity> EmployeeTable = null;

        try {
            out = response.getWriter();
            String position = request.getParameter("position");

            System.out.println("vaaa" + position);

            String query = "SELECT * FROM EMPLOYEE WHERE  POSITION = '" + position + "'";

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            System.out.println("vaaa emm");
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            EmployeeTable = new ArrayList<EmployeeEntity>();
            while (rs.next()) {
                EmployeeEntity Fe = new EmployeeEntity();
                Fe.setemployeeId(rs.getInt("employee_id"));
                System.out.println(" employee id" + rs.getInt("employee_id"));
                Fe.setfirstName(rs.getString("first_name"));
                System.out.println(" first_name" + rs.getString("first_name"));

                Fe.setlastName(rs.getString("last_name"));
                Fe.setAddress(rs.getString("address"));
                Fe.setContactNo(rs.getString("contact_no"));
                Fe.setnationalId(rs.getString("national_id"));
                Fe.setPosition(rs.getString("position"));
                Fe.setsalary(rs.getDouble("salary"));

                EmployeeTable.add(Fe);
            }
            System.out.println("vaaa emssssssssssssm");

            Gson gson = new GsonBuilder().create();
            out.println(gson.toJson(EmployeeTable));

            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(FoodListHelper.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void UpdateEmployee(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");

            String address = request.getParameter("address");
            String contact = request.getParameter("contact_no");

            String nationalId = request.getParameter("national_id");

            String position = request.getParameter("position");
            String salary_ = request.getParameter("salary");
            double salary = Double.parseDouble(salary_);
            String emp = request.getParameter("employee_id");
            Integer empId = Integer.parseInt(emp);

            String query = "UPDATE  EMPLOYEE SET FIRST_NAME = '" + firstName + "' , "
                    + "LAST_NAME= '" + lastName + "', "
                    + "ADDRESS = '" + address + "',"
                    + "CONTACT_NO ='" + contact + "',"
                    + "NATIONAL_ID ='" + nationalId + "',"
                    + "SALARY = " + salary + "  WHERE EMPLOYEE_ID = " + empId;

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();,
            String status = "failure";
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);

            if (rs == null) {
                status = "success";
            }

            out.println(status);
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void UpdateSalary(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String employee = request.getParameter("employee_id");
            double employee_id = Double.parseDouble(employee);

            String salary_ = request.getParameter("salary");
            double salary = Double.parseDouble(salary_);

            String query = "UPDATE  EMPLOYEE SET SALARY =   " + salary + "  WHERE EMPLOYEE_ID = " + employee_id + " ";

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            String status = "failure";
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);

            if (rs == null) {
                status = "success";
            }

            out.println(status);
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void UpdateAdress(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String employee = request.getParameter("employee_id");
            double employee_id = Double.parseDouble(employee);

            String address = request.getParameter("address");

            String query = "UPDATE  EMPLOYEE SET ADDRESS =   ' " + address + " '  WHERE EMPLOYEE_ID =  " + employee_id + " ";

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            String status = "failure";
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);

            if (rs == null) {
                status = "success";
            }

            out.println(status);
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void UpdateContact(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String employee = request.getParameter("employee_id");
            double employee_id = Double.parseDouble(employee);

            String contact = request.getParameter("contact_no");
            double contact_no = Double.parseDouble(contact);

            String query = "UPDATE  EMPLOYEE SET CONTACT_NO = " + contact_no + "  WHERE EMPLOYEE_ID = " + employee_id + " ";

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            String status = "failure";
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);

            if (rs == null) {
                status = "success";
            }

            out.println(status);
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void UpdatePosition(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String employee = request.getParameter("employee_id");
            double employee_id = Double.parseDouble(employee);

            String position = request.getParameter("position");

            String query = "UPDATE  EMPLOYEE SET POSITION =  ' " + position + "'  WHERE EMPLOYEE_ID = " + employee_id + " ";

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            String status = "failure";
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);

            if (rs == null) {
                status = "success";
            }

            out.println(status);
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void GetEmp(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            EmployeeEntity FoodTable = new EmployeeEntity();
            out = response.getWriter();
            String EmployeeId = request.getParameter("employee_id");
            Integer Employee = Integer.parseInt(EmployeeId);
            System.out.println("Hello search foodNo!" + Employee);

            String query = "SELECT * FROM  " + Constant.EMPLOYEETABLE + " where employee_id= " + Employee;//"INSERT INTO FOOD_LIST VALUES ('"+foodItemNO+" ', '"+food_name+"', '" +Price+"' ,'"+CategoryId+"')";
            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();

            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            String status = "failure";
            while (rs.next()) {

                FoodTable.setfirstName(rs.getString("first_name"));
                FoodTable.setlastName(rs.getString("last_name"));
                FoodTable.setAddress(rs.getString("address"));
                FoodTable.setContactNo(rs.getString("contact_no"));
                FoodTable.setnationalId(rs.getString("national_id"));
                FoodTable.setsalary(rs.getDouble("salary"));
                FoodTable.setPosition(rs.getString("position"));

            }

            //String responseStr = gson.toJson(new KEYVALUEPAIR("status", status));
            Gson gson = new GsonBuilder().create();
            out.println(gson.toJson(FoodTable));
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(FoodListHelper.class.getName()).log(Level.SEVERE, null, ex);
        } //catch (SQLException ex) {
        //} 
        finally {
            out.close();
        }
    }

}

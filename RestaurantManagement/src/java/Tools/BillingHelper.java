/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.io.IOException;
import Entity.BillingTableEntity;
import Entity.MealEntity;

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
public class BillingHelper {

    public static void addMealOrder(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            System.out.println("addmeal order");
            String bill = request.getParameter("transaction_id");
            Integer Bill = Integer.parseInt(bill);
            String Mealno = request.getParameter("meal_no");
            Integer MealNo= Integer.parseInt(Mealno);
            String food_no = request.getParameter("food_item_no");
            Integer foodNo = Integer.parseInt(food_no);
            String quantity = request.getParameter("food_quantity");
            Integer foodQuantity = Integer.parseInt(quantity);

            String query = "INSERT  INTO MEAL_ORDER_DETAILS VALUES ( " + Bill + " ," + foodNo + "," + foodQuantity + " , "+MealNo +" )";

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            String status = "failure";
            if (rs == null) {
                status = "success";
            }
            System.out.println("sequennce cheking");
            out.println(status);
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void insertTransaction(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            System.out.println("Inserting transaction");
            Integer billing = null;
            out = response.getWriter();
            String Query = "SELECT MAX(BILLING_ID) AS NEW_BILL FROM BILLING";
            ResultSet Rs = DBConnection.executeQuery(Query);

            while (Rs.next()) {
                billing = Rs.getInt("new_bill");
            }
            System.out.println("here goes prev billing_id" + billing);
            Integer BillingId = billing + 1;

            String query = "INSERT INTO BILLING VALUES (" + BillingId + " , NULL ,NULL  ,NULL)";

            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            String status = "failure";
            if (rs == null) {
                status = "success";
                System.out.println("It is added successfully " + status);
            }
            System.out.println("what is happening");
            out.println(BillingId.toString());
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void addTotalBilling(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String transaction_id = request.getParameter("transaction_id");
            Integer billing = Integer.parseInt(transaction_id);
            String date = request.getParameter("payment_date");
            String Time = request.getParameter("payment_time");

            System.out.println("adding Total");

            String query = "SELECT * FROM  " + Constant.MEAL_TABLE + " NATURAL JOIN " + Constant.FOOD_LIST + " WHERE billing_id= " + billing;

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            double Total = 0;
            while (rs.next()) {
                int quan;
                quan = rs.getInt("quantity");
                double price = rs.getInt("price");
                double sum;
                sum = quan * price;
                Total = Total + sum;
                System.out.println("summing " + Total);
            }
            System.out.println("Total: " + Total);
            query = "UPDATE BILLING SET PAYMENT_DATE = ' " + date + "', PAYMENT_TIME = '" + Time + "',total = " + Total + " WHERE BILLING_ID = " + billing;
            ResultSet rs1 = DBConnection.executeQuery(query);
            String Status = "failure";
            if (rs1 == null) {
                Status = "success";
                System.out.println("bill updating successful");
            }

            Gson gson = new GsonBuilder().create();

            if (Status == "success") {
                out.println(Total);
            } else {
                out.println(Status);
            }
            Total = 0;
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void prevMonth(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        List<BillingTableEntity> BillingTable = null;
        try {
            out = response.getWriter();
            String Date = request.getParameter("payment_date");
            System.out.println("searching bill for this date " + Date);

            String query = "SELECT BILLING_ID, PAYMENT_DATE, PAYMENT_TIME, TOTAL  FROM  BILLING WHERE payment_date like ' " + Date + "%'";

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            ResultSet rs = DBConnection.executeQuery(query);
//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            System.out.println("after sql");
            BillingTable = new ArrayList<BillingTableEntity>();
            System.out.println("lets see what happened");

            while (rs.next()) {
                BillingTableEntity Be = new BillingTableEntity();

                Be.setTransaction_id(rs.getInt("billing_id"));
                System.out.println(rs.getInt("billing_id"));
                Be.setPayment_time(rs.getString("payment_time"));
                System.out.println(rs.getString("Payment_time"));
                Be.setPayment_date(rs.getString("payment_date"));
                System.out.println(rs.getString("payment_date"));
                Be.setTotal(rs.getDouble("total"));
                System.out.println(rs.getDouble("total"));

                BillingTable.add(Be);

            }

            Gson gson = new GsonBuilder().create();
            out.println(gson.toJson(BillingTable));

            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void MealDetailsShow(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        List<MealEntity> MealTable = null;
        try {
            out = response.getWriter();
            String BillingId = request.getParameter("transaction_id");
            System.out.println("searching meal" + BillingId);

            String query = "select meal_no,food_name,food_item_no,quantity, price from meal_order_details natural join food_list where "
                    + "billing_id = "+BillingId;

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            ResultSet rs = DBConnection.executeQuery(query);
//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            System.out.println("after sql");
            MealTable = new ArrayList<MealEntity>();
            System.out.println("lets see what happened");

            while (rs.next()) {
                MealEntity Be = new MealEntity();

                Be.setMealId(rs.getInt("meal_no"));
                
                Be.setFoodName(rs.getString("food_name"));
                
                Be.setFoodNo(rs.getInt("food_item_no"));
                System.out.println(rs.getString("food_name"));
                Be.setPrice(rs.getDouble("price"));
                System.out.println(rs.getDouble("price"));
                Be.setQuantity(rs.getInt("quantity"));

                MealTable.add(Be);

            }

            Gson gson = new GsonBuilder().create();
            out.println(gson.toJson(MealTable));

            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
     public static void DeleteMeal(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
       
        try {
            out = response.getWriter();
            String BillingId = request.getParameter("transaction_id");
            Integer Billingid= Integer.parseInt(BillingId);
            String Meal = request.getParameter("meal_no");
            Integer MealNo= Integer.parseInt(Meal);
            System.out.println("deleting meal" + BillingId);

            String query ="delete from meal_order_details where meal_no = "+MealNo+" and billing_id = "+Billingid;

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
         
//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            System.out.println("after sql");
            ResultSet rs = DBConnection.executeQuery(query);
            
            System.out.println("lets see what happened");
            String Status="failure";

            if (rs==null) {
                Status="success";
             
            }

            Gson gson = new GsonBuilder().create();
            out.println(Status);

            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(BillingHelper.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import BEANS.KEYVALUEPAIR;
import Entity.FoodTableEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.BorderLayout;
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
public class FoodListHelper {

    public static void newFoodAdd(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {

            out = response.getWriter();
            String foodItem = request.getParameter("food_item_no");
            Integer foodItemNo = Integer.parseInt(foodItem);
            System.out.println("Hello new foodNo!" + foodItemNo);
            String food_name = request.getParameter("food_name");
            String Price = request.getParameter("price");
            Double price = Double.parseDouble(Price);
            System.out.println("price"+price);
            String Category = request.getParameter("catagory_id");
            Double CategoryId = Double.parseDouble(Category);

            String query = "INSERT INTO " + Constant.FOOD_LIST + " (FOOD_ITEM_NO, FOOD_NAME, PRICE, CATAGORY_ID) VALUES ( " + foodItemNo + " ,  '" + food_name + " ',  " + price + " ,  " + CategoryId + ")";//"INSERT INTO FOOD_LIST VALUES ('"+foodItemNO+" ', '"+food_name+"', '" +Price+"' ,'"+CategoryId+"')";
            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();

            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            String status = "failure";
            if (rs == null) {
                status = "success";
            }
            Gson gson = new GsonBuilder().create();
            //String responseStr = gson.toJson(new KEYVALUEPAIR("status", status));
            out.println(status);

            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(FoodListHelper.class.getName()).log(Level.SEVERE, null, ex);
        } //catch (SQLException ex) {
        //} 
        finally {
            out.close();
        }
    }

    public static void showFoodList(HttpServletRequest request, HttpServletResponse response) {

        PrintWriter out = null;
        List<FoodTableEntity> FoodTable = null;
        try {
            out = response.getWriter();
            String Category = request.getParameter("catagory_id");
            System.out.println("Showing food of this catagory id!" + Category);
            Integer CategoryId = Integer.parseInt(Category);

            String query = "SELECT food_item_no, food_name, price FROM  " + Constant.FOOD_LIST + " NATURAL JOIN " + Constant.CATAGORY_TABLE + " where catagory_id= " + CategoryId + " ";

            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            FoodTable = new ArrayList<FoodTableEntity>();
            while (rs.next()) {
                FoodTableEntity Fe = new FoodTableEntity();
                Fe.setFoodItemNo(rs.getInt("food_item_no"));
                Fe.setPrice(rs.getDouble("price"));
                Fe.setFoodName(rs.getString("food_name"));

                FoodTable.add(Fe);
            }

            Gson gson = new GsonBuilder().create();
            out.println(gson.toJson(FoodTable));

            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(FoodListHelper.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void Food_id(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String Category = request.getParameter("catagory");
            System.out.println("Hello catagory!" + Category);

            Double Catagory_id = Double.parseDouble(Category);
            String query = "SELECT MAX(FOOD_ITEM_NO) AS FOOD_NO FROM FOOD_LIST WHERE CATAGORY_ID  = '" + Catagory_id + "'";
            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();

            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            Integer food_no = null;
            while (rs.next()) {
                food_no = rs.getInt("FOOD_NO");

            }
            System.out.println("Hello new food!" + food_no);
            String foodId = food_no.toString();

            //String responseStr = gson.toJson(new KEYVALUEPAIR("status", status));
            out.println(foodId);
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(FoodListHelper.class.getName()).log(Level.SEVERE, null, ex);
        } //catch (SQLException ex) {
        //} 
        finally {
            out.close();
        }
    }

    public static void UpdateFood(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String foodItem = request.getParameter("food_item_no");
            Integer foodItemNo = Integer.parseInt(foodItem);
            System.out.println("Hello new foodNo!" + foodItemNo);

            String Price = request.getParameter("price");
             System.out.println("updated Price!" + Price);
            Double price = Double.parseDouble(Price);

            String query = "UPDATE  FOOD_LIST SET PRICE =   " + price + "  WHERE FOOD_ITEM_NO like " + foodItemNo ;//"INSERT INTO FOOD_LIST VALUES ('"+foodItemNO+" ', '"+food_name+"', '" +Price+"' ,'"+CategoryId+"')";
            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();

            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            String status = "failure";
            if (rs == null) {
                status = "success";
            }
            Gson gson = new GsonBuilder().create();
            //String responseStr = gson.toJson(new KEYVALUEPAIR("status", status));
            out.println(status);
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(FoodListHelper.class.getName()).log(Level.SEVERE, null, ex);
        } //catch (SQLException ex) {
        //} 
        finally {
            out.close();
        }

    }

    public static void GetFood(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            FoodTableEntity FoodTable = new FoodTableEntity();
            out = response.getWriter();
            String foodItem = request.getParameter("food_item_no");
            Integer foodItemNo = Integer.parseInt(foodItem);
            System.out.println("Hello search foodNo!" + foodItemNo);

            String query = "SELECT food_item_no,food_name, price FROM  " + Constant.FOOD_LIST + " where food_item_no= " + foodItemNo;//"INSERT INTO FOOD_LIST VALUES ('"+foodItemNO+" ', '"+food_name+"', '" +Price+"' ,'"+CategoryId+"')";
            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();

            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            String status = "failure";
            while (rs.next()) {

                FoodTable.setFoodItemNo(rs.getInt("food_item_no"));
                FoodTable.setFoodName(rs.getString("food_name"));
                FoodTable.setPrice(rs.getDouble("price"));

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

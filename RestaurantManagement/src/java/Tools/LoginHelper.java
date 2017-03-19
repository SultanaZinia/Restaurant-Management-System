/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;
import BEANS.CUSTOMERBEAN;
import BEANS.KEYVALUEPAIR;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author siamzz
 */
public class LoginHelper {
    public static void doLogin(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String username = request.getParameter("user_name");
            String password = request.getParameter("user_password");
            
            String query = "SELECT * FROM "  + Constant.USER_TABLE + " "
                    + "where user_name='" + username + "' and user_password = '" + password + "'";
            
            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            String status = "failure";
            while(rs.next()){
                status = "success";
             
            }
             System.out.println("Hello login!");
            Gson gson = new GsonBuilder().create();
           String responseStr = gson.toJson(new KEYVALUEPAIR("status", status));
            out.println(status);
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(LoginHelper.class.getName()).log(Level.SEVERE, null, ex);
        } //catch (SQLException ex) {
            
        //} 
        finally {
            out.close();
        }
    }
    
    public static void doLogOut(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String username = request.getParameter("username");
            //String password = request.getParameter("password");
            out.println("Logout Success"+username+"$");
        } catch (IOException ex) {
            Logger.getLogger(LoginHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
    
    public static void findUser(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String username = request.getParameter("username");
            //String password = request.getParameter("password");
            
            String query = "SELECT * FROM " + Constant.DATABASE_NAME + ".`" + Constant.USER_TABLE + "` "
                    + "where id_user=" + username + " ";
            
            //Tools1.DBConnection dBConnection = new Tools1.DBConnection();
            //SelectSQL selectSQL = new SelectSQL();
            
            ResultSet rs = DBConnection.executeQuery(query);//selectSQL.selQuery(query);//new DBConnection().executeQuery(query); //DBConnection.executeQuery(query);
            response.setStatus(400);
                        
            CUSTOMERBEAN customerBean = new CUSTOMERBEAN();
            while(rs.next()){
                //String username = rs.getString("username");
                customerBean.setPassword(rs.getString("password"));
                customerBean.setFirstName(rs.getString("first_name"));
                customerBean.setLastName(rs.getString("last_name"));
                response.setStatus(200);
                
            }
            
            //Gson gson = new GsonBuilder().create();
//            String responseStr = gson.toJson(new KeyValuePair("status", status));
            //out.println(gson.toJson(customerBean));
            
            //response.setStatus(sc);
        } catch (Exception ex) {
            Logger.getLogger(LoginHelper.class.getName()).log(Level.SEVERE, null, ex);
        } //catch (SQLException ex) {
            
        //} 
        finally {
            out.close();
        }
    }
    
}

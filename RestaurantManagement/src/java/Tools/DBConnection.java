/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;
import java.sql.*;

/**
 *
 * @author siamzz
 */
public class DBConnection {
    
    private static DBConnection dBConnection;
    private static String status="success";
    //ResultSet rset;
    
    public DBConnection(){
        
    }
    
    public static DBConnection getInstance() {
        if(dBConnection == null) 
            dBConnection = new DBConnection();
        return dBConnection;
    }

    public Connection dbConnect(String db_connect_string,String db_userid, String db_password){
        try{
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            Connection conn = DriverManager.getConnection(db_connect_string, db_userid, db_password);
            return conn;
        }
        catch (Exception e){
            System.out.println("DBConnection.java : Exception Occurred in dbConnect method!!!");
            return null;
        }
    }
    
    public static ResultSet executeQuery(String sql) {
        ResultSet rset = null;
        try {
            DBConnection db = getInstance();
            Connection conn = db.dbConnect(Constant.DATABASE_URL, Constant.USERNAME, Constant.PASSWORD);
            //System.out.println("#"+sql+"#");
            
            //rset= conn.createStatement().executeQuery(sql);
            String keyword = sql.substring(0, 6);
            if(keyword.equalsIgnoreCase("select"))
                rset= conn.createStatement().executeQuery(sql);
            else if(keyword.equalsIgnoreCase("insert") || keyword.equalsIgnoreCase("delete"))
                
            {
                System.out.println("vaaaa");
            conn.createStatement().execute(sql);
           
                
            System.out.println("vaaaanaaa");
            }
            else if(keyword.equalsIgnoreCase("update"))
            {System.out.println("up exct");
                conn.createStatement().executeUpdate(sql);
                System.out.println("vaaaa upexct");}
            else throw new SQLException("Invalid keyword");
            
        } catch (SQLException sqlException) {
            //JOptionPane.showMessageDialog(null, "Database Error! @ Search"+sql, "Error Message", JOptionPane.ERROR_MESSAGE);
            System.out.println("SelectSQL.java: SQL Exception occurred!!!");
            status="failure";
            
            
        }
        return rset;
    }
    
    
}

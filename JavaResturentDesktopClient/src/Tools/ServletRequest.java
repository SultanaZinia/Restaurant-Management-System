/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author zinia
 */
public class ServletRequest {
    private static String currentRequestedServlet = null;
    
    public static void setServletRequest(String requestedServlet){
        currentRequestedServlet = requestedServlet;
    }
    public static String getServletRequest(){
        return currentRequestedServlet;
    }
    
}

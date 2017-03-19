/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Bean.KeyValuePair;
import java.util.List;


/**
 *
 * @author zinia
 */
public class Utils {
    public static String getParamsURL(List<KeyValuePair> paramList){
        String paramStr = "";
        if(paramList!= null || !paramList.isEmpty()){
            int c = 0;
            for(KeyValuePair keyValuePair : paramList){
                if(c == 0) {
                    paramStr += "?";
                    c++;
                }
                else {
                    paramStr += "&";
                }
                
                paramStr += keyValuePair.getKey() + "=" + keyValuePair.getValue();
            }
        }
        return paramStr;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

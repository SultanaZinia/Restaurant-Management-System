/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author siamzz
 */
public class Table_Columns_Names {
  
    private static String[] PREV_BILLING_TableColumnNames = {"Billing_ID",
                                             "PAYMENT_DATE",
                                             "PAYMENT_TIME",
                                             "PAYMENT_AMOUNT"};
     private static String[] EMPLOYEE_PANELID_TableColumnNames = {"EMPLOYEE_ID",
                                             "FIRST_NAME",
                                             "LAST_NAME",
                                             "ADDRESS",
                                             "CONTACT_NO",
                                             "NATIONAL_ID",
                                             "POSTION",
                                             "SALARY"
           };
      private static String[] SHOW_FOOD_LIST_PANELID_TableColumnNames = {"FOOD_ITEM_NO",
                                                   "FOOD_NAME",
                                                    "PRICE"
                                                    };
       private static String[] SHOW_MEAL_DETAILS_PANELID_TableColumnNames = {"MEAL NO",
                                                   "FOOD NUMBER",
                                                   "FOOD NAME",
                                                   "QUANTITY",
                                                   "PRICE"
                                                    };
     
       public static String[] getColumnNames(int tabbedPanelID){
           
           if(tabbedPanelID == Constant.PREV_BILLING_PANELID) return PREV_BILLING_TableColumnNames;
           else if(tabbedPanelID == Constant.EMPLOYEE_PANELID) return EMPLOYEE_PANELID_TableColumnNames;
           else if(tabbedPanelID == Constant.SHOW_FOOD_LIST_PANELID) return SHOW_FOOD_LIST_PANELID_TableColumnNames;
           else if(tabbedPanelID== Constant.SHOW_MEAL_DETAILS_PANELID) return SHOW_MEAL_DETAILS_PANELID_TableColumnNames;
           else throw new ExceptionInInitializerError("Panel ID Undefined!!");
       }
    
}

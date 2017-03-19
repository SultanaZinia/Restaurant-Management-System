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
public class Constant {

    public static final String SERVER_URL = "http://localhost:8084/RestaurantManagement";
    public static final String LOGIN_SERVLET = "/LOGINSERVLET";
    public static final String BILLING_SERVLET = "/BillingServlet";
    public static final String FOOD_LIST_SERVLET = "/FoodListServlet";
    public static final String EMPLOYEE_SERVLET = "/EmployeeServlet";
    public static final String KEY_COMMAND = "command";
    public static final String KEY_LOGIN_METHOD = "login";
    public static final String KEY_FIND_USER_METHOD = "findUser";
    public static final String KEY_USERNAME = "user_name";
    public static final String KEY_PASSWORD = "user_password";
    public static String USER_TABLE = "user_login";
    public static String MEAL_TABLE = "meal_order_details";
    public static String FOOD_LIST = "food_list";
    public static String BILLING_TABLE = "billing";
    public static String FOOD_TABLE = "food_list";
    public static String CATAGORY_TABLE = "food_catagory";
    public static String EMPLOYEETABLE = "EMPLOYEE";

    public static String USERNAME = "resturent_management";
    public static String PASSWORD = "sust";

    //billing
    public static final String KEY_BILLING_ADD = "Add";
    public static final String KEY_TOTAL_BILLING = "Done";
    public static final String KEY_PREV_BILLING = "Ok";
    //food
    public static final String KEY_FOOD_ADD = "FoodAdd";
    public static final String KEY_FOOD_SHOW = "Foodshow";
    public static final String KEY_FIND_FOOD_NO = "FINDID";
    public static final String KEY_CATEGORY = "catagory";
    public static final String KEY_UPDATE_FOOD = "UpdateFood";
  

    //table column names
    public static int CURRENT_BILLING_PANELID = 0;
    public static int PREV_BILLING_PANELID = 1;
    public static int EMPLOYEE_PANELID = 2;
    public static int SHOW_FOOD_LIST_PANELID = 3;
    public static int SHOW_MEAL_DETAILS_PANELID = 4;

    public static final String KEY_YEAR = "year";
    public static final String KEY_MONTH = "month";

    //Employee
    public static final String KEY_ADD_EMPLOYEE = "ADDING";
    public static final String KEY_SHOW_EMPLOYEE = "SHOWDETAILS";
    public static final String KEY_EMPLOYEE_ID = "employee_id";
    public static final String KEY_FNAME = "first_name";

    public static final String KEY_LNAME = "last_name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_CONTACT = "contact_no";

    public static final String KEY_NATIONAL_ID = "national_id";
    public static final String KEY_POSITION = "position";
    public static final String KEY_SALARY = "salary";
    public static final String KEY_FIND_ID = "EMFINDID";
    public static final String KEY_EMP_SHOW= "EMPL";
    //update employee
    public static final String KEY_UPDATE_SALARY = "UPDATE_SALARY";
     public static final String KEY_UPDATE_EMPLOYEE = "UPDATE_EMPLOYEE";
    public static final String KEY_UPDATE_CONTACTNO = "UPDATE_CONTACT";
    public static final String KEY_UPDATE_ADDRESS = "UPDATE_ADDRESS";
    public static final String KEY_UPDATE_POSITION = "UPDATE_POSITION";

    public static final String CHINEESE = "1";
    public static final String BANGLA = "2";
    public static final String INDIAN = "3";

    //employee position
    public static final String manager = "MANAGER";
    public static final String waiter = "WAITER";
    public static final String chef = "CHEF";
    public static final String cashier = "CASHIER";
    public static final String cleaner = "CLEANER";
    //food_list
    public static final String KEY_FOOD_ITEM = "food_item_no";
    public static final String KEY_FOOD_NAME = "food_name";
    public static final String KEY_PRICE = "price";
    public static final String KEY_CATAGROY_ID = "catagory_id";
    public static final String KEY_MEAL_ID = "meal_no";
    public static final String KEY_MEAL_DELETE = "DELETE";
    public static final String KEY_FOOD_PRICE= "PriceShow";

    public static final String KEY_TRANSACTIONID = "transaction_id";
    public static final String KEY_FOODQUANTITY = "food_quantity";
    public static final String KEY_DATE = "payment_date";

    public static final String KEY_TIME = "payment_time";
    public static final String KEY_TRANSACTION_FIND = "TID";
    public static final String KEY_MEAL_DETAILS = "MEALSHOW";
    
}

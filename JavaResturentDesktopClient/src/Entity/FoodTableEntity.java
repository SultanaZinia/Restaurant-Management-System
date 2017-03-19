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
public class FoodTableEntity {
    private Integer food_item_no;
    private String food_name;
    private Double price;
   // private Double food_category;
    
    
     public String getFoodItemNo() {
        String foodItemNo= food_item_no.toString();
        return foodItemNo;
    }

    public void setFoodItemNo(Integer food_item_no) {
        this.food_item_no = food_item_no;
    }

    public String getFoodName() {
        return food_name;
    }

    public void setFoodName(String food_name) {
        this.food_name = food_name;
    }

    public String getPrice() {
        String Price= price.toString();
        return Price ;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    /* public String getFoodCatagory() {
         String foodCatagory= food_category.toString();
        return foodCatagory;
    }

    public void setFoodCatagory(String food_catagory) {
        this.food_category = food_category;
    }*/


   
    
    
    
}

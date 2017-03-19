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
public class MealEntity {
    private Integer MealId;
    private Integer FoodNo;
    private String  FoodName;
    private Double  price;
    private Integer quantity;

    public Integer getMealId() {
        return MealId;
    }

    public void setMealId(Integer MealId) {
        this.MealId = MealId;
    }

    public Integer getFoodNo() {
        return FoodNo;
    }

    public void setFoodNo(Integer FoodNo) {
        this.FoodNo = FoodNo;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

    public Double getPrice() {
        return quantity*price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}

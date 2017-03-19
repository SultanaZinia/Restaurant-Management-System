/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresturentdesktopclient;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author siamzz
 */
@Entity
@Table(name = "FOOD_LIST", catalog = "", schema = "RESTURENT_MANAGEMENT")
@NamedQueries({
    @NamedQuery(name = "FoodList.findAll", query = "SELECT f FROM FoodList f"),
    @NamedQuery(name = "FoodList.findByFoodItemNo", query = "SELECT f FROM FoodList f WHERE f.foodItemNo = :foodItemNo"),
    @NamedQuery(name = "FoodList.findByFoodName", query = "SELECT f FROM FoodList f WHERE f.foodName = :foodName"),
    @NamedQuery(name = "FoodList.findByDescription", query = "SELECT f FROM FoodList f WHERE f.description = :description"),
    @NamedQuery(name = "FoodList.findByPrice", query = "SELECT f FROM FoodList f WHERE f.price = :price"),
    @NamedQuery(name = "FoodList.findByCatagoryId", query = "SELECT f FROM FoodList f WHERE f.catagoryId = :catagoryId")})
public class FoodList implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "FOOD_ITEM_NO")
    private BigDecimal foodItemNo;
    @Column(name = "FOOD_NAME")
    private String foodName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private BigInteger price;
    @Column(name = "CATAGORY_ID")
    private BigInteger catagoryId;

    public FoodList() {
    }

    public FoodList(BigDecimal foodItemNo) {
        this.foodItemNo = foodItemNo;
    }

    public BigDecimal getFoodItemNo() {
        return foodItemNo;
    }

    public void setFoodItemNo(BigDecimal foodItemNo) {
        BigDecimal oldFoodItemNo = this.foodItemNo;
        this.foodItemNo = foodItemNo;
        changeSupport.firePropertyChange("foodItemNo", oldFoodItemNo, foodItemNo);
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        String oldFoodName = this.foodName;
        this.foodName = foodName;
        changeSupport.firePropertyChange("foodName", oldFoodName, foodName);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        BigInteger oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public BigInteger getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(BigInteger catagoryId) {
        BigInteger oldCatagoryId = this.catagoryId;
        this.catagoryId = catagoryId;
        changeSupport.firePropertyChange("catagoryId", oldCatagoryId, catagoryId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodItemNo != null ? foodItemNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodList)) {
            return false;
        }
        FoodList other = (FoodList) object;
        if ((this.foodItemNo == null && other.foodItemNo != null) || (this.foodItemNo != null && !this.foodItemNo.equals(other.foodItemNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaresturentdesktopclient.FoodList[ foodItemNo=" + foodItemNo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

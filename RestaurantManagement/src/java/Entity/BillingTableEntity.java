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
public class BillingTableEntity {
    private Integer billing_id;
    private String payment_date;
    private String payment_time;
    private Double total;
    
    public String getTransaction_id() {
        String billing = billing_id.toString();
        return billing;
    }

    public void setTransaction_id(Integer billing_id) {
        this.billing_id = billing_id;
    }

    public String getTotal() {
        return total.toString();
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPayment_date() {
        return payment_date ;
    }

    public void setPayment_date(String payment_date ) {
        this.payment_date = payment_date;
    }
      public String getPayment_time() {
        return payment_time ;
    }

    public void setPayment_time(String payment_time ) {
        this.payment_time = payment_time;
    }

   
    
    
}

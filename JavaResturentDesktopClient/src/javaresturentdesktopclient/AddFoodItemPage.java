 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresturentdesktopclient;

import Entity.FoodTableEntity;
import Entity.MealEntity;
import TableModel.RestaurantTableModel;
import Tools.Constant;
import Tools.HttpClientUtil;
import Tools.ServletRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author siamzz
 */
public class AddFoodItemPage extends javax.swing.JFrame {

    //public FoodAddShowUpdate add;
    public Home_page hp;
    final static Integer catagoryId[] = {1, 2, 3};
    Integer item;
    String CategoryId= Constant.CHINEESE;
   
    

    /**
     * Creates new form Add_food_item_page_6
     */
    public AddFoodItemPage(Home_page var) {

        initComponents();
        jTextFieldFoodName.setToolTipText("Enter Food Name");
        hp = var;
        ShowFoodTable(CategoryId);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextFieldFoodName = new javax.swing.JTextField();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldUpdateFoodNo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFoodList = new javax.swing.JTable();
        jTextFieldUpdateprice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButtonUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setMaximumSize(new java.awt.Dimension(705, 550));
        setMinimumSize(new java.awt.Dimension(705, 550));
        setPreferredSize(new java.awt.Dimension(705, 550));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("FOOD NAME:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 200, 150, 60);

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("PRICE:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 230, 100, 60);

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("CATAGORY:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 110, 130, 30);

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BUTTON IMAGE/ADD.png"))); // NOI18N
        jButton1.setToolTipText("ADD FOOD ITEM");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(180, 290, 60, 20);
        getContentPane().add(jTextFieldFoodName);
        jTextFieldFoodName.setBounds(140, 220, 140, 20);
        getContentPane().add(jTextFieldPrice);
        jTextFieldPrice.setBounds(140, 250, 140, 20);

        jLabel4.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Add New Food");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 180, 210, 40);

        jComboBox1.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(204, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHINEESE", "BANGLA", "INDIAN" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(270, 110, 140, 30);

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(51, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BUTTON IMAGE/left.png"))); // NOI18N
        jButton2.setToolTipText("back to home page");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(500, 70, 50, 50);

        jLabel7.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("Update Food Item ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 330, 190, 40);

        jTextFieldUpdateFoodNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUpdateFoodNoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUpdateFoodNo);
        jTextFieldUpdateFoodNo.setBounds(150, 370, 130, 20);

        jLabel8.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("FOOD ITEM NO:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 360, 140, 40);

        jTableFoodList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Item No", "Food Name", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFoodList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableFoodList);
        if (jTableFoodList.getColumnModel().getColumnCount() > 0) {
            jTableFoodList.getColumnModel().getColumn(0).setResizable(false);
            jTableFoodList.getColumnModel().getColumn(1).setResizable(false);
            jTableFoodList.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(340, 170, 350, 320);
        getContentPane().add(jTextFieldUpdateprice);
        jTextFieldUpdateprice.setBounds(150, 410, 130, 20);

        jLabel9.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setText("PRICE:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(90, 410, 120, 20);

        jButtonUpdate.setText("update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdate);
        jButtonUpdate.setBounds(167, 440, 90, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BUTTON IMAGE/background-1024x808 - Copy.jpg"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(705, 550));
        jLabel6.setMinimumSize(new java.awt.Dimension(705, 550));
        jLabel6.setPreferredSize(new java.awt.Dimension(705, 550));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 700, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        hp.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // int item=((JComboBox)evt.getSource()).getSelectedIndex();

        Integer foodItem = 0;

        ServletRequest.setServletRequest(Constant.FOOD_LIST_SERVLET);
        if (item == 1)//for getting the last food_item_no of that category
        {

            List<NameValuePair> paramList = new ArrayList<>();

            paramList.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_FIND_FOOD_NO));
            paramList.add(new BasicNameValuePair(Constant.KEY_CATEGORY, Constant.CHINEESE));
            System.out.println("Hello chinese!");
            String response = HttpClientUtil.postRequest(paramList);
            System.out.println("Hello login!" + response);
            foodItem = Integer.parseInt(response) + 1;
            System.out.println("Hello new foodno!" + foodItem);
            //getting category_id

        } else if (item == 2) {

            List<NameValuePair> paramList = new ArrayList<>();

            paramList.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_FIND_FOOD_NO));
            paramList.add(new BasicNameValuePair(Constant.KEY_CATEGORY, Constant.BANGLA));
            String response = HttpClientUtil.postRequest(paramList);
            foodItem = Integer.parseInt(response) + 1;

        } else if (item == 3) {

            List<NameValuePair> paramList = new ArrayList<>();

            paramList.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_FIND_FOOD_NO));
            paramList.add(new BasicNameValuePair(Constant.KEY_CATEGORY, Constant.INDIAN));
            String response = HttpClientUtil.postRequest(paramList);

            foodItem = Integer.parseInt(response) + 1;
            System.out.println(" notjinhg" + foodItem);
        } else {
            System.out.println(" notjinhg");
        }
        String foodName = jTextFieldFoodName.getText();//get food_name
        String price = jTextFieldPrice.getText();//get the price
        String foodItemNo;
        foodItemNo = Integer.toString(foodItem);
        List<NameValuePair> paramList = new ArrayList<>();

        paramList.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_FOOD_ADD));
        paramList.add(new BasicNameValuePair(Constant.KEY_FOOD_ITEM, foodItemNo));
        paramList.add(new BasicNameValuePair(Constant.KEY_FOOD_NAME, foodName));
        paramList.add(new BasicNameValuePair(Constant.KEY_PRICE, price));
        paramList.add(new BasicNameValuePair(Constant.KEY_CATAGROY_ID, CategoryId));
        System.out.println("Adding  new food!");

        String response = HttpClientUtil.postRequest(paramList);
        if (response.equalsIgnoreCase("success")) {

            JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED", "Information", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldFoodName.setText(null);
            jTextFieldPrice.setText(null);
            ShowFoodTable(CategoryId);
        } else {
            JOptionPane.showMessageDialog(null, "Failed please enter valid number in price field!", "Error Message", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        int index;

        index = ((JComboBox) evt.getSource()).getSelectedIndex();
        item = catagoryId[index];

        if (item == 1) {
            CategoryId = Constant.CHINEESE;
        } else if (item == 2) {
            CategoryId = Constant.BANGLA;
        } else {
            CategoryId = Constant.INDIAN;
        }
        ShowFoodTable(CategoryId);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextFieldUpdateFoodNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUpdateFoodNoActionPerformed
        // TODO add your handling code here:
        
        String foodItemNo=jTextFieldUpdateFoodNo.getText();
        
        ServletRequest.setServletRequest(Constant.FOOD_LIST_SERVLET);
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_FOOD_PRICE));
        paramList.add(new BasicNameValuePair(Constant.KEY_FOOD_ITEM,foodItemNo));
        
        String response = HttpClientUtil.postRequest(paramList);
        
        
        Gson gson = new GsonBuilder().create();
        java.lang.reflect.Type collectionType = new TypeToken<FoodTableEntity>() {
        }.getType();
        FoodTableEntity foodList = gson.fromJson(response, collectionType);
        
        
        jTextFieldUpdateprice.setText(foodList.getPrice());
        
        
        
        
        
    }//GEN-LAST:event_jTextFieldUpdateFoodNoActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        String foodItemNo=jTextFieldUpdateFoodNo.getText();//get food_name
        String price=jTextFieldUpdateprice.getText();//get the price
        
        
        ServletRequest.setServletRequest(Constant.FOOD_LIST_SERVLET);
        List<NameValuePair> paramList = new ArrayList<>();
       
        paramList.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_UPDATE_FOOD));
        paramList.add(new BasicNameValuePair(Constant.KEY_FOOD_ITEM,foodItemNo));
        paramList.add(new BasicNameValuePair(Constant.KEY_PRICE,price));
        
        System.out.println("Updated food price!" +price);
        String response = HttpClientUtil.postRequest(paramList);
        if(response.equalsIgnoreCase("success")){
                       JOptionPane.showMessageDialog(null, "Successfully Updated", "Information", JOptionPane.INFORMATION_MESSAGE);
                       jTextFieldUpdateFoodNo.setText(null);
                       jTextFieldUpdateprice.setText(null);  
                       ShowFoodTable(CategoryId);
        }
                else 
                       JOptionPane.showMessageDialog(null, "Failed!"
                               + " \n please give food item no and price correctly , thank you", "Error Message", JOptionPane.ERROR_MESSAGE);
       
        
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public void ShowFoodTable(String catagory) {

        CategoryId= catagory;
        int tabbedPanelID = Constant.SHOW_FOOD_LIST_PANELID;

        //send request to servlet 
        //description, catagory niye prob ase
        List<NameValuePair> paramList = new ArrayList<>();
        System.out.println("show now" + CategoryId);
        ServletRequest.setServletRequest(Constant.FOOD_LIST_SERVLET);
        paramList.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_FOOD_SHOW));
        paramList.add(new BasicNameValuePair(Constant.KEY_CATAGROY_ID, CategoryId));
        String response = HttpClientUtil.postRequest(paramList);

        Gson gson = new GsonBuilder().create();
        Object[][] objectArray = null;
        java.lang.reflect.Type collectionType = new TypeToken<List<FoodTableEntity>>() {
        }.getType();
        List<FoodTableEntity> foodList = gson.fromJson(response, collectionType);
        objectArray = new Object[foodList.size()][];
        int count = 0;

        for (FoodTableEntity prob : foodList) {
            Object[] obj = new Object[4];
            obj[0] = prob.getFoodItemNo();
            obj[1] = prob.getFoodName();
            obj[2] = prob.getPrice();

            objectArray[count] = obj;
            count++;
        }
        RestaurantTableModel restaurantModel1 = new RestaurantTableModel(tabbedPanelID, objectArray);
        jTableFoodList = new JTable(restaurantModel1);
        jTableFoodList.setPreferredScrollableViewportSize(new Dimension(600, 400));
        jTableFoodList.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(jTableFoodList);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFoodList;
    private javax.swing.JTextField jTextFieldFoodName;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldUpdateFoodNo;
    private javax.swing.JTextField jTextFieldUpdateprice;
    // End of variables declaration//GEN-END:variables
}

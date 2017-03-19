/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresturentdesktopclient;

import Entity.BillingTableEntity;
import Entity.MealEntity;
import TableModel.RestaurantTableModel;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siamzz
 */
public class BillingPage extends javax.swing.JFrame {

    Integer transactionId = 0;
    DateFormat dateFormat;
    String Date;
    String Time;
    String transaction;
    Integer count = 1;
    Integer MealNo = 1;
    String Total;

    /**
     * Creates new form BillingPage
     */
    public BillingOptionSelect add;

    public BillingPage(BillingOptionSelect var) {

        initComponents();
        add = var;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButtonremove = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMealOrder = new javax.swing.JTable();
        jTextFieldMealno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(715, 560));
        setMinimumSize(new java.awt.Dimension(715, 560));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("FOOD ITEM NO :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 80, 160, 40);

        jButtonremove.setText("Remove");
        jButtonremove.setToolTipText("Press this Button To Remove Row From Table");
        jButtonremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonremoveActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonremove);
        jButtonremove.setBounds(580, 340, 100, 30);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(280, 80, 90, 31);

        jLabel4.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("QUANTITY:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 120, 130, 40);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(280, 120, 90, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BUTTON IMAGE/ADD.png"))); // NOI18N
        jButton1.setToolTipText("PLEASE CLICK HERE FOR ADD FOOD");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 120, 60, 20);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BUTTON IMAGE/ADD BILL/DONE.png"))); // NOI18N
        jButton2.setToolTipText("CLICK HERE FOR TOTAL");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(310, 460, 60, 20);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BUTTON IMAGE/left.png"))); // NOI18N
        jButton3.setToolTipText("please click for going home page");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(500, 70, 50, 50);

        jTableMealOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meal No", "Food No", "food Name", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTableMealOrder);
        if (jTableMealOrder.getColumnModel().getColumnCount() > 0) {
            jTableMealOrder.getColumnModel().getColumn(1).setResizable(false);
            jTableMealOrder.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 190, 452, 220);

        jTextFieldMealno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMealnoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldMealno);
        jTextFieldMealno.setBounds(580, 290, 100, 30);

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("MEAL NO:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 290, 100, 30);

        jButton4.setText("print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(600, 450, 70, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BUTTON IMAGE/background-1024x808 - Copy.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(715, 560));
        jLabel2.setMinimumSize(new java.awt.Dimension(715, 560));
        jLabel2.setPreferredSize(new java.awt.Dimension(715, 560));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 700, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String food_no = jTextField3.getText();
        String quantity = jTextField4.getText();

        ServletRequest.setServletRequest(Constant.BILLING_SERVLET);
        //getting transaction id
        if (count == 1) {
            System.out.println("New bill add which is null");

            List<NameValuePair> paramList = new ArrayList<>();
            paramList.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_TRANSACTION_FIND));

            String response = HttpClientUtil.postRequest(paramList);
            transactionId = Integer.parseInt(response);
            System.out.println("New Trnsaction Id!" + transactionId);

            count = 2;
        }

        //add bill to meal order details table
        System.out.println("Hello bill add!");
        List<NameValuePair> paramLis = new ArrayList<>();
        paramLis.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_BILLING_ADD));
        paramLis.add(new BasicNameValuePair(Constant.KEY_FOOD_ITEM, food_no));
        paramLis.add(new BasicNameValuePair(Constant.KEY_MEAL_ID, MealNo.toString()));
        paramLis.add(new BasicNameValuePair(Constant.KEY_TRANSACTIONID, transactionId.toString()));
        paramLis.add(new BasicNameValuePair(Constant.KEY_FOODQUANTITY, quantity));
        String response = HttpClientUtil.postRequest(paramLis);
        if (response.equalsIgnoreCase("success")) {
            
            jTextField3.setText(null);
            jTextField4.setText(null);

            MealNo++;
            ShowTable(transactionId);

        } else {
            JOptionPane.showMessageDialog(null, "Failed!"
                    + "\n please give food item no and quantity correctly , thank you", "Error Message", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        add.show();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ServletRequest.setServletRequest(Constant.BILLING_SERVLET);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        String DateTime = dateFormat.format(date);
        Date = DateTime.substring(0, 10);
        Time = DateTime.substring(11, 18);
        System.out.println("Date: " + Date + " Time: " + Time);

        //send request to servlet
        List<NameValuePair> paramLis = new ArrayList<>();
        paramLis.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_TOTAL_BILLING));
        paramLis.add(new BasicNameValuePair(Constant.KEY_DATE, Date.trim()));
        paramLis.add(new BasicNameValuePair(Constant.KEY_TIME, Time.trim()));
        paramLis.add(new BasicNameValuePair(Constant.KEY_TRANSACTIONID, transactionId.toString()));

        String response = HttpClientUtil.postRequest(paramLis);

        //get response
        if (response.equalsIgnoreCase("failure")) {
            JOptionPane.showMessageDialog(null, "Failed!", "Error Message", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Total " + response, "Information", JOptionPane.INFORMATION_MESSAGE);
            Total = response;
            System.out.println("total " + response);
            jTextField3.setText(null);
            jTextField4.setText(null);
            count = 1;
            MealNo = 1;
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonremoveActionPerformed
        // TODO add your handling code here:
        String mealNo = jTextFieldMealno.getText();
        System.out.println("Hello meal remove");
        ServletRequest.setServletRequest(Constant.BILLING_SERVLET);

        List<NameValuePair> paramLis = new ArrayList<>();
        paramLis.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_MEAL_DELETE));

        paramLis.add(new BasicNameValuePair(Constant.KEY_MEAL_ID, mealNo));
        paramLis.add(new BasicNameValuePair(Constant.KEY_TRANSACTIONID, transactionId.toString()));

        String response = HttpClientUtil.postRequest(paramLis);
        if (response.equalsIgnoreCase("success")) {
            JOptionPane.showMessageDialog(null, "Deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldMealno.setText(null);

            MealNo--;

            ShowTable(transactionId);

        } else {
            JOptionPane.showMessageDialog(null, "Failed!"
                    + "\n please give Meal No, thank you", "Error Message", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButtonremoveActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        System.out.println("khgfkh");
    }//GEN-LAST:event_formKeyReleased

    private void jTextFieldMealnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMealnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMealnoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        
        try {
            Document doc = new Document(PageSize.A4.rotate());
            String Datee = Date;
            PdfWriter.getInstance(doc, new FileOutputStream("d:/BillingTable_" + transactionId + "_" + Datee + ".pdf"));
            
            PdfPTable pdfTable = new PdfPTable(jTableMealOrder.getColumnCount());
            //adding table headers
            for (int i = 0; i < jTableMealOrder.getColumnCount(); i++) {
                pdfTable.addCell(jTableMealOrder.getColumnName(i));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows < jTableMealOrder.getRowCount(); rows++) {
                for (int cols = 0; cols < jTableMealOrder.getColumnCount(); cols++) {
                    pdfTable.addCell(jTableMealOrder.getModel().getValueAt(rows, cols).toString());

                }
            }

            doc.open();
          
            Paragraph preface = new Paragraph("Biliing Id :  "+transactionId+"                                                                                                                                  DATE : " + Date + "  TIME :" + Time + "\n\n\n\n");
            preface.setAlignment(Element.ALIGN_LEFT);
            doc.add(preface);
            pdfTable.setHorizontalAlignment(Element.ALIGN_CENTER);
            doc.add(pdfTable);

            Paragraph preface1 = new Paragraph("\n\n\n\n\tTotal:" + Total + "\n\n");
            preface1.setAlignment(Element.ALIGN_BASELINE);
            doc.add(preface1);
            doc.add(new Paragraph());

            doc.add(new Paragraph("\n\n\n\nTHANK YOU"));

            doc.close();
            System.out.println("done");
            JOptionPane.showMessageDialog(null, "Printed", "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException ex) {
            Logger.getLogger(BillingPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BillingPage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void ShowTable(int BillingId) {

        Integer billingId = BillingId;
        int tabbedPanelID = Constant.SHOW_MEAL_DETAILS_PANELID;

        //send request to servlet 
        ServletRequest.setServletRequest(Constant.BILLING_SERVLET);
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_MEAL_DETAILS));
        paramList.add(new BasicNameValuePair(Constant.KEY_TRANSACTIONID, billingId.toString()));

        String response = HttpClientUtil.postRequest(paramList);

        Gson gson = new GsonBuilder().create();
        Object[][] objectArray = null;
        java.lang.reflect.Type collectionType = new TypeToken<List<MealEntity>>() {
        }.getType();
        List<MealEntity> MealList = gson.fromJson(response, collectionType);
        objectArray = new Object[MealList.size()][];
        int count = 0;

        for (MealEntity prob : MealList) {
            Object[] obj = new Object[7];
            obj[0] = prob.getMealId();
            obj[1] = prob.getFoodNo();
            obj[2] = prob.getFoodName();

            obj[3] = prob.getQuantity();
            obj[4] = prob.getPrice();

            objectArray[count] = obj;
            count++;
        }
        RestaurantTableModel restaurantModel1 = new RestaurantTableModel(tabbedPanelID, objectArray);
        jTableMealOrder = new JTable(restaurantModel1);
        jTableMealOrder.setPreferredScrollableViewportSize(new Dimension(600, 400));
        jTableMealOrder.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(jTableMealOrder);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonremove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMealOrder;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldMealno;
    // End of variables declaration//GEN-END:variables
}

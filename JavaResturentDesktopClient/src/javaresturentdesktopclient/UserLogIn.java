/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaresturentdesktopclient;

import Bean.KeyValuePair;
import Tools.Constant;
import Tools.HttpClientUtil;
import Tools.ServletRequest;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/**
 *
 * @author siamzz
 */
public class UserLogIn extends javax.swing.JFrame {
     

    /**
     * Creates new form UserLogIn
     */
     public Home_page hp;
    public UserLogIn() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private String username;

    public String getUsername() {
        return username;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(680, 530));
        setMinimumSize(new java.awt.Dimension(680, 530));
        setPreferredSize(new java.awt.Dimension(680, 530));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 153, 255));
        jLabel2.setText("USER NAME :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 300, 150, 48);

        jTextField1.setBackground(new java.awt.Color(204, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(370, 310, 241, 30);

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 153, 255));
        jLabel3.setText("PASSWORD:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 360, 130, 30);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BUTTON IMAGE/button(1).png"))); // NOI18N
        jToggleButton1.setToolTipText("PLEASE CLICK FOR LOG IN");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(450, 410, 100, 30);

        jPasswordField1.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(370, 360, 241, 30);

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setText("POWERED BY: TECHTRUST");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(380, 460, 230, 23);

        jLabel5.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 153, 255));
        jLabel5.setText("RESTAURANT MANAGEMENT SYSTEM");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 210, 560, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BUTTON IMAGE/LOG IN.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 680, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        String username = jTextField1.getText();
       // String username = jTextField1.getText();
        String password;
        password = jPasswordField1.getText();
        //List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
        //nameValuePairs.add(new BasicNameValuePair("registrationid", "123456789"));
        List<NameValuePair> paramList = new ArrayList<>();
        ServletRequest.setServletRequest(Constant.LOGIN_SERVLET);
        paramList.add(new BasicNameValuePair(Constant.KEY_COMMAND, Constant.KEY_LOGIN_METHOD));
        paramList.add(new BasicNameValuePair(Constant.KEY_USERNAME, username));
        paramList.add(new BasicNameValuePair(Constant.KEY_PASSWORD, password));
        
        String response = HttpClientUtil.postRequest(paramList);
        
        if(response.equalsIgnoreCase("success"))
        {   
          JOptionPane.showMessageDialog(null, "Login Success", "Information", JOptionPane.INFORMATION_MESSAGE);
          Home_page go_for_hmpg = new  Home_page(this);
          go_for_hmpg.setUserNameTextField(getUsername());
          go_for_hmpg.setVisible(true);
         go_for_hmpg.setResizable(false);
        this.hide();
        jPasswordField1.setText(null);} 
        else 
            JOptionPane.showMessageDialog(null, "Login Failed!"
                    + "PLEASE GIVE THE CORRECT USER NAME AND PASSWORD", "Error Message", JOptionPane.ERROR_MESSAGE);
        
     
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}

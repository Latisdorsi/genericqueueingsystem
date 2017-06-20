/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueclient;

//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.JsonNode;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import org.json.JSONException;
//import org.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author alber
 */
public class LoginPanel extends javax.swing.JFrame {

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();

    }

    String session;

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
        userTxt = new javax.swing.JTextField();
        passTxt = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        setMaximumSize(new java.awt.Dimension(458, 222));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Password: ");

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GQS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        loginBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passTxt))
                    .addComponent(loginBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(loginBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        if (!userTxt.getText().isEmpty() && !passTxt.getText().isEmpty()) {
            try {

                // create HTTP Client
                HttpClient httpClient = HttpClientBuilder.create().build();

                // Create new getRequest with below mentioned URL
                HttpPost postRequest = new HttpPost("http://localhost:8080/ws/account/login");
                StringEntity input = new StringEntity("{\"username\":\"" + userTxt.getText() + "\",\n\"password\":\"" + passTxt.getText() + "\"}");
                // Add additional header to getRequest which accepts application/JSON data
                input.setContentType("application/json");
                postRequest.setEntity(input);
                // Execute your request and catch response
                HttpResponse response = httpClient.execute(postRequest);

                // Check for HTTP response code: 200 = success
                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + response.getStatusLine().getStatusCode());

                }

                // Get-Capture Complete application/JSON body response
                BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
                String output = null;
                output = br.readLine();
                System.out.println("============Output:============");
                System.out.println(output);

                //gets the session
                if (output.substring(12, 13).equalsIgnoreCase("\"")) {

                    JOptionPane.showMessageDialog(rootPane, "Login Failed!");
                    LoginPanel l = new LoginPanel();
                    l.setVisible(true);
                    this.dispose(); //closes the login page.
                } else {
                    session = output.substring(12, 76);
                    Session.setSesh(session);
                    JOptionPane.showMessageDialog(rootPane, "Login Successful!");
                    //Move to the next Form
                    if (userTxt.getText().equals("admin") || userTxt.getText().equals("admin")) {
                        AdminPanel a = new AdminPanel();
                        a.setVisible(true);
                        this.dispose(); //closes the login page.
                    } else {
                        
                        //logging in to the member's form
                        ManagerPanel m = new ManagerPanel();
                        m.setVisible(true);
                        this.dispose(); //closes the login page.
                    }

                }

            } catch (ClientProtocolException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Error! User not found.");

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Error! User not found.");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Error! User not found.");
        }
        /*
        ////////////TRY UNIREST
        JSONObject obj = new JSONObject();
        try {
        obj.put("username", userTxt.getText());
        obj.put("password", passTxt.getText());
        } catch (JSONException ex) {
        Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/ws/account/login")
        .header("Content-Type", "application/json")
        .body(obj)
        .asJson();
        } catch (UnirestException ex) {
        Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
         */

 /*
        ////////////TRY UNIREST
        
         JSONObject obj = new JSONObject();
        try {
            obj.put("username", userTxt.getText());
            obj.put("password", passTxt.getText());
        } catch (JSONException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/ws/account/login")
                    .header("Content-Type", "application/json")
                    .body(obj)
                    .asJson();
        } catch (UnirestException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }//GEN-LAST:event_loginBtnActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
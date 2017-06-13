package queueclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alber
 */
public class AdminPanel extends javax.swing.JFrame {

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoutBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        logoLabel5 = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();
        logoLabel4 = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        logoLabel7 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        createManagerBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        logoLabel6 = new javax.swing.JLabel();
        passTxt1 = new javax.swing.JPasswordField();
        jPanel8 = new javax.swing.JPanel();
        logoLabel13 = new javax.swing.JLabel();
        editPassTxt = new javax.swing.JPasswordField();
        logoLabel14 = new javax.swing.JLabel();
        editUserTxt = new javax.swing.JTextField();
        logoLabel15 = new javax.swing.JLabel();
        editNameTxt = new javax.swing.JTextField();
        editManagerBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        logoLabel8 = new javax.swing.JLabel();
        editPassTxt1 = new javax.swing.JPasswordField();
        logoLabel10 = new javax.swing.JLabel();
        deleteUserTxt = new javax.swing.JTextField();
        deleteManagerBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 102, 102));

        logoutBtn.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        logoutBtn.setText("Log Out");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("GQS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel5.setBorder(new javax.swing.border.MatteBorder(null));

        logoLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        logoLabel5.setText("Password:");

        logoLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        logoLabel4.setText("Username:");

        logoLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        logoLabel7.setText("Name:");

        createManagerBtn.setText("Create Manager");
        createManagerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createManagerBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("Create Manager Account");

        logoLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        logoLabel6.setText("Re-Enter:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(logoLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(logoLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userTxt)
                                    .addComponent(passTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addComponent(logoLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(logoLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(206, 206, 206)
                        .addComponent(createManagerBtn)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoLabel4)
                    .addComponent(logoLabel7)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoLabel5)
                    .addComponent(passTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(createManagerBtn)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logoLabel6)
                            .addComponent(passTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel8.setBorder(new javax.swing.border.MatteBorder(null));

        logoLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        logoLabel13.setText("Password:");

        logoLabel14.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        logoLabel14.setText("Username:");

        logoLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        logoLabel15.setText("Name:");

        editManagerBtn.setText("Save Changes");
        editManagerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editManagerBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setText("Edit Manager Account");

        logoLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        logoLabel8.setText("Re-Enter:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(logoLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(logoLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(editUserTxt)
                                    .addComponent(editPassTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addComponent(logoLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(logoLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editPassTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207)
                        .addComponent(editManagerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoLabel14)
                    .addComponent(logoLabel15)
                    .addComponent(editUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoLabel13)
                    .addComponent(editPassTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(editManagerBtn)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logoLabel8)
                            .addComponent(editPassTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        logoLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        logoLabel10.setText("Username:");

        deleteManagerBtn.setText("Delete Account");
        deleteManagerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteManagerBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setText("Delete Manager Account");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(logoLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteUserTxt))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteManagerBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoLabel10)
                    .addComponent(deleteUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteManagerBtn))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Admin Dashboard", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        try {

            // create HTTP Client
            HttpClient httpClient = HttpClientBuilder.create().build();

            // Create new getRequest with below mentioned URL
            HttpPost postRequest = new HttpPost("http://localhost:8080/ws/account/logout");
            StringEntity input = new StringEntity("{\"session\":\"" + Session.getSesh() + "\"}");
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
            String output;
            System.out.println("============Output:============");

            // Simply iterate through JSON response and show on console.
            while ((output = br.readLine()) != null) {
                System.out.println(output);

            }
            //Notification of Successful Log Out
            JOptionPane.showMessageDialog(rootPane, "Successfully Logged Out!");

            //Move back to the next Form
            LoginPanel l = new LoginPanel();
            l.setVisible(true);
            this.dispose(); //closes the login page.

        } catch (ClientProtocolException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error! User not found.");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error! User not found.");

        }


    }//GEN-LAST:event_logoutBtnActionPerformed

    private void createManagerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createManagerBtnActionPerformed
        // TODO add your handling code here:
        if (!userTxt.getText().isEmpty() && !passTxt.getText().isEmpty() && !nameTxt.getText().isEmpty()
                && passTxt.getText().equals(passTxt1.getText())) {
            try {

                // create HTTP Client
                HttpClient httpClient = HttpClientBuilder.create().build();

                // Create new postRequest with below mentioned URL
                HttpPost postRequest = new HttpPost("http://localhost:8080/ws/account/create/manager");
                StringEntity input = new StringEntity("{\"username\":\"" + userTxt.getText() + "\","
                        + "\"password\":\"" + passTxt.getText() + "\","
                        + "\"name\":\"" + nameTxt.getText() + "\","
                        + "\"session\":\"" + Session.getSesh() + "\"}");
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
                String output;
                System.out.println("============Output:============");

                // Simply iterate through JSON response and show on console.
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    
                   //Notification of Successful/Failed post
                   if(output.substring(10,11).equalsIgnoreCase("1"))
                   {
                       if(output.substring(24, 28).equalsIgnoreCase("1001"))
                       {
                       JOptionPane.showMessageDialog(rootPane, "Insufficient Privileges");
                       }
                    JOptionPane.showMessageDialog(rootPane, output.substring(43, 90));
                   }
                   else{
                   JOptionPane.showMessageDialog(rootPane, "Account Creation Success!");
                   }
               }
                

            } catch (ClientProtocolException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Error! Check your input.");

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Error! Check your input.");

            }
            //Clear Forms
            userTxt.setText("");
            passTxt.setText("");
            passTxt1.setText("");
            nameTxt.setText("");

        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Error! Check your input.");
        }
    }//GEN-LAST:event_createManagerBtnActionPerformed

    private void editManagerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editManagerBtnActionPerformed
        // TODO add your handling code here:
        if (!editUserTxt.getText().isEmpty() && !editPassTxt.getText().isEmpty() && !editNameTxt.getText().isEmpty()
                && editPassTxt.getText().equals(editPassTxt1.getText())) {
            try {

                // create HTTP Client
                HttpClient httpClient = HttpClientBuilder.create().build();

                // Create new postRequest with below mentioned URL
                HttpPost postRequest = new HttpPost("http://localhost:8080/ws/account/edit/manager");
                StringEntity input = new StringEntity("{\"username\":\"" + editUserTxt.getText() + "\","
                        + "\"password\":\"" + editPassTxt.getText() + "\","
                        + "\"name\":\"" + editNameTxt.getText() + "\","
                        + "\"session\":\"" + Session.getSesh() + "\"}");
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
                String output;
                System.out.println("============Output:============");

                // Simply iterate through JSON response and show on console.
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    
                    //Notification of Successful/Failed post
                   if(output.substring(10,11).equalsIgnoreCase("1"))
                   {
                       if(output.substring(24, 28).equalsIgnoreCase("1001"))
                       {
                       JOptionPane.showMessageDialog(rootPane, "Insufficient Privileges");
                       }
                    JOptionPane.showMessageDialog(rootPane, output.substring(43, 96));
                   }
                   else{
                   JOptionPane.showMessageDialog(rootPane, "Account Modification Success!");
                   }
                }
                
               

            } catch (ClientProtocolException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Error! Check your input.");

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Error! Check your input.");

            }
            
            //Clear Forms
            editUserTxt.setText("");
            editPassTxt.setText("");
            editPassTxt1.setText("");
            editNameTxt.setText("");
        }
        else{
        JOptionPane.showMessageDialog(rootPane, "Error! Check your input.");
        }
    }//GEN-LAST:event_editManagerBtnActionPerformed

    private void deleteManagerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteManagerBtnActionPerformed
        // TODO add your handling code here:
         if (!deleteUserTxt.getText().isEmpty()) {
            try {

                // create HTTP Client
                HttpClient httpClient = HttpClientBuilder.create().build();

                // Create new postRequest with below mentioned URL
                HttpPost postRequest = new HttpPost("http://localhost:8080/ws/account/delete/manager");
                StringEntity input = new StringEntity("{\"username\":\"" + deleteUserTxt.getText() + "\","
                        + "\"session\":\"" + Session.getSesh() + "\"}");
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
                String output;
                System.out.println("============Output:============");
                
                // Simply iterate through JSON response and show on console.
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    
                    //Notification of Successful/Failed post
                   if(output.substring(10,11).equalsIgnoreCase("1"))
                   {
                       if(output.substring(24, 28).equalsIgnoreCase("1001"))
                       {
                       JOptionPane.showMessageDialog(rootPane, "Insufficient Privileges");
                       }
                    JOptionPane.showMessageDialog(rootPane, output.substring(43, 96));
                   }
                   else{
                   JOptionPane.showMessageDialog(rootPane, "Account Deleted!");
                   }
                }
                
               

            } catch (ClientProtocolException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Error! Check your input.");

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Error! Check your input.");

            }
            //Clear Forms
            deleteUserTxt.setText("");
         }
    }//GEN-LAST:event_deleteManagerBtnActionPerformed
    
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
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createManagerBtn;
    private javax.swing.JButton deleteManagerBtn;
    private javax.swing.JTextField deleteUserTxt;
    private javax.swing.JButton editManagerBtn;
    private javax.swing.JTextField editNameTxt;
    private javax.swing.JPasswordField editPassTxt;
    private javax.swing.JPasswordField editPassTxt1;
    private javax.swing.JTextField editUserTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel logoLabel10;
    private javax.swing.JLabel logoLabel13;
    private javax.swing.JLabel logoLabel14;
    private javax.swing.JLabel logoLabel15;
    private javax.swing.JLabel logoLabel4;
    private javax.swing.JLabel logoLabel5;
    private javax.swing.JLabel logoLabel6;
    private javax.swing.JLabel logoLabel7;
    private javax.swing.JLabel logoLabel8;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JPasswordField passTxt1;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}

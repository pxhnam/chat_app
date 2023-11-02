package form;

import java.awt.Color;
import model.Account;
import service.Client;
import model.Response;
import model.User;
import model.CurrentUser;

public class frmLogin extends javax.swing.JFrame implements Runnable {
    
    private final Client client;
    private final Thread thread;
    
    public frmLogin() {
        initComponents();
        init();
        client = new Client();
        thread = new Thread(this);
        thread.start();
    }
    
    private void init() {
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(btnLogin);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        btnLogin.setFocusPainted(false);
        btnRegister.setFocusPainted(false);
    }
    
    public void setResponse(String message) {
        txtResponse.setText(message);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtResponse = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        txtUsername = new swing.TextField();
        txtPassword = new swing.PasswordField();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtResponse.setFont(new java.awt.Font("DVN-Poppins", 0, 12)); // NOI18N
        txtResponse.setForeground(new java.awt.Color(51, 51, 51));
        txtResponse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtResponse.setText(" ");

        Title.setBackground(new java.awt.Color(255, 255, 255));
        Title.setFont(new java.awt.Font("DVN-Poppins ExtBd", 0, 20)); // NOI18N
        Title.setForeground(new java.awt.Color(51, 51, 51));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("ĐĂNG NHẬP");

        txtUsername.setForeground(new java.awt.Color(51, 51, 51));
        txtUsername.setToolTipText("");
        txtUsername.setCaretColor(new java.awt.Color(51, 51, 51));
        txtUsername.setFont(new java.awt.Font("DVN-Poppins", 0, 12)); // NOI18N
        txtUsername.setLabelText("Gmail");

        txtPassword.setForeground(new java.awt.Color(51, 51, 51));
        txtPassword.setCaretColor(new java.awt.Color(51, 51, 51));
        txtPassword.setEchoChar('\u2022');
        txtPassword.setFont(new java.awt.Font("DVN-Poppins", 0, 12)); // NOI18N
        txtPassword.setLabelText("Mật khẩu");
        txtPassword.setShowAndHide(true);

        btnLogin.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N
        btnLogin.setText("Đăng Nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnRegister.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N
        btnRegister.setText("Đăng Ký");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegister)
                        .addGap(35, 35, 35))
                    .addComponent(txtResponse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Title)
                .addGap(20, 20, 20)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtResponse)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnRegister))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        Client.send(new Account(txtUsername.getText(), String.valueOf(txtPassword.getPassword())));
    }//GEN-LAST:event_btnLoginActionPerformed
    
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        thread.stop();
        new frmRegister().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnRegisterActionPerformed
    
    @Override
    public void run() {
        while (true) {
            if (!client.isAlive()) {
                if (client.getObj() instanceof Response) {
                    Response response = (Response) client.getObj();
                    setResponse(response.getMessage());
                    client.setObj(null);
                } else if (client.getObj() instanceof User) {
                    User u = (User) client.getObj();
                    CurrentUser.setId(u.getId());
                    CurrentUser.setFullname(u.getFullname());
                    client.setObj(null);
                    new frmMain().setVisible(true);
                    this.dispose();
                    break;
                } else {
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private swing.PasswordField txtPassword;
    private javax.swing.JLabel txtResponse;
    private swing.TextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

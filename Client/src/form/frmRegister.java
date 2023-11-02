package form;

import java.awt.Color;
import java.util.Calendar;
import javax.swing.JOptionPane;
import service.Client;
import model.Register;
import model.Response;
import validation.DateValidator;

public class frmRegister extends javax.swing.JFrame implements Runnable {

    private final Client client;
    private final Thread thread;

    public frmRegister() {
        initComponents();
        init();
        client = new Client();
        thread = new Thread(this);
        thread.start();
    }

    private void init() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.getRootPane().setDefaultButton(btnRegister);
        btnRegister.setFocusPainted(false);
        loadDOB();
        loadGender();
    }

    private void loadGender() {
        cbGender.addItem("Nữ");
        cbGender.addItem("Nam");

    }

    private void loadDOB() {
        for (int i = 1; i <= 31; i++) {
            cbDay.addItem(i + "");
        }
        for (int i = 1; i <= 12; i++) {
            cbMonth.addItem(i + "");
        }
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        for (int i = 1930; i <= year; i++) {
            cbYear.addItem(i + "");
            cbYear.setSelectedIndex(cbYear.getItemCount() - 1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        paneGender = new javax.swing.JPanel();
        cbGender = new swing.combo_suggestion.ComboBoxSuggestion();
        paneDOB = new javax.swing.JPanel();
        cbDay = new swing.combo_suggestion.ComboBoxSuggestion();
        cbMonth = new swing.combo_suggestion.ComboBoxSuggestion();
        cbYear = new swing.combo_suggestion.ComboBoxSuggestion();
        btnBack = new javax.swing.JLabel();
        txtFullName = new swing.TextField();
        txtPassword = new swing.PasswordField();
        txtUsername = new swing.TextField();
        btnRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DVN-Poppins ExtBd", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG KÝ");

        paneGender.setBackground(new java.awt.Color(255, 255, 255));
        paneGender.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gender", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DVN-Poppins", 0, 11))); // NOI18N
        paneGender.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N

        cbGender.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N

        javax.swing.GroupLayout paneGenderLayout = new javax.swing.GroupLayout(paneGender);
        paneGender.setLayout(paneGenderLayout);
        paneGenderLayout.setHorizontalGroup(
            paneGenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 86, Short.MAX_VALUE)
        );
        paneGenderLayout.setVerticalGroup(
            paneGenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        paneDOB.setBackground(new java.awt.Color(255, 255, 255));
        paneDOB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Day Of Birth", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DVN-Poppins", 0, 11))); // NOI18N
        paneDOB.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N

        cbDay.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N

        cbMonth.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N

        cbYear.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N

        javax.swing.GroupLayout paneDOBLayout = new javax.swing.GroupLayout(paneDOB);
        paneDOB.setLayout(paneDOBLayout);
        paneDOBLayout.setHorizontalGroup(
            paneDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDOBLayout.createSequentialGroup()
                .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        paneDOBLayout.setVerticalGroup(
            paneDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDOBLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(paneDOBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnBack.setFont(new java.awt.Font("DVN-Poppins ExtBd", 0, 12)); // NOI18N
        btnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBack.setText("Trở về");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        txtFullName.setFont(new java.awt.Font("DVN-Poppins", 0, 12)); // NOI18N
        txtFullName.setLabelText("Họ và tên");

        txtPassword.setEchoChar('\u2022');
        txtPassword.setFont(new java.awt.Font("DVN-Poppins", 0, 12)); // NOI18N
        txtPassword.setLabelText("Mật khẩu");
        txtPassword.setShowAndHide(true);

        txtUsername.setFont(new java.awt.Font("DVN-Poppins", 0, 12)); // NOI18N
        txtUsername.setLabelText("Gmail");

        btnRegister.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N
        btnRegister.setText("Đăng Ký");
        btnRegister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paneDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegister)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnRegister)
                .addGap(15, 15, 15)
                .addComponent(btnBack)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing

    public boolean isValid(String username, String password, String fullname, int gender, int day, int month, int year) {
        if (username.trim().equals("") || password.trim().equals("") || fullname.trim().equals("")) {
            return false;
        }
        return DateValidator.isValidDate(day, month, year);
    }

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        thread.stop();
        new frmLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        try {
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());
            String fullname = txtFullName.getText();
            int gender = cbGender.getSelectedIndex();
            int day = Integer.parseInt(cbDay.getSelectedItem().toString());
            int month = Integer.parseInt(cbMonth.getSelectedItem().toString());
            int year = Integer.parseInt(cbYear.getSelectedItem().toString());
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            if (isValid(username, password, fullname, gender, day, month, year)) {
                Client.send(new Register(username, password, fullname, gender, calendar.getTime()));
            } else {
                JOptionPane.showMessageDialog(this, "Kiểm tra lại thông tin!");
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    @Override
    public void run() {
        while (true) {
            if (!client.isAlive()) {
                if (client.getObj() instanceof Response) {
                    Response response = (Response) client.getObj();
                    if (response.isBool()) {
                        JOptionPane.showMessageDialog(this, response.getMessage());
                        client.setObj(null);
                        new frmLogin().setVisible(true);
                        this.dispose();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(this, response.getMessage());
                        client.setObj(null);
                    }
                } else if (client.getObj() instanceof Register) {
                    Register reg = (Register) client.getObj();
                    if (reg.getCode() == null || reg.isVeri() == false) {
                        try {
                            String code = JOptionPane.showInputDialog(this, "Mã xác minh: ", "Xác Minh Email", JOptionPane.PLAIN_MESSAGE);
                            if (!code.trim().equals("")) {
                                reg.setCode(code);
                                Client.send(reg);
                            }
                        } catch (NullPointerException e) {
                            System.out.println(e.toString());
                        }
                    }
                    client.setObj(null);
                } else {
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JButton btnRegister;
    private swing.combo_suggestion.ComboBoxSuggestion cbDay;
    private swing.combo_suggestion.ComboBoxSuggestion cbGender;
    private swing.combo_suggestion.ComboBoxSuggestion cbMonth;
    private swing.combo_suggestion.ComboBoxSuggestion cbYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel paneDOB;
    private javax.swing.JPanel paneGender;
    private swing.TextField txtFullName;
    private swing.PasswordField txtPassword;
    private swing.TextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

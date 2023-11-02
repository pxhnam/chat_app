package form;

import java.util.Calendar;
import model.CurrentUser;
import model.Information;
import model.Response;
import service.Client;

public class frmSetting extends javax.swing.JFrame implements Runnable {

    private final Client client;
    private final Thread thread;

    public frmSetting() {
        initComponents();
        init();
        client = new Client();
        thread = new Thread(this);
        thread.start();
        Client.send(new Information());
    }

    private void init() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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

    private void setDOB(String day, String month, String year) {

        cbDay.setSelectedItem(day);
        cbMonth.setSelectedItem(Integer.parseInt(month));
        cbYear.setSelectedItem(year);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        labelFullName = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        paneDOB = new javax.swing.JPanel();
        cbDay = new swing.combo_suggestion.ComboBoxSuggestion();
        cbMonth = new swing.combo_suggestion.ComboBoxSuggestion();
        cbYear = new swing.combo_suggestion.ComboBoxSuggestion();
        paneGender = new javax.swing.JPanel();
        cbGender = new swing.combo_suggestion.ComboBoxSuggestion();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelTitle.setFont(new java.awt.Font("DVN-Poppins ExtBd", 0, 20)); // NOI18N
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setText("Thông Tin Cá Nhân");

        labelFullName.setFont(new java.awt.Font("DVN-Poppins", 0, 12)); // NOI18N
        labelFullName.setText("Họ tên: ");

        txtFullName.setFont(new java.awt.Font("DVN-Poppins", 0, 12)); // NOI18N

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
                .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btnSave.setFont(new java.awt.Font("DVN-Poppins", 0, 12)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFullName)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtFullName)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(paneGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(paneDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle)
                .addGap(18, 18, 18)
                .addComponent(labelFullName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        thread.stop();
        new frmMain().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    @Override
    public void run() {
        while (true) {
            if (!client.isAlive()) {
                if (client.getObj() instanceof Information) {
                    Information info = (Information) client.getObj();
                    txtFullName.setText(info.getFullname());
                    cbGender.setSelectedIndex(info.getGender());
                    String[] dob = String.valueOf(info.getDob()).split("-");
                    setDOB(dob[2], dob[1], dob[0]);
                    client.setObj(null);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private swing.combo_suggestion.ComboBoxSuggestion cbDay;
    private swing.combo_suggestion.ComboBoxSuggestion cbGender;
    private swing.combo_suggestion.ComboBoxSuggestion cbMonth;
    private swing.combo_suggestion.ComboBoxSuggestion cbYear;
    private javax.swing.JLabel labelFullName;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPanel paneDOB;
    private javax.swing.JPanel paneGender;
    private javax.swing.JTextField txtFullName;
    // End of variables declaration//GEN-END:variables
}

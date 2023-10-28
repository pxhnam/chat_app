package component;

import form.frmMain;
import java.awt.Color;
import service.Client;
import model.Friend;

public class Item_User extends javax.swing.JPanel {

    private int id;
    private String fullname;
    private boolean status;

    private boolean mouseOver;

    public Item_User(int id, String name, boolean status) {
        initComponents();
        this.id = id;
        this.fullname = name;
        this.status = status;
        lbName.setText(name);
        updateStatus(status);
    }

    public void updateStatus(boolean stt) {
        activeStatus.setActive(stt);
        setStatus(stt);
        lbStatus.setText(stt == true ? "Online" : "Offline");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbName = new javax.swing.JLabel();
        imageAvatar2 = new swing.ImageAvatar();
        lbStatus = new javax.swing.JLabel();
        activeStatus = new swing.ActiveStatus();

        setBackground(new java.awt.Color(242, 242, 242));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        lbName.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lbName.setText("Name");

        imageAvatar2.setBorderSize(0);
        imageAvatar2.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N

        lbStatus.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(117, 117, 117));
        lbStatus.setText("Offline");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbName)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setBackground(new Color(230, 230, 230));
        mouseOver = true;
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setBackground(new Color(242, 242, 242));
        mouseOver = false;

    }//GEN-LAST:event_formMouseExited

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (mouseOver) {
            Client.send(new Friend(id));
            frmMain.setTo(id);
        }
    }//GEN-LAST:event_formMouseReleased

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String name) {
        this.fullname = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ActiveStatus activeStatus;
    private swing.ImageAvatar imageAvatar2;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}

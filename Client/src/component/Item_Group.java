package component;

import java.awt.Color;
import model.CurrentUser;
import model.Group_Chat;
import model.Notice;
import service.Client;

public class Item_Group extends javax.swing.JPanel {

    private int ID;
    private String code;
    private String name;

    private boolean mouseOver;

    public Item_Group(int ID, String code, String name) {
        initComponents();
        this.ID = ID;
        this.code = code;
        this.name = name;
        init();
    }

    private void init() {
        lbName.setText(name);
        lbCode.setText(code);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbName = new javax.swing.JLabel();
        imageAvatar2 = new swing.ImageAvatar();
        lbCode = new javax.swing.JLabel();

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
        imageAvatar2.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/group.png"))); // NOI18N

        lbCode.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        lbCode.setForeground(new java.awt.Color(117, 117, 117));
        lbCode.setText("Offline");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(109, 109, 109))
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbName)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbCode))
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
            Client.send(new Group_Chat(ID, name, code, CurrentUser.getId()));
            Notice.set(ID, "group");
        }
    }//GEN-LAST:event_formMouseReleased

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvatar imageAvatar2;
    private javax.swing.JLabel lbCode;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}

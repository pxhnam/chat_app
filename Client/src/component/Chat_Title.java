package component;

import java.awt.Color;
import javax.swing.JOptionPane;
import model.CurrentUser;
import service.Client;

public class Chat_Title extends javax.swing.JPanel {

    private int id;

    public Chat_Title() {
        initComponents();
    }

    public void set(int id, String name, boolean status) {
        setId(id);
        setFullName(name);
        setStatus(status);
    }

    public void set(int id, String name, String code) {
        setId(id);
        setFullName(name);
        lbStatus.setText(code);
        lbStatus.setForeground(new Color(110, 110, 110));
    }

    public void setFullName(String name) {
        lbName.setText(name);
    }

    public void setBlock(boolean is) {
        btnBlock.setVisible(is);
    }

    public void setLabelStt(String stt) {
        lbStatus.setText(stt);
    }

    public void setStatus(boolean status) {
        if (status) {
            lbStatus.setText("Đang hoạt động");
            lbStatus.setForeground(new Color(40, 174, 59));
        } else {
            lbStatus.setText("Không hoạt động");
            lbStatus.setForeground(new Color(110, 110, 110));
        }
    }

    public void setCode(String code) {
        lbStatus.setText(code);
        lbStatus.setForeground(new Color(110, 110, 110));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        layer = new javax.swing.JLayeredPane();
        lbName = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        layerPane = new javax.swing.JLayeredPane();
        btnBlock = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));

        layer.setLayout(new java.awt.GridLayout(0, 1));

        lbName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(66, 66, 66));
        lbName.setText("Name");
        layer.add(lbName);

        lbStatus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(40, 174, 59));
        lbStatus.setText("Active now");
        layer.add(lbStatus);

        layerPane.setLayout(new java.awt.GridBagLayout());

        btnBlock.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnBlock.setForeground(new java.awt.Color(255, 0, 51));
        btnBlock.setText("Chặn");
        btnBlock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBlockMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 10);
        layerPane.add(btnBlock, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(layerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layer)
            .addComponent(layerPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBlockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBlockMouseClicked
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn chặn " + lbName.getText() + " không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            Client.send(new model.Block(CurrentUser.getId(), id));
        }
    }//GEN-LAST:event_btnBlockMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBlock;
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLayeredPane layerPane;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}

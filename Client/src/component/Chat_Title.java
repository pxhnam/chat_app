package component;

import java.awt.Color;

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
    
    public void setFullName(String name) {
        lbName.setText(name);
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
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer = new javax.swing.JLayeredPane();
        lbName = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(333, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layer)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}

package form;

import connection.DataAccess;
import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import model.BroadCast;
import service.Server;
import swing.ScrollBar;
import item.Item;
import java.sql.Timestamp;

public class frmServer extends javax.swing.JFrame {

    private DefaultListModel model;
    private final DataAccess access;
    private final Server server;

    public frmServer(Server server) {
        initComponents();
        this.server = server;
        access = new DataAccess();
        init();
    }

    private void init() {
        this.setLocationRelativeTo(null);
        logger.setEditable(false);
        this.getRootPane().setDefaultButton(btnSend);
        spLeft.setVerticalScrollBar(new ScrollBar());
        spRight.setVerticalScrollBar(new ScrollBar());
        logger.setLineWrap(true);
        model = new DefaultListModel();
        listUser.setModel(model);
        loadUser();
    }

    public void loadUser() {
        ResultSet result = access.Query("SELECT * FROM Account");
        try {
            while (result.next()) {
                model.addElement(new Item(result.getInt("id"), result.getString("fullname"), result.getBoolean("Status") == true ? "Online" : "Offline"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void addElement(int id, String name, boolean status) {
        model.addElement(new Item(id, name, status == true ? "Online" : "Offline"));
    }

    public void clearModel() {
        model.clear();
    }

    public void loadStatus(int id, boolean status) {
        for (Object o : model.toArray()) {
            Item item = (Item) o;
            if (item.getId() == id) {
                item.setStatus(status == true ? "Online" : "Offline");
                listUser.repaint();
                listUser.revalidate();
                break;
            }
        }
    }

    public void logger(String log) {
        // Định dạng ngày giờ theo định dạng DD/MM/YYYY HH:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Định dạng ngày giờ hiện tại của Việt Nam
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));

        logger.append("[" + now.format(formatter) + "] " + log + "\n");
        scrollToBottom();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneUser = new javax.swing.JPanel();
        spRight = new javax.swing.JScrollPane();
        listUser = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtBroadcast = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        paneLog = new javax.swing.JPanel();
        spLeft = new javax.swing.JScrollPane();
        logger = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        paneUser.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách người dùng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 0, 11))); // NOI18N

        spRight.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listUser.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        listUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listUserMouseClicked(evt);
            }
        });
        spRight.setViewportView(listUser);

        javax.swing.GroupLayout paneUserLayout = new javax.swing.GroupLayout(paneUser);
        paneUser.setLayout(paneUserLayout);
        paneUserLayout.setHorizontalGroup(
            paneUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spRight, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        );
        paneUserLayout.setVerticalGroup(
            paneUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneUserLayout.createSequentialGroup()
                .addComponent(spRight, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jLabel1.setText("Broadcast: ");

        txtBroadcast.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N

        btnSend.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        btnSend.setText("Gửi");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        paneLog.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Log", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 0, 11))); // NOI18N

        logger.setColumns(20);
        logger.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        logger.setRows(5);
        spLeft.setViewportView(logger);

        javax.swing.GroupLayout paneLogLayout = new javax.swing.GroupLayout(paneLog);
        paneLog.setLayout(paneLogLayout);
        paneLogLayout.setHorizontalGroup(
            paneLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spLeft)
        );
        paneLogLayout.setVerticalGroup(
            paneLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLogLayout.createSequentialGroup()
                .addComponent(spLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBroadcast, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSend)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBroadcast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneLog, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        access.Update("UPDATE Account SET Status = 0");
    }//GEN-LAST:event_formWindowClosing

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        String message = txtBroadcast.getText().trim();
        if (!message.equals("")) {
            int result = access.Update("INSERT INTO broadcast (`message`) VALUES ('" + message + "')");
            if (result > 0) {
                server.broadcast(new BroadCast(message, new Timestamp(System.currentTimeMillis())));
                txtBroadcast.setText("");
            }
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void listUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listUserMouseClicked
        if (evt.getClickCount() == 2) {
            Object o = listUser.getSelectedValue();
            Item item = (Item) o;
            int id = item.getId();
            String name = item.getFullname();
            ResultSet result = access.Query("SELECT * FROM Account WHERE ID = " + id);
            try {
                if (result.next()) {
                    if (result.getBoolean("Active")) {
                        int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn khóa tài khoản của " + name + " không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if (res == JOptionPane.YES_OPTION) {
                            int inactive = access.Update("UPDATE Account SET Active = 0 WHERE ID = " + id);
                            if (inactive > 0) {
                                server.blockUser(id);
                                JOptionPane.showMessageDialog(this, "Khóa thành công tài khoản " + name);
                            }
                        }
                    } else {
                        int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn mở lại tài khoản của " + name + " không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if (res == JOptionPane.YES_OPTION) {
                            int active = access.Update("UPDATE Account SET Active = 1 WHERE ID = " + id);
                            if (active > 0) {
                                JOptionPane.showMessageDialog(this, "Mở thành công tài khoản " + name);
                            }
                        }
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_listUserMouseClicked

    private void scrollToBottom() {
        JScrollBar verticalBar = spLeft.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> listUser;
    private javax.swing.JTextArea logger;
    private javax.swing.JPanel paneLog;
    private javax.swing.JPanel paneUser;
    private javax.swing.JScrollPane spLeft;
    private javax.swing.JScrollPane spRight;
    private javax.swing.JTextField txtBroadcast;
    // End of variables declaration//GEN-END:variables
}

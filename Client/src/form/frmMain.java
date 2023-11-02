package form;

import component.Item_Group;
import service.Client;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import component.Item_User;
import model.*;
import list.*;
import swing.ScrollBar;
import utils.TimestampUtils;

public class frmMain extends javax.swing.JFrame implements Runnable {

    private final Client client;
    private static int menu = 0;
    private final Thread thread;

    public frmMain() {
        initComponents();
        init();
        client = new Client();
        thread = new Thread(this);
        thread.start();
        Client.send(new People());
    }

    private void init() {
        this.setLocationRelativeTo(null);
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        initTitle();
        btnFr.setEnabled(false);
    }

    private void initTitle() {
        chatTitle.setFullName("");
        chatTitle.setLabelStt("");
        chatTitle.setBlock(false);
    }

    private void clear() {
        menuList.removeAll();
        menuList.add(new Item_User(0, "Tin nhắn hệ thống", true), "wrap");
        menuList.repaint();
        menuList.revalidate();
    }

    private void closeForm() {
        thread.stop();
        Client.send(new Logout(CurrentUser.getId(), CurrentUser.getFullname()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneLeft = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        btnFr = new javax.swing.JButton();
        btnGr = new javax.swing.JButton();
        chatTitle = new component.Chat_Title();
        boxChat = new component.Chat_Body();
        chatBottom = new component.Chat_Bottom();
        paneTopLeft = new javax.swing.JPanel();
        btnAddFr = new javax.swing.JButton();
        btnJoinGr = new javax.swing.JButton();
        btnCreateGr = new javax.swing.JButton();
        pane2 = new javax.swing.JPanel();
        btnSetting = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChatLor");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        paneLeft.setBackground(new java.awt.Color(242, 242, 242));
        paneLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách người dùng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DVN-Poppins", 0, 12))); // NOI18N
        paneLeft.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        sp.setBackground(new java.awt.Color(242, 242, 242));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnFr.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N
        btnFr.setText("Bạn bè");
        btnFr.setFocusable(false);
        btnFr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFrActionPerformed(evt);
            }
        });
        jPanel1.add(btnFr);

        btnGr.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N
        btnGr.setText("Nhóm");
        btnGr.setFocusable(false);
        btnGr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrActionPerformed(evt);
            }
        });
        jPanel1.add(btnGr);

        javax.swing.GroupLayout paneLeftLayout = new javax.swing.GroupLayout(paneLeft);
        paneLeft.setLayout(paneLeftLayout);
        paneLeftLayout.setHorizontalGroup(
            paneLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        paneLeftLayout.setVerticalGroup(
            paneLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneLeftLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        chatBottom.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N

        paneTopLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        paneTopLeft.setLayout(new java.awt.GridLayout(3, 0));

        btnAddFr.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N
        btnAddFr.setText("Thêm bạn bè");
        btnAddFr.setFocusable(false);
        btnAddFr.setMaximumSize(new java.awt.Dimension(90, 23));
        btnAddFr.setMinimumSize(new java.awt.Dimension(90, 23));
        btnAddFr.setPreferredSize(new java.awt.Dimension(90, 23));
        btnAddFr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFrActionPerformed(evt);
            }
        });
        paneTopLeft.add(btnAddFr);

        btnJoinGr.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N
        btnJoinGr.setText("Tham gia nhóm");
        btnJoinGr.setFocusable(false);
        btnJoinGr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinGrActionPerformed(evt);
            }
        });
        paneTopLeft.add(btnJoinGr);

        btnCreateGr.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N
        btnCreateGr.setText("Tạo nhóm");
        btnCreateGr.setFocusable(false);
        btnCreateGr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateGrActionPerformed(evt);
            }
        });
        paneTopLeft.add(btnCreateGr);

        pane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pane2.setLayout(new java.awt.GridLayout());

        btnSetting.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N
        btnSetting.setText("Cài Đặt");
        btnSetting.setFocusable(false);
        btnSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingActionPerformed(evt);
            }
        });
        pane2.add(btnSetting);

        btnLogout.setFont(new java.awt.Font("DVN-Poppins", 0, 11)); // NOI18N
        btnLogout.setText("Đăng Xuất");
        btnLogout.setFocusable(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        pane2.add(btnLogout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneTopLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paneLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addComponent(chatBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(boxChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chatTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(boxChat, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(chatBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneTopLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(paneLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeForm();
    }//GEN-LAST:event_formWindowClosing

    private void btnGrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrActionPerformed
        menu = 1;
        setMenu(menu);
        Client.send(new Group(CurrentUser.getId()));
    }//GEN-LAST:event_btnGrActionPerformed

    private void btnFrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFrActionPerformed
        menu = 0;
        setMenu(menu);
        Client.send(new People());
    }//GEN-LAST:event_btnFrActionPerformed

    private void btnCreateGrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateGrActionPerformed
        try {
            String nameGr = JOptionPane.showInputDialog(this, "Tên nhóm", "Tạo nhóm", JOptionPane.PLAIN_MESSAGE);
            if (!nameGr.trim().equals("")) {
                Client.send(new Create_Group(nameGr.trim(), CurrentUser.getId(), CurrentUser.getFullname()));
            }
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnCreateGrActionPerformed

    private void btnJoinGrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinGrActionPerformed
        try {
            String codeGr = JOptionPane.showInputDialog(this, "Mã nhóm", "Tham gia nhóm", JOptionPane.PLAIN_MESSAGE);
            if (!codeGr.trim().equals("")) {
                Client.send(new Join_Group(codeGr.trim(), CurrentUser.getId()));
            }
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnJoinGrActionPerformed

    private void btnAddFrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFrActionPerformed
        try {
            String email = JOptionPane.showInputDialog(this, "Email", "Thêm bạn bè", JOptionPane.PLAIN_MESSAGE);
            if (!email.trim().equals("")) {
                Client.send(new Add_Friend(CurrentUser.getId(), email.trim()));
            }
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnAddFrActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        closeForm();
        new frmLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingActionPerformed
        thread.stop();
        new frmSetting().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSettingActionPerformed

    private void clickGroup() {
        chatBottom.setVisible(true);
        chatTitle.setBlock(false);
    }

    private void setMenu(int index) {
        if (index == 0) {
            btnFr.setEnabled(false);
            btnGr.setEnabled(true);
        } else {
            btnFr.setEnabled(true);
            btnGr.setEnabled(false);
        }
    }

    public void loadStatus(int id, boolean bool) {
        for (Component com : menuList.getComponents()) {
            Item_User item = (Item_User) com;
            if (item.getId() == id) {
                item.updateStatus(bool);
                if (item.getId() == chatTitle.getId()) {
                    chatTitle.setStatus(bool);
                }
                break;
            }
        }
    }

    public void removeFriend(int id) {
        for (Component com : menuList.getComponents()) {
            Item_User item = (Item_User) com;
            if (item.getId() == id) {
                menuList.remove(item);
                initTitle();
                menuList.repaint();
                menuList.revalidate();
                break;
            }
        }
    }

    public void loadFriend() {
        for (Component com : menuList.getComponents()) {
            Item_User item = (Item_User) com;
            if (item.getId() == Notice.getID() && Notice.getType().equals("user")) {
                chatTitle.set(item.getId(), item.getFullName(), item.isStatus());
                if (item.getId() == 0) {
                    chatBottom.setVisible(false);
                    chatTitle.setBlock(false);
                } else {
                    chatBottom.setVisible(true);
                    chatTitle.setBlock(true);
                }
                break;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            if (!client.isAlive()) {
                if (client.getObj() instanceof ListPeople) {
                    clear();
                    ListPeople listPeople = (ListPeople) client.getObj();
                    listPeople.printList().forEach((people) -> {
                        menuList.add(new Item_User(people.getId(), people.getFullname(), people.isStatus()), "wrap");
                    });
                    client.setObj(null);
                } else if (client.getObj() instanceof ListGroup) {
                    clear();
                    ListGroup groups = (ListGroup) client.getObj();
                    groups.print().forEach((gr) -> {
                        menuList.add(new Item_Group(gr.getID(), gr.getCode(), gr.getName()), "wrap");
                    });
                    client.setObj(null);
                } else if (client.getObj() instanceof ListMessage) {
                    ListMessage listMessage = (ListMessage) client.getObj();
                    loadFriend();
                    boxChat.clearChat();
                    listMessage.printList().forEach((message) -> {
                        if (message.getFrom() == CurrentUser.getId()) {
                            boxChat.addRight(message.getMsg(), TimestampUtils.getTime(message.getSentAt()));
                        } else {
                            boxChat.addLeft(message.getMsg(), TimestampUtils.getTime(message.getSentAt()), message.getNameSender());
                        }
                    });
                    client.setObj(null);
                } else if (client.getObj() instanceof ListChat) {
                    ListChat chats = (ListChat) client.getObj();
                    clickGroup();
                    boxChat.clearChat();
                    chatTitle.set(chats.getID(), chats.getTitle(), chats.getCode());
                    chats.print().forEach((chat) -> {
                        if (chat.getSender() == CurrentUser.getId()) {
                            boxChat.addRight(chat.getMessage(), TimestampUtils.getTime(chat.getSentAt()));
                        } else {
                            boxChat.addLeft(chat.getMessage(), TimestampUtils.getTime(chat.getSentAt()), chat.getName());
                        }
                    });
                    client.setObj(null);
                } else if (client.getObj() instanceof Text) {
                    Text text = (Text) client.getObj();
                    if (text.getFrom() == Notice.getID() && Notice.getType().equals("user")) {
                        boxChat.addLeft(text.getMsg(), TimestampUtils.getTime(text.getSentAt()), text.getNameSender());
                    } else if (text.getFrom() == CurrentUser.getId()) {
                        boxChat.addRight(text.getMsg(), TimestampUtils.getTime(text.getSentAt()));
                    }
                    client.setObj(null);
                } else if (client.getObj() instanceof Chat) {
                    Chat chat = (Chat) client.getObj();
                    if (Notice.getID() == chat.getGroup() && Notice.getType().equals("group")) {
                        if (chat.getSender() == CurrentUser.getId()) {
                            boxChat.addRight(chat.getMessage(), TimestampUtils.getTime(chat.getSentAt()));
                        } else {
                            boxChat.addLeft(chat.getMessage(), TimestampUtils.getTime(chat.getSentAt()), chat.getName());
                        }
                    }
                    client.setObj(null);
                } else if (client.getObj() instanceof BroadCast) {
                    BroadCast bc = (BroadCast) client.getObj();
                    if (Notice.getID() == 0) {
                        boxChat.addLeft(bc.getMessage(), TimestampUtils.getTime(bc.getSentAt()), "Tin nhắn hệ thống");
                    }
                    client.setObj(null);
                } else if (client.getObj() instanceof Add_Friend) {
                    Add_Friend add = (Add_Friend) client.getObj();
                    if (add.isIsFriend()) {
                        if (menu == 0) {
                            menuList.add(new Item_User(add.getIdFr(), add.getName(), add.isStatus()), "wrap");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, add.getResponse());
                    }
                    client.setObj(null);
                } else if (client.getObj() instanceof Create_Group) {
                    Create_Group cgr = (Create_Group) client.getObj();
                    if (cgr.isIsSuccess()) {
                        if (menu == 1) {
                            menuList.add(new Item_Group(cgr.getID(), cgr.getCode(), cgr.getName()), "wrap");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, cgr.getResponse());
                    }
                    client.setObj(null);
                } else if (client.getObj() instanceof Join_Group) {
                    Join_Group jgr = (Join_Group) client.getObj();
                    if (jgr.isIsJoin()) {
                        if (menu == 1) {
                            menuList.add(new Item_Group(jgr.getID(), jgr.getCode(), jgr.getName()), "wrap");
                        }
                    } else {
                        //"Mã nhóm \"" + jgr.getCode() + "\" có vấn đề!"
                        JOptionPane.showMessageDialog(this, jgr.getResponse());
                    }
                    client.setObj(null);
                } else if (client.getObj() instanceof Block) {
                    Block block = (Block) client.getObj();
                    if (menu == 0) {
                        removeFriend(block.getBlocked());
                    }
                    Notice.setID(-1);
                    client.setObj(null);
                } /*else if (client.getObj() instanceof Register) {
                    Register reg = (Register) client.getObj();
                    if (menu == 0) {
                        menuList.add(new Item_User(reg.getId(), reg.getFullname(), true), "wrap");
                    }
                    client.setObj(null);
                }*/ else if (client.getObj() instanceof Login) {
                    Login log = (Login) client.getObj();
                    if (menu == 0) {
                        loadStatus(log.getId(), true);
                    }
                    client.setObj(null);
                } else if (client.getObj() instanceof Logout) {
                    Logout out = (Logout) client.getObj();
                    if (menu == 0) {
                        loadStatus(out.getId(), false);
                    }
                    client.setObj(null);
                } else if (client.getObj() instanceof Lock) {
                    Lock block = (Lock) client.getObj();
                    if (block.getId() == CurrentUser.getId()) {
                        JOptionPane.showMessageDialog(this, "Tài khoản của bạn đã bị khóa!");
                        Client.send(new Logout(CurrentUser.getId(), CurrentUser.getFullname()));
                        client.setObj(null);
                        new frmLogin().setVisible(true);
                        this.dispose();
                        break;
                    }
                } else {
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Chat_Body boxChat;
    private javax.swing.JButton btnAddFr;
    private javax.swing.JButton btnCreateGr;
    private javax.swing.JButton btnFr;
    private javax.swing.JButton btnGr;
    private javax.swing.JButton btnJoinGr;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSetting;
    private component.Chat_Bottom chatBottom;
    private component.Chat_Title chatTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JPanel pane2;
    private javax.swing.JPanel paneLeft;
    private javax.swing.JPanel paneTopLeft;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables

}

package form;

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
    private static int to = 0;
    private String nameFriend = "";

    public frmMain() {
        initComponents();
        init();
        client = new Client();
        new Thread(this).start();
        Client.send(new People());
    }

    private void init() {
        this.setLocationRelativeTo(null);
//        this.getRootPane().setDefaultButton(btnSend);
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        chatTitle.setFullName("");
        chatTitle.setLabelStt("");
        chatBottom.setVisible(false);
    }

    private void clear() {
        menuList.removeAll();
        menuList.add(new Item_User(0, "Tin nhắn hệ thống", true), "wrap");
        menuList.repaint();
        menuList.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneLeft = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();
        paneRight = new javax.swing.JPanel();
        chatTitle = new component.Chat_Title();
        boxChat = new component.Chat_Body();
        chatBottom = new component.Chat_Bottom();

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
        paneLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách người dùng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 0, 11))); // NOI18N

        sp.setBackground(new java.awt.Color(242, 242, 242));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(255, 204, 255));

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

        javax.swing.GroupLayout paneLeftLayout = new javax.swing.GroupLayout(paneLeft);
        paneLeft.setLayout(paneLeftLayout);
        paneLeftLayout.setHorizontalGroup(
            paneLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );
        paneLeftLayout.setVerticalGroup(
            paneLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        paneRight.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout paneRightLayout = new javax.swing.GroupLayout(paneRight);
        paneRight.setLayout(paneRightLayout);
        paneRightLayout.setHorizontalGroup(
            paneRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boxChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chatTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chatBottom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );
        paneRightLayout.setVerticalGroup(
            paneRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRightLayout.createSequentialGroup()
                .addComponent(chatTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(boxChat, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(chatBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(paneRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(paneRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Client.send(new Logout(CurrentUser.getId(), CurrentUser.getFullname()));
    }//GEN-LAST:event_formWindowClosing

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

    public void loadFriend() {
        for (Component com : menuList.getComponents()) {
            Item_User item = (Item_User) com;
            if (item.getId() == to) {
                chatTitle.set(item.getId(), item.getFullName(), item.isStatus());
                if (item.getId() == 0) {
                    nameFriend = "Tin nhắn hệ thống";
                    chatBottom.setVisible(false);
                } else {
                    nameFriend = item.getFullName();
                    chatBottom.setVisible(true);
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
                } else if (client.getObj() instanceof ListMessage) {
                    ListMessage listMessage = (ListMessage) client.getObj();
                    loadFriend();
                    boxChat.clearChat();
                    listMessage.printList().forEach((message) -> {
                        if (message.getFrom() == CurrentUser.getId()) {
                            boxChat.addRight(message.getMsg(), TimestampUtils.getTime(message.getCreatedAt()));
                        } else {
                            boxChat.addLeft(message.getMsg(), TimestampUtils.getTime(message.getCreatedAt()), nameFriend);
//                            boxChat.addDate(message.getCreatedAt() + "");
                        }
                    });
                    client.setObj(null);
                } else if (client.getObj() instanceof Text) {
                    Text text = (Text) client.getObj();
                    if (text.getFrom() == to) {
                        boxChat.addLeft(text.getMsg(), TimestampUtils.getTime(text.getCreatedAt()), nameFriend);
                    } else if (text.getFrom() == CurrentUser.getId()) {
                        boxChat.addRight(text.getMsg(), TimestampUtils.getTime(text.getCreatedAt()));
                    }
                    client.setObj(null);
                } else if (client.getObj() instanceof BroadCast) {
                    BroadCast bc = (BroadCast) client.getObj();
                    if (to == 0) {
                        boxChat.addLeft(bc.getMessage(), TimestampUtils.getTime(bc.getCreatedAt()), "Tin nhắn hệ thống");
                    }
                    client.setObj(null);
                } else if (client.getObj() instanceof Register) {
                    Register reg = (Register) client.getObj();
                    menuList.add(new Item_User(reg.getId(), reg.getFullname(), true), "wrap");
                    client.setObj(null);
                } else if (client.getObj() instanceof Login) {
                    Login log = (Login) client.getObj();
                    loadStatus(log.getId(), true);
                    client.setObj(null);
                } else if (client.getObj() instanceof Logout) {
                    Logout out = (Logout) client.getObj();
                    loadStatus(out.getId(), false);
                    client.setObj(null);
                } else if (client.getObj() instanceof Block) {
                    Block block = (Block) client.getObj();
                    if (block.getId() == CurrentUser.getId()) {
                        JOptionPane.showMessageDialog(this, "Tài khoản của bạn đã bị khóa!");
                        Client.send(new Logout(CurrentUser.getId(), CurrentUser.getFullname()));
                        client.setObj(null);
                        System.out.println("block");
                        new frmLogin().setVisible(true);
                        this.dispose();
                    }
                } else {
                }
            }
        }
    }

    public static int getTo() {
        return to;
    }

    public static void setTo(int to) {
        frmMain.to = to;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Chat_Body boxChat;
    private component.Chat_Bottom chatBottom;
    private component.Chat_Title chatTitle;
    private javax.swing.JLayeredPane menuList;
    private javax.swing.JPanel paneLeft;
    private javax.swing.JPanel paneRight;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}

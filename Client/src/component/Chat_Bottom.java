package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import model.Chat;
import service.Client;
import model.CurrentUser;
import model.Notice;
import model.Text;
import net.miginfocom.swing.MigLayout;
import swing.JIMSendTextPane;
import swing.ScrollBar;

public class Chat_Bottom extends javax.swing.JPanel {

    private MigLayout mig;

    public Chat_Bottom() {
        initComponents();
        init();
    }

    private void init() {
        mig = new MigLayout("fillx, filly", "0[fill]0[]0[]2", "2[fill]2[]0");
        setLayout(mig);
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        JIMSendTextPane txt = new JIMSendTextPane();
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                refresh();
                if (ke.getKeyChar() == 10 && ke.isControlDown()) {
                    //Ctrl + Enter
                    eventSend(txt);
                }
            }
        });
        txt.setBorder(new EmptyBorder(5, 5, 5, 5));
        txt.setHintText("Write Message Here ...");
        txt.setFont(new java.awt.Font("DVN-Poppins", 0, 11));
        scroll.setViewportView(txt);
        ScrollBar sb = new ScrollBar();
        sb.setBackground(new Color(229, 229, 229));
        sb.setPreferredSize(new Dimension(2, 10));
        scroll.setVerticalScrollBar(sb);
        add(sb);
        add(scroll, "w 100%");
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]3[]0", "0[bottom]0"));
        panel.setPreferredSize(new Dimension(30, 28));
        panel.setBackground(Color.WHITE);
        JButton btn = new JButton();
        btn.setBorder(null);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setIcon(new ImageIcon(getClass().getResource("/image/send.png")));
        btn.addActionListener((ActionEvent ae) -> {
            eventSend(txt);
        });
        panel.add(btn);
        add(panel, "wrap");
    }

    private void eventSend(JIMSendTextPane txt) {
        String text = txt.getText().trim();
        if (!text.equals("")) {
            if (Notice.getID() > 0) {
                if (Notice.getType().equals("user")) {
                    Client.send(new Text(Notice.getID(), CurrentUser.getId(), CurrentUser.getFullname(), text));
                } else {
                    Client.send(new Chat(Notice.getID(), CurrentUser.getId(), CurrentUser.getFullname(), text));
                }
            }
            txt.setText("");
            txt.grabFocus();
            refresh();
        } else {
            txt.grabFocus();
        }
    }

    private void refresh() {
        revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

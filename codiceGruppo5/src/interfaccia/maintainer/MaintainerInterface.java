//Gruppo 5
package interfaccia.maintainer;

import enumeratives.GeneralState;
import enumeratives.StatoMaintainer;
import interfaccia.Login;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import progettosegruppo5.Maintainer;
import progettosegruppo5.Query;
import java.sql.ResultSet;
import java.sql.Date;

public class MaintainerInterface extends javax.swing.JFrame {

    private Maintainer m = new Maintainer("", "", "");
    Query query = new Query();
    Thread t;

    /*
    Hidden feature: interface for story ID 19
    Alessia Carbone 0622701487
    16/12/2020 
     */
    public MaintainerInterface() {
        initComponents();
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    LocalDate dataAttuale = LocalDate.now();
                    LinkedList<String> lista = m.getMyActivities();
                    for (String activity : lista) {
                        String query = "select data,tempo from maintainanceactivity where activityID = '" + activity + "'";
                        ResultSet rst = Query.genericQuery(query);
                        Boolean test = rst.next();
                        while (test) {
                            Date data = rst.getDate("data");
                            if (data.toLocalDate().isEqual(dataAttuale)) {
                                String q = "delete from assegnazioneattivita where nomemaintainer = '" + m.getNome() + "' and activityID = '" + activity + "'";
                                Query.genericUpdate(q);
                                String q1 = "select min from availability where nomemaintainer = '" + m.getNome() + "' and giorno = '" + rst.getDate("data") + "'";
                                int min = 0;
                                ResultSet r = Query.genericQuery(q1);
                                Boolean t = r.next();
                                while (t) {
                                    min = r.getInt("min");
                                    t = r.next();
                                }
                                int minuti = min + rst.getInt("tempo");
                                String q2 = "update availability set min = " + minuti + " where nomemaintainer = '" + m.getNome() + "' and giorno = '" + rst.getDate("data") + "'";
                                Query.genericUpdate(q2);
                                String q3 = "update maintainanceactivity set generalstate = '" + GeneralState.CLOSED.toString() + "' where activityID = '" + activity + "'";
                                Query.genericUpdate(q3);
                                attivitàTerminata(activity);
                            }
                            test = rst.next();
                        }
                    }
                } catch (SQLException ex) {
                }
            }
        });
        t.start();
    }

    public void setMaintainer(Maintainer m) {
        this.m = m;
        this.aggiornaTabella();
        this.aggiornaArea();
    }

    public void attivitàTerminata(String activityID) {
        Icon i = new ImageIcon(getClass().getResource("/images/ok.png"));
        JOptionPane.showMessageDialog(this, "L'attività " + activityID + " è terminata!", "Terminazione attività", JOptionPane.PLAIN_MESSAGE, i);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maintainer's messages");
        setIconImage(new ImageIcon(getClass().getResource("/images/message.png")).getImage());

        lista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        /*
        lista.setModel(null);
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        */
        jScrollPane1.setViewportView(lista);

        jButton1.setText("Esci");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setText("Notifiche");

        jLabel2.setText("Prese in carico");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(jTextArea1);
        jTextArea1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked
        String notifica = lista.getSelectedValue();
        Icon i = new ImageIcon(getClass().getResource("/images/question.png"));
        int r = JOptionPane.showConfirmDialog(this, "Accetti l'attività?", "Presa in carico", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        char message[] = notifica.toCharArray();
        char id[] = new char[10];
        int j;
        for (j = 0; j < message.length; j++) {
            if (message[j] != ':') {
                id[j] = message[j];
            } else {
                break;
            }
        }
        String activityID = String.valueOf(id, 0, j);
        String query = null;
        String query1 = null;
        String query2 = null;
        String query3 = null;
        if (r == JOptionPane.YES_OPTION) {
            try {
                query = "update assegnazioneattivita set statomaintainer = '" + StatoMaintainer.READ.toString() + "' where nomemaintainer = '" + m.getNome() + "' and activityID = '" + activityID + "'";
                query1 = "update maintainanceactivity set generalstate = '" + GeneralState.INPROGRESS.toString() + "' where activityID = '" + activityID + "'";
                query2 = "delete from notifiche where nomemaintainer = '" + m.getNome() + "' and notifica = '" + notifica + "'";
                Query.genericUpdate(query);
                Query.genericUpdate(query1);
                Query.genericUpdate(query2);
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            }
        } else {
            try {
                query3 = "update assegnazioneattivita set statomaintainer = '" + StatoMaintainer.RECEIVED.toString() + "' where nomemaintainer = '" + m.getNome() + "' and activityID = '" + activityID + "'";
                Query.genericUpdate(query3);
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            }
        }
        aggiornaArea();
        aggiornaTabella();
    }//GEN-LAST:event_listaMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/exit.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler uscire?", "Esci", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        if (r == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    public void aggiornaArea() {
        LinkedList<String> listaAttivitàLette = new LinkedList<>();
        LinkedList<String> listaAttivitàInCorso = new LinkedList<>();
        String stringa = "";
        try {
            String query = "select activityID from assegnazioneattivita where nomemaintainer = '" + this.m.getNome() + "' and statomaintainer = '" + StatoMaintainer.READ.toString() + "'";
            ResultSet rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                listaAttivitàLette.add(rst.getString("activityID"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Non hai notifiche!", "Attenzione", JOptionPane.ERROR_MESSAGE, i);
        }
        try {
            String query = "select activityID from maintainanceactivity where generalstate = '" + GeneralState.INPROGRESS.toString() + "'";
            ResultSet rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                listaAttivitàInCorso.add(rst.getString("activityID"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Non hai notifiche!", "Attenzione", JOptionPane.ERROR_MESSAGE, i);
        }
        for (String s : listaAttivitàLette) {
            for (String s1 : listaAttivitàInCorso) {
                if (s.compareTo(s1) == 0) {
                    stringa = stringa + "•" + s1 + "\n";
                }
            }
        }
        this.jTextArea1.setText(stringa);
    }

    public void aggiornaTabella() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        LinkedList<String> notifiche;
        try {
            notifiche = this.m.viewMessages();
            if (notifiche.isEmpty()) {
                Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Non hai notifiche!", "Attenzione", JOptionPane.ERROR_MESSAGE, i);
                this.lista.setModel(listModel);
                return;
            }
            for (String u : notifiche) {
                listModel.addElement(u);
            }
            this.lista.setModel(listModel);
            Icon i = new ImageIcon(getClass().getResource("/images/message.png"));
            JOptionPane.showMessageDialog(this, "Hai delle notifiche!", "Notifiche", JOptionPane.PLAIN_MESSAGE, i);
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    listaMouseClicked(evt);
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MaintainerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaintainerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaintainerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaintainerInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaintainerInterface().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JList<String> lista;
    // End of variables declaration//GEN-END:variables
}

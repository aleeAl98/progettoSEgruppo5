//Gruppo 5
package interfaccia.amministratore;

import interfaccia.Login;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import progettosegruppo5.Amministratore;
import progettosegruppo5.Query;
import progettosegruppo5.Site;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AmministratoreInterfaceSiti extends javax.swing.JFrame {
    private Amministratore a = new Amministratore("","","");
    Query q = new Query();
    JTextField factory = new JTextField();
    JTextField area = new JTextField();
    JTextField nuovaFactory = new JTextField();
    JTextField nuovaArea = new JTextField();
    
    /*
    Hidden feature: interface for story ID 11
    Alessia Carbone 0622701487
    10/12/2020
    */
    public AmministratoreInterfaceSiti() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelTitleAdmin = new javax.swing.JLabel();
        jButtonAggiungi = new javax.swing.JButton();
        jButtonElimina = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonModifica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sites management");
        setIconImage(new ImageIcon(getClass().getResource("/images/administrator.png")).getImage());

        jButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton1.setText("Esci");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Siti", "Competenze", "Utenti", "Materiali", "Procedure", "Tipi" }));
        jComboBox1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabelTitleAdmin.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabelTitleAdmin.setForeground(new java.awt.Color(254, 160, 36));
        jLabelTitleAdmin.setText("Gestione siti");

        jButtonAggiungi.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonAggiungi.setText("Aggiungi");
        jButtonAggiungi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAggiungi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAggiungiMouseClicked(evt);
            }
        });

        jButtonElimina.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonElimina.setText("Elimina");
        jButtonElimina.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonElimina.setEnabled(false);
        jButtonElimina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminaMouseClicked(evt);
            }
        });

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        /*
        jTable1.setModel(null);
        */
        jScrollPane1.setViewportView(jTable1);
        this.aggiornaTabella();

        jButtonModifica.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonModifica.setText("Modifica");
        jButtonModifica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonModifica.setEnabled(false);
        jButtonModifica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonModificaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 381, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonModifica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTitleAdmin, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jLabelTitleAdmin)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonElimina)
                    .addComponent(jButtonAggiungi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonModifica)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private ArrayList<Site> getArrayList(LinkedList<Site> l){
        ArrayList<Site> list = new ArrayList<>();
        for(Site s : l){
            list.add(s);
        }
        return list;
    }
    
    private void aggiornaTabella() {
        LinkedList<Site> l = null;
        try {
            l = this.a.viewSite();
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            return;
        }
        ArrayList<Site> list = getArrayList(l);
        Object a[][] = new Object[l.size()][2];
        int n = 0;
        for (Site s : list) {
            a[n][0] = s.getSiteName();
            a[n][1] = s.getArea();
            n++;
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                a,
                new String[]{
                    "Factory site", "Area"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtons(evt);
            }
        });
    }
    
    private void jButtons(java.awt.event.MouseEvent evt) {
        this.jButtonModifica.setEnabled(true);
        this.jButtonElimina.setEnabled(true);
    }
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/exit.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler uscire?", "Esci", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        if (r == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        String state = evt.getItem().toString();
        if (state.compareTo("Utenti") == 0) {
            AmministratoreInterfaceUtenti a = new AmministratoreInterfaceUtenti();
            a.setVisible(Boolean.TRUE);
            a.setAmministratore(this.a);
            this.dispose();
        }
        if (state.compareTo("Competenze") == 0) {
            AmministratoreInterfaceCompetenze a = new AmministratoreInterfaceCompetenze();
            a.setVisible(Boolean.TRUE);
            a.setAmministratore(this.a);
            this.dispose();
        }
        if (state.compareTo("Materiali") == 0) {
            AmministratoreInterfaceMateriali a = new AmministratoreInterfaceMateriali();
            a.setVisible(Boolean.TRUE);
            a.setAmministratore(this.a);
            this.dispose();
        }
        if (state.compareTo("Procedure") == 0) {
            AmministratoreInterfaceProcedure a = new AmministratoreInterfaceProcedure();
            a.setVisible(Boolean.TRUE);
            a.setAmministratore(this.a);
            this.dispose();
        }
        if (state.compareTo("Tipi") == 0) {
            AmministratoreInterfaceTipi a = new AmministratoreInterfaceTipi();
            a.setVisible(Boolean.TRUE);
            a.setAmministratore(this.a);
            this.dispose();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private Component jOptionAggiungi() {
        factory.setFont(new Font(Font.DIALOG, 0, 12));
        factory.setSize(7, 50);
        factory.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        area.setFont(new Font(Font.DIALOG, 0, 12));
        area.setSize(7, 50);
        area.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        JLabel labelFactory = new JLabel("Factory site ");
        JLabel labelArea = new JLabel("Area ");
        labelFactory.setFont(new Font(Font.DIALOG, 0, 12));
        labelArea.setFont(new Font(Font.DIALOG, 0, 12));
        JPanel p = new JPanel();
        GridLayout l = new GridLayout(4, 1);
        l.setHgap(10);
        p.setLayout(l);
        p.add(labelFactory);
        p.add(factory);
        p.add(labelArea);
        p.add(area);
        return p;
    }
    
    private void jButtonAggiungiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAggiungiMouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/site.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionAggiungi(), "Aggiungi sito", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
        if (r == JOptionPane.YES_OPTION) {
            if (factory.getText().compareTo("") == 0 || area.getText().compareTo("") == 0) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Tutti i campi sono obbligatori!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                factory.setText("");
                area.setText("");
                return;
            }
            try {
                this.a.insertSite(factory.getText(), area.getText());
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                factory.setText("");
                area.setText("");
                return;
            }
            String query = "";
            ResultSet rst = null;
            Boolean nomeTrovato = false;
            query = "select factorysite,area from siti where factorysite = '" + factory.getText() + "' and area = '" + area.getText() + "'";
            try {
                rst = Query.genericQuery(query);
                boolean test = rst.next();
                if (!test) {
                    i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Inserimento non riuscito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    factory.setText("");
                    area.setText("");
                }
                while (test) {
                    if (rst.getString("factorysite").compareTo(factory.getText()) == 0 && rst.getString("area").compareTo(area.getText()) == 0) {
                        nomeTrovato = true;
                    }
                    test = rst.next();
                }
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                factory.setText("");
                area.setText("");
                return;
            }
            if (nomeTrovato) {
                i = new ImageIcon(getClass().getResource("/images/ok.png"));
                JOptionPane.showMessageDialog(this, "Inserimento riuscito!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                factory.setText("");
                area.setText("");
                this.aggiornaTabella();
            } else {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Inserimento non riuscito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                factory.setText("");
                area.setText("");
            }
        }
    }//GEN-LAST:event_jButtonAggiungiMouseClicked

    private void jButtonEliminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminaMouseClicked
        int s = this.jTable1.getSelectedRow();
        LinkedList<Site> l;
        try {
            l = this.a.viewSite();
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            nuovaFactory.setText("");
            nuovaArea.setText("");
            return;
        }
        ArrayList<Site> list = getArrayList(l);
        String factoryName = list.get(s).getSiteName();
        String areaName = list.get(s).getArea();
        Icon i = new ImageIcon(getClass().getResource("/images/question.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro/a di voler eliminare il sito?", "Eliminazione sito", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        String query = "";
        ResultSet rst = null;
        Boolean test = false;
        if (r == JOptionPane.YES_OPTION) {
            try {
                this.a.deleteSite(factoryName, areaName);
                query = "select factorysite,area from siti where factorysite = '" + factoryName + "'";
                rst = Query.genericQuery(query);
                test = rst.next();
                if (!test) {
                    i = new ImageIcon(getClass().getResource("/images/ok.png"));
                    JOptionPane.showMessageDialog(this, "Cancellazione riuscita!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                    this.aggiornaTabella();
                    return;
                }
                while (test) {
                    if (rst.getString("factorysite").compareTo(factoryName) == 0) {
                        i = new ImageIcon(getClass().getResource("/images/warning.png"));
                        JOptionPane.showMessageDialog(this, "Cancellazione non riuscita!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                        return;
                    }
                }
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                return;
            }
        }
    }//GEN-LAST:event_jButtonEliminaMouseClicked

    private Component jOptionUpdate() {
        nuovaFactory.setFont(new Font(Font.DIALOG, 0, 12));
        nuovaFactory.setSize(7, 50);
        nuovaFactory.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        nuovaArea.setFont(new Font(Font.DIALOG, 0, 12));
        nuovaArea.setSize(7, 50);
        nuovaArea.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        JLabel labelNuovaFactory = new JLabel("Nuovo factory site     ");
        JLabel labelNuovaArea = new JLabel("Nuova area     ");
        labelNuovaFactory.setFont(new Font(Font.DIALOG, 0, 12));
        labelNuovaArea.setFont(new Font(Font.DIALOG, 0, 12));
        JPanel p = new JPanel();
        GridLayout l = new GridLayout(2, 1);
        l.setHgap(10);
        p.setLayout(l);
        p.add(labelNuovaFactory);
        p.add(nuovaFactory);
        p.add(labelNuovaArea);
        p.add(nuovaArea);
        return p;
    }
    
    private void jButtonModificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificaMouseClicked
        int s = this.jTable1.getSelectedRow();
        LinkedList<Site> l;
        try {
            l = this.a.viewSite();
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            nuovaFactory.setText("");
            nuovaArea.setText("");
            return;
        }
        ArrayList<Site> list = getArrayList(l);
        String factoryName = list.get(s).getSiteName();
        String areaName = list.get(s).getArea();
        Icon i = new ImageIcon(getClass().getResource("/images/site.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionUpdate(), "Modifica sito", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
        if (r == JOptionPane.YES_OPTION) {
            if (nuovaFactory.getText().compareTo("") == 0 && nuovaArea.getText().compareTo("") == 0) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Il campo è obbligatorio!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovaFactory.setText("");
                nuovaArea.setText("");
                return;
            }
            if (factoryName.compareTo(nuovaFactory.getText()) == 0) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Inserire un nome diverso!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovaFactory.setText("");
                nuovaArea.setText("");
                return;
            }
            if (areaName.compareTo(nuovaArea.getText()) == 0) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Inserire un nome diverso!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovaFactory.setText("");
                nuovaArea.setText("");
                return;
            }
            try {
                this.a.updateSite(factoryName, nuovaFactory.getText(), areaName, nuovaArea.getText());
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovaFactory.setText("");
                nuovaArea.setText("");
                return;
            }
            String query = "";
            ResultSet rst = null;
            Boolean nomeTrovato = false;

            if(nuovaArea.getText().compareTo("") == 0){
                query = "select factorysite,area from siti where factorysite = '" + nuovaFactory.getText() + "' and area = '" + areaName + "'";
                nuovaArea.setText(areaName);
            }
            if(nuovaFactory.getText().compareTo("") == 0){
                query = "select factorysite,area from siti where factorysite = '" + factoryName + "' and area = '" + nuovaArea.getText() + "'";
                nuovaFactory.setText(factoryName);
            }
            if(nuovaArea.getText().compareTo("") != 0 && nuovaFactory.getText().compareTo("") != 0){
                query = "select factorysite,area from siti where factorysite = '" + nuovaFactory.getText() + "' and area = '" + nuovaArea.getText() + "'";
            }
            try {
                rst = Query.genericQuery(query);
                boolean test = rst.next();
                if (!test) {
                    i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Modifica non riuscita!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    nuovaFactory.setText("");
                    nuovaArea.setText("");
                    return;
                }
                while (test) {
                    if (rst.getString("factorysite").compareTo(nuovaFactory.getText()) == 0 && rst.getString("area").compareTo(nuovaArea.getText()) == 0) {
                        nomeTrovato = true;
                    }
                    test = rst.next();
                }
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovaFactory.setText("");
                nuovaArea.setText("");
                return;
            }

            if (nomeTrovato) {
                i = new ImageIcon(getClass().getResource("/images/ok.png"));
                JOptionPane.showMessageDialog(this, "Modifica riuscita!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                nuovaFactory.setText("");
                nuovaArea.setText("");
                this.aggiornaTabella();
            } else {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Modifica non riuscita!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovaFactory.setText("");
                nuovaArea.setText("");
            }
        }
    }//GEN-LAST:event_jButtonModificaMouseClicked

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
            java.util.logging.Logger.getLogger(AmministratoreInterfaceSiti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceSiti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceSiti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceSiti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AmministratoreInterfaceSiti().setVisible(true);
            }
        });
    }

    public void setAmministratore(Amministratore a) {
        this.a = a;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAggiungi;
    private javax.swing.JButton jButtonElimina;
    private javax.swing.JButton jButtonModifica;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelTitleAdmin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

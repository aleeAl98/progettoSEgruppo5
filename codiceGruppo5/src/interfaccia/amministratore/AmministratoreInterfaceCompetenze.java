//Gruppo 5
package interfaccia.amministratore;

import interfaccia.Login;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import progettosegruppo5.Amministratore;
import progettosegruppo5.Query;
import java.sql.ResultSet;

public class AmministratoreInterfaceCompetenze extends javax.swing.JFrame {
    private Amministratore a = new Amministratore("", "", "");
    Query q = new Query();
    JTextField nome = new JTextField();
    JTextField nuovoNome = new JTextField();
    
    /*
    Hidden feature: interface for story ID 7
    Alessia Carbone 0622701487
    1/12/2020
    */
    public AmministratoreInterfaceCompetenze() {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jListLista = new javax.swing.JList<>();
        jButtonModifica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Competencies management");
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
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Competenze", "Utenti", "Siti", "Materiali", "Procedure", "Tipi" }));
        jComboBox1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabelTitleAdmin.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabelTitleAdmin.setForeground(new java.awt.Color(254, 160, 36));
        jLabelTitleAdmin.setText("Gestione competenze");

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

        jListLista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jListLista.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jListLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListListaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListLista);
        try{
            this.aggiornaTabella();
        }catch(SQLException ex){}

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 51, Short.MAX_VALUE)
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
                .addGap(25, 25, 25)
                .addComponent(jLabelTitleAdmin)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonElimina)
                    .addComponent(jButtonAggiungi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonModifica)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aggiornaTabella() throws SQLException {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        LinkedList<String> competencies = this.a.viewCompetencies();
        for (String u : competencies) {
            listModel.addElement(u);
        }
        this.jListLista.setModel(listModel);
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
        if (state.compareTo("Siti") == 0) {
            AmministratoreInterfaceSiti a = new AmministratoreInterfaceSiti();
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
        nome.setFont(new Font(Font.DIALOG, 0, 12));
        nome.setSize(7, 50);
        nome.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        JLabel labelNome = new JLabel("Nome ");
        labelNome.setFont(new Font(Font.DIALOG, 0, 12));
        JPanel p = new JPanel();
        GridLayout l = new GridLayout(2, 1);
        l.setHgap(10);
        p.setLayout(l);
        p.add(labelNome);
        p.add(nome);
        return p;
    }
    
    private void jButtonAggiungiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAggiungiMouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/skill.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionAggiungi(), "Aggiungi competenza", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
        if (r == JOptionPane.YES_OPTION) {
            if (nome.getText().compareTo("") == 0) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Tutti i campi sono obbligatori!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                return;
            }
            try {
                this.a.insertCompetency(nome.getText());
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                return;
            }
            String query = "";
            ResultSet rst = null;
            Boolean nomeTrovato = false;
            query = "select competenza from competenze where competenza = '" + nome.getText() + "'";
            try {
                rst = Query.genericQuery(query);
                boolean test = rst.next();
                if (!test) {
                    i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Inserimento non riuscito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    nome.setText("");
                }
                while (test) {
                    if (rst.getString("competenza").compareTo(nome.getText()) == 0) {
                        nomeTrovato = true;
                    }
                    test = rst.next();
                }
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                return;
            }
            if (nomeTrovato) {
                i = new ImageIcon(getClass().getResource("/images/ok.png"));
                JOptionPane.showMessageDialog(this, "Inserimento riuscito!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                nome.setText("");
                try {
                    this.aggiornaTabella();
                } catch (SQLException ex) {
                    i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    nome.setText("");
                }
            } else {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Inserimento non riuscito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
            }
        }
    }//GEN-LAST:event_jButtonAggiungiMouseClicked

    private void jButtonEliminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminaMouseClicked
        String s = this.jListLista.getSelectedValue();
        Icon i = new ImageIcon(getClass().getResource("/images/question.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro/a di voler eliminare la competenza?", "Eliminazione competenza", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        String query = "";
        ResultSet rst = null;
        Boolean test = false;
        if (r == JOptionPane.YES_OPTION) {
            try {
                this.a.deleteCompetency(s);
                query = "select competenza from competenze where competenza = '" + s + "'";
                rst = Query.genericQuery(query);
                test = rst.next();
                if (!test) {
                    i = new ImageIcon(getClass().getResource("/images/ok.png"));
                    JOptionPane.showMessageDialog(this, "Cancellazione riuscita!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                    try {
                        this.aggiornaTabella();
                    } catch (SQLException ex) {
                        i = new ImageIcon(getClass().getResource("/images/warning.png"));
                        JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    }
                    return;
                }
                while (test) {
                    if (rst.getString("competenza").compareTo(s) == 0) {
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

    private void jListListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListListaMouseClicked
        this.jButtonModifica.setEnabled(true);
        this.jButtonElimina.setEnabled(true);
    }//GEN-LAST:event_jListListaMouseClicked

    private Component jOptionUpdate() {
        nuovoNome.setFont(new Font(Font.DIALOG, 0, 12));
        nuovoNome.setSize(7, 50);
        nuovoNome.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        JLabel labelNuovoNome = new JLabel("Nuovo nome     ");
        labelNuovoNome.setFont(new Font(Font.DIALOG, 0, 12));
        JPanel p = new JPanel();
        GridLayout l = new GridLayout(2, 1);
        l.setHgap(10);
        p.setLayout(l);
        p.add(labelNuovoNome);
        p.add(nuovoNome);
        return p;
    }
    
    private void jButtonModificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificaMouseClicked
        String s = this.jListLista.getSelectedValue();
        Icon i = new ImageIcon(getClass().getResource("/images/skill.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionUpdate(), "Modifica competenza", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
        if (r == JOptionPane.YES_OPTION) {
            if (s.compareTo(nuovoNome.getText()) == 0) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Inserire un nome diverso!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovoNome.setText("");
                return;
            }
            if (nuovoNome.getText().compareTo("") == 0) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Il campo è obbligatorio!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovoNome.setText("");
                return;
            }
            try {
                this.a.updateCompetency(s, nuovoNome.getText());
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovoNome.setText("");
                return;
            }
            String query = "";
            ResultSet rst = null;
            Boolean nomeTrovato = false;

            query = "select competenza from competenze where competenza = '" + nuovoNome.getText() + "'";
            try {
                rst = Query.genericQuery(query);
                boolean test = rst.next();
                if (!test) {
                    i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Modifica non riuscita!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    nuovoNome.setText("");
                    return;
                }
                while (test) {
                    if (rst.getString("competenza").compareTo(nuovoNome.getText()) == 0) {
                        nomeTrovato = true;
                    }
                    test = rst.next();
                }
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovoNome.setText("");
                return;
            }

            if (nomeTrovato) {
                i = new ImageIcon(getClass().getResource("/images/ok.png"));
                JOptionPane.showMessageDialog(this, "Modifica riuscita!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                nuovoNome.setText("");
                try {
                    this.aggiornaTabella();
                } catch (SQLException ex) {
                    i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    nuovoNome.setText("");
                }
            } else {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Modifica non riuscita!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovoNome.setText("");
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
            java.util.logging.Logger.getLogger(AmministratoreInterfaceCompetenze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceCompetenze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceCompetenze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceCompetenze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AmministratoreInterfaceCompetenze().setVisible(true);
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
    private javax.swing.JList<String> jListLista;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

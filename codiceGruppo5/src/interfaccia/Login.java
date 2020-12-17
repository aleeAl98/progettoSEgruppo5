//Gruppo 5
package interfaccia;

import interfaccia.amministratore.AmministratoreInterfaceUtenti;
import interfaccia.maintainer.MaintainerInterface;
import interfaccia.planner.PlannerInterfaceActivitiesList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import progettosegruppo5.Amministratore;
import progettosegruppo5.Maintainer;
import progettosegruppo5.Planner;
import progettosegruppo5.Query;

public class Login extends javax.swing.JFrame {
    Query q = new Query();

    public Login() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLoginTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonRuoloAm = new javax.swing.JRadioButton();
        jRadioButtonRuoloMa = new javax.swing.JRadioButton();
        jRadioButtonRuoloPl = new javax.swing.JRadioButton();
        jButtonEsci = new javax.swing.JButton();
        jButtonAccedi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maintainance app");
        setIconImage((new ImageIcon(getClass().getResource("/images/user.png"))).getImage());

        jLabelLoginTitle.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabelLoginTitle.setForeground(new java.awt.Color(254, 160, 36));
        jLabelLoginTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoginTitle.setText("Welcome");
        jLabelLoginTitle.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Sei un");

        jRadioButtonRuoloAm.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonRuoloAm.setText("Amministratore");
        jRadioButtonRuoloAm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioButtonRuoloAm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonRuoloAmMouseClicked(evt);
            }
        });

        jRadioButtonRuoloMa.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonRuoloMa.setText("Maintainer");
        jRadioButtonRuoloMa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioButtonRuoloMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonRuoloMaMouseClicked(evt);
            }
        });

        jRadioButtonRuoloPl.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButtonRuoloPl.setText("Planner");
        jRadioButtonRuoloPl.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioButtonRuoloPl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonRuoloPlMouseClicked(evt);
            }
        });

        jButtonEsci.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonEsci.setText("Esci");
        jButtonEsci.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonEsci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEsciMouseClicked(evt);
            }
        });

        jButtonAccedi.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonAccedi.setText("Accedi");
        jButtonAccedi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAccedi.setEnabled(false);
        jButtonAccedi.setFocusable(false);
        jButtonAccedi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAccediMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Password");

        jTextFieldUsername.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jTextFieldUsername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldUsernameKeyTyped(evt);
            }
        });

        jPasswordField.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jPasswordField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 160, 36));
        jLabel4.setText("Please login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelLoginTitle))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonEsci, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAccedi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldUsername)
                            .addComponent(jPasswordField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonRuoloPl)
                                    .addComponent(jRadioButtonRuoloAm)
                                    .addComponent(jRadioButtonRuoloMa))
                                .addGap(0, 108, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLoginTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jRadioButtonRuoloAm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonRuoloPl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonRuoloMa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAccedi)
                    .addComponent(jButtonEsci, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonRuoloAmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonRuoloAmMouseClicked
        this.jRadioButtonRuoloMa.setSelected(false);
        this.jRadioButtonRuoloPl.setSelected(false);
    }//GEN-LAST:event_jRadioButtonRuoloAmMouseClicked

    private void jRadioButtonRuoloMaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonRuoloMaMouseClicked
        this.jRadioButtonRuoloAm.setSelected(false);
        this.jRadioButtonRuoloPl.setSelected(false);
    }//GEN-LAST:event_jRadioButtonRuoloMaMouseClicked

    private void jRadioButtonRuoloPlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonRuoloPlMouseClicked
        this.jRadioButtonRuoloAm.setSelected(false);
        this.jRadioButtonRuoloMa.setSelected(false);
    }//GEN-LAST:event_jRadioButtonRuoloPlMouseClicked

    private void jButtonEsciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEsciMouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/exit.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler uscire?", "Esci", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        if (r == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_jButtonEsciMouseClicked

    private void jButtonAccediMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAccediMouseClicked
        String username = this.jTextFieldUsername.getText();
        String password = this.jPasswordField.getText();
        Boolean buttonAm = this.jRadioButtonRuoloAm.isSelected();
        Boolean buttonPl = this.jRadioButtonRuoloPl.isSelected();
        Boolean buttonMa = this.jRadioButtonRuoloMa.isSelected();
        String query = "";
        ResultSet rst = null;
        String usernameTrovato = "";
        String passwordTrovata = "";
        String nome = "";
        int numeroAccessi = 0;
        Boolean flag = true;

        if (!buttonAm && !buttonPl && !buttonMa) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Inserisci un ruolo!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        
        if(username.compareTo("") == 0 || password.compareTo("") == 0){
           Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
           JOptionPane.showMessageDialog(this, "Campi obbligatori!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }

        /*
        Story ID 16: Administrator login
        Chiara Cafaro 0622701443
        16/12/2020
        */
        if (buttonAm) {
            query = "select usernameac,passwordac,nomeamministratore,numeroaccessi from accesso where usernameac = '" + username + "'";
            try {
                rst = Query.genericQuery(query);
                boolean test = rst.next();
                if (!test) {
                    Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Username non esistente!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    this.jPasswordField.setText("");
                    this.jTextFieldUsername.setText("");
                    flag = false;
                }
                while (test) {
                    usernameTrovato = rst.getString("usernameac");
                    passwordTrovata = rst.getString("passwordac");
                    nome = rst.getString("nomeamministratore");
                    numeroAccessi = rst.getInt("numeroaccessi");
                    test = rst.next();
                }
                if (usernameTrovato.compareTo(username) == 0 && passwordTrovata.compareTo(password) == 0) {
                    String updateAc = "update accesso set numeroaccessi = " + (numeroAccessi+1) + " where usernameac = '" + username + "'"; 
                    Query.genericUpdate(updateAc);
                    AmministratoreInterfaceUtenti a = new AmministratoreInterfaceUtenti();
                    a.setVisible(Boolean.TRUE);
                    a.setAmministratore(new Amministratore(username, password, nome));
                    this.dispose();
                } else {
                    if (flag) {
                        Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                        JOptionPane.showMessageDialog(this, "Password errata!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                        this.jPasswordField.setText("");
                    }
                }
            } catch (SQLException ex) {
                Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                this.jPasswordField.setText("");
                this.jTextFieldUsername.setText("");
            }
        }
        /*
        Story ID 17: Planner login 
        Laura De Vivo 0622701475
        16/12/2020
        */
        if (buttonPl) {
            query = "select usernameac,passwordac,nomeplanner,numeroaccessi from accesso where usernameac = '" + username + "'";
            try {
                rst = Query.genericQuery(query);
                boolean test = rst.next();
                if (!test) {
                    Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Username non esistente!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    this.jTextFieldUsername.setText("");
                    this.jPasswordField.setText("");
                    flag = Boolean.FALSE;
                }
                while (test) {
                    usernameTrovato = rst.getString("usernameac");
                    passwordTrovata = rst.getString("passwordac");
                    nome = rst.getString("nomeplanner");
                    numeroAccessi = rst.getInt("numeroaccessi");
                    test = rst.next();
                }
                if (usernameTrovato.compareTo(username) == 0 && passwordTrovata.compareTo(password) == 0) {
                    String updateAc = "update accesso set numeroaccessi = " + (numeroAccessi+1) + " where usernameac = '" + username + "'"; 
                    Query.genericUpdate(updateAc);
                    PlannerInterfaceActivitiesList p = new PlannerInterfaceActivitiesList();
                    p.setVisible(Boolean.TRUE);
                    p.setPlanner(new Planner(username, password, nome));
                    this.dispose();
                } else {
                    if (flag) {
                        Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                        JOptionPane.showMessageDialog(this, "Password errata!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                        this.jPasswordField.setText("");
                    }
                }
            } catch (SQLException ex) {
                Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                this.jPasswordField.setText("");
                this.jTextFieldUsername.setText("");
            }
        }
        /*
        Story ID 18: Maintainer login
        Alessia Carbone 0622701487
        16/12/2020
        */
        if (buttonMa) {
            query = "select usernameac,passwordac,nomemaintainer,numeroaccessi from accesso where usernameac = '" + username + "'";
            try {
                rst = Query.genericQuery(query);
                boolean test = rst.next();
                if (!test) {
                    Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Username non esistente!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    this.jPasswordField.setText("");
                    this.jTextFieldUsername.setText("");
                    flag = Boolean.FALSE;
                }
                while (test) {
                    usernameTrovato = rst.getString("usernameac");
                    passwordTrovata = rst.getString("passwordac");
                    nome = rst.getString("nomemaintainer");
                    numeroAccessi = rst.getInt("numeroaccessi");
                    test = rst.next();
                }
                if (usernameTrovato.compareTo(username) == 0 && passwordTrovata.compareTo(password) == 0) {
                    String updateAc = "update accesso set numeroaccessi = " + (numeroAccessi+1) + " where usernameac = '" + username + "'"; 
                    Query.genericUpdate(updateAc);
                    MaintainerInterface m = new MaintainerInterface();
                    m.setVisible(Boolean.TRUE);
                    m.setMaintainer(new Maintainer(username, password, nome));
                    this.dispose();
                } else {
                    if (flag) {
                        Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                        JOptionPane.showMessageDialog(this, "Password errata!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                        this.jPasswordField.setText("");
                    }
                }
            } catch (SQLException ex) {
                Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                this.jPasswordField.setText("");
                this.jTextFieldUsername.setText("");
            }
        }
    }//GEN-LAST:event_jButtonAccediMouseClicked

    private void jTextFieldUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsernameKeyTyped
        this.jButtonAccedi.setEnabled(true);
        this.jButtonAccedi.setFocusable(true);
    }//GEN-LAST:event_jTextFieldUsernameKeyTyped

    private void jPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyTyped
        this.jButtonAccedi.setEnabled(true);
        this.jButtonAccedi.setFocusable(true);
    }//GEN-LAST:event_jPasswordFieldKeyTyped

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccedi;
    private javax.swing.JButton jButtonEsci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelLoginTitle;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JRadioButton jRadioButtonRuoloAm;
    private javax.swing.JRadioButton jRadioButtonRuoloMa;
    private javax.swing.JRadioButton jRadioButtonRuoloPl;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}

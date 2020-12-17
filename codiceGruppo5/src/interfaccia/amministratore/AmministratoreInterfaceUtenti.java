//Gruppo 5
package interfaccia.amministratore;

import interfaccia.Login;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import progettosegruppo5.Amministratore;
import progettosegruppo5.Maintainer;
import progettosegruppo5.Query;

public class AmministratoreInterfaceUtenti extends javax.swing.JFrame {
    private Amministratore a = new Amministratore("", "", "");
    Query q = new Query();

    JTextField nome = new JTextField();
    JTextField nuovoNome = new JTextField();
    JTextField username = new JTextField();
    JComboBox competenza = new JComboBox();
    JPasswordField password = new JPasswordField();
    JPasswordField conferma = new JPasswordField();
    JRadioButton buttonPl = new JRadioButton();
    JRadioButton buttonMa = new JRadioButton();
    Boolean maintainer = false;
    Boolean planner = false;
    String c = "";
    
    /*
    Hidden feature: interface for story ID 1, story ID 9
    Alessia Carbone 0622701487
    28/11/2020 - 1/12/2020
    */
    public AmministratoreInterfaceUtenti() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonEsciAm = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelTitleUsers = new javax.swing.JLabel();
        jButtonAggiungi = new javax.swing.JButton();
        jButtonElimina = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListLista = new javax.swing.JList<>();
        jButtonCompetenza = new javax.swing.JButton();
        jButtonViewCompetenze2 = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Users management");
        setIconImage(new ImageIcon(getClass().getResource("/images/administrator.png")).getImage());

        jButtonEsciAm.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonEsciAm.setText("Esci");
        jButtonEsciAm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonEsciAm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEsciAmMouseClicked(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Utenti", "Competenze", "Siti", "Materiali", "Procedure", "Tipi" }));
        jComboBox1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabelTitleUsers.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabelTitleUsers.setForeground(new java.awt.Color(254, 160, 36));
        jLabelTitleUsers.setText("Gestione utenti");

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

        jListLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jListLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListLista);
        this.aggiornaTabella();

        jButtonCompetenza.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonCompetenza.setText("Aggiungi competenza");
        jButtonCompetenza.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCompetenza.setEnabled(false);
        jButtonCompetenza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCompetenzaMouseClicked(evt);
            }
        });

        jButtonViewCompetenze2.setText("Visualizza competenze");
        jButtonViewCompetenze2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonViewCompetenze2.setEnabled(false);
        jButtonViewCompetenze2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonViewCompetenze2MouseClicked(evt);
            }
        });

        jButtonUpdate.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonUpdate.setText("Modifica");
        jButtonUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonUpdate.setEnabled(false);
        jButtonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonUpdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButtonEsciAm, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButtonAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jButtonElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addComponent(jButtonViewCompetenze2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(195, 195, 195)
                                    .addComponent(jLabelTitleUsers))
                                .addComponent(jButtonCompetenza, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEsciAm))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelTitleUsers)
                            .addGap(63, 63, 63)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonUpdate))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonAggiungi)
                                .addComponent(jButtonElimina))
                            .addGap(278, 278, 278)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonCompetenza)
                                .addComponent(jButtonViewCompetenze2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEsciAmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEsciAmMouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/exit.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler uscire?", "Esci", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        if (r == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonEsciAmMouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        String state = evt.getItem().toString();
        if (state.compareTo("Competenze") == 0) {
            AmministratoreInterfaceCompetenze a = new AmministratoreInterfaceCompetenze();
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

    private void aggiornaAvailability(String username, String password, String nome) throws SQLException{
        Maintainer m = new Maintainer(username,password,nome);
        Date dataIniziale = Date.valueOf(LocalDate.now());
        Date dataAttuale = dataIniziale;
        Date data;
        for(int i=0; i<365; i++){
            if(i == 0){
                data = dataAttuale;
            }
            else{
                data = Date.valueOf(dataAttuale.toLocalDate().plusDays(1));
            }
            int mese = data.toLocalDate().getMonthValue();
            int giorno = data.toLocalDate().getDayOfMonth();
            if(!((mese==1&&giorno==1)||(mese==1&&giorno==6)||(mese==4&&giorno==25)||(mese==5&&giorno==1)||(mese==6&&giorno==2)||(mese==8&&giorno==15)||(mese==11&&giorno==1)||(mese==12&&giorno==25)||(mese==12&&giorno==26)||(mese==12&&giorno==31))){
                    m.insertAvailability(data, nome, 420);
            }
            dataAttuale = data;
        }
    }
    
    private Component jOptionAggiungi() {
        nome.setFont(new Font(Font.DIALOG, 0, 12));
        username.setFont(new Font(Font.DIALOG, 0, 12));
        password.setFont(new Font(Font.DIALOG, 0, 12));
        conferma.setFont(new Font(Font.DIALOG, 0, 12));
        nome.setSize(7, 50);
        username.setSize(7, 50);
        password.setSize(7, 50);
        conferma.setSize(7, 50);
        nome.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        username.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        password.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        conferma.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        JLabel labelNome = new JLabel("Nome     ");
        JLabel labelUsername = new JLabel("Username     ");
        JLabel labelPassword = new JLabel("Password     ");
        JLabel labelConferma = new JLabel("Conferma password     ");
        JLabel labelRuolo = new JLabel("Ruolo     ");
        labelNome.setFont(new Font(Font.DIALOG, 0, 12));
        labelUsername.setFont(new Font(Font.DIALOG, 0, 12));
        labelPassword.setFont(new Font(Font.DIALOG, 0, 12));
        labelConferma.setFont(new Font(Font.DIALOG, 0, 12));
        buttonPl.setFont(new Font(Font.DIALOG, 0, 12));
        buttonMa.setFont(new Font(Font.DIALOG, 0, 12));
        buttonPl.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        buttonMa.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        buttonPl.setText("Planner");
        buttonMa.setText("Maintainer");
        buttonPl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buttonMa.setSelected(false);
            }
        });
        buttonMa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                buttonPl.setSelected(false);
            }
        });
        JPanel p = new JPanel();
        GridLayout l = new GridLayout(6, 1);
        l.setHgap(10);
        p.setLayout(l);
        p.add(labelNome);
        p.add(nome);
        p.add(labelUsername);
        p.add(username);
        p.add(labelPassword);
        p.add(password);
        p.add(labelConferma);
        p.add(conferma);
        p.add(labelRuolo);
        p.add(buttonPl);
        p.add(new JLabel("     "));
        p.add(buttonMa);
        return p;
    }
    
    private void jButtonAggiungiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAggiungiMouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/userAdd.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionAggiungi(), "Aggiungi utente", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
        if (r == JOptionPane.YES_OPTION) {
            if (!buttonMa.isSelected() && !buttonPl.isSelected()) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Nessun ruolo inserito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                username.setText("");
                password.setText("");
                conferma.setText("");
                buttonPl.setSelected(false);
                buttonMa.setSelected(false);
                return;
            }
            if (conferma.getText().compareTo(this.password.getText()) != 0) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Password non corrispondenti!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                username.setText("");
                password.setText("");
                conferma.setText("");
                buttonPl.setSelected(false);
                buttonMa.setSelected(false);
                return;
            }
            if (nome.getText().compareTo("") == 0 || username.getText().compareTo("") == 0 || password.getText().compareTo("") == 0) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Tutti i campi sono obbligatori!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                username.setText("");
                password.setText("");
                conferma.setText("");
                buttonPl.setSelected(false);
                buttonMa.setSelected(false);
                return;
            }
            try {
                this.a.insertUser(username.getText(), password.getText(), nome.getText(), buttonPl.isSelected());
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                username.setText("");
                password.setText("");
                conferma.setText("");
                buttonPl.setSelected(false);
                buttonMa.setSelected(false);
                return;
            }
            String query = "";
            ResultSet rst = null;
            Boolean nomeTrovato = false;
            if (this.buttonPl.isSelected()) {
                query = "select nomeplanner from planner where nomeplanner = '" + nome.getText() + "'";
                try {
                    rst = Query.genericQuery(query);
                    boolean test = rst.next();
                    if (!test) {
                        i = new ImageIcon(getClass().getResource("/images/warning.png"));
                        JOptionPane.showMessageDialog(this, "Inserimento non riuscito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    }
                    while (test) {
                        if (rst.getString("nomeplanner").compareTo(nome.getText()) == 0) {
                            nomeTrovato = true;
                        }
                        test = rst.next();
                    }
                } catch (SQLException ex) {
                    i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    nome.setText("");
                    username.setText("");
                    password.setText("");
                    conferma.setText("");
                    buttonPl.setSelected(false);
                    buttonMa.setSelected(false);
                    return;
                }
            } else {
                query = "select nomemaintainer from maintainer where nomemaintainer = '" + nome.getText() + "'";
                try {
                    rst = Query.genericQuery(query);
                    boolean test = rst.next();
                    if (!test) {
                        i = new ImageIcon(getClass().getResource("/images/warning.png"));
                        JOptionPane.showMessageDialog(this, "Inserimento non riuscito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    }
                    while (test) {
                        if (rst.getString("nomemaintainer").compareTo(nome.getText()) == 0) {
                            nomeTrovato = true;
                        }
                        test = rst.next();
                    }
                    this.aggiornaAvailability(username.getText(),password.getText(),nome.getText());
                } catch (SQLException ex) {
                    i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    nome.setText("");
                    username.setText("");
                    password.setText("");
                    conferma.setText("");
                    buttonPl.setSelected(false);
                    buttonMa.setSelected(false);
                    return;
                }
            }
            if (nomeTrovato) {
                i = new ImageIcon(getClass().getResource("/images/ok.png"));
                JOptionPane.showMessageDialog(this, "Inserimento riuscito!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                nome.setText("");
                username.setText("");
                password.setText("");
                conferma.setText("");
                buttonPl.setSelected(false);
                buttonMa.setSelected(false);
                this.aggiornaTabella();

            } else {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Inserimento non riuscito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                username.setText("");
                password.setText("");
                conferma.setText("");
                buttonPl.setSelected(false);
                buttonMa.setSelected(false);
            }
        }
    }//GEN-LAST:event_jButtonAggiungiMouseClicked

    private void jButtonEliminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminaMouseClicked
        String s = this.jListLista.getSelectedValue();
        Icon i = new ImageIcon(getClass().getResource("/images/question.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro/a di voler eliminare l'utente?", "Eliminazione utente", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        String query = "";
        ResultSet rst = null;
        Boolean test = false;
        if (r == JOptionPane.YES_OPTION) {
            try {
                this.a.deleteUser(s, planner);
                if (planner) {
                    query = "select nomeplanner from planner where nomeplanner = '" + s + "'";
                    rst = Query.genericQuery(query);
                    test = rst.next();
                    if (!test) {
                        i = new ImageIcon(getClass().getResource("/images/ok.png"));
                        JOptionPane.showMessageDialog(this, "Cancellazione riuscita!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                        this.aggiornaTabella();
                        nuovoNome.setText("");

                        return;
                    }
                    while (test) {
                        if (rst.getString("nomeplanner").compareTo(s) == 0) {
                            i = new ImageIcon(getClass().getResource("/images/warning.png"));
                            JOptionPane.showMessageDialog(this, "Cancellazione non riuscita!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                            return;
                        }
                    }
                }
                if (maintainer) {
                    query = "select nomemaintainer from maintainer where nomemaintainer = '" + s + "'";
                    rst = Query.genericQuery(query);
                    test = rst.next();
                    if (!test) {
                        i = new ImageIcon(getClass().getResource("/images/ok.png"));
                        JOptionPane.showMessageDialog(this, "Cancellazione riuscita!", "Success", JOptionPane.INFORMATION_MESSAGE, i);

                        this.aggiornaTabella();
                        return;
                    }
                    while (test) {
                        if (rst.getString("nomemaintainer").compareTo(s) == 0) {
                            i = new ImageIcon(getClass().getResource("/images/warning.png"));
                            JOptionPane.showMessageDialog(this, "Cancellazione non riuscita!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                            return;
                        }
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
        String selezionato = this.jListLista.getSelectedValue();
        String query = "select nomemaintainer from maintainer where nomemaintainer = '" + selezionato + "'";
        Boolean test = false;
        ResultSet rst = null;
        try {
            rst = Query.genericQuery(query);
            test = rst.next();
            if (!test) {
                this.jButtonCompetenza.setEnabled(false);
                this.jButtonViewCompetenze2.setEnabled(false);
                this.jButtonUpdate.setEnabled(true);
                this.jButtonElimina.setEnabled(true);
                maintainer = false;
                planner = true;
            }
            while (test) {
                this.jButtonCompetenza.setEnabled(true);
                this.jButtonViewCompetenze2.setEnabled(true);
                if (rst.getString("nomemaintainer").compareTo(selezionato) == 0) {
                    maintainer = true;
                    planner = false;
                    this.jButtonUpdate.setEnabled(true);
                    this.jButtonElimina.setEnabled(true);
                    return;
                }
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
    }//GEN-LAST:event_jListListaMouseClicked

    private Component jOptionCompetenza() {
        LinkedList<String> lis = new LinkedList<>();
        try {
            lis = this.a.viewCompetencies();
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        String stringa[] = new String[lis.size()];
        int n = 0;
        for (String i : lis) {
            stringa[n] = i;
            n++;
        }
        competenza.setFont(new Font(Font.DIALOG, 0, 12));
        competenza.setSize(7, 50);
        competenza.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        competenza.setModel(new DefaultComboBoxModel<>(stringa));
        competenza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCompStateChange(evt);
            }
        });
        JLabel labelCompetenza = new JLabel("Competenza     ");
        labelCompetenza.setFont(new Font(Font.DIALOG, 0, 12));
        JPanel p = new JPanel();
        GridLayout l = new GridLayout(2, 1);
        l.setHgap(10);
        p.setLayout(l);
        p.add(labelCompetenza);
        p.add(competenza);
        return p;
    }

    private void jComboBoxCompStateChange(java.awt.event.ItemEvent evt) {
        c = evt.getItem().toString();
    }
    
    private void jButtonCompetenzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCompetenzaMouseClicked
        String s = this.jListLista.getSelectedValue();
        String stampa = "";
        Icon i = new ImageIcon(getClass().getResource("/images/userAdd.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionCompetenza(), "Aggiungi competenza", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
        if (r == JOptionPane.YES_OPTION) {
            try {
                this.a.setCompetencyMaintainer(s, c);
                String q = "select competenza from possesso where nomemaintainer = '" + s + "'";
                ResultSet rst = Query.genericQuery(q);
                Boolean test = rst.next();
                if (!test) {
                    i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Nessuna competenza assegnata!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    return;
                }
                while (test) {
                    stampa = stampa + rst.getString("competenza") + "\n";
                    test = rst.next();
                }
                i = new ImageIcon(getClass().getResource("/images/ok.png"));
                JOptionPane.showMessageDialog(this, s + ": " + stampa, "Success", JOptionPane.INFORMATION_MESSAGE, i);
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            }
        }
    }//GEN-LAST:event_jButtonCompetenzaMouseClicked

    private Component jOptionVisualizzaCompetenze() {
        LinkedList<String> lis = new LinkedList<>();
        String query = "select competenza from possesso where nomemaintainer = '" + this.jListLista.getSelectedValue() + "'";
        try {
            ResultSet rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                lis.add(rst.getString("competenza"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        String stringa = "";
        for (String s : lis) {
            stringa = stringa + "•" + s + "\n";
        }
        JTextArea area = new JTextArea();
        area.setEnabled(false);
        area.setText(stringa);
        JPanel p = new JPanel();
        GridLayout l = new GridLayout(2, 1);
        l.setHgap(10);
        p.setLayout(l);
        p.add(area);
        return p;
    }
    
    private void jButtonViewCompetenze2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonViewCompetenze2MouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/skill.png"));
        JOptionPane.showConfirmDialog(this, this.jOptionVisualizzaCompetenze(), "Visualizza competenze", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
    }//GEN-LAST:event_jButtonViewCompetenze2MouseClicked

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
    
    private void jButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateMouseClicked
        String s = this.jListLista.getSelectedValue();
        Icon i = new ImageIcon(getClass().getResource("/images/userAdd.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionUpdate(), "Modifica utente", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
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
                this.a.updateUser(s, nuovoNome.getText(), planner);
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovoNome.setText("");
                return;
            }
            String query = "";
            ResultSet rst = null;
            Boolean nomeTrovato = false;
            if (planner) {
                query = "select nomeplanner from planner where nomeplanner = '" + nuovoNome.getText() + "'";
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
                        if (rst.getString("nomeplanner").compareTo(nuovoNome.getText()) == 0) {
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
            }
            if (maintainer) {
                query = "select nomemaintainer from maintainer where nomemaintainer = '" + nuovoNome.getText() + "'";
                try {
                    rst = Query.genericQuery(query);
                    boolean test = rst.next();
                    if (!test) {
                        i = new ImageIcon(getClass().getResource("/images/warning.png"));
                        JOptionPane.showMessageDialog(this, "Modifica non riuscita!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    }
                    while (test) {
                        if (rst.getString("nomemaintainer").compareTo(nuovoNome.getText()) == 0) {
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
            }
            if (nomeTrovato) {
                i = new ImageIcon(getClass().getResource("/images/ok.png"));
                JOptionPane.showMessageDialog(this, "Modifica riuscita!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                nuovoNome.setText("");
                this.aggiornaTabella();
                nuovoNome.setText("");
            } else {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Modifica non riuscita!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovoNome.setText("");
            }
        }
    }//GEN-LAST:event_jButtonUpdateMouseClicked

    private void aggiornaTabella() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        LinkedList<String> users = new LinkedList<>();
        try {
            users = this.a.viewUser();
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        for (String u : users) {
            listModel.addElement(u);
        }
        this.jListLista.setModel(listModel);
    }
    
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
            java.util.logging.Logger.getLogger(AmministratoreInterfaceUtenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceUtenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceUtenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceUtenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AmministratoreInterfaceUtenti().setVisible(true);
            }
        });
    }

    public void setAmministratore(Amministratore a) {
        this.a = a;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAggiungi;
    private javax.swing.JButton jButtonCompetenza;
    private javax.swing.JButton jButtonElimina;
    private javax.swing.JButton jButtonEsciAm;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonViewCompetenze2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelTitleUsers;
    private javax.swing.JList<String> jListLista;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

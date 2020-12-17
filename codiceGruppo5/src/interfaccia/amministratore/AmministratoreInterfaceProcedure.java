//Gruppo 5
package interfaccia.amministratore;

import interfaccia.Login;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import progettosegruppo5.Amministratore;
import progettosegruppo5.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import progettosegruppo5.MaintainanceProcedure;

public class AmministratoreInterfaceProcedure extends javax.swing.JFrame {
    private Amministratore a = new Amministratore("", "", "");
    Query q = new Query();
    JTextField nome = new JTextField();
    JTextField nuovoNome = new JTextField();
    JFileChooser filename = new JFileChooser();
    JButton button = new JButton();
    JButton nuovoFile = new JButton();
    File file = null;
    String c = "";
    JComboBox competenza = new JComboBox();
    
    /*
    Hidden feature: interface for story ID 5, story ID 8
    Alessia Carbone 0622701487
    28/11/2020 - 1/12/2020
    */
    public AmministratoreInterfaceProcedure() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonEsci = new javax.swing.JButton();
        jLabelTitleAdmin = new javax.swing.JLabel();
        jButtonAggiungi = new javax.swing.JButton();
        jButtonElimina = new javax.swing.JButton();
        jButtonOpen = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListLista = new javax.swing.JList<>();
        jButtonCompetenza = new javax.swing.JButton();
        jButtonViewCompetenze = new javax.swing.JButton();
        jButtonModificaFile = new javax.swing.JButton();
        jButtonModificaNome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Procedures management");
        setIconImage(new ImageIcon(getClass().getResource("/images/administrator.png")).getImage());

        jComboBox1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Procedure", "Competenze", "Utenti", "Siti", "Materiali", "Tipi" }));
        jComboBox1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButtonEsci.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonEsci.setText("Esci");
        jButtonEsci.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonEsci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEsciMouseClicked(evt);
            }
        });

        jLabelTitleAdmin.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabelTitleAdmin.setForeground(new java.awt.Color(254, 160, 36));
        jLabelTitleAdmin.setText("Gestione procedure");

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

        jButtonOpen.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonOpen.setText("Apri file");
        jButtonOpen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonOpen.setEnabled(false);
        jButtonOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOpenMouseClicked(evt);
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

        jButtonViewCompetenze.setText("Visualizza competenze");
        jButtonViewCompetenze.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonViewCompetenze.setEnabled(false);
        jButtonViewCompetenze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonViewCompetenzeMouseClicked(evt);
            }
        });

        jButtonModificaFile.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonModificaFile.setText("Modifica file");
        jButtonModificaFile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonModificaFile.setEnabled(false);
        jButtonModificaFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonModificaFileMouseClicked(evt);
            }
        });

        jButtonModificaNome.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonModificaNome.setText("Modifica nome");
        jButtonModificaNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonModificaNome.setEnabled(false);
        jButtonModificaNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonModificaNomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonEsci, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 94, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonModificaFile, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonModificaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTitleAdmin, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCompetenza, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonViewCompetenze, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEsci))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTitleAdmin)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAggiungi)
                            .addComponent(jButtonElimina)
                            .addComponent(jButtonOpen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModificaNome)
                    .addComponent(jButtonModificaFile)
                    .addComponent(jButtonCompetenza)
                    .addComponent(jButtonViewCompetenze))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aggiornaTabella() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        LinkedList<MaintainanceProcedure> procedures = new LinkedList<>();
        try {
            procedures = this.a.viewProcedures();
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        for (MaintainanceProcedure u : procedures) {
            listModel.addElement(u.getProcedureName());
        }
        this.jListLista.setModel(listModel);
    }
    
    private void saveFile() {
        File from = file.getAbsoluteFile();
        File to = new File(getClass().getResource("/pdf/").getPath() + file.getName());
        try {
            Files.copy(from.toPath(), to.toPath(), REPLACE_EXISTING);
        } catch (IOException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel salvataggio del file!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
    }
    
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
        if (state.compareTo("Competenze") == 0) {
            AmministratoreInterfaceCompetenze a = new AmministratoreInterfaceCompetenze();
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

    private void jButtonEsciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEsciMouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/exit.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler uscire?", "Esci", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        if (r == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonEsciMouseClicked

    private Component jOptionAggiungi() {
        nome.setFont(new Font(Font.DIALOG, 0, 12));
        nome.setSize(7, 50);
        nome.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        JLabel labelNome = new JLabel("Nome ");
        JLabel chooseFile = new JLabel("Scegli un file ");
        labelNome.setFont(new Font(Font.DIALOG, 0, 12));
        chooseFile.setFont(new Font(Font.DIALOG, 0, 12));
        button.setFont(new Font(Font.DIALOG, 0, 12));
        button.setSize(7, 50);
        button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        button.setText("Apri");
        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonFile(evt);
            }
        });
        JPanel p = new JPanel();
        GridLayout l = new GridLayout(2, 1);
        l.setHgap(10);
        p.setLayout(l);
        p.add(labelNome);
        p.add(nome);
        p.add(chooseFile);
        p.add(button);
        return p;
    }

    private void jButtonFile(MouseEvent evt) {
        filename.setDialogTitle("Scegli un file");
        filename.setFont(new Font(Font.DIALOG, 0, 12));
        filename.setSize(30, 50);
        filename.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        JPanel p = new JPanel();
        int n = filename.showOpenDialog(p);
        if (n == JFileChooser.APPROVE_OPTION) {
            file = filename.getSelectedFile();
        } else {
            file = null;
        }
    }
    
    private void jButtonAggiungiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAggiungiMouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/procedure.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionAggiungi(), "Aggiungi procedura", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
        if (r == JOptionPane.YES_OPTION) {
            if (nome.getText().compareTo("") == 0 || file == null) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Tutti i campi sono obbligatori!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                file = null;
                return;
            }
            this.saveFile();
            try {
                this.a.insertProcedure(nome.getText(), file.getName());
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                file = null;
                return;
            }
            String query = "";
            ResultSet rst = null;
            Boolean nomeTrovato = false;
            query = "select nomeprocedura from maintainanceprocedure where nomeprocedura = '" + nome.getText() + "'";
            try {
                rst = Query.genericQuery(query);
                boolean test = rst.next();
                if (!test) {
                    i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Inserimento non riuscito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                    nome.setText("");
                    file = null;
                    return;
                }
                while (test) {
                    if (rst.getString("nomeprocedura").compareTo(nome.getText()) == 0) {
                        nomeTrovato = true;
                    }
                    test = rst.next();
                }
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                file = null;
                return;
            }
            if (nomeTrovato) {
                i = new ImageIcon(getClass().getResource("/images/ok.png"));
                JOptionPane.showMessageDialog(this, "Inserimento riuscito!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                nome.setText("");
                file = null;
                this.aggiornaTabella();
            } else {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Inserimento non riuscito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nome.setText("");
                file = null;
            }
        }
    }//GEN-LAST:event_jButtonAggiungiMouseClicked

    private void jButtonEliminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminaMouseClicked
        String s = this.jListLista.getSelectedValue();
        Icon i = new ImageIcon(getClass().getResource("/images/question.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro/a di voler eliminare la procedura?", "Eliminazione procedura", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        String query = "";
        ResultSet rst = null;
        Boolean test = false;
        if (r == JOptionPane.YES_OPTION) {
            try {
                this.a.deleteProcedure(s);
                query = "select nomeprocedura from maintainanceprocedure where nomeprocedura = '" + s + "'";
                rst = Query.genericQuery(query);
                test = rst.next();
                if (!test) {
                    i = new ImageIcon(getClass().getResource("/images/ok.png"));
                    JOptionPane.showMessageDialog(this, "Cancellazione riuscita!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                    this.aggiornaTabella();
                    return;
                }
                while (test) {
                    if (rst.getString("nomeprocedura").compareTo(s) == 0) {
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

    private void jButtonOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOpenMouseClicked
        String s = this.jListLista.getSelectedValue();
        String query = "";
        ResultSet rst = null;
        String smp = "";
        try {
            query = "select smp from maintainanceprocedure where nomeprocedura = '" + s + "'";
            rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                smp = rst.getString("smp");
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        File f = new File(getClass().getResource("/pdf/" + smp).getPath());
        Desktop desktop = Desktop.getDesktop();
        if (f.exists()) {
            try {
                desktop.open(f);
            } catch (IOException ex) {
                Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nell'apertura del file!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            }
        }
    }//GEN-LAST:event_jButtonOpenMouseClicked

    private Component jOptionUpdateName() {
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
    
    private Component jOptionUpdateFile() {
        nuovoFile.setFont(new Font(Font.DIALOG, 0, 12));
        nuovoFile.setSize(7, 50);
        nuovoFile.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        nuovoFile.setText("Scegli un file");
        nuovoFile.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonFile(evt);
            }
        });
        JLabel labelNuovoNome = new JLabel("Nuovo file ");
        labelNuovoNome.setFont(new Font(Font.DIALOG, 0, 12));
        JPanel p = new JPanel();
        GridLayout l = new GridLayout(2, 1);
        l.setHgap(10);
        p.setLayout(l);
        p.add(labelNuovoNome);
        p.add(nuovoFile);
        return p;
    }
    
    private void jListListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListListaMouseClicked
        this.jButtonOpen.setEnabled(true);
        this.jButtonCompetenza.setEnabled(true);
        this.jButtonViewCompetenze.setEnabled(true);
        this.jButtonElimina.setEnabled(true);
        this.jButtonModificaNome.setEnabled(true);
        this.jButtonModificaFile.setEnabled(true);
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
        JLabel labelCompetenza = new JLabel("Competenza ");
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
        Icon i = new ImageIcon(getClass().getResource("/images/procedure.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionCompetenza(), "Aggiungi competenza", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
        if (r == JOptionPane.YES_OPTION) {
            try {
                this.a.insertRequiredCompetencyforProcedure(s, c);
                String q = "select competenza from competenzerichieste where nomeprocedura = '" + s + "'";
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
        try {
            lis = this.a.viewRequiredCompetenciesforProcedure(this.jListLista.getSelectedValue());
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
    
    private void jButtonViewCompetenzeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonViewCompetenzeMouseClicked
        String s = this.jListLista.getSelectedValue();
        String stampa = "";
        Icon i = new ImageIcon(getClass().getResource("/images/skill.png"));
        JOptionPane.showConfirmDialog(this, this.jOptionVisualizzaCompetenze(), "Visualizza competenze", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
    }//GEN-LAST:event_jButtonViewCompetenzeMouseClicked

    private void jButtonModificaFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificaFileMouseClicked
        String s = this.jListLista.getSelectedValue();
        Icon i = new ImageIcon(getClass().getResource("/images/procedure.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionUpdateFile(), "Modifica file", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
        if (r == JOptionPane.YES_OPTION) {
            if (file == null) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Il campo è obbligatorio!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                return;
            }
            this.saveFile();
            try {
                String q = "select smp from maintainanceprocedure where nomeprocedura = '" + s + "'";
                String smp = "";
                ResultSet rst = Query.genericQuery(q);
                Boolean test = rst.next();
                while (test) {
                    smp = rst.getString("smp");
                    test = rst.next();
                }
                this.a.updateProcedure("", "", smp, file.getName());
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                return;
            }
            i = new ImageIcon(getClass().getResource("/images/ok.png"));
            JOptionPane.showMessageDialog(this, "Modifica riuscita!\n" + s + ": " + file.getName(), "Success", JOptionPane.INFORMATION_MESSAGE, i);
            this.aggiornaTabella();
        }
    }//GEN-LAST:event_jButtonModificaFileMouseClicked

    private void jButtonModificaNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificaNomeMouseClicked
        String s = this.jListLista.getSelectedValue();
        Icon i = new ImageIcon(getClass().getResource("/images/procedure.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionUpdateName(), "Modifica nome procedura", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
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
                this.a.updateProcedure(s, nuovoNome.getText(), "", "");
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovoNome.setText("");
                return;
            }
            String query = "";
            ResultSet rst = null;
            Boolean nomeTrovato = false;
            query = "select nomeprocedura from maintainanceprocedure where nomeprocedura = '" + nuovoNome.getText() + "'";
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
                    if (rst.getString("nomeprocedura").compareTo(nuovoNome.getText()) == 0) {
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
                this.aggiornaTabella();
            } else {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Modifica non riuscita!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                nuovoNome.setText("");
            }
        }
    }//GEN-LAST:event_jButtonModificaNomeMouseClicked

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
            java.util.logging.Logger.getLogger(AmministratoreInterfaceProcedure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceProcedure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceProcedure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AmministratoreInterfaceProcedure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AmministratoreInterfaceProcedure().setVisible(true);
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
    private javax.swing.JButton jButtonEsci;
    private javax.swing.JButton jButtonModificaFile;
    private javax.swing.JButton jButtonModificaNome;
    private javax.swing.JButton jButtonOpen;
    private javax.swing.JButton jButtonViewCompetenze;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelTitleAdmin;
    private javax.swing.JList<String> jListLista;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

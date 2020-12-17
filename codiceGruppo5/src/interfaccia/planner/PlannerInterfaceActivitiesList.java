//Gruppo 5
package interfaccia.planner;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import enumeratives.GeneralState;
import enumeratives.StatoMaintainer;
import enumeratives.TicketStateForArea;
import enumeratives.TipoAttività;
import interfaccia.Login;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.TableCellRenderer;
import progettosegruppo5.MaintainanceActivity;
import progettosegruppo5.Planner;
import progettosegruppo5.Query;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;

public class PlannerInterfaceActivitiesList extends javax.swing.JFrame {

    private Planner p = new Planner("", "", "");
    Query q = new Query();
    JTextField activityID = new JTextField();
    JComboBox nomeProcedura = new JComboBox();
    JComboBox tipologia = new JComboBox();
    JTextArea descrizione = new JTextArea();
    JSlider tempo = new JSlider();
    JCheckBox interrompibile = new JCheckBox();
    JTextField settimana = new JTextField();
    JComboBox tipo = new JComboBox();
    int giorno;
    int mese;
    int anno;
    JComboBox materiali = new JComboBox();
    JTextArea materialiArea = new JTextArea();
    JComboBox area = new JComboBox();
    String proceduraScelta = "";
    String tipologiaScelta = "";
    String tipoScelto = "";
    String areaScelta = "";
    String id;
    LinkedList<String> materialiScelti = new LinkedList<>();
    String materialeSelezionato = "";
    String stato = "NOTSTARTED";

    JTextArea descrizioneEWO = new JTextArea();
    JTextField tempoEWO = new JTextField();
    LinkedList<String> competenzeEWO = new LinkedList<>();
    LinkedList<String> materialiEWO = new LinkedList<>();

    /*
    Hidden feature: interface for story ID 2, story ID 3, story ID 14, story ID 13
    Alessia Carbone 0622701487
    28/11/2020 - 1/12/2020 - 10/12/2020
     */
    public PlannerInterfaceActivitiesList() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonEsci = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonAggiungi = new javax.swing.JButton();
        jButtonElimina = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAttività = new javax.swing.JTable();
        statoCombo = new javax.swing.JComboBox<>();
        buttonTickets = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Activities management");
        setIconImage(new ImageIcon(getClass().getResource("/images/planner.png")).getImage());

        jButtonEsci.setText("Esci");
        jButtonEsci.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonEsci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEsciMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 160, 36));
        jLabel1.setText("Settimana n°");

        jButtonAggiungi.setText("Aggiungi");
        jButtonAggiungi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAggiungi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAggiungiMouseClicked(evt);
            }
        });

        jButtonElimina.setText("Elimina");
        jButtonElimina.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonElimina.setEnabled(false);
        jButtonElimina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminaMouseClicked(evt);
            }
        });

        jTableAttività.setBackground(new java.awt.Color(254, 160, 36));
        jTableAttività.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        /*
        jTableAttività.setModel(null);
        */
        jTableAttività.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAttivitàMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAttività);
        this.aggiornaTabella();

        String stati[] = {"NOTSTARTED","INPROGRESS","CLOSED"};
        statoCombo.setModel(new DefaultComboBoxModel(stati));
        statoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statoComboItemStateChanged(evt);
            }
        });

        buttonTickets.setText("Visualizza ticket");
        buttonTickets.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonTicketsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEsci, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(statoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonElimina)
                        .addComponent(jButtonAggiungi))
                    .addComponent(jButtonEsci))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTickets)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setEWOId() {
        int EWOid = 0;
        String query = "";
        ResultSet rst = null;
        ArrayList<String> activityIdentifiers = new ArrayList<>();
        try {
            query = "select activityID from maintainanceactivity where tipologia = '" + TipoAttività.EWO.toString() + "'";
            rst = Query.genericQuery(query);
            Boolean test = rst.next();
            if (!test) {
                this.id = "EWO1";
                return;
            }
            while (test) {
                activityIdentifiers.add(rst.getString("activityID"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        EWOid = activityIdentifiers.size() + 1;
        this.id = "EWO" + EWOid;
    }

    public void setId() {
        String id = "";
        String query = "";
        ResultSet rst = null;
        ArrayList<Integer> activityIdentifiers = new ArrayList<>();
        try {
            query = "select activityID from maintainanceactivity where tipologia != '" + TipoAttività.EWO.toString() + "'";
            rst = Query.genericQuery(query);
            Boolean test = rst.next();
            if (!test) {
                this.id = String.valueOf("1");
                return;
            }
            while (test) {
                activityIdentifiers.add(Integer.valueOf(rst.getString("activityID")));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        id = String.valueOf(activityIdentifiers.get(activityIdentifiers.size() - 1) + 1);
        this.id = id;
    }

    private void jButtonEsciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEsciMouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/exit.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler uscire?", "Esci", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        if (r == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonEsciMouseClicked

    private Component jOptionSelect() {
        JPanel p = new JPanel();
        try {
            ArrayList<MaintainanceActivity> list = this.p.viewMaintainanceActivity();
            ArrayList<MaintainanceActivity> l = new ArrayList<>();
            for (MaintainanceActivity m : list) {
                if (m.getGeneralState().toString().compareTo(stato) == 0) {
                    l.add(m);
                }
            }
            MaintainanceActivity m = l.get(this.jTableAttività.getSelectedRow());
            p = new JPanel();
            JLabel labelSettimana = new javax.swing.JLabel();
            JTextField settimana = new javax.swing.JTextField();
            JLabel labelDescrizione = new javax.swing.JLabel();
            JTextArea descrizione = new javax.swing.JTextArea();
            JLabel jLabelInformazioni = new javax.swing.JLabel();
            JLabel jLabelCompetenze = new javax.swing.JLabel();
            JTextArea jTextAreaCompetenze = new javax.swing.JTextArea();
            JButton jButtonForward = new javax.swing.JButton();
            JButton jButtonFile = new javax.swing.JButton();

            labelSettimana.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
            labelSettimana.setForeground(new java.awt.Color(254, 160, 36));
            labelSettimana.setText("Settimana n°");

            settimana.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            settimana.setText(String.valueOf(m.getSettimana()));
            settimana.setEnabled(false);
            labelDescrizione.setText("Descrizione attività");

            descrizione.setColumns(20);
            descrizione.setRows(5);
            descrizione.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            descrizione.setText(m.getDescrizione());
            descrizione.setEnabled(false);

            String skills = "";
            String procedura = m.getNomeProcedura();
            String query = "select competenza from competenzerichieste where nomeprocedura = '" + procedura + "'";
            ResultSet rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                skills = skills + "•" + (rst.getString("competenza")) + "\n";
                test = rst.next();
            }

            jButtonFile.addMouseListener(new MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonFile(evt);
                }
            });

            jButtonForward.addMouseListener(new MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButtonForward(evt);
                }
            });

            jLabelInformazioni.setText(m.getActivityID() + " - " + m.getFactorySite() + " " + m.getArea() + " - " + m.getTipo() + " - " + m.getTempo() + "'");

            jLabelCompetenze.setText("Competenze richieste");

            jTextAreaCompetenze.setColumns(20);
            jTextAreaCompetenze.setRows(5);
            jTextAreaCompetenze.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            jTextAreaCompetenze.setText(skills);
            jTextAreaCompetenze.setEnabled(false);

            jButtonForward.setText("Procedi");
            jButtonForward.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

            jButtonFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download.png"))); // NOI18N
            jButtonFile.setText(" SMP");
            jButtonFile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

            if (stato.compareTo("NOTSTARTED") != 0) {
                jButtonForward.setVisible(false);
            }
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(p);
            p.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelDescrizione)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(labelSettimana)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(settimana, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(77, 77, 77)
                                                    .addComponent(jLabelInformazioni, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(jButtonFile, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButtonForward, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(descrizione, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabelCompetenze)
                                                            .addComponent(jTextAreaCompetenze, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(15, 15, 15))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(labelSettimana)
                                                    .addGap(24, 24, 24)
                                                    .addComponent(labelDescrizione))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabelInformazioni, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(settimana, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabelCompetenze)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(descrizione, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                            .addComponent(jTextAreaCompetenze))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButtonForward, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonFile))
                                    .addContainerGap())
            );

        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        return p;
    }

    private void jButtonForward(java.awt.event.MouseEvent evt) {
        int i = this.jTableAttività.getSelectedRow();
        ArrayList<MaintainanceActivity> list = new ArrayList<>();
        try {
            list = this.p.viewMaintainanceActivity();
        } catch (SQLException ex) {
            Icon icon = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, icon);
        }
        ArrayList<MaintainanceActivity> l = new ArrayList<>();
        for (MaintainanceActivity m : list) {
            if (stato.compareTo(m.getGeneralState().toString()) == 0) {
                l.add(m);
            }
        }
        MaintainanceActivity a = l.get(i);
        if (a.getTipologia().toString().compareTo(TipoAttività.EWO.toString()) == 0) {
            try {
                LinkedList<String> competenze = new LinkedList<>();
                String query = "select competenza from competenzerichieste where nomeprocedura = '" + a.getNomeProcedura() + "'";
                ResultSet rst = Query.genericQuery(query);
                Boolean test = rst.next();
                while (test) {
                    competenze.add(rst.getString("competenza"));
                    test = rst.next();
                }

                for (String s : competenzeEWO) {
                    if (!competenze.contains(s)) {
                        a.setInsertCompetency(s);
                        competenze.remove(s);
                    }
                }
                for (String s : competenze) {
                    if (!competenzeEWO.contains(s)) {
                        a.setDeleteCompetency(s);
                    }
                }

                LinkedList<String> materiali = new LinkedList<>();
                query = "select nomemateriale from possessom where activityID = '" + a.getActivityID() + "'";
                rst = Query.genericQuery(query);
                test = rst.next();
                while (test) {
                    materiali.add(rst.getString("nomemateriale"));
                    test = rst.next();
                }

                for (String s : materialiEWO) {
                    if (!materiali.contains(s)) {
                        a.setInsertMaterials(s);
                        materiali.remove(s);
                    }
                }
                for (String s : materiali) {
                    if (!materialiEWO.contains(s)) {
                        a.setDeleteMaterials(s);
                    }
                }

                a.setTempo(Integer.valueOf(tempoEWO.getText()));
                a.setDescrizione(descrizioneEWO.getText());

            } catch (SQLException ex) {
                Icon image = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, image);
            }
        }
        PlannerInterfaceCalendar in = new PlannerInterfaceCalendar();
        in.setAttributes(this.p, a);
        in.setVisible(Boolean.TRUE);
        this.dispose();
    }

    private void jButtonFile(java.awt.event.MouseEvent evt) {
        String s;
        try {
            s = this.p.viewMaintainanceActivity().get(this.jTableAttività.getSelectedRow()).getNomeProcedura();
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            return;
        }
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
    }

    private Component jOptionAggiungi() {
        DatePicker data = new DatePicker();
        JButton addMateriali = new JButton();
        JButton removeMateriali = new JButton();
        activityID.setFont(new Font(Font.DIALOG, 0, 12));
        nomeProcedura.setFont(new Font(Font.DIALOG, 0, 12));
        tipologia.setFont(new Font(Font.DIALOG, 0, 12));
        descrizione.setFont(new Font(Font.DIALOG, 0, 12));
        tempo.setFont(new Font(Font.DIALOG, 0, 12));
        interrompibile.setFont(new Font(Font.DIALOG, 0, 12));
        settimana.setFont(new Font(Font.DIALOG, 0, 12));
        tipo.setFont(new Font(Font.DIALOG, 0, 12));
        data.setFont(new Font(Font.DIALOG, 0, 12));
        area.setFont(new Font(Font.DIALOG, 0, 12));
        materiali.setFont(new Font(Font.DIALOG, 0, 12));
        materialiArea.setFont(new Font(Font.DIALOG, 0, 12));
        addMateriali.setFont(new Font(Font.DIALOG, 0, 12));
        addMateriali.setText("↓");
        removeMateriali.setFont(new Font(Font.DIALOG, 0, 12));
        removeMateriali.setText("↑");
        activityID.setSize(7, 50);
        nomeProcedura.setSize(7, 50);
        tipologia.setSize(7, 50);
        descrizione.setSize(7, 50);
        tempo.setSize(7, 50);
        interrompibile.setSize(7, 50);
        settimana.setSize(7, 50);
        tipo.setSize(7, 50);
        data.setSize(7, 50);
        area.setSize(7, 50);
        materiali.setSize(7, 50);
        materialiArea.setSize(7, 50);
        addMateriali.setSize(7, 50);
        removeMateriali.setSize(7, 50);
        activityID.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        nomeProcedura.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        tipologia.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        descrizione.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        tempo.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        interrompibile.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        settimana.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        tipo.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        data.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        area.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        materiali.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        materialiArea.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        addMateriali.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        removeMateriali.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        //ActivityID
        activityID.setEnabled(false);
        this.setId();
        activityID.setText(id);
        //Procedure
        String queryProcedure = "select nomeprocedura from maintainanceprocedure";
        ResultSet rst = null;
        String[] procedure;
        LinkedList<String> l = new LinkedList<>();
        try {
            rst = Query.genericQuery(queryProcedure);
            Boolean test = rst.next();
            if (!test) {
                l = null;
            }
            while (test) {
                l.add(rst.getString("nomeprocedura"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        if (l == null) {
            procedure = new String[0];
        } else {
            procedure = new String[l.size()];
            int n = 0;
            for (String s : l) {
                procedure[n] = s;
                n++;
            }
        }
        nomeProcedura.setModel(new DefaultComboBoxModel<>(procedure));
        nomeProcedura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxProcStateChange(evt);
            }
        });
        //Tipologia attività (enum)
        TipoAttività tipologie[] = TipoAttività.values();
        int length = tipologie.length;
        String tipologieStringhe[] = new String[length];
        for (int i = 0; i < length; i++) {
            tipologieStringhe[i] = tipologie[i].toString();
        }
        tipologia.setModel(new DefaultComboBoxModel<>(tipologieStringhe));
        tipologia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getItem().toString().compareTo(TipoAttività.EWO.toString()) == 0) {
                    setEWOId();
                    activityID.setText(id);
                } else {
                    setId();
                    activityID.setText(id);
                }
                jComboBoxTipologiaStateChange(evt);
            }
        });
        //Tempo d'intervento
        tempo.setMinimum(60);
        tempo.setMaximum(420);
        tempo.setMajorTickSpacing(60);
        tempo.setMinorTickSpacing(10);
        tempo.setPaintTicks(true);
        tempo.setPaintLabels(true);
        //Settimana
        settimana.setEnabled(false);
        data.addDateChangeListener(new DateChangeListener() {
            @Override
            public void dateChanged(DateChangeEvent dce) {
                LocalDate data = dce.getSource().getDate();
                int day = data.getDayOfMonth();
                int month = data.getMonthValue();
                int days = 0;
                int week = 0;
                for (int i = 1; i < month; i++) {
                    if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                        days = days + 31;
                    }
                    if (i == 2) {
                        days = days + 28;
                    }
                    if (i == 4 || i == 6 || i == 9 || i == 11) {
                        days = days + 30;
                    }
                }
                days = days + day;
                week = (days / 7) + 1;
                settimana.setText(String.valueOf(week));
                giorno = data.getDayOfMonth();
                mese = data.getMonthValue();
                anno = data.getYear();
            }
        });
        //Tipo attività (db)
        String queryTipo = "select tipo from maintainancetype";
        rst = null;
        String[] tipi;
        LinkedList<String> t = new LinkedList<>();
        try {
            rst = Query.genericQuery(queryTipo);
            Boolean test = rst.next();
            if (!test) {
                t = null;
            }
            while (test) {
                t.add(rst.getString("tipo"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        if (t == null) {
            tipi = new String[0];
        } else {
            tipi = new String[t.size()];
            int n = 0;
            for (String s : t) {
                tipi[n] = s;
                n++;
            }
        }
        tipo.setModel(new DefaultComboBoxModel<>(tipi));
        tipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipiStateChange(evt);
            }
        });
        //Area
        String queryAree = "select factorysite,area from siti";
        rst = null;
        String[] aree;
        l = new LinkedList<>();
        try {
            rst = Query.genericQuery(queryAree);
            Boolean test = rst.next();
            if (!test) {
                l = null;
            }
            while (test) {
                l.add(rst.getString("factorysite") + "-" + rst.getString("area"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        if (l == null) {
            aree = new String[0];
        } else {
            aree = new String[l.size()];
            int n = 0;
            for (String s : l) {
                aree[n] = s;
                n++;
            }
        }
        area.setModel(new DefaultComboBoxModel<>(aree));
        area.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAreeStateChange(evt);
            }
        });
        //Materiali
        materialiArea.setEnabled(false);
        String queryMateriali = "select nomemateriale from materiali";
        LinkedList<String> list = new LinkedList<>();
        ResultSet r = null;
        try {
            r = Query.genericQuery(queryMateriali);
            Boolean test = r.next();
            while (test) {
                list.add(r.getString("nomemateriale"));
                test = r.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        String m[] = new String[list.size()];
        int n = 0;
        for (String s : list) {
            m[n] = s;
            n++;
        }
        materiali.setModel(new DefaultComboBoxModel<>(m));
        materiali.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxMaterialiStateChange(evt);
            }
        });
        addMateriali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMaterialiMouseClicked(evt);
            }
        });
        removeMateriali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMaterialiMouseClicked(evt);
            }
        });
        //Labels
        JLabel labelActivityID = new JLabel("ID attività ");
        JLabel labelNomeProcedura = new JLabel("Procedura ");
        JLabel labelTipologia = new JLabel("Tipologia attività ");
        JLabel labelDescrizione = new JLabel("Descrizione attività ");
        JLabel labelTempo = new JLabel("Tempo d'intervento (min) ");
        JLabel labelInterrompibile = new JLabel("Attività interrompibile? ");
        JLabel labelSettimana = new JLabel("Settimana ");
        JLabel labelTipo = new JLabel("Tipo di attività ");
        JLabel labelData = new JLabel("Data ");
        JLabel labelStato = new JLabel("Stato attività ");
        JLabel labelArea = new JLabel("Area intervento ");
        JLabel labelMateriali = new JLabel("Materiali ");
        labelActivityID.setFont(new Font(Font.DIALOG, 0, 12));
        labelNomeProcedura.setFont(new Font(Font.DIALOG, 0, 12));
        labelTipologia.setFont(new Font(Font.DIALOG, 0, 12));
        labelDescrizione.setFont(new Font(Font.DIALOG, 0, 12));
        labelTempo.setFont(new Font(Font.DIALOG, 0, 12));
        labelInterrompibile.setFont(new Font(Font.DIALOG, 0, 12));
        labelSettimana.setFont(new Font(Font.DIALOG, 0, 12));
        labelTipo.setFont(new Font(Font.DIALOG, 0, 12));
        labelData.setFont(new Font(Font.DIALOG, 0, 12));
        labelStato.setFont(new Font(Font.DIALOG, 0, 12));
        labelArea.setFont(new Font(Font.DIALOG, 0, 12));
        labelMateriali.setFont(new Font(Font.DIALOG, 0, 12));
        //Layout
        descrizione.setColumns(20);
        descrizione.setRows(5);
        descrizione.setColumns(20);
        descrizione.setRows(5);
        JScrollPane jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(descrizione);
        materialiArea.setColumns(20);
        materialiArea.setRows(5);
        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(materialiArea);
        JPanel p = new JPanel();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(p);
        p.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(labelDescrizione)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(labelActivityID)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(activityID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(labelNomeProcedura)
                                                                        .addComponent(labelTipologia)
                                                                        .addComponent(labelTipo)
                                                                        .addComponent(labelArea))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(tipo, 0, 176, Short.MAX_VALUE)
                                                                                        .addComponent(area, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(tipologia, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(nomeProcedura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(11, 11, 11)
                                                                .addComponent(labelMateriali)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(materiali, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(addMateriali)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(removeMateriali))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane2)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(labelData)
                                                                                        .addComponent(labelSettimana))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(settimana, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                        .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(labelTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelInterrompibile)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(interrompibile)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelActivityID)
                                        .addComponent(activityID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelDescrizione)
                                        .addComponent(labelMateriali)
                                        .addComponent(materiali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addMateriali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(removeMateriali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(labelNomeProcedura)
                                                .addComponent(nomeProcedura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelData))
                                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelTipologia)
                                                        .addComponent(tipologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelSettimana)
                                                        .addComponent(settimana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelTipo)
                                                        .addComponent(labelTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelArea)
                                                        .addComponent(area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(tempo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelInterrompibile)
                                        .addComponent(interrompibile))
                                .addContainerGap())
        );
        return p;
    }

    private void jComboBoxProcStateChange(java.awt.event.ItemEvent evt) {
        proceduraScelta = evt.getItem().toString();
    }

    private void jComboBoxTipologiaStateChange(java.awt.event.ItemEvent evt) {
        tipologiaScelta = evt.getItem().toString();
    }

    private void jComboBoxTipiStateChange(java.awt.event.ItemEvent evt) {
        tipoScelto = evt.getItem().toString();
    }

    private void jComboBoxAreeStateChange(java.awt.event.ItemEvent evt) {
        areaScelta = evt.getItem().toString();
    }

    private void jComboBoxMaterialiStateChange(java.awt.event.ItemEvent evt) {
        materialeSelezionato = evt.getItem().toString();
    }

    private void aggiornaTabella() {
        ArrayList<MaintainanceActivity> list = null;
        ArrayList<MaintainanceActivity> l = new ArrayList<>();
        try {
            list = this.p.viewMaintainanceActivity();
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            return;
        }
        for (MaintainanceActivity a : list) {
            if (a.getGeneralState().toString().compareTo(stato) == 0) {
                l.add(a);
            }
        }
        Object a[][] = new Object[l.size()][5];
        int n = 0;
        for (MaintainanceActivity m : l) {
            try {
                a[n][0] = m.getActivityID();
                a[n][1] = m.getFactorySite() + " - " + m.getArea();
                a[n][2] = m.getTipo();
                a[n][3] = String.valueOf(m.getTempo());
                a[n][4] = "";
                n++;
            } catch (SQLException ex) {
                Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                return;
            }
        }
        jTableAttività.setModel(new javax.swing.table.DefaultTableModel(
                a,
                new String[]{
                    "ID", "Area", "Tipo", "Intervento stimato (min)", ""
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableAttività.getColumn("").setCellRenderer(new JTableButtonRenderer());
        jTableAttività.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (jTableAttività.getSelectedColumn() == 4) {
                    jButtonSelezionaMouseClicked(evt);
                }
            }
        });
    }

    private class JTableButtonRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton seleziona = new JButton("Seleziona");
            seleziona.setFont(new Font(Font.DIALOG, 0, 12));
            seleziona.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            seleziona.setSize(7, 50);
            seleziona.setEnabled(true);
            return seleziona;
        }

    }

    private void jButtonSelezionaMouseClicked(java.awt.event.MouseEvent evt) {
        String activityID = jTableAttività.getValueAt(jTableAttività.getSelectedRow(), 0).toString();
        String query = "select tipologia from maintainanceactivity where activityID = '" + activityID + "'";
        ResultSet rst = null;
        Boolean test = null;
        Component p = null;
        Boolean ewo = false;
        try {
            rst = Query.genericQuery(query);
            test = rst.next();
            while (test) {
                if (rst.getString("tipologia").compareTo(TipoAttività.EWO.toString()) == 0) {
                    p = jOptionSelectEWO();
                    ewo = true;
                } else {
                    p = jOptionSelect();
                }
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        Icon i = new ImageIcon(getClass().getResource("/images/activity.png"));
        JOptionPane.showMessageDialog(this, p, "Visualizzazione attività", JOptionPane.PLAIN_MESSAGE, i);
        if (ewo) {
            try {
                String nomeProcedura = "";
                query = "select nomeprocedura from maintainanceactivity where activityID = '" + activityID + "'";
                rst = Query.genericQuery(query);
                test = rst.next();
                while (test) {
                    nomeProcedura = rst.getString("nomeprocedura");
                    test = rst.next();
                }
                LinkedList<String> competenze = new LinkedList<>();
                query = "select competenza from competenzerichieste where nomeprocedura = '" + nomeProcedura + "'";
                rst = Query.genericQuery(query);
                test = rst.next();
                while (test) {
                    competenze.add(rst.getString("competenza"));
                    test = rst.next();
                }
                if (!competenzeEWO.isEmpty()) {
                    for (String s1 : competenzeEWO) {
                        if (!competenze.contains(s1)) {
                            query = "insert into competenzerichieste(nomeprocedura,competenza) values ('" + proceduraScelta + "', '" + s1 + "')";
                            Query.genericUpdate(query);
                            competenze.remove(s1);
                        }
                    }

                    for (String s : competenze) {
                        if (!competenzeEWO.contains(s)) {
                            query = "delete from competenzerichieste where competenza = '" + s + "' and nomeprocedura = '" + proceduraScelta + "'";
                            Query.genericUpdate(query);
                        }
                    }
                }
                LinkedList<String> materiali = new LinkedList<>();
                query = "select nomemateriale from possessom where activityID = '" + activityID + "'";
                rst = Query.genericQuery(query);
                test = rst.next();
                while (test) {
                    materiali.add(rst.getString("nomemateriale"));
                    test = rst.next();
                }

                if (!materialiEWO.isEmpty()) {
                    for (String s1 : materialiEWO) {
                        if (!materiali.contains(s1)) {
                            query = "insert into possessom(activityID,nomemateriale) values ('" + activityID + "', '" + s1 + "')";
                            Query.genericUpdate(query);
                            materiali.remove(s1);
                        }
                    }
                    for (String s : materiali) {
                        if (!materialiEWO.contains(s)) {
                            query = "delete from possessom where nomemateriale = '" + s + "' and activityID = '" + activityID + "'";
                            Query.genericUpdate(query);
                        }
                    }
                }

                query = "update maintainanceactivity set tempo = " + Integer.valueOf(tempoEWO.getText()) + " where activityID = '" + activityID + "'";
                Query.genericUpdate(query);
                query = "update maintainanceactivity set descrizione = '" + descrizioneEWO.getText() + "' where activityID = '" + activityID + "'";
                Query.genericUpdate(query);

            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            }
            this.aggiornaTabella();
        }
    }

    private Component jOptionSelectEWO() {
        ArrayList<MaintainanceActivity> list = new ArrayList<>();
        try {
            list = this.p.viewMaintainanceActivity();
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        ArrayList<MaintainanceActivity> l = new ArrayList<>();
        for (MaintainanceActivity m : list) {
            if (m.getGeneralState().toString().compareTo(stato) == 0) {
                l.add(m);
            }
        }
        MaintainanceActivity m = l.get(this.jTableAttività.getSelectedRow());
        JButton addCompetenza;
        JButton addMateriali;
        JTextArea areaCompetenze;
        JTextArea areaMateriali;
        JTextField data;
        JComboBox<String> jComboBoxCompetenze;
        JComboBox<String> jComboBoxMateriali;
        JLabel jLabelCompetenze;
        JLabel jLabelInformazioni;
        JScrollPane jScrollPane1;
        JScrollPane jScrollPane2;
        JScrollPane jScrollPane3;
        JLabel labelData;
        JLabel labelDescrizione;
        JLabel labelMateriali;
        JLabel labelSettimana;
        JLabel labelTempo;
        JButton removeCompetenza;
        JButton removeMateriali;
        JTextField settimana;
        JButton file;
        JButton procedi;
        procedi = new javax.swing.JButton();
        file = new javax.swing.JButton();
        labelSettimana = new javax.swing.JLabel();
        settimana = new javax.swing.JTextField();
        labelDescrizione = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descrizioneEWO = new javax.swing.JTextArea();
        jLabelInformazioni = new javax.swing.JLabel();
        jLabelCompetenze = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaCompetenze = new javax.swing.JTextArea();
        jComboBoxCompetenze = new javax.swing.JComboBox<>();
        addCompetenza = new javax.swing.JButton();
        removeCompetenza = new javax.swing.JButton();
        labelData = new javax.swing.JLabel();
        data = new javax.swing.JTextField();
        labelMateriali = new javax.swing.JLabel();
        jComboBoxMateriali = new javax.swing.JComboBox<>();
        addMateriali = new javax.swing.JButton();
        removeMateriali = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaMateriali = new javax.swing.JTextArea();
        labelTempo = new javax.swing.JLabel();
        tempoEWO = new javax.swing.JTextField();

        labelSettimana.setText("Settimana n° ");

        settimana.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        settimana.setEnabled(false);
        settimana.setText(String.valueOf(m.getSettimana()));

        labelDescrizione.setText("Descrizione");

        descrizioneEWO.setColumns(20);
        descrizioneEWO.setRows(5);
        descrizioneEWO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        descrizioneEWO.setText(m.getDescrizione());
        jScrollPane1.setViewportView(descrizioneEWO);

        try {
            jLabelInformazioni.setText(m.getActivityID() + " - " + m.getFactorySite() + " " + m.getArea() + " - " + m.getTipo() + " - " + m.getTempo() + "'");
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }

        jLabelCompetenze.setText("Competenze");

        areaCompetenze.setColumns(20);
        areaCompetenze.setRows(5);
        areaCompetenze.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        areaCompetenze.setEnabled(false);
        jScrollPane2.setViewportView(areaCompetenze);

        String competenzeRichieste = "";
        String query = "select competenza from competenzerichieste where nomeprocedura = '" + m.getNomeProcedura() + "'";
        try {
            ResultSet rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                competenzeRichieste = competenzeRichieste + "•" + rst.getString("competenza") + "\n";
                competenzeEWO.add(rst.getString("competenza"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        areaCompetenze.setText(competenzeRichieste);

        LinkedList<String> competenze = new LinkedList<>();
        query = "select competenza from competenze";
        try {
            ResultSet rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                competenze.add(rst.getString("competenza"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        String stringaCompetenze[] = new String[competenze.size()];
        int n = 0;
        for (String s : competenze) {
            stringaCompetenze[n] = s;
            n++;
        }

        jComboBoxCompetenze.setModel(new javax.swing.DefaultComboBoxModel<>(stringaCompetenze));

        addCompetenza.setText("↓");
        addCompetenza.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (!competenzeEWO.contains(jComboBoxCompetenze.getSelectedItem().toString())) {
                    competenzeEWO.add(jComboBoxCompetenze.getSelectedItem().toString());
                    String s = "";
                    for (String stringa : competenzeEWO) {
                        s = s + "•" + stringa + "\n";
                    }
                    areaCompetenze.setText(s);
                }
            }
        });

        removeCompetenza.setText("↑");
        removeCompetenza.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (competenzeEWO.contains(jComboBoxCompetenze.getSelectedItem().toString())) {
                    competenzeEWO.remove(jComboBoxCompetenze.getSelectedItem().toString());
                    String s = "";
                    for (String stringa : competenzeEWO) {
                        s = s + "•" + stringa + "\n";
                    }
                    try {
                        m.setDeleteCompetency(jComboBoxCompetenze.getSelectedItem().toString());
                    } catch (SQLException ex) {
                    }
                    areaCompetenze.setText(s);
                }
            }
        });

        labelData.setText("Data");

        data.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        data.setEnabled(false);
        data.setText(m.getData().toString());

        labelMateriali.setText("Materiali");

        String materialiRichiesti = "";
        query = "select nomemateriale from possessom where activityID = '" + m.getActivityID() + "'";
        try {
            ResultSet rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                materialiRichiesti = materialiRichiesti + "•" + rst.getString("nomemateriale") + "\n";
                materialiEWO.add(rst.getString("nomemateriale"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        areaMateriali.setText(materialiRichiesti);

        LinkedList<String> materiali = new LinkedList<>();
        query = "select nomemateriale from materiali";
        try {
            ResultSet rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                materiali.add(rst.getString("nomemateriale"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        String stringaMateriali[] = new String[materiali.size()];
        n = 0;
        for (String s : materiali) {
            stringaMateriali[n] = s;
            n++;
        }

        jComboBoxMateriali.setModel(new javax.swing.DefaultComboBoxModel<>(stringaMateriali));

        addMateriali.setText("↓");
        addMateriali.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (!materialiEWO.contains(jComboBoxMateriali.getSelectedItem().toString())) {
                    materialiEWO.add(jComboBoxMateriali.getSelectedItem().toString());
                    String s = "";
                    for (String stringa : materialiEWO) {
                        s = s + "•" + stringa + "\n";
                    }
                    areaMateriali.setText(s);
                }
            }
        });

        removeMateriali.setText("↑");
        removeMateriali.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (materialiEWO.contains(jComboBoxMateriali.getSelectedItem().toString())) {
                    materialiEWO.remove(jComboBoxMateriali.getSelectedItem().toString());
                    String s = "";
                    for (String stringa : materialiEWO) {
                        s = s + "•" + stringa + "\n";
                    }
                    areaMateriali.setText(s);
                    try {
                        m.setDeleteMaterials(jComboBoxMateriali.getSelectedItem().toString());
                    } catch (SQLException ex) {
                    }
                }
            }
        });

        areaMateriali.setColumns(20);
        areaMateriali.setRows(5);
        areaMateriali.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        areaMateriali.setEnabled(false);
        jScrollPane3.setViewportView(areaMateriali);

        labelTempo.setText("Tempo d'intervento (minuti)");

        tempoEWO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tempoEWO.setText(String.valueOf(m.getTempo()));

        procedi.setText("Procedi");
        procedi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        procedi.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonForward(evt);
            }
        });

        file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download.png")));
        file.setText("SMP");
        file.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        file.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonFile(evt);
            }
        });

        JPanel p = new JPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(p);
        p.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(labelSettimana)
                                                                        .addComponent(labelDescrizione))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(settimana, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(labelData)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(data)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelInformazioni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(labelTempo)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tempoEWO))))
                                        .addComponent(jScrollPane3)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jScrollPane2)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelCompetenze)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxCompetenze, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addCompetenza, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(removeCompetenza, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelMateriali, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxMateriali, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addMateriali, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(removeMateriali, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(file)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(procedi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelSettimana)
                                        .addComponent(settimana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelInformazioni))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelData)
                                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelTempo)
                                        .addComponent(tempoEWO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addComponent(labelDescrizione)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCompetenze)
                                        .addComponent(jComboBoxCompetenze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addCompetenza)
                                        .addComponent(removeCompetenza))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelMateriali)
                                        .addComponent(jComboBoxMateriali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addMateriali)
                                        .addComponent(removeMateriali))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(file)
                                        .addComponent(procedi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        return p;
    }

    private void jButtonAggiungiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAggiungiMouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/activity.png"));
        int r = JOptionPane.showConfirmDialog(this, this.jOptionAggiungi(), "Aggiungi attività", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
        if (r == JOptionPane.YES_OPTION) {
            if (activityID.getText().compareTo("") == 0 || descrizione.getText().compareTo("") == 0 || (anno == 0 && mese == 0 && giorno == 0)) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Tutti i campi sono obbligatori!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                activityID.setText("");
                descrizione.setText("");
                tempo.setValue(tempo.getMinimum());
                settimana.setText("");
                interrompibile.setSelected(false);
                materialiArea.setText("");
                return;
            }
            if(proceduraScelta.compareTo("") == 0) {
                nomeProcedura.setSelectedItem(nomeProcedura.getItemAt(0));
                proceduraScelta = nomeProcedura.getItemAt(0).toString();
            }
            if(tipologiaScelta.compareTo("") == 0) {
                tipologia.setSelectedItem(tipologia.getItemAt(0));
                tipologiaScelta = tipologia.getItemAt(0).toString();
            }
            if(tipoScelto.compareTo("") == 0) {
                tipo.setSelectedItem(tipo.getItemAt(0));
                tipoScelto = tipo.getItemAt(0).toString();
            }
            if(areaScelta.compareTo("") == 0) {
                area.setSelectedItem(area.getItemAt(0));
                areaScelta = area.getItemAt(0).toString();
            }
            try {
                String a = "";
                String f = "";
                int n = areaScelta.indexOf("-");
                f = areaScelta.substring(0, n);
                a = areaScelta.substring(n + 1, areaScelta.length());
                TipoAttività t = null;
                if (TipoAttività.EWO.toString().compareTo(tipologiaScelta) == 0) {
                    t = TipoAttività.EWO;
                    this.p.addEWOActivity(activityID.getText(), proceduraScelta,
                            t, descrizione.getText(), tempo.getValue(),
                            interrompibile.isSelected(), Integer.valueOf(settimana.getText()), tipoScelto,
                            Date.valueOf(anno + "-" + mese + "-" + giorno), a, f, materialiScelti);
                }
                if (TipoAttività.EXTRA.toString().compareTo(tipologiaScelta) == 0) {
                    t = TipoAttività.EXTRA;
                    this.p.insertMaintainanceActivity(activityID.getText(), proceduraScelta,
                            t, descrizione.getText(), tempo.getValue(),
                            interrompibile.isSelected(), Integer.valueOf(settimana.getText()), tipoScelto,
                            Date.valueOf(anno + "-" + mese + "-" + giorno), a, f, materialiScelti);
                }
                if (TipoAttività.PLANNED.toString().compareTo(tipologiaScelta) == 0) {
                    t = TipoAttività.PLANNED;
                    this.p.insertMaintainanceActivity(activityID.getText(), proceduraScelta,
                            t, descrizione.getText(), tempo.getValue(),
                            interrompibile.isSelected(), Integer.valueOf(settimana.getText()), tipoScelto,
                            Date.valueOf(anno + "-" + mese + "-" + giorno), a, f, materialiScelti);
                }
                if (TipoAttività.UNPLANNED.toString().compareTo(tipologiaScelta) == 0) {
                    t = TipoAttività.UNPLANNED;
                    this.p.insertMaintainanceActivity(activityID.getText(), proceduraScelta,
                            t, descrizione.getText(), tempo.getValue(),
                            interrompibile.isSelected(), Integer.valueOf(settimana.getText()), tipoScelto,
                            Date.valueOf(anno + "-" + mese + "-" + giorno), a, f, materialiScelti);
                }
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                activityID.setText("");
                descrizione.setText("");
                tempo.setValue(tempo.getMinimum());
                settimana.setText("");
                interrompibile.setSelected(false);
                materialiArea.setText("");
                return;
            }
            String query = "";
            ResultSet rst = null;
            Boolean nomeTrovato = false;
            query = "select activityID from maintainanceactivity where activityID = '" + activityID.getText() + "'";
            try {
                rst = Query.genericQuery(query);
                boolean test = rst.next();
                if (!test) {
                    i = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Inserimento non riuscito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                }
                while (test) {
                    if (rst.getString("activityID").compareTo(activityID.getText()) == 0) {
                        nomeTrovato = true;
                    }
                    test = rst.next();
                }
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                activityID.setText("");
                descrizione.setText("");
                tempo.setValue(tempo.getMinimum());
                settimana.setText("");
                interrompibile.setSelected(false);
                materialiArea.setText("");
                return;
            }
            if (nomeTrovato) {
                i = new ImageIcon(getClass().getResource("/images/ok.png"));
                JOptionPane.showMessageDialog(this, "Inserimento riuscito!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                activityID.setText("");
                descrizione.setText("");
                tempo.setValue(tempo.getMinimum());
                settimana.setText("");
                interrompibile.setSelected(false);
                materialiArea.setText("");
                this.aggiornaTabella();

            } else {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Inserimento non riuscito!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                activityID.setText("");
                descrizione.setText("");
                tempo.setValue(tempo.getMinimum());
                settimana.setText("");
                interrompibile.setSelected(false);
                materialiArea.setText("");
            }
        }
    }//GEN-LAST:event_jButtonAggiungiMouseClicked

    private void jButtonEliminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminaMouseClicked
        int s = this.jTableAttività.getSelectedRow();
        String activityID = null;
        try {
            ArrayList<MaintainanceActivity> list = this.p.viewMaintainanceActivity();
            ArrayList<MaintainanceActivity> m = new ArrayList<>();
            for (MaintainanceActivity a : list) {
                if (a.getGeneralState().toString().compareTo(stato) == 0) {
                    m.add(a);
                }
            }
            activityID = m.get(s).getActivityID();
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        Icon i = new ImageIcon(getClass().getResource("/images/question.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro/a di voler eliminare l'attività?", "Eliminazione attività", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        String query = "";
        ResultSet rst = null;
        Boolean test = false;
        if (r == JOptionPane.YES_OPTION) {
            try {
                this.p.deleteMaintainanceActivity(activityID);
                query = "select activityID from maintainanceactivity where activityID = '" + activityID + "'";
                rst = Query.genericQuery(query);
                test = rst.next();
                if (!test) {
                    i = new ImageIcon(getClass().getResource("/images/ok.png"));
                    JOptionPane.showMessageDialog(this, "Cancellazione riuscita!", "Success", JOptionPane.INFORMATION_MESSAGE, i);
                    this.aggiornaTabella();
                    return;
                }
                while (test) {
                    if (rst.getString("activityID").compareTo(activityID) == 0) {
                        i = new ImageIcon(getClass().getResource("/images/warning.png"));
                        JOptionPane.showMessageDialog(this, "Cancellazione non riuscita!", "Errore", JOptionPane.ERROR_MESSAGE, i);
                        return;
                    }
                }
            } catch (SQLException ex) {
                i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            }
        }
    }//GEN-LAST:event_jButtonEliminaMouseClicked

    private void addMaterialiMouseClicked(java.awt.event.MouseEvent evt) {
        if (materialiScelti.contains(materialeSelezionato)) {
            return;
        }
        materialiScelti.add(materialeSelezionato);
        String s = "";
        for (String m : materialiScelti) {
            s = s + "•" + m + "\n";
        }
        materialiArea.setText(s);
    }

    private void removeMaterialiMouseClicked(java.awt.event.MouseEvent evt) {
        if (!materialiScelti.contains(materialeSelezionato)) {
            return;
        }
        materialiScelti.remove(materialeSelezionato);
        String s = "";
        for (String m : materialiScelti) {
            s = s + "•" + m + "\n";
        }
        materialiArea.setText(s);
    }

    private void jTableAttivitàMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAttivitàMouseClicked
        this.jButtonElimina.setEnabled(true);
        int s = 0;
        ArrayList<MaintainanceActivity> l = new ArrayList<>();
        try {
            l = this.p.viewMaintainanceActivity();
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        ArrayList<MaintainanceActivity> list = new ArrayList<>();
        for (MaintainanceActivity a : l) {
            if (a.getGeneralState().toString().compareTo(stato) == 0) {
                list.add(a);
            }
        }
        s = list.get(this.jTableAttività.getSelectedRow()).getSettimana();
        this.jLabel1.setText("Settimana n° " + s);
    }//GEN-LAST:event_jTableAttivitàMouseClicked

    private void statoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statoComboItemStateChanged
        if (evt.getItem().toString().compareTo("NOTSTARTED") == 0) {
            stato = "NOTSTARTED";
            this.jButtonAggiungi.setVisible(true);
            this.jButtonElimina.setVisible(true);
            this.aggiornaTabella();
        }
        if (evt.getItem().toString().compareTo("INPROGRESS") == 0) {
            stato = "INPROGRESS";
            this.jButtonAggiungi.setVisible(false);
            this.jButtonElimina.setVisible(false);
            this.aggiornaTabella();
        }
        if (evt.getItem().toString().compareTo("CLOSED") == 0) {
            stato = "CLOSED";
            this.jButtonAggiungi.setVisible(false);
            this.jButtonElimina.setVisible(true);
            this.aggiornaTabella();
        }
    }//GEN-LAST:event_statoComboItemStateChanged

    private void buttonTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTicketsMouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/tickets.png"));
        int r = JOptionPane.showConfirmDialog(this, this.ticketsButton(), "Tickets", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_OPTION, i);
    }//GEN-LAST:event_buttonTicketsMouseClicked

    private Component ticketsButton() {
        JTextField data;
        JLabel jLabelTitle;
        JScrollPane jScrollPane4;
        JTable jTable1;
        JLabel labelData;
        JLabel labelSettimana;
        JTextField settimana;
        labelSettimana = new javax.swing.JLabel();
        settimana = new javax.swing.JTextField();
        jLabelTitle = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        data = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        JPanel p = new JPanel();

        labelSettimana.setText("Settimana n° ");

        settimana.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        settimana.setEnabled(false);
        settimana.setText("");

        jLabelTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(254, 160, 36));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Assigned tickets");

        labelData.setText("Data");

        data.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        data.setEnabled(false);

        LinkedList<MaintainanceActivity> lista = new LinkedList<>();
        String query = "select activityID, nomeprocedura, descrizione, tempo, interrompibile, settimana, tipo, data, generalstate from maintainanceactivity where tipologia = '" + TipoAttività.EWO.toString() + "'";
        Object[][] a = null;
        try {
            ResultSet rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                String activityID = rst.getString("activityID");
                String nomeProcedura = rst.getString("nomeprocedura");
                String d = rst.getString("descrizione");
                int tempo = rst.getInt("tempo");
                boolean interrompibile = rst.getBoolean("interrompibile");
                int set = rst.getInt("settimana");
                String tipo = rst.getString("tipo");
                Date date = rst.getDate("data");
                String generalState = rst.getString("generalstate");
                GeneralState gs = null;
                if (generalState.compareTo(GeneralState.CLOSED.toString()) == 0) {
                    gs = GeneralState.CLOSED;
                }
                if (generalState.compareTo(GeneralState.INPROGRESS.toString()) == 0) {
                    gs = GeneralState.INPROGRESS;
                }
                if (generalState.compareTo(GeneralState.NOTSTARTED.toString()) == 0) {
                    gs = GeneralState.NOTSTARTED;
                }
                lista.add(new MaintainanceActivity(activityID, nomeProcedura, TipoAttività.EWO, d, tempo, interrompibile, set, tipo, date, gs));
                test = rst.next();

            }
            a = new Object[lista.size()][7];
            int n = 0;
            for (MaintainanceActivity m : lista) {
                a[n][0] = m.getActivityID();
                a[n][1] = m.getFactorySite() + " - " + m.getArea();
                a[n][2] = m.getTipo();
                a[n][3] = String.valueOf(m.getTempo());
                a[n][4] = m.getGeneralState().toString();
                query = "select statomaintainer from assegnazioneattivita where activityID = '" + m.getActivityID() + "'";
                rst = Query.genericQuery(query);
                test = rst.next();
                if (!test) {
                    a[n][5] = "";
                }
                while (test) {
                    a[n][5] = rst.getString("statomaintainer");
                    test = rst.next();
                }

                query = "select ticketstateforarea from possessos where activityID = '" + m.getActivityID() + "'";
                rst = Query.genericQuery(query);
                test = rst.next();
                if (!test) {
                    a[n][6] = "";
                }
                while (test) {
                    a[n][6] = rst.getString("ticketstateforarea");
                    test = rst.next();
                }
                n++;
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                a,
                new String[]{
                    "EWO ID", "Area", "Tipo", "Tempo (min)", "Stato generale", "Stato maintainer", "Stato area"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jTable1.getColumn("Stato generale").setCellRenderer(new JTable1Renderer());
        jTable1.getColumn("Stato maintainer").setCellRenderer(new JTable1Renderer());
        jTable1.getColumn("Stato area").setCellRenderer(new JTable1Renderer());

        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaintainanceActivity m = lista.get(jTable1.getSelectedRow());
                settimana.setText(String.valueOf(m.getSettimana()));
                data.setText(m.getData().toString());
            }
        });

        jScrollPane4.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(p);
        p.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(labelData)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(labelSettimana)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(settimana, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(71, 71, 71)
                                                .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                                                .addGap(73, 73, 73)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitle)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(settimana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelSettimana))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelData)
                                                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        return p;
    }

    private class JTable1Renderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
            if (col == 4) {
                if (value != null) {
                    if (value.toString().compareTo(GeneralState.NOTSTARTED.toString()) == 0) {
                        l.setBackground(Color.RED);
                    }
                    if (value.toString().compareTo(GeneralState.INPROGRESS.toString()) == 0) {
                        l.setBackground(Color.GREEN);
                    }
                    if (value.toString().compareTo(GeneralState.CLOSED.toString()) == 0) {
                        l.setBackground(Color.YELLOW);
                    }
                }
            }
            if (col == 5) {
                if (value != null) {
                    if (value.toString().compareTo(StatoMaintainer.SENT.toString()) == 0) {
                        l.setBackground(Color.RED);
                    }
                    if (value.toString().compareTo(StatoMaintainer.READ.toString()) == 0) {
                        l.setBackground(Color.GREEN);
                    }
                    if (value.toString().compareTo(StatoMaintainer.RECEIVED.toString()) == 0) {
                        l.setBackground(Color.YELLOW);
                    }
                }
            }
            if (col == 6) {
                if (value != null) {
                    if (value.toString().compareTo(TicketStateForArea.NOTSENT.toString()) == 0) {
                        l.setBackground(Color.RED);
                    }
                    if (value.toString().compareTo(TicketStateForArea.RECEIVED.toString()) == 0) {
                        l.setBackground(Color.GREEN);
                    }
                    if (value.toString().compareTo(StatoMaintainer.SENT.toString()) == 0) {
                        l.setBackground(Color.YELLOW);
                    }
                }
            }
            return l;
        }

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
            java.util.logging.Logger.getLogger(PlannerInterfaceActivitiesList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlannerInterfaceActivitiesList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlannerInterfaceActivitiesList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlannerInterfaceActivitiesList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlannerInterfaceActivitiesList().setVisible(true);
            }
        });
    }

    public void setPlanner(Planner p) {
        this.p = p;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTickets;
    private javax.swing.JButton jButtonAggiungi;
    private javax.swing.JButton jButtonElimina;
    private javax.swing.JButton jButtonEsci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAttività;
    private javax.swing.JComboBox<String> statoCombo;
    // End of variables declaration//GEN-END:variables
}

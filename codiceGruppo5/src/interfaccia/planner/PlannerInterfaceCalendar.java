//Gruppo 5
package interfaccia.planner;

import enumeratives.StatoMaintainer;
import enumeratives.TipoAttività;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import progettosegruppo5.MaintainanceActivity;
import progettosegruppo5.Planner;
import progettosegruppo5.Query;

public class PlannerInterfaceCalendar extends javax.swing.JFrame {

    private Planner p;
    private MaintainanceActivity activity;
    JTable tabellaAvailability = new JTable();
    String nomeMaintainer = null;

    /*
    Hidden feature: interface for story ID 4, story ID 15
    Alessia Carbone 0622701487
    10/12/2020 - 16/12/2020 
     */
    public PlannerInterfaceCalendar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonEsci = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldSettimana = new javax.swing.JTextField();
        jTextFieldInformazioni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelCompetenze = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCompetenze = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMaintainer = new javax.swing.JTable();
        labelTempo = new javax.swing.JLabel();
        tempoIntervento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Activities planning");
        setIconImage(new ImageIcon(getClass().getResource("/images/calendar.png")).getImage());

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

        jTextFieldSettimana.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldSettimana.setEnabled(false);

        jTextFieldInformazioni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldInformazioni.setEnabled(false);

        jLabel2.setText("Disponibilità maintainer");

        jLabelCompetenze.setText("Competenze richieste");

        jTextAreaCompetenze.setColumns(20);
        jTextAreaCompetenze.setRows(5);
        jTextAreaCompetenze.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextAreaCompetenze.setEnabled(false);
        jScrollPane1.setViewportView(jTextAreaCompetenze);

        jTableMaintainer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        /*
        jTableMaintainer.setModel(null);
        */
        jScrollPane2.setViewportView(jTableMaintainer);

        labelTempo.setText("Tempo d'intervento");

        tempoIntervento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tempoIntervento.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonEsci, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel1)))
                    .addComponent(jLabelCompetenze))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldSettimana, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelTempo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tempoIntervento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldInformazioni, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEsci)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldSettimana)
                        .addComponent(jTextFieldInformazioni)
                        .addComponent(labelTempo)
                        .addComponent(tempoIntervento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCompetenze)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEsciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEsciMouseClicked
        Icon i = new ImageIcon(getClass().getResource("/images/exit.png"));
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler uscire?", "Esci", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, i);
        if (r == JOptionPane.YES_OPTION) {
            PlannerInterfaceActivitiesList pl = new PlannerInterfaceActivitiesList();
            pl.setVisible(true);
            pl.setPlanner(this.p);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonEsciMouseClicked

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
            java.util.logging.Logger.getLogger(PlannerInterfaceCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlannerInterfaceCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlannerInterfaceCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlannerInterfaceCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlannerInterfaceCalendar().setVisible(true);
            }
        });
    }

    public void setAttributes(Planner p, MaintainanceActivity a) {
        this.p = p;
        this.activity = a;
        if(a.getTipologia().toString().compareTo(TipoAttività.EWO.toString()) != 0){
            this.labelTempo.setVisible(false);
            this.tempoIntervento.setVisible(false);
        }
        else{
            this.tempoIntervento.setText(a.getTempo() + "'");
        }
        jTextFieldSettimana.setText(String.valueOf(this.activity.getSettimana()));
        try {
            jTextFieldInformazioni.setText(this.activity.getActivityID() + " - " + this.activity.getFactorySite() + " " + this.activity.getArea() + " - " + this.activity.getTempo() + "'");
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        jTextAreaCompetenze.setText(this.getCompetenzeRichieste());
        this.aggiornaTabella();
    }

    private String getCompetenzeRichieste() {
        String s = "";
        String query = "select competenza from competenzerichieste where nomeprocedura = '" + this.activity.getNomeProcedura() + "'";
        ResultSet rst = null;
        try {
            rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                s = s + "•" + rst.getString("competenza") + "\n";
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        return s;
    }

    private Date[] getDate() {
        Date data[] = new Date[7];
        int settimana = activity.getSettimana();
        int days = settimana * 7;
        int month = 1;
        int day = 0;
        for (int i = days; i > 0;) {
            if (i >= 28) {
                switch (month) {
                    case 1:
                        month += 1;
                        i -= 31;
                        break;
                    case 2:
                        month += 1;
                        i -= 28;
                        break;
                    case 3:
                        month += 1;
                        i -= 31;
                        break;
                    case 4:
                        month += 1;
                        i -= 30;
                        break;
                    case 5:
                        month += 1;
                        i -= 31;
                        break;
                    case 6:
                        month += 1;
                        i -= 30;
                        break;
                    case 7:
                        month += 1;
                        i -= 31;
                        break;
                    case 8:
                        month += 1;
                        i -= 31;
                        break;
                    case 9:
                        month += 1;
                        i -= 30;
                        break;
                    case 10:
                        month += 1;
                        i -= 31;
                        break;
                    case 11:
                        month += 1;
                        i -= 30;
                        break;
                    case 12:
                        month += 1;
                        i -= 31;
                        break;
                }
            } else {
                day = i - 6;
                i = 0;
            }
        }
        LocalDate dataAttuale = LocalDate.now();
        int d = dataAttuale.getDayOfMonth();
        int m = dataAttuale.getMonthValue();
        int dayy = 0;
        int week = 0;
        for (int i = 1; i < m; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                dayy = dayy + 31;
            }
            if (i == 2) {
                dayy = dayy + 28;
            }
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                dayy = dayy + 30;
            }
        }
        dayy = dayy + d;
        week = dayy / 7;
        int year = 0;
        if (activity.getSettimana() < week) {
            year = 2021;
        } else {
            year = 2020;
        }
        if ((day > 25 && month == 1) || (day > 25 && month == 3) || (day > 25 && month == 5) || (day > 25 && month == 7) || (day > 25 && month == 8) || (day > 25 && month == 10) || (day > 25 && month == 12)) {
            switch (day) {
                case 26:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month, day + 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month, day + 4));
                    data[5] = Date.valueOf(LocalDate.of(year, month, day + 5));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    break;
                case 27:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month, day + 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month, day + 4));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    break;
                case 28:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month, day + 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    break;
                case 29:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 4));
                    break;
                case 30:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[3] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 4));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 5));
                    break;
                case 31:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 4));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 5));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 6));
                    break;
            }
            return data;
        } else if ((day > 24 && month == 4) || (day > 24 && month == 6) || (day > 24 && month == 9) || (day > 24 && month == 11)) {
            switch (day) {
                case 25:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month, day + 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month, day + 4));
                    data[5] = Date.valueOf(LocalDate.of(year, month, day + 5));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    break;
                case 26:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month, day + 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month, day + 4));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    break;
                case 27:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month, day + 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    break;
                case 28:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 4));
                    break;
                case 29:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[3] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 4));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 5));
                    break;
                case 30:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 4));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 5));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 6));
                    break;
            }
            return data;
        }
        if (day > 22 && month == 2) {
            switch (day) {
                case 23:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month, day + 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month, day + 4));
                    data[5] = Date.valueOf(LocalDate.of(year, month, day + 5));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    break;
                case 24:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month, day + 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month, day + 4));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    break;
                case 25:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month, day + 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    break;
                case 26:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 4));
                    break;
                case 27:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[3] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 4));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 5));
                    break;
                case 28:
                    data[0] = Date.valueOf(LocalDate.of(year, month, day));
                    data[1] = Date.valueOf(LocalDate.of(year, month + 1, 1));
                    data[2] = Date.valueOf(LocalDate.of(year, month + 1, 2));
                    data[3] = Date.valueOf(LocalDate.of(year, month + 1, 3));
                    data[4] = Date.valueOf(LocalDate.of(year, month + 1, 4));
                    data[5] = Date.valueOf(LocalDate.of(year, month + 1, 5));
                    data[6] = Date.valueOf(LocalDate.of(year, month + 1, 6));
                    break;
            }
            return data;
        }
        data[0] = Date.valueOf(LocalDate.of(year, month, day));
        data[1] = Date.valueOf(LocalDate.of(year, month, day + 1));
        data[2] = Date.valueOf(LocalDate.of(year, month, day + 2));
        data[3] = Date.valueOf(LocalDate.of(year, month, day + 3));
        data[4] = Date.valueOf(LocalDate.of(year, month, day + 4));
        data[5] = Date.valueOf(LocalDate.of(year, month, day + 5));
        data[6] = Date.valueOf(LocalDate.of(year, month, day + 6));
        return data;
    }

    private HashSet<String> getAvailableMaintainers(Date[] data) {
        HashSet<String> nomi = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            String query = "select nomemaintainer from availability where giorno = '" + data[i] + "'";
            ResultSet rst = null;
            try {
                rst = Query.genericQuery(query);
                Boolean test = rst.next();
                while (test) {
                    nomi.add(rst.getString("nomemaintainer"));
                    test = rst.next();
                }
            } catch (SQLException ex) {
                Icon icon = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, icon);
            }
        }
        return nomi;
    }

    private LinkedList<String> getCompetenzeRichieste(String nomeProcedura) {
        LinkedList<String> competenze = new LinkedList<>();
        String query = "select competenza from competenzerichieste where nomeprocedura = '" + nomeProcedura + "'";
        ResultSet rst = null;
        try {
            rst = Query.genericQuery(query);
            Boolean test = rst.next();
            while (test) {
                competenze.add(rst.getString("competenza"));
                test = rst.next();
            }
        } catch (SQLException ex) {
            Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
        }
        return competenze;
    }

    private Object[][] getModel(Date[] data, HashSet<String> nomi, LinkedList<String> competenze) {
        Object a[][] = new Object[nomi.size()][9];
        int n = 0;
        for (String maintainer : nomi) {
            LinkedList<String> competenzeMaintainer = new LinkedList<>();
            String query = "select competenza from possesso where nomemaintainer = '" + maintainer + "'";
            ResultSet rst = null;
            try {
                rst = Query.genericQuery(query);
                Boolean test = rst.next();
                while (test) {
                    competenzeMaintainer.add(rst.getString("competenza"));
                    test = rst.next();
                }
            } catch (SQLException ex) {
                Icon i = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, i);
            }
            int c = 0;
            for (String competenza : competenze) {
                if (competenzeMaintainer.contains(competenza)) {
                    c += 1;
                }
            }
            String disponibilità[] = new String[7];
            for (int i = 0; i < 7; i++) {
                query = "select min from availability where nomemaintainer = '" + maintainer + "' and giorno = '" + data[i] + "'";
                rst = null;
                try {
                    rst = Query.genericQuery(query);
                    Boolean test = rst.next();
                    if (!test) {
                        disponibilità[i] = "0%";
                    }
                    while (test) {
                        disponibilità[i] = String.valueOf((rst.getInt("min") * 100) / 420) + "%";
                        test = rst.next();
                    }
                } catch (SQLException ex) {
                    Icon icon = new ImageIcon(getClass().getResource("/images/warning.png"));
                    JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, icon);
                }
            }
            a[n][0] = maintainer;
            a[n][1] = c + "/" + competenze.size();
            a[n][2] = disponibilità[0];
            a[n][3] = disponibilità[1];
            a[n][4] = disponibilità[2];
            a[n][5] = disponibilità[3];
            a[n][6] = disponibilità[4];
            a[n][7] = disponibilità[5];
            a[n][8] = disponibilità[6];
            n++;
        }
        return a;
    }

    private void aggiornaTabella() {
        Date data[] = getDate();
        HashSet<String> nomi = getAvailableMaintainers(data);
        LinkedList<String> competenze = getCompetenzeRichieste(this.activity.getNomeProcedura());
        Object a[][] = getModel(data, nomi, competenze);
        jTableMaintainer.setModel(new javax.swing.table.DefaultTableModel(
                a,
                new String[]{
                    "Maintainer", "Competenze", data[0].toString(), data[1].toString(),
                    data[2].toString(), data[3].toString(), data[4].toString(),
                    data[5].toString(), data[6].toString()
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        
        jTableMaintainer.getColumnModel().getColumn(2).setCellRenderer(new StatusColumnCellRenderer());
        jTableMaintainer.getColumnModel().getColumn(3).setCellRenderer(new StatusColumnCellRenderer());
        jTableMaintainer.getColumnModel().getColumn(4).setCellRenderer(new StatusColumnCellRenderer());
        jTableMaintainer.getColumnModel().getColumn(5).setCellRenderer(new StatusColumnCellRenderer());
        jTableMaintainer.getColumnModel().getColumn(6).setCellRenderer(new StatusColumnCellRenderer());
        jTableMaintainer.getColumnModel().getColumn(7).setCellRenderer(new StatusColumnCellRenderer());
        jTableMaintainer.getColumnModel().getColumn(8).setCellRenderer(new StatusColumnCellRenderer());
        
        jTableMaintainer.addMouseListener(new MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if(evt.getClickCount() == 2 && (jTableMaintainer.getSelectedColumn() == 2 || jTableMaintainer.getSelectedColumn() == 3 || jTableMaintainer.getSelectedColumn() == 4 || jTableMaintainer.getSelectedColumn() == 5 || jTableMaintainer.getSelectedColumn() == 6 || jTableMaintainer.getSelectedColumn() == 7 || jTableMaintainer.getSelectedColumn() == 8)){
                        jTableCellClicked(evt);
                    }
                }
        });
    }
    
    private void jTableCellClicked(MouseEvent evt) {
        Boolean assegnabile = true;
        Icon i = new ImageIcon(getClass().getResource("/images/activity.png"));
        JOptionPane.showMessageDialog(this, this.jOptionAssegna(), "Aggiungi attività", JOptionPane.PLAIN_MESSAGE, i);
        if(nomeMaintainer == null) return;
        try {
            if(activity.getData().toString().compareTo(this.jTableMaintainer.getColumnName(this.jTableMaintainer.getSelectedColumn())) != 0){
                Icon icon = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Data non corrispondente!", "Errore", JOptionPane.ERROR_MESSAGE, icon);
                return;
            }
            if(activity.getTipologia().toString().compareTo(TipoAttività.EWO.toString()) == 0){
                Date dataAssegnata = Date.valueOf(this.jTableMaintainer.getColumnName(this.jTableMaintainer.getSelectedColumn()));
                String nomeMaintainer = this.jTableMaintainer.getValueAt(this.jTableMaintainer.getSelectedRow(),0).toString();
                LinkedList<String> attività = new LinkedList<>();
                String query = "select activityID from assegnazioneattivita where nomemaintainer = '" + nomeMaintainer + "'";
                ResultSet rst = Query.genericQuery(query);
                Boolean test = rst.next();
                while(test){
                    attività.add(rst.getString("activityID"));
                    test = rst.next();
                }
                for(String a : attività){
                    query = "select data,interrompibile from maintainanceactivity where activityID = '" + a + "'";
                    rst = Query.genericQuery(query);
                    test = rst.next();
                    while(test){
                        if(rst.getDate("data").toLocalDate().isEqual(dataAssegnata.toLocalDate()) && rst.getBoolean("interrompibile") == false){
                            assegnabile = false;
                        }
                        test = rst.next();
                    }
                }
            }
            if(assegnabile){
                this.p.setMaintainanceActivity(activity.getActivityID(), nomeMaintainer, StatoMaintainer.SENT.toString(), activity.getData(), activity.getTempo());
                String message = activity.getActivityID() + ": " + activity.getDescrizione() + ", " + activity.getTipo() + ", presso " + activity.getFactorySite() + " - " + activity.getArea() + "    tempo stimato: " + activity.getTempo() + ", " + activity.getData().toString();
                this.p.sendNotify(nomeMaintainer, message);
                i = new ImageIcon(getClass().getResource("/images/ok.png"));
                JOptionPane.showMessageDialog(this, "L'Attività n° " + activity.getActivityID() + " è stata assegnata correttamente a " + nomeMaintainer, "Assegnazione attività",JOptionPane.PLAIN_MESSAGE, i);
            }
            else{
                Icon icon = new ImageIcon(getClass().getResource("/images/warning.png"));
                JOptionPane.showMessageDialog(this, "Il maintainer è impegnato in un'attività non interrompibile!", "Errore", JOptionPane.ERROR_MESSAGE, icon);
            }
        } catch (SQLException ex) {
            Icon icon = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, icon);
        }
    }

    private Component jOptionAssegna() {
        JPanel p = new JPanel();
        JLabel labelSettimana = new JLabel("Settimana n° ");
        JTextField settimana = new JTextField(String.valueOf(this.activity.getSettimana()));
        JLabel labelData = new JLabel("Data ");
        JTextField data = new JTextField(this.jTableMaintainer.getColumnName(this.jTableMaintainer.getSelectedColumn()));
        JTextField informazioni = new JTextField();
        try{
            informazioni = new JTextField(this.activity.getActivityID() + " - " + this.activity.getFactorySite() + " " + this.activity.getArea() + " - " + this.activity.getTempo() + "'");
        } catch(SQLException ex){
            Icon icon = new ImageIcon(getClass().getResource("/images/warning.png"));
            JOptionPane.showMessageDialog(this, "Errore nel database!", "Errore", JOptionPane.ERROR_MESSAGE, icon);
        }
        JLabel labelMaintainer = new JLabel("Disponibilità " + this.jTableMaintainer.getValueAt(this.jTableMaintainer.getSelectedRow(), 0).toString());
        JTextField availability = new JTextField(this.jTableMaintainer.getValueAt(this.jTableMaintainer.getSelectedRow(), this.jTableMaintainer.getSelectedColumn()).toString());
        labelSettimana.setFont(new Font(Font.DIALOG, 0, 12));
        labelSettimana.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        labelSettimana.setSize(7, 50);
        labelData.setFont(new Font(Font.DIALOG, 0, 12));
        labelData.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        labelData.setSize(7, 50);
        labelMaintainer.setFont(new Font(Font.DIALOG, 0, 12));
        labelMaintainer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        labelMaintainer.setSize(7, 50);
        settimana.setFont(new Font(Font.DIALOG, 0, 12));
        settimana.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        settimana.setSize(7, 50);
        settimana.setEnabled(false);
        data.setFont(new Font(Font.DIALOG, 0, 12));
        data.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        data.setSize(7, 50);
        data.setEnabled(false);
        availability.setFont(new Font(Font.DIALOG, 0, 12));
        availability.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        availability.setSize(7, 50);
        availability.setEnabled(false);
        informazioni.setFont(new Font(Font.DIALOG, 0, 12));
        informazioni.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        informazioni.setSize(7, 50);
        informazioni.setEnabled(false);
        tabellaAvailability.setFont(new Font(Font.DIALOG, 0, 12));
        tabellaAvailability.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        String disponibilità = this.jTableMaintainer.getValueAt(this.jTableMaintainer.getSelectedRow(), this.jTableMaintainer.getSelectedColumn()).toString();
        int d = 0;
        if(disponibilità.length() == 4) d = Integer.valueOf(disponibilità.substring(0,3));
        if(disponibilità.length() == 3) d = Integer.valueOf(disponibilità.substring(0,2));
        if(disponibilità.length() == 2) d = Integer.valueOf(disponibilità.substring(0,1));
        int minuti = (420 * d)/100;
        Object a[][] = new Object[1][9];
        a[0][0] = this.jTableMaintainer.getValueAt(this.jTableMaintainer.getSelectedRow(), 0).toString();
        a[0][1] = this.jTableMaintainer.getValueAt(this.jTableMaintainer.getSelectedRow(), 1).toString();
        if(minuti >= 60) {
            a[0][2] = 60;
            minuti = minuti - 60;
        }
        else {
            a[0][2] = minuti;
            minuti = 0;
        }
        if(minuti >= 60) {
            a[0][3] = 60;
            minuti = minuti - 60;
        }
        else {
            a[0][3] = minuti;
            minuti = 0;
        }
        if(minuti >= 60) {
            a[0][4] = 60;
            minuti = minuti - 60;
        }
        else {
            a[0][4] = minuti;
            minuti = 0;
        }
        if(minuti >= 60) {
            a[0][5] = 60;
            minuti = minuti - 60;
        }
        else {
            a[0][5] = minuti;
            minuti = 0;
        }
        if(minuti >= 60) {
            a[0][6] = 60;
            minuti = minuti - 60;
        }
        else {
            a[0][6] = minuti;
            minuti = 0;
        }
        if(minuti >= 60) {
            a[0][7] = 60;
            minuti = minuti - 60;
        }
        else {
            a[0][7] = minuti;
            minuti = 0;
        }
        if(minuti >= 60) {
            a[0][8] = 60;
        }
        else {
            a[0][8] = minuti;
        }
        tabellaAvailability.setModel(new javax.swing.table.DefaultTableModel(
                a,
                new String[]{
                    "Nome maintainer", "Competenze", "8:00 - 9:00", "9:00 - 10:00", "10:00 - 11:00",
                    "11:00 - 12:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00"                        
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabellaAvailability.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (tabellaAvailability.getSelectedColumn() != 0 && tabellaAvailability.getSelectedColumn() != 1 && evt.getClickCount() == 2) {
                    jButtonSelezionaMouseClicked(evt);
                }
            }
        });
        tabellaAvailability.getColumnModel().getColumn(2).setCellRenderer(new StatusColumn());
        tabellaAvailability.getColumnModel().getColumn(3).setCellRenderer(new StatusColumn());
        tabellaAvailability.getColumnModel().getColumn(4).setCellRenderer(new StatusColumn());
        tabellaAvailability.getColumnModel().getColumn(5).setCellRenderer(new StatusColumn());
        tabellaAvailability.getColumnModel().getColumn(6).setCellRenderer(new StatusColumn());
        tabellaAvailability.getColumnModel().getColumn(7).setCellRenderer(new StatusColumn());
        tabellaAvailability.getColumnModel().getColumn(8).setCellRenderer(new StatusColumn());
        
        JScrollPane jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(tabellaAvailability);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(p);
        p.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelMaintainer, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(availability, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelSettimana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(settimana, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(informazioni))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSettimana)
                    .addComponent(settimana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelData)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaintainer)
                    .addComponent(informazioni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availability, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        return p;
    }
    
    public class StatusColumn extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
            if(Integer.valueOf(value.toString()) >= 50){
                l.setBackground(Color.GREEN);
                return l;
            }
            if(Integer.valueOf(value.toString()) >= 30 && Integer.valueOf(value.toString()) < 50){
                l.setBackground(Color.YELLOW);
                return l;
            }
            if(Integer.valueOf(value.toString()) >= 20 && Integer.valueOf(value.toString()) < 30){
                l.setBackground(Color.ORANGE);
                return l;
            }
            if(Integer.valueOf(value.toString()) < 20){
                l.setBackground(Color.RED);
                return l;
            }
            return l;
        }
    }
    
    private void jButtonSelezionaMouseClicked(java.awt.event.MouseEvent evt) {
        Icon i = new ImageIcon(getClass().getResource("/images/question.png"));
        int r = JOptionPane.showConfirmDialog(this, "Vuoi assegnare l'attività?", "Assegnazione attività",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, i);
        if(JOptionPane.YES_OPTION == r){
            nomeMaintainer = jTableMaintainer.getValueAt(this.jTableMaintainer.getSelectedRow(),0).toString();
        }
        else{
            nomeMaintainer = null;
        }
    }

    public class StatusColumnCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
            if(value.toString().length() == 4){
                l.setBackground(Color.GREEN);
                return l;
            }
            if(value.toString().length() == 2){
                l.setBackground(Color.RED);
                return l;
            }
            if(Integer.valueOf(value.toString().substring(0,1)) > 9 && Integer.valueOf(value.toString().substring(0,1)) < 26){
                l.setBackground(Color.ORANGE);
                return l;
            }
            l.setBackground(Color.YELLOW);
            return l;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEsci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCompetenze;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMaintainer;
    private javax.swing.JTextArea jTextAreaCompetenze;
    private javax.swing.JTextField jTextFieldInformazioni;
    private javax.swing.JTextField jTextFieldSettimana;
    private javax.swing.JLabel labelTempo;
    private javax.swing.JTextField tempoIntervento;
    // End of variables declaration//GEN-END:variables
}

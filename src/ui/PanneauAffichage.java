/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modele.ImageErreur;
import modele.ListeQuestions;
import modele.QCM;
import modele.ResultatExecution;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class PanneauAffichage extends javax.swing.JPanel {

    private ListeQuestions listeQuestions;
    private DefaultTableModel model;

    //Constructeur
    public PanneauAffichage(ListeQuestions listeQuestions) {
        this.listeQuestions = listeQuestions;
        initComponents();
        setBounds(3, 30, 980, 595);
        
        listerQuestions(listeQuestions);
    }

    // afficher les questions dans la table
    private void listerQuestions(ListeQuestions listeQuestions1) {
        JTableHeader header = tableListing.getTableHeader();
        header.setBackground(new java.awt.Color(204, 102, 204));
        header.setForeground(new java.awt.Color(0, 102, 102));
        header.setFont(new Font("Arial", 1, 17));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        tableListing.setFont(new Font("Arial", 0, 15));
        tableListing.setRowHeight(31);

        model = (DefaultTableModel) tableListing.getModel();

        chargerTable();
        ajusterHauteurLignes();
    }

    //pour charger la table
    private void chargerTable() {
        viderTable();
        QCM maQCM;
        ImageErreur maQuesImg;
        ResultatExecution maQuesRes;

        int num;
        String titre;
        String question;
        for (int i = 0; i < listeQuestions.getSize(); i++) { //parcour du mon Map
            num = listeQuestions.getQuestionN(listeQuestions.tableauCles()[i]).getNumQuestion();
            titre = listeQuestions.getQuestionN(num).getTitre();
            if (checkBoxQCM.isSelected() && titre.equals("Choisir la ou les bonnes réponses")) {
                maQCM = (QCM) (listeQuestions.getQuestionN(num));
                model.insertRow(model.getRowCount(), new Object[]{num, "<html>" + titre + "</html>", "<html>" + maQCM.getLaQuestion() + "</html>"});
            } 
            else if (checkBoxErreur.isSelected() && titre.equals("Trouver l'erreur dans ce code")) {
                maQuesImg = (ImageErreur) (listeQuestions.getQuestionN(listeQuestions.tableauCles()[i]));
                model.insertRow(model.getRowCount(), new Object[]{num, "<html>" + titre + "</html>", "<html>" + maQuesImg.getlImage() + "</html>"});
            } 
            else if (checkBoxResultat.isSelected() && titre.equals("Trouver le resultat d'execution de ce code")) {
                maQuesRes = (ResultatExecution) (listeQuestions.getQuestionN(listeQuestions.tableauCles()[i]));
                model.insertRow(model.getRowCount(), new Object[]{num, "<html>" + titre + "</html>", "<html>" + maQuesRes.getQuestion()+ "</html>"});
            }
        }
        ajusterHauteurLignes();
    }
    
    // ajuster l'hauteur des lignes de la table
    private void ajusterHauteurLignes() {
        //ajuster l<hauteur des lignes de tableau
        for (int i = 0; i < tableListing.getRowCount(); i++) {
            if (tableListing.getModel().getValueAt(i, 2).toString().length() > 90) {
                tableListing.setRowHeight(i, 65);
            }
        }
    }

    private void viderTable() {
        for (int i = tableListing.getRowCount(); i > 0; i--) {
            model.removeRow(i - 1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHaut = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        pnlBas = new javax.swing.JPanel();
        checkBoxQCM = new javax.swing.JCheckBox();
        checkBoxErreur = new javax.swing.JCheckBox();
        checkBoxResultat = new javax.swing.JCheckBox();
        scrollPnlTable = new javax.swing.JScrollPane();
        tableListing = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setPreferredSize(new java.awt.Dimension(980, 595));
        setLayout(null);

        pnlHaut.setBackground(new java.awt.Color(0, 102, 102));
        pnlHaut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlHaut.setPreferredSize(new java.awt.Dimension(980, 75));
        pnlHaut.setLayout(null);

        lblTitre.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblTitre.setForeground(new java.awt.Color(255, 255, 255));
        lblTitre.setText("Liste des questions");
        pnlHaut.add(lblTitre);
        lblTitre.setBounds(331, 22, 250, 31);

        add(pnlHaut);
        pnlHaut.setBounds(0, 0, 980, 75);

        pnlBas.setBackground(new java.awt.Color(204, 255, 204));
        pnlBas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlBas.setPreferredSize(new java.awt.Dimension(980, 480));
        pnlBas.setLayout(null);

        checkBoxQCM.setBackground(new java.awt.Color(204, 255, 204));
        checkBoxQCM.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        checkBoxQCM.setSelected(true);
        checkBoxQCM.setText("Questions à choix multiple");
        checkBoxQCM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });
        pnlBas.add(checkBoxQCM);
        checkBoxQCM.setBounds(20, 10, 240, 27);

        checkBoxErreur.setBackground(new java.awt.Color(204, 255, 204));
        checkBoxErreur.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        checkBoxErreur.setSelected(true);
        checkBoxErreur.setText("Trouver l'erreur dans le code");
        checkBoxErreur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });
        pnlBas.add(checkBoxErreur);
        checkBoxErreur.setBounds(290, 10, 250, 27);

        checkBoxResultat.setBackground(new java.awt.Color(204, 255, 204));
        checkBoxResultat.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        checkBoxResultat.setSelected(true);
        checkBoxResultat.setText("Trouver le resultat d'execution ?");
        checkBoxResultat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });
        pnlBas.add(checkBoxResultat);
        checkBoxResultat.setBounds(580, 10, 270, 27);

        tableListing.setAutoCreateRowSorter(true);
        tableListing.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        tableListing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Titre", "Question"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableListing.setColumnSelectionAllowed(true);
        tableListing.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tableListing.setShowGrid(true);
        tableListing.setSurrendersFocusOnKeystroke(true);
        scrollPnlTable.setViewportView(tableListing);
        tableListing.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tableListing.getColumnModel().getColumnCount() > 0) {
            tableListing.getColumnModel().getColumn(0).setMaxWidth(50);
            tableListing.getColumnModel().getColumn(1).setMinWidth(310);
            tableListing.getColumnModel().getColumn(1).setMaxWidth(310);
        }

        pnlBas.add(scrollPnlTable);
        scrollPnlTable.setBounds(1, 50, 978, 469);

        add(pnlBas);
        pnlBas.setBounds(0, 75, 980, 520);
    }// </editor-fold>//GEN-END:initComponents

    // Filtrer avec les CheckBox
    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed

        checkBoxQCM.setFont(new java.awt.Font("Tahoma", (checkBoxQCM.isSelected()) ? 1 : 0, 15));
        checkBoxErreur.setFont(new java.awt.Font("Tahoma", (checkBoxErreur.isSelected()) ? 1 : 0, 15));
        checkBoxResultat.setFont(new java.awt.Font("Tahoma", (checkBoxResultat.isSelected()) ? 1 : 0, 15));

        chargerTable();
    }//GEN-LAST:event_checkBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxErreur;
    private javax.swing.JCheckBox checkBoxQCM;
    private javax.swing.JCheckBox checkBoxResultat;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlHaut;
    private javax.swing.JScrollPane scrollPnlTable;
    private javax.swing.JTable tableListing;
    // End of variables declaration//GEN-END:variables
}

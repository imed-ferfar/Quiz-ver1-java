/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.ajout_modification;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import modele.ImageErreur;
import modele.ListeQuestions;
import modele.QCM;
import modele.ResultatExecution;
import utils.QuestionDejaPresenteException;

/**
 *
 * @author BaDRi
 */
public class PanneauModification extends javax.swing.JPanel {

    private PanneauAjoutQCM monPanQCM;
    private PanneauAjoutQuesImg monPanQuesImg;
    private PanneauAjoutQuesRes monPanQuesRes;

    private JLabel lblType;
    private ListeQuestions listeQuestions;
    private QCM maQCM;
    private ImageErreur maQuesImg;
    private ResultatExecution maQuesRes;
    private DefaultTableModel model;
    private boolean etatManip;

    public PanneauModification(ListeQuestions listeQuestions) {
        this.listeQuestions = listeQuestions;
        initComponents();
        setBounds(3, 0, 980, 595);
        listerQuestions(listeQuestions);
        System.out.println(String.valueOf(listeQuestions.getSize()));

        monPanQCM = new PanneauAjoutQCM();
        pnlCentre.add(monPanQCM);
        tabbedP.setEnabledAt(3, false);
        tabbedP.setEnabledAt(2, false);

    }

    //filter par le mot clé
    private void filtrerTable(String motCle) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tableListing.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(motCle));
        ajusterHauteurLignes();
    }

    // preparer la table
    private void listerQuestions(ListeQuestions listeQuestions1) {
        JTableHeader header = tableListing.getTableHeader();
        header.setBackground(new java.awt.Color(0, 102, 102));
        header.setForeground(new java.awt.Color(0, 102, 102));
        header.setFont(new Font("Arial", 1, 17));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        tableListing.setFont(new Font("Arial", 0, 15));
        tableListing.setRowHeight(31);
        model = (DefaultTableModel) tableListing.getModel();
        chargerTable();
    }

    // remplir la table
    private void chargerTable() {
        viderTable();
        QCM maQCM;
        ImageErreur maQuesImg;
        ResultatExecution maQuesRes;

        int num;
        String titre;
        String question;
        for (int i = 0; i < listeQuestions.getSize(); i++) {
            num = listeQuestions.getQuestionN(listeQuestions.tableauCles()[i]).getNumQuestion();
            titre = listeQuestions.getQuestionN(listeQuestions.tableauCles()[i]).getTitre();
            if (checkBoxQCM.isSelected() && titre.equals("Choisir la ou les bonnes réponses")) {
                maQCM = (QCM) (listeQuestions.getQuestionN(listeQuestions.tableauCles()[i]));
                model.insertRow(model.getRowCount(), new Object[]{num, "<html>" + titre + "</html>", "<html>" + maQCM.getLaQuestion() + "</html>"});
            } else if (checkBoxErreur.isSelected() && titre.equals("Trouver l'erreur dans ce code")) {
                maQuesImg = (ImageErreur) (listeQuestions.getQuestionN(listeQuestions.tableauCles()[i]));
                model.insertRow(model.getRowCount(), new Object[]{num, "<html>" + titre + "</html>", "<html>" + maQuesImg.getlImage() + "</html>"});
            } else if (checkBoxResultat.isSelected() && titre.equals("Trouver le resultat d'execution de ce code")) {
                maQuesRes = (ResultatExecution) (listeQuestions.getQuestionN(listeQuestions.tableauCles()[i]));
                model.insertRow(model.getRowCount(), new Object[]{num, "<html>" + titre + "</html>", "<html>" + maQuesRes.getQuestion() + "</html>"});
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

    // pour vider la table
    private void viderTable() {
        for (int i = tableListing.getRowCount(); i > 0; i--) {
            model.removeRow(i - 1);
        }
    }

    public boolean isEtatManip() {
        return etatManip;
    }

    public void setEtatManip(boolean etatManip) {
        this.etatManip = etatManip;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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
        pnlBouton = new javax.swing.JPanel();
        btnAjouter = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        tabbedP = new javax.swing.JTabbedPane();
        pnlListe = new javax.swing.JPanel();
        checkBoxQCM = new javax.swing.JCheckBox();
        checkBoxErreur = new javax.swing.JCheckBox();
        checkBoxResultat = new javax.swing.JCheckBox();
        txtRecherche = new javax.swing.JTextField();
        scrollPnlTable = new javax.swing.JScrollPane();
        tableListing = new javax.swing.JTable();
        lblIcon = new javax.swing.JLabel();
        pnlRecap = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblRecap3 = new javax.swing.JLabel();
        txtQCM = new javax.swing.JTextField();
        lblRecap4 = new javax.swing.JLabel();
        txtQuesImg = new javax.swing.JTextField();
        lblRecap5 = new javax.swing.JLabel();
        txtResExe = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblRecap1 = new javax.swing.JLabel();
        lblRecap2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblRecap6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        pnlAjout = new javax.swing.JPanel();
        pnlBas = new javax.swing.JPanel();
        btnConfirmer = new javax.swing.JButton();
        btnReinitialiser = new javax.swing.JButton();
        btnAnnulerA = new javax.swing.JButton();
        comboBoxType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        pnlCentre = new javax.swing.JPanel();
        pnlModifier = new javax.swing.JPanel();
        pnlBasModif = new javax.swing.JPanel();
        btnConfirmerModif = new javax.swing.JButton();
        btnAnnulerM = new javax.swing.JButton();
        pnlCentreModif = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        lbl2 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setPreferredSize(new java.awt.Dimension(980, 595));
        setLayout(null);

        pnlHaut.setBackground(new java.awt.Color(0, 102, 102));
        pnlHaut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlHaut.setPreferredSize(new java.awt.Dimension(980, 75));
        pnlHaut.setLayout(null);

        lblTitre.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblTitre.setForeground(new java.awt.Color(255, 255, 255));
        lblTitre.setText("Gérer les questions");
        pnlHaut.add(lblTitre);
        lblTitre.setBounds(365, 5, 250, 35);

        add(pnlHaut);
        pnlHaut.setBounds(0, 0, 980, 45);

        pnlBouton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlBouton.setLayout(null);

        btnAjouter.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAjouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Add-icon (1).png"))); // NOI18N
        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });
        pnlBouton.add(btnAjouter);
        btnAjouter.setBounds(130, 7, 150, 31);

        btnModifier.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-undo-icon.png"))); // NOI18N
        btnModifier.setText("Modifier");
        btnModifier.setEnabled(false);
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });
        pnlBouton.add(btnModifier);
        btnModifier.setBounds(415, 7, 150, 31);

        btnSupprimer.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Close-icon.png"))); // NOI18N
        btnSupprimer.setText("Supprimer");
        btnSupprimer.setEnabled(false);
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });
        pnlBouton.add(btnSupprimer);
        btnSupprimer.setBounds(700, 7, 150, 31);

        add(pnlBouton);
        pnlBouton.setBounds(0, 45, 980, 45);

        tabbedP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabbedP.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N

        pnlListe.setBackground(new java.awt.Color(156, 204, 101));
        pnlListe.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlListe.setPreferredSize(new java.awt.Dimension(975, 480));
        pnlListe.setLayout(null);

        checkBoxQCM.setBackground(new java.awt.Color(156, 204, 101));
        checkBoxQCM.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        checkBoxQCM.setSelected(true);
        checkBoxQCM.setText("Questions à choix multiple");
        checkBoxQCM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });
        pnlListe.add(checkBoxQCM);
        checkBoxQCM.setBounds(1, 9, 210, 25);

        checkBoxErreur.setBackground(new java.awt.Color(156, 204, 101));
        checkBoxErreur.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        checkBoxErreur.setSelected(true);
        checkBoxErreur.setText("Trouver l'erreur dans le code");
        checkBoxErreur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });
        pnlListe.add(checkBoxErreur);
        checkBoxErreur.setBounds(210, 9, 230, 25);

        checkBoxResultat.setBackground(new java.awt.Color(156, 204, 101));
        checkBoxResultat.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        checkBoxResultat.setSelected(true);
        checkBoxResultat.setText("Trouver le resultat d'execution ?");
        checkBoxResultat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });
        pnlListe.add(checkBoxResultat);
        checkBoxResultat.setBounds(450, 9, 270, 25);

        txtRecherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRechercheKeyReleased(evt);
            }
        });
        pnlListe.add(txtRecherche);
        txtRecherche.setBounds(750, 7, 210, 29);

        tableListing.setAutoCreateRowSorter(true);
        tableListing.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        tableListing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Titre", "Question"
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
        tableListing.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tableListingMouseMoved(evt);
            }
        });
        scrollPnlTable.setViewportView(tableListing);
        tableListing.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tableListing.getColumnModel().getColumnCount() > 0) {
            tableListing.getColumnModel().getColumn(0).setMaxWidth(55);
            tableListing.getColumnModel().getColumn(1).setMinWidth(310);
            tableListing.getColumnModel().getColumn(1).setMaxWidth(310);
        }

        pnlListe.add(scrollPnlTable);
        scrollPnlTable.setBounds(1, 43, 973, 420);

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search-icon (2).png"))); // NOI18N
        lblIcon.setText("jLabel2");
        lblIcon.setToolTipText("");
        pnlListe.add(lblIcon);
        lblIcon.setBounds(718, 6, 32, 32);

        tabbedP.addTab("Liste des question   ", pnlListe);

        pnlRecap.setLayout(null);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridLayout(3, 2));

        lblRecap3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblRecap3.setText("Choisir la ou les bonnes réponses");
        jPanel2.add(lblRecap3);

        txtQCM.setEditable(false);
        txtQCM.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        txtQCM.setText(String.valueOf(listeQuestions.getSizeQCM()));
        jPanel2.add(txtQCM);

        lblRecap4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblRecap4.setText("Trouver l'erreur dans ce code");
        jPanel2.add(lblRecap4);

        txtQuesImg.setEditable(false);
        txtQuesImg.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        txtQuesImg.setText(String.valueOf(listeQuestions.getSizeImg()));
        jPanel2.add(txtQuesImg);

        lblRecap5.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        lblRecap5.setText("Trouver le resultat d'execution de ce code");
        jPanel2.add(lblRecap5);

        txtResExe.setEditable(false);
        txtResExe.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        txtResExe.setText(String.valueOf(listeQuestions.getSizeRes()));
        jPanel2.add(txtResExe);

        pnlRecap.add(jPanel2);
        jPanel2.setBounds(110, 90, 770, 120);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        lblRecap1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        lblRecap1.setText("Type de question");
        jPanel3.add(lblRecap1);

        lblRecap2.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        lblRecap2.setText("Nombre de question");
        jPanel3.add(lblRecap2);

        pnlRecap.add(jPanel3);
        jPanel3.setBounds(140, 40, 650, 40);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        lblRecap6.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        lblRecap6.setText("Total");
        jPanel4.add(lblRecap6);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 102, 102));
        txtTotal.setText(String.valueOf(listeQuestions.getSize()));
        jPanel4.add(txtTotal);

        pnlRecap.add(jPanel4);
        jPanel4.setBounds(110, 250, 770, 40);

        tabbedP.addTab("Recapitulatif des questions   ", pnlRecap);

        pnlAjout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        pnlAjout.setForeground(new java.awt.Color(0, 102, 102));
        pnlAjout.setPreferredSize(new java.awt.Dimension(980, 505));
        pnlAjout.setLayout(null);

        pnlBas.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlBas.setLayout(null);

        btnConfirmer.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnConfirmer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Add-icon (1).png"))); // NOI18N
        btnConfirmer.setText("Soumettre");
        btnConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmerActionPerformed(evt);
            }
        });
        pnlBas.add(btnConfirmer);
        btnConfirmer.setBounds(760, 10, 150, 29);

        btnReinitialiser.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnReinitialiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Reset-icon.png"))); // NOI18N
        btnReinitialiser.setText("Réinitialiser");
        btnReinitialiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReinitialiserActionPerformed(evt);
            }
        });
        pnlBas.add(btnReinitialiser);
        btnReinitialiser.setBounds(380, 10, 150, 29);

        btnAnnulerA.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAnnulerA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Go-back-icon.png"))); // NOI18N
        btnAnnulerA.setText("Annuler");
        btnAnnulerA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerMAActionPerformed(evt);
            }
        });
        pnlBas.add(btnAnnulerA);
        btnAnnulerA.setBounds(40, 10, 150, 29);

        pnlAjout.add(pnlBas);
        pnlBas.setBounds(0, 420, 970, 50);

        comboBoxType.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        comboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Question à choix multiple", "Trouver l'erreur dans le code", "Trouver le resultat d'execution" }));
        comboBoxType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxTypeItemStateChanged(evt);
            }
        });
        pnlAjout.add(comboBoxType);
        comboBoxType.setBounds(520, 13, 310, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel1.setText("Choisir le type de question :");
        pnlAjout.add(jLabel1);
        jLabel1.setBounds(130, 13, 270, 30);
        pnlAjout.add(pnlCentre);
        pnlCentre.setBounds(0, 65, 970, 355);

        tabbedP.addTab("Ajouter question   ", pnlAjout);

        pnlModifier.setLayout(null);

        pnlBasModif.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlBasModif.setLayout(null);

        btnConfirmerModif.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnConfirmerModif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-undo-icon.png"))); // NOI18N
        btnConfirmerModif.setText("Soumettre");
        btnConfirmerModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmerModifActionPerformed(evt);
            }
        });
        pnlBasModif.add(btnConfirmerModif);
        btnConfirmerModif.setBounds(760, 10, 150, 29);

        btnAnnulerM.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAnnulerM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Go-back-icon.png"))); // NOI18N
        btnAnnulerM.setText("Annuler");
        btnAnnulerM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerMAActionPerformed(evt);
            }
        });
        pnlBasModif.add(btnAnnulerM);
        btnAnnulerM.setBounds(40, 10, 150, 29);

        pnlModifier.add(pnlBasModif);
        pnlBasModif.setBounds(0, 420, 970, 50);

        pnlCentreModif.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlModifier.add(pnlCentreModif);
        pnlCentreModif.setBounds(0, 65, 970, 355);

        lbl1.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        lbl1.setText("Modification de la question № : ");
        pnlModifier.add(lbl1);
        lbl1.setBounds(40, 21, 290, 31);

        txtNum.setEditable(false);
        txtNum.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        txtNum.setText("000");
        txtNum.setOpaque(false);
        pnlModifier.add(txtNum);
        txtNum.setBounds(340, 21, 55, 31);

        lbl2.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        lbl2.setText("de type : ");
        pnlModifier.add(lbl2);
        lbl2.setBounds(410, 20, 90, 31);

        txtType.setEditable(false);
        txtType.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        txtType.setOpaque(false);
        pnlModifier.add(txtType);
        txtType.setBounds(505, 20, 430, 31);

        tabbedP.addTab("Modifier question", pnlModifier);

        add(tabbedP);
        tabbedP.setBounds(0, 90, 980, 505);
    }// </editor-fold>//GEN-END:initComponents

    // filter par les checkBox
    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed

        checkBoxQCM.setFont(new java.awt.Font("Tahoma", (checkBoxQCM.isSelected()) ? 1 : 0, 15));
        checkBoxErreur.setFont(new java.awt.Font("Tahoma", (checkBoxErreur.isSelected()) ? 1 : 0, 15));
        checkBoxResultat.setFont(new java.awt.Font("Tahoma", (checkBoxResultat.isSelected()) ? 1 : 0, 15));
        chargerTable();
    }//GEN-LAST:event_checkBoxActionPerformed

    //Bouton ajouter une question
    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        tabbedP.setSelectedIndex(2);
        tabbedP.setEnabledAt(2, true);
        comboBoxType.setSelectedIndex(0);
        // repaint();
    }//GEN-LAST:event_btnAjouterActionPerformed

    //Bouton modifier une question
    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        pnlCentreModif.removeAll();
        tabbedP.setEnabledAt(3, true);
        tabbedP.setSelectedIndex(3);
        int cle = Integer.valueOf(String.valueOf(tableListing.getModel().getValueAt(tableListing.getSelectedRow(), 0)));
        String titre = listeQuestions.getQuestionN(cle).getTitre();
        txtNum.setText(Integer.toString(cle));
        txtType.setText(titre);
        switch (titre) {
            case "Choisir la ou les bonnes réponses":
                monPanQCM = new PanneauAjoutQCM((QCM) listeQuestions.getQuestionN(cle));
                pnlCentreModif.add(monPanQCM);
                break;
            case "Trouver l'erreur dans ce code":
                monPanQuesImg = new PanneauAjoutQuesImg((ImageErreur) listeQuestions.getQuestionN(cle));
                pnlCentreModif.add(monPanQuesImg);
                break;
            case "Trouver le resultat d'execution de ce code":
                monPanQuesRes = new PanneauAjoutQuesRes((ResultatExecution) listeQuestions.getQuestionN(cle));
                pnlCentreModif.add(monPanQuesRes);
                break;
        }
        // repaint();
    }//GEN-LAST:event_btnModifierActionPerformed

    //bouton réinatialiser
    private void btnReinitialiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReinitialiserActionPerformed
        switch (comboBoxType.getSelectedIndex()) {
            case 0:
                monPanQCM.reinitialiser();
                break;
            case 1:
                monPanQuesImg.reinitialiser();
                break;
            case 2:
                monPanQuesRes.reinitialiser();
                break;
        }
    }//GEN-LAST:event_btnReinitialiserActionPerformed
// bouton confirmer (Ajout)
    private void btnConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmerActionPerformed
        boolean flag = false;
        switch (comboBoxType.getSelectedIndex()) {
            case 0:
                if (monPanQCM.validerData()) {
                    int numQuestion = listeQuestions.nouveauNumQuestion();
                    String titre = listeQuestions.getTypeQuestion()[0];
                    String laQuestion = monPanQCM.getTxtQuestion().getText();
                    maQCM = new QCM(numQuestion, titre, laQuestion);
                    String choix;
                    int nombreChoix = monPanQCM.getListeChoix().size();

                    for (int i = 0; i < nombreChoix; i++) {
                        choix = monPanQCM.getListeChoix().get(i).getText();
                        maQCM.ajouterChoix(choix);
                    }
                    maQCM.creerReponses();
                    for (int i = 0; i < nombreChoix; i++) {
                        if (monPanQCM.getListeBonnesReponses().get(i).isSelected()) {
                            maQCM.faireChoix(i);
                        }
                    }
                    System.out.println(maQCM.toString());
                    try {
                        listeQuestions.ajouterQuestion(maQCM);
                        flag = true;
                    } catch (QuestionDejaPresenteException e) {
                        JOptionPane.showMessageDialog(null, e.getQues().toString(),
                                "Erreur ajout", JOptionPane.ERROR_MESSAGE);
                        flag = false;
                    } finally {
                        if (flag) {
                            JOptionPane.showMessageDialog(null, "La question N :  " + maQCM.getNumQuestion() + " a été bien ajouteé :\n"
                                    + "\n" + "     Titre: " + maQCM.getTitre() + "\n" + "     La question: " + maQCM.getLaQuestion(),
                                    "Question ajoutée avec succès", JOptionPane.INFORMATION_MESSAGE);
                            etatManip = true;
                        }
                    }
                    monPanQCM.reinitialiser();
                }

                break;
            case 1:
                if (monPanQuesImg.validerData()) {
                    int numQuestion = listeQuestions.nouveauNumQuestion();
                    String titre = listeQuestions.getTypeQuestion()[1];
                    String laQuestion = monPanQuesImg.getPathImage();
                    int numErreur = monPanQuesImg.getNumLigneErreur();
                    String erreur = monPanQuesImg.getErreur();
                    String correction = monPanQuesImg.getCorrection();
                    maQuesImg = new ImageErreur(numQuestion, titre, laQuestion, 1);
                    maQuesImg.creerReponses();
                    String[] tab = {String.valueOf(numErreur), erreur, correction};
                    maQuesImg.ajouterCorrigeErreur(tab);
                    try {
                        listeQuestions.ajouterQuestion(maQuesImg);
                        flag = true;
                    } catch (QuestionDejaPresenteException e) {
                        JOptionPane.showMessageDialog(null, e.getQues().toString(),
                                "Erreur ajout", JOptionPane.ERROR_MESSAGE);
                        flag = false;
                    } finally {
                        if (flag) {
                            JOptionPane.showMessageDialog(null, "La question N :  " + maQuesImg.getNumQuestion() + " a été bien ajouteé :\n"
                                    + "\n" + "     Titre: " + maQuesImg.getTitre() + "\n" + "     La question: " + maQuesImg.getlImage(),
                                    "Question ajoutée avec succès", JOptionPane.INFORMATION_MESSAGE);
                            etatManip = true;
                        }
                    }
                    monPanQuesImg.reinitialiser();
                }
                break;
            case 2:
                if (monPanQuesRes.validerData()) {
                    int numQuestion = listeQuestions.nouveauNumQuestion();
                    String titre = listeQuestions.getTypeQuestion()[2];
                    String laQuestion = monPanQuesRes.getTxtAreaQuestion().getText();
                    String reponse = monPanQuesRes.getTxtResultat().getText();
                    maQuesRes = new ResultatExecution(numQuestion, titre, laQuestion, reponse);
                    try {
                        listeQuestions.ajouterQuestion(maQuesRes);
                        flag = true;
                    } catch (QuestionDejaPresenteException e) {
                        JOptionPane.showMessageDialog(null, e.getQues().toString(),
                                "Erreur ajout", JOptionPane.ERROR_MESSAGE);
                        flag = false;
                    } finally {
                        if (flag) {
                            JOptionPane.showMessageDialog(null, "La question N :  " + maQuesRes.getNumQuestion() + " a été bien ajouteé :\n"
                                    + "\n" + "     Titre: " + maQuesRes.getTitre() + "\n" + "     La question: " + maQuesRes.getQuestion(),
                                    "Question ajoutée avec succès", JOptionPane.INFORMATION_MESSAGE);
                            etatManip = true;
                        }
                    }
                    monPanQuesRes.reinitialiser();
                }
                break;
        }

    }//GEN-LAST:event_btnConfirmerActionPerformed

    private void comboBoxTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxTypeItemStateChanged
        pnlCentre.removeAll();
        switch (comboBoxType.getSelectedIndex()) {
            case 0:
                monPanQCM = new PanneauAjoutQCM();
                pnlCentre.add(monPanQCM);
                break;
            case 1:
                monPanQuesImg = new PanneauAjoutQuesImg(listeQuestions);
                pnlCentre.add(monPanQuesImg);
                break;
            case 2:
                monPanQuesRes = new PanneauAjoutQuesRes();
                pnlCentre.add(monPanQuesRes);
                break;
        }
        repaint();
    }//GEN-LAST:event_comboBoxTypeItemStateChanged
    // zone texte de recherche
    private void txtRechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRechercheKeyReleased
        String motCle = txtRecherche.getText();
        filtrerTable(motCle);
    }//GEN-LAST:event_txtRechercheKeyReleased

    private void tableListingMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListingMouseMoved
        if ((tableListing.getSelectedRows().length) == 1) {
            // System.out.println("onnn");
            btnModifier.setEnabled(true);
            btnSupprimer.setEnabled(true);

        } else {
            //  System.out.println("offf");
            btnModifier.setEnabled(false);
            btnSupprimer.setEnabled(false);
            tabbedP.setEnabledAt(3, false);
        }
    }//GEN-LAST:event_tableListingMouseMoved

    //Bouton supprimer
    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        int numLigne = tableListing.getSelectedRow();
        int numQuestion = Integer.valueOf(String.valueOf(tableListing.getModel().getValueAt(numLigne, 0)));
        String titre = listeQuestions.getQuestionN(numQuestion).getTitre();
        String[] choix = {"Supprimer", "Ne pas supprimer"};
        int reponse = JOptionPane.showOptionDialog(null,
                "Attention,  voulez-vous supprimer la question suivante :"
                + "\n№ : " + numQuestion + "\nTitre : " + titre,
                "Supprission d'une question",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                new javax.swing.ImageIcon(getClass().getResource("/images/Test-paper-icon2.png")), choix, choix[1]);
        switch (reponse) {
            case 0:
                supprimerQuestion(numQuestion, numLigne);
                break;
            case 1: // ne pas enregistrer
                break;

            default:
        }
    }//GEN-LAST:event_btnSupprimerActionPerformed

    // bouton confirmer (Modification)
    private void btnConfirmerModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmerModifActionPerformed

        boolean flag = false;
        switch (txtType.getText()) {
            case "Choisir la ou les bonnes réponses":
                if (monPanQCM.validerData()) {
                    int cle = Integer.parseInt(txtNum.getText());
                    String titre = txtType.getText();
                    String laQuestion = monPanQCM.getTxtQuestion().getText();
                    String choix;
                    int nombreChoix = monPanQCM.getListeChoix().size();
                    maQCM = (QCM) listeQuestions.getQuestionN(cle);
                    maQCM.setLaQuestion(laQuestion);
                    maQCM.getListeChoix().clear();
                    for (int i = 0; i < nombreChoix; i++) {
                        choix = monPanQCM.getListeChoix().get(i).getText();
                        maQCM.ajouterChoix(choix);
                    }
                    maQCM.creerReponses();
                    for (int i = 0; i < nombreChoix; i++) {
                        if (monPanQCM.getListeBonnesReponses().get(i).isSelected()) {
                            maQCM.faireChoix(i);
                        }
                    }

                    monPanQCM.reinitialiser();
                    JOptionPane.showMessageDialog(null, "La question N :  " + cle + " a été bien modifeé :\n"
                            + "\n" + "     Titre: " + titre + "\n" + "     La question: " + laQuestion,
                            "Question modifiée avec succès", JOptionPane.INFORMATION_MESSAGE);
                    etatManip = true;
                }
                break;
            case "Trouver l'erreur dans ce code":
                if (monPanQuesImg.validerData()) {
                    int cle = Integer.parseInt(txtNum.getText());
                    String titre = txtType.getText();
                    String laQuestion = monPanQuesImg.getPathImage();
                    int numErreur = monPanQuesImg.getNumLigneErreur();
                    String erreur = monPanQuesImg.getErreur();
                    String correction = monPanQuesImg.getCorrection();
                    String[] tab = {String.valueOf(numErreur), erreur, correction};
                    maQuesImg = (ImageErreur) listeQuestions.getQuestionN(cle);
                    maQuesImg.setlImage(laQuestion);
                    maQuesImg.setLigne(tab, 0);
                    monPanQuesImg.reinitialiser();
                    JOptionPane.showMessageDialog(null, "La question N :  " + cle + " a été bien modifeé :\n"
                            + "\n" + "     Titre: " + titre + "\n" + "     La question: " + laQuestion,
                            "Question modifiée avec succès", JOptionPane.INFORMATION_MESSAGE);
                    etatManip = true;
                }
                break;
            case "Trouver le resultat d'execution de ce code":
                if (monPanQuesRes.validerData()) {
                    int cle = Integer.parseInt(txtNum.getText());
                    String titre = txtType.getText();
                    String laQuestion = monPanQuesRes.getTxtAreaQuestion().getText();
                    String reponse = monPanQuesRes.getTxtResultat().getText();
                    maQuesRes = (ResultatExecution) listeQuestions.getQuestionN(cle);
                    maQuesRes.setQuestion(laQuestion);
                    maQuesRes.setReponse(reponse);
                    JOptionPane.showMessageDialog(null, "La question N :  " + cle + " a été bien modifeé :\n"
                            + "\n" + "     Titre: " + titre + "\n" + "     La question: " + laQuestion,
                            "Question modifiée avec succès", JOptionPane.INFORMATION_MESSAGE);
                    etatManip = true;
                }
                break;
        }


    }//GEN-LAST:event_btnConfirmerModifActionPerformed

    private void btnAnnulerMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerMAActionPerformed
        tabbedP.setEnabledAt(3, false);
        tabbedP.setEnabledAt(2, false);
        tabbedP.setSelectedIndex(0);
        pnlCentre.removeAll();
        pnlCentreModif.removeAll();
    }//GEN-LAST:event_btnAnnulerMAActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnAnnulerA;
    private javax.swing.JButton btnAnnulerM;
    private javax.swing.JButton btnConfirmer;
    private javax.swing.JButton btnConfirmerModif;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnReinitialiser;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JCheckBox checkBoxErreur;
    private javax.swing.JCheckBox checkBoxQCM;
    private javax.swing.JCheckBox checkBoxResultat;
    private javax.swing.JComboBox<String> comboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblRecap1;
    private javax.swing.JLabel lblRecap2;
    private javax.swing.JLabel lblRecap3;
    private javax.swing.JLabel lblRecap4;
    private javax.swing.JLabel lblRecap5;
    private javax.swing.JLabel lblRecap6;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JPanel pnlAjout;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlBasModif;
    private javax.swing.JPanel pnlBouton;
    private javax.swing.JPanel pnlCentre;
    private javax.swing.JPanel pnlCentreModif;
    private javax.swing.JPanel pnlHaut;
    private javax.swing.JPanel pnlListe;
    private javax.swing.JPanel pnlModifier;
    private javax.swing.JPanel pnlRecap;
    private javax.swing.JScrollPane scrollPnlTable;
    private javax.swing.JTabbedPane tabbedP;
    private javax.swing.JTable tableListing;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtQCM;
    private javax.swing.JTextField txtQuesImg;
    private javax.swing.JTextField txtRecherche;
    private javax.swing.JTextField txtResExe;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables

    public void supprimerQuestion(int cle, int ligne) {
        model.removeRow(ligne);
        listeQuestions.supprimerQuestion(cle);
        etatManip = true;
    }
}

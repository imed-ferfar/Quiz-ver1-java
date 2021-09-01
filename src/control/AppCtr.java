/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import io.ManipFichier;
import java.util.Locale;
import modele.ListeProfils;
import modele.ListeQuestions;
import ui.FenPrincipale;


/**
 *
 * @author Ferfar Imad Eddine
 */
public class AppCtr {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Creer liste des questions
        ListeQuestions maListe = new ListeQuestions();
        ListeProfils maListeProfils = new ListeProfils();
        
        //Charger les questions de type QCM
        ManipFichier.lireFichier("Fichiers\\data_QCM.txt",maListe,"QCM");
        
        //Charger les questions de type ImageCinqErreurs
        ManipFichier.lireFichier("Fichiers\\data_ImageAvecErreurs.txt",maListe,"ImageCinqErreurs");
        
        //Charger les questions de type Resultat d'Execution
        ManipFichier.lireFichier("Fichiers\\data_resultatExe.txt",maListe,"ResultatExecution");
        ManipFichier.lireFichier("Fichiers\\data_profils.txt",maListeProfils);
        
        maListe.afficherQuestions();// test visuel
                
        //Lancer la fenetre principale
        Locale locale = Locale.getDefault();
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenPrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenPrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenPrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenPrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenPrincipale(maListe,maListeProfils, locale).setVisible(true);
            }
        });
        
        
    }
    
   
}

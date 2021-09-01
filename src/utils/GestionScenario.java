/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;
import modele.ImageErreur;
import modele.ListeQuestions;
import modele.Profil;
import modele.QCM;
import modele.ResultatExecution;
import modele.Scenario;
import ui.ListePanneaux;
import ui.PanneauParcours;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class GestionScenario {

    //Lancer un objet Scenario, et passer comme parametre pour un autre objet ListePanneaux (pour un quizz)
    public static ListePanneaux lancerScenario(int nbrQuestions, ListeQuestions listeQuestion, String utilisateur, int typeQuestChoisies) {

        Profil monProfil = new Profil(utilisateur, nbrQuestions);
        Scenario monScenario = new Scenario(nbrQuestions, listeQuestion, typeQuestChoisies);

        ListePanneaux listePanneau = new ListePanneaux(monScenario, monProfil);

        return listePanneau;
    }

    // Lancer un Panneau d'affichage
    public static PanneauParcours LancerPanneau(ListeQuestions listeQuestions, int cle) {

        switch (listeQuestions.getQuestionN(cle).getTitre()) {
            case "Choisir la ou les bonnes réponses":
                return new PanneauParcours((QCM) listeQuestions.getQuestionN(cle));
            case "Trouver l'erreur dans ce code":
                return new PanneauParcours((ImageErreur) listeQuestions.getQuestionN(cle));
            case "Trouver le resultat d'execution de ce code":
                return new PanneauParcours((ResultatExecution) listeQuestions.getQuestionN(cle));
            default:
                JOptionPane.showMessageDialog(null, "Desole! veuillez repeter svp",
                        "Erreur de selection", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

}

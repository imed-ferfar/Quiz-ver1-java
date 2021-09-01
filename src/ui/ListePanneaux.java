/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import modele.ImageErreur;
import modele.Profil;
import modele.QCM;
import modele.ResultatExecution;
import modele.Scenario;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class ListePanneaux {

    private ArrayList<PanneauQuiz> listing;
    private Profil monProfil;
    Scenario monScenario;
    PanneauQuiz monPanneau;

    // constructeurs
    public ListePanneaux() {
    }

    public ListePanneaux(Scenario monScenario, Profil monProfil) {
        listing = new ArrayList<>();
        this.monScenario = monScenario;
        remplirListeDePanneaux(monScenario);
    }
    
    // Ajouter une nombre définit (monScenario1.getSize()) de panneaux
    private void remplirListeDePanneaux(Scenario monScenario1) {
        int cle;
        for (int i = 0; i < monScenario1.getSize(); i++) {
            cle = monScenario1.tableauCles()[i];
            switch (monScenario1.getQuestionN(cle).getTitre()) {
                case "Choisir la ou les bonnes réponses":
                    monPanneau = new PanneauQuiz((QCM) monScenario1.getQuestionN(cle));
                    listing.add(monPanneau);
                    break;
                case "Trouver l'erreur dans ce code":
                    monPanneau = new PanneauQuiz((ImageErreur) monScenario1.getQuestionN(cle));
                    listing.add(monPanneau);
                    break;
                case "Trouver le resultat d'execution de ce code":
                    monPanneau = new PanneauQuiz((ResultatExecution) monScenario1.getQuestionN(cle));
                    listing.add(monPanneau);
            }
        }
    }

    //Getters
    public Scenario getMonScenario() {
        return monScenario;
    }

    public Profil getMonProfil() {
        return monProfil;
    }

    public ArrayList<PanneauQuiz> getListing() {
        return listing;
    }

    public PanneauQuiz getListing(int position) {
        return listing.get(position);
    }

    public int getSize() {
        return listing.size();
    }

    // pour ajouter un panneau
    public void ajouterPanneau(PanneauQuiz panneau) {
        listing.add(panneau);
    }
}

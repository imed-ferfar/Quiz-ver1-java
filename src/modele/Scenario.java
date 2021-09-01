/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.swing.JOptionPane;
import utils.QuestionDejaPresenteException;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class Scenario extends ListeQuestions {

    // private ReponseQCM_user[] reponsesQCM;
    //private ReponseImg_user[] reponsesImg;
    private ListeQuestions listeQuestion;
    private int typeQuestChoisies ;

    int[] tabTemp;

    // Constructeurs
    public Scenario() {
    }

    public Scenario(int nombreQues, ListeQuestions listeQuestion, int typeQuestChoisies) {
        super();
        this.listeQuestion = listeQuestion;
        this.typeQuestChoisies = typeQuestChoisies;
        //reponsesQCM = new ReponseQCM_user[listeQuestion.listingQCM.size()];
        //reponsesImg = new ReponseImg_user[listeQuestion.listingImg.size()];

        // creer un tableau pour recevoir les reponses
        tabTemp = new int[nombreQues];
        remplirTableauAleatoire(tabTemp, typeQuestChoisies);
        for (int i = 0; i < tabTemp.length; i++) {
            try {
                ajouterQuestion(listeQuestion.getQuestionN(tabTemp[i]));
            } catch (QuestionDejaPresenteException e) {
                JOptionPane.showMessageDialog(null, e.getQues().toString(),
                        "Erreur ajout", JOptionPane.ERROR_MESSAGE);
            }
        }
        afficherQuestions();// test visuel
    }

    private void remplirTableauAleatoire(int[] tab, int typeQuestChoisies) {
        int val;
        int max = listeQuestion.maxCle();
        int min = listeQuestion.minCle();
        System.out.println("min :" + min + ",   max :" + max);
        System.out.println("Lise aleatoire des questions : " + tab.length);//test visuel
        for (int i = 0; i < tab.length; i++) {
            val = (int) ((Math.random() * max) + min);
            String titre = listeQuestion.getQuestionN(val).getTitre();
            switch (typeQuestChoisies) {
                case 1:
                    while (verifierValeur(tab, val, i) || !titre.equalsIgnoreCase("Choisir la ou les bonnes réponses") ) {
                        System.out.println(val + "---->" + (verifierValeur(tab, val, i) + "-----" + listeQuestion.getQuestionN(val).getTitre()));
                        val = (int) ((Math.random() * max) + min);
                        titre = listeQuestion.getQuestionN(val).getTitre();
                    }
                    break;

                case 2:
                    while ((verifierValeur(tab, val, i)) || (!listeQuestion.getQuestionN(val).getTitre().equals("Trouver l'erreur dans ce code"))) {
                        val = (int) ((Math.random() * max) + min);
                    }
                    break;
                case 4:
                    while ((verifierValeur(tab, val, i)) || (!listeQuestion.getQuestionN(val).getTitre().equals("Trouver le resultat d'execution de ce code"))) {
                        val = (int) ((Math.random() * max) + min);
                    }
                    break;
                case 3:
                    while ((verifierValeur(tab, val, i)) || (listeQuestion.getQuestionN(val).getTitre().equals("Trouver le resultat d'execution de ce code"))) {
                        val = (int) ((Math.random() * max) + min);
                    }
                    break;
                case 6:
                    while ((verifierValeur(tab, val, i)) || (listeQuestion.getQuestionN(val).getTitre().equals("Choisir la ou les bonnes réponses"))) {
                        val = (int) ((Math.random() * max) + min);
                    }
                    break;
                case 5:
                    while ((verifierValeur(tab, val, i)) || (listeQuestion.getQuestionN(val).getTitre().equals("Trouver l'erreur dans ce code"))) {
                        val = (int) ((Math.random() * max) + min);
                    }
                    break;
                case 7:
                    while (verifierValeur(tab, val, i)) {
                        val = (int) ((Math.random() * max) + min);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Desole! veuillez repeter svp",
                            "Erreur de selection", JOptionPane.WARNING_MESSAGE);
            }
            tab[i] = val;
            System.out.println(tab[i]);//test visuel
        }
    }

    private boolean verifierValeur(int[] tab, int nombre, int position) {
        for (int i = 0; i < position; i++) {
            if (tab[i] == nombre) {
                return true;
            }
        }
        return false;
    }

    //Partie reponse
    /*public ReponseQCM_user getReponsesQCM(int position) {
        return reponsesQCM[position];
    }

    public void ajouterReponseChoisie(ReponseQCM_user reponse, int position) {
        reponsesQCM[position] = reponse;
    }
    public void ajouterReponseChoisie(ReponseImg_user reponse, int position){
        reponsesImg[position] = reponse; 
    }
    public ReponseImg_user getRepenseImg(int position) {
        return reponsesImg[position];
    }
     */
}

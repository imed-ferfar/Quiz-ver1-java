/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import utils.QuestionDejaPresenteException;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class ListeQuestions {

    private final int NOMBRE_TYPE_QUESTION = 3;
    private final String[] typeQuestion = {"Choisir la ou les bonnes réponses",
        "Trouver l'erreur dans ce code", "Trouver le resultat d'execution de ce code"};

    private Map<Integer, Question> mapQuestion; //le cœur de mon application :)

    //Constructeur
    public ListeQuestions() {
        mapQuestion = new HashMap<>();
    }

    public void ajouterQuestion(Question maQuestion) throws QuestionDejaPresenteException {

        if (verifierDoublon(maQuestion)) {
            throw new QuestionDejaPresenteException(maQuestion, "Question en double!!!");
        } else {
            mapQuestion.put(maQuestion.getNumQuestion(), maQuestion);
        }
    }

    //pour supprimer une question
    public void supprimerQuestion(int cle) {
        QCM maQCM;
        ImageErreur maQuesImg;
        ResultatExecution maQuesRes;
        String titre = mapQuestion.get(cle).getTitre();
        String laQuestion = "";

        if (titre.equals("Choisir la ou les bonnes réponses")) {
            maQCM = (QCM) (mapQuestion.get(cle));
            laQuestion = maQCM.getLaQuestion();
        } else if (titre.equals("Trouver l'erreur dans ce code")) {
            maQuesImg = (ImageErreur) (mapQuestion.get(cle));
            maQuesImg.getlImage();
        } else if (titre.equals("Trouver le resultat d'execution de ce code")) {
            maQuesRes = (ResultatExecution) (mapQuestion.get(cle));
            maQuesRes.getQuestion();
        }
        mapQuestion.remove(cle);
        JOptionPane.showMessageDialog(null, "La question suivante a été bien supprimeé :\nN : " + cle
                + "\nTitre : " + titre
                + "\nLa question : " + laQuestion, "Question supprimer avec succès", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean verifierDoublon(Question maQuestion) {
        for (Map.Entry monEntry : mapQuestion.entrySet()) {
            if (maQuestion.equals(monEntry.getValue())) {
                return true;
            }
        }
        return false;
    }

    //Ancienne version ;)
    /*
    public void ajouterQuestionAnonyme(int numQuestion, ListeQuestions listeQuestion, int typeQuestShoisies){
        
        for (QCM tmp : listeQuestion.getListingQCM()) {
            if (numQuestion == tmp.getNumQuestion()) {
                try {
                    ajouterQuestion(tmp);
                } catch (QuestionDejaPresenteException e) {
                JOptionPane.showMessageDialog(null, e.getQues().toString(),
                    "Erreur ajout",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        for (ImageErreur tmp : listeQuestion.getListingImg()) {
            if (numQuestion == tmp.getNumQuestion()) {
                try {
                    ajouterQuestion(tmp);
                } catch (QuestionDejaPresenteException e) {
                JOptionPane.showMessageDialog(null, e.getQues().toString(),
                    "Erreur ajout",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        for (ResultatExecution tmp : listeQuestion.getListingResExec()) {
            if (numQuestion == tmp.getNumQuestion()) {
                try {
                    ajouterQuestion(tmp);
                } catch (QuestionDejaPresenteException e) {
                JOptionPane.showMessageDialog(null, e.getQues().toString(),
                    "Erreur ajout",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }*/
    //Getters
    public String[] getTypeQuestion() {
        return typeQuestion;
    }

    public Map<Integer, Question> getMapQuestion() {
        return mapQuestion;
    }

    public Question getQuestionN(int cle) {
        return mapQuestion.get(cle);
    }

    public int getSize() {
        return mapQuestion.size();
    }

    public int getSizeQCM() {
        int somme = 0;
        for (Map.Entry monEntry : mapQuestion.entrySet()) {
            if (monEntry.getValue().getClass().getName().equals("modele.QCM")) {
                somme++;
            }
        }
        return somme;
    }

    public int getSizeImg() {
        int somme = 0;
        for (Map.Entry monEntry : mapQuestion.entrySet()) {
            if (monEntry.getValue().getClass().getName().equals("modele.ImageErreur")) {
                somme++;
            }
        }
        return somme;
    }

    public int getSizeRes() {
        int somme = 0;
        for (Map.Entry monEntry : mapQuestion.entrySet()) {
            if (monEntry.getValue().getClass().getName().equals("modele.ResultatExecution")) {
                somme++;
            }
        }
        return somme;
    }

    public String listingQCM() {
        String message = "";

        for (int i = 0; i < mapQuestion.size(); i++) {
            if (mapQuestion.get(tableauCles()[i]).getTitre().equalsIgnoreCase(typeQuestion[0])) {
                message += mapQuestion.get(tableauCles()[i]).toString() + "\n";
            }
        }
        return message;
    }

    public String listingImageCinqErreurs() {
        String message = "";
        for (int i = 0; i < mapQuestion.size(); i++) {
            if (mapQuestion.get(tableauCles()[i]).getTitre().equalsIgnoreCase(typeQuestion[1])) {
                message += mapQuestion.get(tableauCles()[i]).toString() + "\n";
            }
        }
        return message;
    }

    public String listingErreursSurImage() {
        String message = "";
        ImageErreur maQuest;
        for (int i = 0; i < mapQuestion.size(); i++) {
            if (mapQuestion.get(tableauCles()[i]).getTitre().equalsIgnoreCase(typeQuestion[1])) {
                maQuest = (ImageErreur) mapQuestion.get(tableauCles()[i]);
                message += maQuest.listingEreurs();
              //  System.out.println("j = " + i); // test visuel
            }
        }
        return message;
    }

    public String listingResultatExecution() {
        String message = "";
        for (int i = 0; i < mapQuestion.size(); i++) {
            if (mapQuestion.get(tableauCles()[i]).getTitre().equalsIgnoreCase(typeQuestion[2])) {
                message += mapQuestion.get(tableauCles()[i]).toString() + "\n";
            }
        }
        return message;
    }

    public void afficherQuestions() {
        System.out.println("=========Listing des questions=========");
        for (Map.Entry monEntry : mapQuestion.entrySet()) {
            System.out.println("clé: " + monEntry.getKey() + " | " + monEntry.getValue());
        }
    }

    public int nouveauNumQuestion() {
        int nouveauNum = 1;
        while (mapQuestion.containsKey(nouveauNum)) {
            nouveauNum++;
        }
        return nouveauNum;
    }

    public int[] tableauCles() {
        int[] tab = new int[mapQuestion.size()];
        int j = 0;
        for (Iterator i = mapQuestion.keySet().iterator(); i.hasNext();) {
            tab[j] = (int) i.next();
            j++;
        }
        return tab;  //   [cle1,cle2,cle3 ........clen]
    }

    public int minCle() {
        int minVal = tableauCles()[0];
        for (int i = 1; i < tableauCles().length; i++) {
            if (tableauCles()[i] < minVal) {
                minVal = tableauCles()[i];
            }
        }
        return minVal;
    }

    public int maxCle() {
        int maxVal = tableauCles()[0];
        for (int i = 1; i < tableauCles().length; i++) {
            if (tableauCles()[i] > maxVal) {
                maxVal = tableauCles()[i];
            }
        }
        return maxVal;
    }

    // retourne nombre des questions selon le types choisis
   /* public int nombreQuestion(String titre){
        int nombre=0;
        for (int i=0; i< mapQuestion.size(); i++)
            if (mapQuestion.get(tableauCles()[i]).getTitre().equalsIgnoreCase(titre))
                nombre++;
            return nombre;
    }*/
    
    // retourne nombre des questions selon le types choisis
    public int nombreQuestion(int typeQuestion) {
        int nombre = 0;
        switch (typeQuestion) {
            case 1:
                nombre = getSizeQCM();
                break;
            case 2:
                nombre = getSizeImg();
                break;
            case 4:
                nombre = getSizeRes();
                break;
            case 3:
                nombre = getSizeQCM()+getSizeImg();
                break;
            case 5:
                nombre = getSizeQCM()+getSizeRes();
                break;
            case 6:
                nombre = getSizeImg() +getSizeRes();
                break;
            case 7: nombre =  getSize();
                break;
        }

        return nombre;
    }

}

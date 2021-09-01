/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class QCM extends Question implements ReponseQCM{
    private String laQuestion;
    private ArrayList<String> listeChoix;
    private boolean[] reponses;
    
    //constructeurs
    public QCM() {
    }
    
    public QCM(int numQuestion, String titre, String laQuestion) {
        super(numQuestion, titre);
        this.laQuestion = laQuestion;
        listeChoix = new ArrayList<>();
    }
    
    //Ajouter un choix de reponeses
    public void ajouterChoix(String choix){
        if (verifierChoix(choix))
            listeChoix.add(choix);
    }
    
    private boolean verifierChoix(String choix){
        for (String tmp : listeChoix) {
            if (choix.equals(tmp)) {
                return false;
            }
        }
        return true;
    }
    
    public String getLaQuestion() {
        return laQuestion;
    }
    
    public String getChoix(int position) {
        return listeChoix.get(position);
    }

    public ArrayList<String> getListeChoix() {
        return listeChoix;
    }

    public boolean getReponses(int position) {
        return reponses[position];
    }

    public void setLaQuestion(String laQuestion) {
        this.laQuestion = laQuestion;
    }

    @Override
    // Creer le tableau des bonnes reponses
    public void creerReponses(){
        reponses = new boolean[listeChoix.size()];
    }
    
    @Override
    // Ajouter une bonne reponse
    public void faireChoix(int position){
        reponses[position]=true;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.laQuestion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QCM other = (QCM) obj;
        
        if ((super.getNumQuestion() != other.getNumQuestion()) &&(!Objects.equals(this.laQuestion, other.laQuestion))) {
            return false;
        }
        /*if (!Objects.equals(super.getTitre(), other.getTitre())) {
            return false;
        }
        
        if (!Objects.equals(this.laQuestion, other.laQuestion)) {
            return false;
        }*/
        return true;
    }
    
    public String listingChoix(){
        String message = "";
        for(int i=0;i<listeChoix.size(); i++)
            message += "#"+listeChoix.get(i)+"_"+reponses[i];
        return message;
    }
    
    @Override
    public String toString() {
        return super.getNumQuestion() + "#" + super.getTitre()+"#" + laQuestion + listingChoix();
    }


    
}

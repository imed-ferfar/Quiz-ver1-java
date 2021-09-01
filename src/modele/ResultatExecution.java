/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Objects;
import java.util.StringTokenizer;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class ResultatExecution extends Question implements ReponseExecution{
    private String question;
    private String reponse;

    //Constructeurs
    public ResultatExecution() {
    }

    public ResultatExecution(int numQuestion, String titre, String question, String reponse) {
        super(numQuestion, titre);
        this.question = question;
        this.reponse = reponse;
    }

    //Getters
    public String getQuestion() {
        return question;
    }

    public String getReponse() {
        return reponse;
    }

    //Setters
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.question);
        hash = 83 * hash + Objects.hashCode(this.reponse);
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
        final ResultatExecution other = (ResultatExecution) obj;
         if ((super.getNumQuestion() != other.getNumQuestion()) &&(!Objects.equals(this.question, other.question))) {
            return false;

        }
        return true;
    }

    @Override
    public String toString() {
        StringTokenizer token;
        token = new StringTokenizer(question);
       // System.out.println(token.nextToken("\n")+"ouiiiiiiiiiii");
        //System.out.println(question);
        String texte =token.nextToken("\n");
        for (int i=0;i<token.countTokens();i++)
            texte += "_"+token.nextToken("\n");
        return super.getNumQuestion() + "#" + super.getTitre()+"#" + texte+ "#"+ reponse;
    }

    // non utilisees pour cette version
    @Override
    public void creerReponses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterReponseExe(String resultat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 

    
    
    
     
 
    
    
    
}

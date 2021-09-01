/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Objects;

/**
 *
 * @author Ferfar Imad Eddine
 */

public class Question {
    private int numQuestion;
    private String titre;

    // Constructeurs
    public Question() {
    }
    
    public Question(int numQuestion, String titre) {
        this.numQuestion = numQuestion;
        this.titre = titre;
    }

    //Getters
    public int getNumQuestion() {
        return numQuestion;
    }

    public String getTitre() {
        return titre;
    }

    //Setters  -- pas besoin --
   /* public void setNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }*/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.numQuestion;
        hash = 67 * hash + Objects.hashCode(this.titre);
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
        final Question other = (Question) obj;
        if (this.numQuestion != other.numQuestion) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return true;
    }
    
}


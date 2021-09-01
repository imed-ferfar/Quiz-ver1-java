/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;



import modele.Question;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class QuestionDejaPresenteException extends Exception {
    
    private Question ques;

    public QuestionDejaPresenteException() {
    }
    
    public QuestionDejaPresenteException (Question ques,String message) {
        super(message);
        this.ques = ques;
    }

    public Question getQues() {
        return ques;
    }
     
}

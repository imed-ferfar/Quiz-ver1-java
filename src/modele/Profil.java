/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class Profil {
    
    private String utilisateur;
    private String laDate;
    private String lHeure;
    private int nombreQuestion;
    private double note;
    private boolean[] notes;
    private int duree;
    
    Date date;
    DateFormat formatDate,formatHeure;

    public Profil() {
    }
    public Profil(String utilisateur, int nombreQuestion) {
        formatDate = new SimpleDateFormat("dd/MM/YY");
        formatHeure = new SimpleDateFormat("HH/mm");
        date = new Date();
        
        laDate = formatDate.format(date);
        lHeure = formatHeure.format(date);
        this.utilisateur = utilisateur;
        this.nombreQuestion = nombreQuestion;
        notes = new boolean[nombreQuestion];
    }

    public Profil(String utilisateur, String laDate, String lHeure, int nombreQuestion, double note, int duree) {
        this.utilisateur = utilisateur;
        this.laDate = laDate;
        this.lHeure = lHeure;
        this.nombreQuestion = nombreQuestion;
        this.note = note;
        this.duree = duree;
    }

    
    // setters
    public void setDuree(int duree) {
        this.duree = duree;
    }
    
    //getters
    public String getUtilisateur() {
        return utilisateur;
    }
    
    public boolean[] getNotes() {
        return notes;
    }
    
    public int getDuree() {
        return duree;
    }
    
    public void ajouterNote(int position){
        notes[position] = true;
    }
    public int calculerNote(){
        double somme=0;
        for (int i = 0;i<notes.length;i++)
            if (notes[i])
                somme++;
        return (int)((somme/notes.length)*100);
    } 

    @Override
    public String toString() {
        return utilisateur + "#" + laDate + "#" + lHeure + "#" + nombreQuestion + "#" + note + "#" + duree;
    }    

    
}

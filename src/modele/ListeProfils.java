/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class ListeProfils {
    ArrayList<Profil> listing;

    //Constructeurs
    public ListeProfils() {
        listing = new ArrayList<>();
    }

    //Getters
    public ArrayList<Profil> getListing() {
        return listing;
    }

    //Setters
    public void setListing(ArrayList<Profil> listing) {
        this.listing = listing;
    }
    
    public void ajouterProfil(Profil monProfil){
        listing.add(monProfil);
    }

    @Override
    public String toString() {
        String message="";
        for (Profil tmp : listing)
            message+= tmp+"\n";
        return message;
    }
    
    
    
}

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
public class ImageErreur extends Question implements ReponseImg {

    private String lImage;
    private String[][] reponses;
    private int nombreErreurs;

    //constructeurs
    public ImageErreur() {

    }

    public ImageErreur(int numQuestion, String titre, String lImage, int nombreErreurs) {
        super(numQuestion, titre);
        this.lImage = lImage;
        this.nombreErreurs = nombreErreurs;

    }

    // vérifier ligne d’erreur / pas besoins pour cette version – 1 erreur par image
    private boolean verifierLigne(String[] ligne) {
        /* for (int i=0;i<reponses[0].length;i++) {
           if (ligne[i]==reponses[i][j])
            for (int j=0;j<reponses.length;j++)
            }
        }*/
        return true;
    }

    //Getters
    public String getlImage() {
        return lImage;
    }

    public int getNombreErreurs() {
        return nombreErreurs;
    }

    public String[] getLigne(int position) {
        String[] tab = new String[reponses.length];
        for (int i = 0; i < reponses.length; i++) {
            tab[i] = reponses[i][position];
        }
        return tab;
    }

    public void setlImage(String lImage) {
        this.lImage = lImage;
    }
    
    
    public void setLigne(String[] tab, int position) {
        for (int i = 0; i < reponses.length; i++) {
            reponses[i][position] = tab[i];
        }
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.lImage);
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
        final ImageErreur other = (ImageErreur) obj;
        if ((super.getNumQuestion() != other.getNumQuestion()) && (!Objects.equals(this.lImage, other.lImage))) {
            return false;
        }
        /*  if (!Objects.equals(this.lImage, other.lImage)) {
            return false;
        }
        if (!Arrays.deepEquals(this.reponses, other.reponses)) {
            return false;
        }*/
        return true;
    }

    public String listingEreurs() {
        String message = "";
       // System.out.println("nombre erreurs :" + reponses[0].length);  // test visuel
        for (int i = 0; i < reponses[0].length; i++) {
            message += super.getNumQuestion() + "#" + reponses[0][i] + "#" + reponses[1][i] + "#" + reponses[2][i] + "\n";
            //System.out.println("i = " + i); // test visuel
        }
        return message;
    }

    @Override
    public String toString() {
        return super.getNumQuestion() + "#" + super.getTitre() + "#" + lImage + "#" + nombreErreurs;
    }

    @Override
    public void creerReponses() {
        reponses = new String[3][getNombreErreurs()];
    }

    @Override
    //Ajouter une ligne dans la matrice des erreurs
    public void ajouterCorrigeErreur(String[] ligne) {
        int j = 0;
        if (verifierLigne(ligne)) {
            while (reponses[0][j] != null) {
                j++;
            }
            for (int i = 0; i < reponses.length; i++) {
                reponses[i][j] = ligne[i];
            }
        }
    }

}

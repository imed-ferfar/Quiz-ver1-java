/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import modele.ImageErreur;
import modele.ListeProfils;
import modele.ListeQuestions;
import modele.Profil;
import modele.QCM;
import modele.ResultatExecution;
import utils.QuestionDejaPresenteException;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class ManipFichier {

    // lire un fichier (avec type de question)
    public static void lireFichier(String monFichier, ListeQuestions maListe, String typeQuestion) {
        // lecture
        File fichierIn = new File(monFichier);
        //declarer le fichier en sortie        
        FileReader fr;// = null;
        BufferedReader br = null;
        try {
            //creer le stream entree
            fr = new FileReader(fichierIn);
            br = new BufferedReader(fr);

            switch (typeQuestion) {
                case "QCM":
                    chargerFichierQCM(br, maListe);
                    break;
                case "ImageCinqErreurs":
                    chargerFichierImages(br, maListe);
                    break;
                case "ResultatExecution":
                    chargerFichierResultatExe(br, maListe);
                    break;
                default:
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fichier non trouve!\n",
                    "Fichier non trouve!", JOptionPane.ERROR_MESSAGE);
            // System.out.println("Fichier non trouve!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur de manipulation fichier!\n",
                    "Erreur de manipulation fichier!!", JOptionPane.ERROR_MESSAGE);
            //  System.out.println("Erreur de manipulation fichier!");
        } finally {
            if (br != null)
                try {
                br.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erreur de manipulation fichier!\n",
                        "Erreur de manipulation fichier!!", JOptionPane.ERROR_MESSAGE);
                //System.out.println("Erreur de manipulation stream!");
            }
        }
    }

    // lire un fichier (standard)
    public static void lireFichier(String monFichier, ListeProfils maListeProfils) {
        // lecture
        File fichierIn = new File(monFichier);
        //declarer le fichier en sortie        
        FileReader fr = null;
        BufferedReader br = null;
        try {
            //creer le stream entree
            fr = new FileReader(fichierIn);
            br = new BufferedReader(fr);

            Profil monProfil;
            //lecture du fichier
            String ligne;
            StringTokenizer token, token_bis;
            while ((ligne = br.readLine()) != null) { // boucler tant quon a pas la fin du fichier
                token = new StringTokenizer(ligne);
                monProfil = new Profil(token.nextToken("#"), token.nextToken("#"), token.nextToken("#"), Integer.parseInt(token.nextToken("#")), Double.parseDouble(token.nextToken("#")), Integer.parseInt(token.nextToken("#")));
                maListeProfils.ajouterProfil(monProfil);
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fichier non trouve!",
                    "Fichier non trouve!", JOptionPane.ERROR_MESSAGE);
            //System.out.println("Fichier non trouve!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur de manipulation fichier!\n",
                    "Erreur de manipulation fichier!!", JOptionPane.ERROR_MESSAGE);
            // System.out.println("Erreur de manipulation fichier!");
        } finally {
            if (br != null)
                try {
                br.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erreur de manipulation fichier!\n",
                        "Erreur de manipulation fichier!!", JOptionPane.ERROR_MESSAGE);
                //  System.out.println("Erreur de manipulation stream!");
            }
        }
    }

    // ecrire un fichier
    public static void ecrireFichier(String monFichier, String texte) {
        File fichierSortie = new File(monFichier);
        FileWriter fw;// = null;
        BufferedWriter bw = null;
        //creer le stream sortie
        try {
            fw = new FileWriter(fichierSortie);
            bw = new BufferedWriter(fw);
            bw.write(texte); //ecrire dans le fichier sortie
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fichier non trouve!",
                    "Fichier non trouve!", JOptionPane.ERROR_MESSAGE);
            // System.out.println("Fichier non trouve!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fichier non trouve!\n",
                    "Fichier non trouve!", JOptionPane.ERROR_MESSAGE);
            // System.out.println("Erreur de manipulation fichier!");
        } finally {
            if (bw != null)
                try {
                bw.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erreur de manipulation fichier!\n",
                        "Erreur de manipulation fichier!!", JOptionPane.ERROR_MESSAGE);
                // System.out.println("Erreur de manipulation stream!");
            }
        }
    }

    // pour le type de question QCM
    private static void chargerFichierQCM(BufferedReader br, ListeQuestions maListe) throws HeadlessException, IOException, NumberFormatException {
        QCM maQuestion;
        //lecture du fichier
        String ligne;
        StringTokenizer token, token_bis;
        while ((ligne = br.readLine()) != null) { // boucler tant quon a pas la fin du fichier
            int i;
            token = new StringTokenizer(ligne);
            maQuestion = new QCM(Integer.parseInt(token.nextToken("#")), token.nextToken("#"), token.nextToken("#"));
            boolean[] tab = new boolean[token.countTokens()];
            for (i = 0; i < tab.length; i++) {
                token_bis = new StringTokenizer(token.nextToken("#"));
                maQuestion.ajouterChoix(token_bis.nextToken("_"));
                tab[i] = Boolean.parseBoolean(token_bis.nextToken("_"));
            }
            maQuestion.creerReponses();

            for (i = 0; i < tab.length; i++) {
                if (tab[i]) {
                    maQuestion.faireChoix(i);
                }
            }
            try {
                maListe.ajouterQuestion(maQuestion);
            } catch (QuestionDejaPresenteException e) {
                JOptionPane.showMessageDialog(null, e.getQues().toString(),
                        "Erreur ajout", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // pour le type de question ImageErreur
    private static void chargerFichierImages(BufferedReader br, ListeQuestions maListe) throws HeadlessException, IOException, NumberFormatException {
        ImageErreur maQuestion;
        //lecture du fichier
        String ligne;
        StringTokenizer token;
        while ((ligne = br.readLine()) != null) { // boucler tant quon a pas la fin du fichier
            token = new StringTokenizer(ligne);
            maQuestion = new ImageErreur(Integer.parseInt(token.nextToken("#")), token.nextToken("#"), token.nextToken("#"), Integer.parseInt(token.nextToken("#")));
            maQuestion.creerReponses();
            chargerFichierErreurs("Fichiers\\data_listingErreurs.txt", maQuestion);
            try {
                maListe.ajouterQuestion(maQuestion);
            } catch (QuestionDejaPresenteException e) {
                JOptionPane.showMessageDialog(null, e.getQues().toString(),
                        "Erreur ajout", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // pour la liste des erreurs
    private static void chargerFichierErreurs(String monFichier, ImageErreur maQuestion) throws IOException {
        File fichierIn = new File(monFichier);
        //declarer le fichier en sortie        
        FileReader fr;//= null;
        BufferedReader br = null;
        try {
            //creer le stream entree
            fr = new FileReader(fichierIn);
            br = new BufferedReader(fr);
            //lecture du fichier
            String ligne;
            StringTokenizer token;
            String[] tab;
            while ((ligne = br.readLine()) != null) {
                token = new StringTokenizer(ligne);
                if (Integer.parseInt(token.nextToken("#")) == maQuestion.getNumQuestion()) {
                    tab = new String[token.countTokens()];
                    for (int i = 0; i < tab.length; i++) {
                        tab[i] = token.nextToken("#");
                    }
                    maQuestion.ajouterCorrigeErreur(tab);
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fichier non trouve!\n",
                    "Fichier non trouve!", JOptionPane.ERROR_MESSAGE);
            // System.out.println("Fichier non trouve!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur de manipulation fichier!\n",
                    "Erreur de manipulation fichier!!", JOptionPane.ERROR_MESSAGE);
            // System.out.println("Erreur de manipulation fichier!");
        } finally {
            if (br != null)
                try {
                br.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erreur de manipulation fichier!\n",
                        "Erreur de manipulation fichier!!", JOptionPane.ERROR_MESSAGE);
                // System.out.println("Erreur de manipulation stream!");
            }
        }
    }

    // pour le type de question ResultatExec
    private static void chargerFichierResultatExe(BufferedReader br, ListeQuestions maListe) throws IOException {
        ResultatExecution maQuestion;
        //lecture du fichier
        String ligne;
        StringTokenizer token, token_bis;
        while ((ligne = br.readLine()) != null) { // boucler tant quon a pas la fin du fichier
            int i;
            token = new StringTokenizer(ligne);
            int numQues = Integer.parseInt(token.nextToken("#"));
            String titre = token.nextToken("#");
            token_bis = new StringTokenizer(token.nextToken("#"));
            String texte = "";
            texte += (token_bis.nextToken("_"));
            for (i = 0; i < token_bis.countTokens(); i++) {
                texte += ("\n" + token_bis.nextToken("_"));
            }
            maQuestion = new ResultatExecution(numQues, titre, texte, token.nextToken("#"));//token_bis.nextToken("_")+"\n"+token_bis.nextToken("_")
            //maQuestion.creerReponses();
            // maQuestion.faireChoix(i);
            try {
                maListe.ajouterQuestion(maQuestion);
            } catch (QuestionDejaPresenteException e) {
                JOptionPane.showMessageDialog(null, e.getQues().toString(),
                        "Erreur ajout", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // pour copie un fichier
    public static void copierFichier(File fichierSource, File fichierDestination) throws IOException {
        if (!fichierSource.exists()) {
            return;
        }
        if (!fichierDestination.exists()) {
            fichierDestination.createNewFile();
        }
        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(fichierSource).getChannel();
            destination = new FileOutputStream(fichierDestination).getChannel();
            if (destination != null && source != null) {
                destination.transferFrom(source, 0, source.size());
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fichier non trouve!\n",
                    "Fichier non trouve!", JOptionPane.ERROR_MESSAGE);
            // System.out.println("Fichier non trouve!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur de manipulation fichier!\n",
                    "Erreur de copier de fichier!!", JOptionPane.ERROR_MESSAGE);
            // System.out.println("Erreur de manipulation fichier!");
        } finally {
            if ((source != null) || (destination != null))
                try {
                source.close();
                destination.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erreur de manipulation fichier!\n",
                        "Erreur de fermeture de fichier!!", JOptionPane.ERROR_MESSAGE);
                // System.out.println("Erreur de manipulation stream!");
            }

        }
    }
}
